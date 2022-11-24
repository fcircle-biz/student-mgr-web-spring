package jp.co.infrontinc.studentmanager.domain.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import jp.co.infrontinc.studentmanager.domain.common.exception.SystemException;
import jp.co.infrontinc.studentmanager.domain.common.util.DBUtils;
import jp.co.infrontinc.studentmanager.domain.common.util.MyDateUtils;
import jp.co.infrontinc.studentmanager.domain.common.util.MySQLUtils;
import jp.co.infrontinc.studentmanager.domain.student.model.Counter;
import jp.co.infrontinc.studentmanager.domain.student.model.ReceiveSubject;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;
import jp.co.infrontinc.studentmanager.domain.student.model.StudentC;

/**
 * 生徒管理データベースの生徒テーブルを操作するクラス
 * 
 * @author infront
 *
 */
@Component
public class StudentDAO {
	
	/** データソース */
	@Autowired
	private DataSource dataSource;
	
	/**
	 * 条件検索
	 * 
	 * @param conn
	 * @param pcond
	 * @return studentList
	 */
	public List<Student> findByCondition(StudentC pcond) {
		
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Integer pStudentId = pcond.getStudentId();
			String pStudentName = pcond.getStudentName();
			Integer pPrefId = pcond.getPrefId();
			
			// SQL文を構築
			StringBuilder sql = new StringBuilder();
			sql.append("	SELECT *												   ");
			sql.append("	  FROM m_student										   ");
			sql.append(" LEFT JOIN m_gender											   ");
			sql.append(" 		ON m_gender.gender_cd = m_student.gender_cd			   ");
			sql.append(" LEFT JOIN m_pref											   ");
			sql.append("		ON m_pref.pref_id = m_student.pref_id				   ");
			sql.append(" LEFT JOIN t_receive_subject								   ");
			sql.append("		ON t_receive_subject.student_id = m_student.student_id ");
			sql.append(" LEFT JOIN m_subject										   ");
			sql.append("		ON m_subject.subject_cd = t_receive_subject.subject_cd ");
			sql.append("	 WHERE true												   ");
			
			if (pStudentId != null) {
				sql.append("   AND m_student.student_id = ?							   ");
			}
			if (pStudentName != null) {
				sql.append("   AND m_student.student_name like ?					   ");
			}
			if (pPrefId != null) {
				sql.append("   AND m_pref.pref_id = ?								   ");
			}
			sql.append("  ORDER BY m_student.student_id								   ");
			
			stmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			if (pStudentId != null) {
				stmt.setInt(i++, pStudentId);
			}
			if (pStudentName != null) {
				stmt.setString(i++, "%" + pStudentName + "%");
			}
			if (pPrefId != null) {
				stmt.setInt(i++, pPrefId);
			}
			
			rs = stmt.executeQuery();
			
			// リスト・インスタンス・変数の生成/宣言/初期化
			List<Student> studentList = new ArrayList<>();
			List<ReceiveSubject> receiveSubjectList = null;
			Student student = null;
			Student lastStudent = null;
			ReceiveSubject receiveSubject = null;
			
			// 条件分岐の為に比較対象となる仮IDを用意
			int tempStudentId = -1;	
			while(rs.next()) {
				
				int studentId = rs.getInt("student_id");
				String studentName = rs.getString("student_name");
				String genderCd = rs.getString("gender_cd");
				String genderName = rs.getString("gender_name");
				int prefId = rs.getInt("pref_id");
				String prefName = rs.getString("pref_name");
				int age = rs.getInt("age");
				Date birthday = rs.getDate("birthday");
				String subjectCd = rs.getString("subject_cd");
				String subjectName = rs.getString("subject_name");
				
				receiveSubject = new ReceiveSubject();
				receiveSubject.setStudentId(studentId);
				receiveSubject.setSubjectCd(subjectCd);
				receiveSubject.setSubjectName(subjectName);
				
				if (tempStudentId != studentId) {
					receiveSubjectList = new ArrayList<>();
					student = new Student();
					student.setStudentId(studentId);
					student.setStudentName(studentName);
					student.setGenderCd(genderCd);
					student.setGenderName(genderName);
					student.setPrefId(prefId);
					student.setPrefName(prefName);
					student.setAge(age);
					student.setBirthday(birthday);
					student.setReceiveSubjectList(receiveSubjectList);
					studentList.add(student);
					
					tempStudentId = studentId;
					lastStudent = studentList.get(studentList.size() - 1);
				}
				if (lastStudent.getStudentId() == studentId) { 
					receiveSubjectList.add(receiveSubject);
				}
				
			}
			return studentList;
			
		}
		catch (SQLException e) {
			
			throw new SystemException(
					StudentDAO.class, 
					"findByConditionの実行に失敗しました。",e);
		}
		finally {
			// 結果セットの破棄
			DBUtils.close(rs);
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
		}
	}
	
	/**
	 * 生徒ID指定による検索
	 * 
	 * @param conn
	 * @param id
	 * @return student
	 */
	public Student findById(Integer id) {
		
		try {
			
			StudentC cond = new StudentC();
			cond.setStudentId(id);
			
			List<Student> studentList = findByCondition(cond);
			if (studentList.size() == 0) {
				return null;
			}
			return studentList.get(0);
		
		}
		catch(Exception e) {
			
			throw new SystemException(
					StudentDAO.class, 
					"findByIdの実行に失敗しました。",e);
		}
	}
		
	/**
	 * 生徒のデータ登録
	 * 
	 * @param conn
	 * @param student
	 */
	public void insert(Student student) {
			
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		PreparedStatement stmt = null;
		
		try {
			
			int studentId = getStudentIdFromSeq();
			student.setStudentId(studentId);
			
			// SQL文を構築
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO m_student(			");
			sql.append("				  student_id	");
			sql.append("				, student_name	");
			sql.append("				, gender_cd		");
			sql.append("				, pref_id		");
			sql.append("				, age			");
			sql.append("				, birthday		");
			sql.append("			 ) VALUES (			");
			sql.append("				  ?				");
			sql.append("				, ?				");
			sql.append("				, ?				");
			sql.append("				, ?				");
			sql.append("				, ?				");
			sql.append("				, ?				");
			sql.append("			 )					");
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, student.getStudentId());
			stmt.setString(2, student.getStudentName());
			stmt.setString(3, student.getGenderCd());
			stmt.setInt(4, student.getPrefId());
			stmt.setInt(5,student. getAge());
			stmt.setDate(6, MyDateUtils.convDate(student.getBirthday()));
			
			// INSERT文を実行
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			
			throw new SystemException(
					StudentDAO.class, 
					"insertの実行に失敗しました。",e);
		
		}
		finally {
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
			
		}
	}
	/**
	 * シーケンスから生徒IDを取得
	 * 
	 * @param conn
	 * @return studentId(rs.getInt("nextval"))
	 */
	public int getStudentIdFromSeq() {
		
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(" select nextval('student_id_seq')");
			
			if (!rs.next()) {
				throw new SQLException("シーケンスが取得できません。");
			}
			
			return rs.getInt("nextval");
		
		}
		catch(Exception e) {
			
			throw new SystemException(
					StudentDAO.class, 
					"getStudentIdFromSeqの実行に失敗しました。",e);
		}
		finally {
			// 結果セットの破棄
			DBUtils.close(rs);
			// ステートメントの破棄
			DBUtils.close(stmt);
			
		}
	}
	
	/**
	 * 生徒のデータ更新
	 * 
	 * @param conn
	 * @param student
	 */
	public void update(Student student) {
			
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		PreparedStatement stmt = null;
		
		try {
			
			Counter counter = new Counter();
			
			// SQL文を構築
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE m_student	   ");			
			MySQLUtils.setUpdate(sql, "student_name", student.getStudentName(), counter);
			MySQLUtils.setUpdate(sql, "gender_cd", student.getGenderCd(), counter);
			MySQLUtils.setUpdate(sql, "pref_id", student.getPrefId(), counter);
			MySQLUtils.setUpdate(sql, "age", student.getAge(), counter);
			MySQLUtils.setUpdate(sql, "birthday", student.getBirthday(), counter);
			sql.append("  WHERE student_id = ? ");
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, student.getStudentId());
			
			// UPDATE文を実行 / 更新失敗(更新件数0件以下)の場合エラーを投げる
			int ret = stmt.executeUpdate();
			if (ret <= 0) {
				throw new SystemException(
						StudentDAO.class, 
						"生徒情報の更新に失敗しました：" + student.toString());
			}
			
		}
		catch(Exception e) {
			
			throw new SystemException(
					StudentDAO.class, 
					"updateの実行に失敗しました。",e);
		}
		finally {
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
			
		}
	}
	
	/**
	 * 生徒のデータ削除
	 * 
	 * @param conn
	 * @param id
	 */
	public void delete(Integer id) {
			
		Connection conn = DataSourceUtils.getConnection(dataSource);
		
		PreparedStatement stmt = null;
		
		try {
			
			// SQL文を構築
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM m_student		");
			sql.append("	   WHERE student_id	= ? ");
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, id);
			
			// DELETE文を実行
			stmt.executeUpdate();
			
		}
		catch(Exception e) {
			
			throw new SystemException(
					StudentDAO.class, 
					"deleteの実行に失敗しました。", e);
		}
		finally {
			// ステートメントオブジェクトの破棄
			DBUtils.close(stmt);
			
		}
	}
}
