package jp.co.infrontinc.studentmanager.domain.student.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.infrontinc.studentmanager.domain.common.util.DBUtils;
import jp.co.infrontinc.studentmanager.domain.student.dao.ReceiveSubjectDAO;
import jp.co.infrontinc.studentmanager.domain.student.dao.StudentDAO;
import jp.co.infrontinc.studentmanager.domain.student.model.ReceiveSubject;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;
import jp.co.infrontinc.studentmanager.domain.student.model.StudentC;

/**
 * 生徒情報サービス / 生徒管理データベースのテーブルを操作するクラス
 * 
 * @author infront
 *
 */
public class StudentService {
	
	private StudentDAO studentDAO = new StudentDAO();
	private ReceiveSubjectDAO receiveSubjectDAO = new ReceiveSubjectDAO();
	
	public StudentService() throws Exception {
		
		// JDBCを利用するための準備
		DBUtils.initJDBC();
	}
	
	/**
	 * 条件検索
	 * 
	 * @param pcond
	 * @return studentList
	 * @throws Exception
	 */
	public List<Student> findByCondition(StudentC pcond) throws Exception {
		
		Connection conn = null;
		List<Student> studentList = null;
		
		try {
			// DB接続
			conn = DBUtils.getConnection();
			
			studentList = studentDAO.findByCondition(conn, pcond);
			
			return studentList;
			
		}
		catch (SQLException e) {
			// ロールバック
			DBUtils.rollback(conn);
			// 例外ハンドリング
			DBUtils.handleException(e);
			System.out.println("DB処理でエラーが発生しました。");
			System.out.println("StudentService.findByConditionの実行に失敗しました。");
			throw e;
			
		}
		finally {
			// DBの切断
			DBUtils.close(conn);
		}
	}
	
	/**
	 * 生徒ID指定による検索
	 * 
	 * @param id
	 * @return syudent(studentDAO.findById(conn, id))
	 * @throws Exception
	 */
	public Student findById(Integer id) throws Exception  {
		
		Connection conn = null;
		
		try {
			// DB接続
			conn = DBUtils.getConnection();
			return studentDAO.findById(conn, id);
			
		}
		catch (SQLException e) {
			
			System.out.println("StudentService.findByIdの実行に失敗しました。");
			throw e;
			
		}
		finally {
			// DBの切断
			DBUtils.close(conn);
		}
		
	}
	
	/**
	 * 全件検索
	 * 
	 * @return studentList(findByCondition(null))
	 * @throws Exception
	 */
	public List<Student> findAll() throws Exception {
		return findByCondition(null);
	}
	
	/**
	 * 登録
	 * 
	 * @param student
	 * @throws Exception
	 */
	public void insert(Student student) throws Exception {
		
		Connection conn = null;
		
		try {
			// DB接続
			conn = DBUtils.getConnection();
			
			studentDAO.insert(conn, student);
			
			for (ReceiveSubject rsub : student.getReceiveSubjectList()) {
				rsub.setStudentId(student.getStudentId());
				receiveSubjectDAO.insert(conn, rsub);
			}
			
			// INSERT文をコミット
			DBUtils.commit(conn);
		
		}
		catch (SQLException e) {
			// ロールバック
			DBUtils.rollback(conn);
			// 例外ハンドリング
			DBUtils.handleException(e);
			System.out.println("DB処理でエラーが発生しました。");
			System.out.println("StudentService.insertの実行に失敗しました。");
			throw e;
			
		}
		finally {
			// DBの切断
			DBUtils.close(conn);
			
		}
	}
	
	/**
	 * 更新
	 * 
	 * @param student
	 * @throws Exception
	 */
	public void update(Student student) throws Exception {
		
		Connection conn = null;
		
		try {
			// DB接続
			conn = DBUtils.getConnection();
			
			studentDAO.update(conn, student);
			
			if(student.isNotEmpty(student.getReceiveSubjectList())) {
				receiveSubjectDAO.updateByStudentId(conn, student.getStudentId(), student.getReceiveSubjectList());
			}
			
			// UPDATE文をコミット
			DBUtils.commit(conn);
		
		}
		catch (SQLException e) {
			// ロールバック
			DBUtils.rollback(conn);
			// 例外ハンドリング
			DBUtils.handleException(e);
			System.out.println("DB処理でエラーが発生しました。");
			System.out.println("StudentService.deleteの実行に失敗しました。");
			throw e;
			
		}
		finally {
			// DBの切断
			DBUtils.close(conn);
			
		}
	}
	
	/**
	 * 削除
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void delete(Integer id) throws Exception {
		
		Connection conn = null;
		
		try {
			// DB接続
			conn = DBUtils.getConnection();
			
			studentDAO.delete(conn, id);
			receiveSubjectDAO.deleteByStudentId(conn, id);
			
			// DELETE文をコミット
			DBUtils.commit(conn);
		
		}
		catch (SQLException e) {
			// ロールバック
			DBUtils.rollback(conn);
			// 例外ハンドリング
			DBUtils.handleException(e);
			System.out.println("DB処理でエラーが発生しました。");
			System.out.println("StudentService.deleteの実行に失敗しました。");
			throw e;
			
		}
		finally {
			// DBの切断
			DBUtils.close(conn);
			
		}
	}
}
