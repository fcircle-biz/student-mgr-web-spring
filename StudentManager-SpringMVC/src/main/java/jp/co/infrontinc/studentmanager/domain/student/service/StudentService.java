package jp.co.infrontinc.studentmanager.domain.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private ReceiveSubjectDAO receiveSubjectDAO;
	
	/**
	 * 条件検索
	 * 
	 * @param pcond
	 * @return studentList
	 */
	public List<Student> findByCondition(StudentC pcond) {
		
		return studentDAO.findByCondition(pcond);
	}
	
	/**
	 * 生徒ID指定による検索
	 * 
	 * @param id
	 * @return syudent(studentDAO.findById(conn, id))
	 */
	public Student findById(Integer id) {
		
		return studentDAO.findById(id);
	}
	
	/**
	 * 全件検索
	 * 
	 * @return studentList(findByCondition(null))
	 */
	public List<Student> findAll() {
		return findByCondition(null);
	}
	
	/**
	 * 登録
	 * 
	 * @param student
	 */
	public void insert(Student student) {
		
		studentDAO.insert(student);
		
		for (ReceiveSubject rsub : student.getReceiveSubjectList()) {
			rsub.setStudentId(student.getStudentId());
			receiveSubjectDAO.insert(rsub);
		}
	}
	
	/**
	 * 更新
	 * 
	 * @param student
	 */
	public void update(Student student) {
		
		studentDAO.update(student);
		
		if(student.isNotEmpty(student.getReceiveSubjectList())) {
			receiveSubjectDAO.updateByStudentId(student.getStudentId(), student.getReceiveSubjectList());
		}
	}
	
	/**
	 * 削除
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		
		studentDAO.delete(id);
		receiveSubjectDAO.deleteByStudentId(id);
	}
}
