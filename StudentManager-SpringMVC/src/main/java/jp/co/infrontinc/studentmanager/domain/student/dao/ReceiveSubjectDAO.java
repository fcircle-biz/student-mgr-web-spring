package jp.co.infrontinc.studentmanager.domain.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.infrontinc.studentmanager.domain.common.util.DBUtils;
import jp.co.infrontinc.studentmanager.domain.student.model.ReceiveSubject;

/**
 * 生徒管理データベースの生徒別履修教科テーブルを操作するクラス
 * 
 * @author infront
 *
 */
public class ReceiveSubjectDAO {
	
	public ReceiveSubjectDAO() throws Exception {
		
		// JDBCを利用するための準備
		DBUtils.initJDBC();
	}
	
	/**
	 * 生徒別履修教科のデータ登録
	 * 
	 * @param conn
	 * @param receiveSubject
	 * @throws Exception
	 */
	public void insert(Connection conn, ReceiveSubject rsub) throws Exception {
		
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
			
			System.out.println("ReceiveSubjectDAO.insertの実行に失敗しました。");
			throw e;
		
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
	 * @throws Exception
	 */
	public void updateByStudentId(Connection conn, Integer id, List<ReceiveSubject> receiveSubjectList) throws Exception {
		
		try {
			
			deleteByStudentId(conn, id);
			
			for (ReceiveSubject rsub : receiveSubjectList) {
				rsub.setStudentId(id);
				insert(conn, rsub);
			}
			
		}
		catch(Exception e) {
			
			System.out.println("ReceiveSubjectDAO.updateの実行に失敗しました。");
			throw e;
		}
	}
	
	/**
	 * 生徒別履修教科のデータ削除
	 * 
	 * @param conn
	 * @param id
	 * @throws Exception
	 */
	public void deleteByStudentId(Connection conn, Integer id) throws Exception {
			
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
			
			System.out.println("ReceiveSubjectDAO.deleteの実行に失敗しました。");
			throw e;
		
		}
		finally {
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
			
		}
	}
}
