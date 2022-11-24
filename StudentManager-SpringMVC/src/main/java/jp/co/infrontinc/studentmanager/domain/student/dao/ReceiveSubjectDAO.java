package jp.co.infrontinc.studentmanager.domain.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import jp.co.infrontinc.studentmanager.domain.common.exception.SystemException;
import jp.co.infrontinc.studentmanager.domain.common.util.DBUtils;
import jp.co.infrontinc.studentmanager.domain.student.model.ReceiveSubject;

/**
 * 生徒管理データベースの生徒別履修教科テーブルを操作するクラス
 * 
 * @author infront
 *
 */
@Component
public class ReceiveSubjectDAO {
	
	/** データソース */
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 生徒別履修教科のデータ登録
	 * 
	 * @param conn
	 * @param receiveSubject
	 */
	public void insert(ReceiveSubject rsub) {
		
		// データソースからコネクションを取得
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO t_receive_subject(  ");
		sql.append("					  student_id ");
		sql.append("					, subject_cd ");
		sql.append("				 ) VALUES (		 ");
		sql.append("					  ?			 ");
		sql.append("					, ?			 ");
		sql.append("				 )				 ");
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, rsub.getStudentId());
			stmt.setString(2, rsub.getSubjectCd());
			
			// INSERT文を実行する
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			
			throw new SystemException(
					ReceiveSubjectDAO.class, 
					"insertの実行に失敗しました。",e);
		}
		finally {
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
			
		}
	}
	
	/**
	 * 生徒別履修教科のデータ更新
	 * 
	 * @param conn
	 * @param id
	 * @param receiveSubjectList
	 */
	public void updateByStudentId(Integer id, List<ReceiveSubject> receiveSubjectList) {
		
		try {
			
			deleteByStudentId(id);
			
			for (ReceiveSubject rsub : receiveSubjectList) {
				rsub.setStudentId(id);
				insert(rsub);
			}
			
		}
		catch(Exception e) {
			
			throw new SystemException(
					ReceiveSubjectDAO.class, 
					"updateの実行に失敗しました。",e);
			
		}
	}
	
	/**
	 * 生徒別履修教科のデータ削除
	 * 
	 * @param conn
	 * @param id
	 */
	public void deleteByStudentId(Integer id) {
			
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		PreparedStatement stmt = null;
		
		try {
			
			// SQL文を構築
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM t_receive_subject ");
			sql.append("	   WHERE student_id	= ?	   ");
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, id);
			
			// DELETE文を実行
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			
			throw new SystemException(
					ReceiveSubjectDAO.class, 
					"deleteの実行に失敗しました。",e);
		
		}
		finally {
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
			
		}
	}
}
