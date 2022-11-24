package jp.co.infrontinc.studentmanager.app.student.controller;

import java.util.List;

import jp.co.infrontinc.studentmanager.app.student.model.StudentCP;
import jp.co.infrontinc.studentmanager.app.student.model.StudentP;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;
import jp.co.infrontinc.studentmanager.domain.student.model.StudentC;

public class StudentModelHelper {
	
	public static Student p2s(StudentP studentP) {
		
		Student student = new Student();
		
		if (studentP.getStudentId() != null) {
			student.setStudentId(studentP.getStudentId());
		}
		student.setStudentName(studentP.getStudentName());
		student.setGenderCd(studentP.getGenderCd());
		student.setPrefId(studentP.getPrefId());
		student.setAge(studentP.getAge());
		student.setBirthday(studentP.getBirthday());
		student.setReceiveSubjectList(studentP.getReceiveSubjectList());
		
		return student;
	}
	
	public static StudentC p2s(StudentCP studentCP) {
		
		StudentC studentC = new StudentC();
		studentC.setStudentName(studentCP.getStudentName());
		studentC.setPrefId(studentCP.getPrefId());
		
		return studentC;
	}
	
	public static StudentP s2p(Student student, StudentP studentP) {
		
		student.setStudentId(studentP.getStudentId());
		studentP.setStudentName(student.getStudentName());
		studentP.setGenderCd(student.getGenderCd());
		studentP.setPrefId(student.getPrefId());
		studentP.setAge(student.getAge());
		studentP.setBirthday(student.getBirthday());
		studentP.setReceiveSubjectList(student.getReceiveSubjectList());
		studentP.listToArray(student.getReceiveSubjectList());
		
		return studentP;
	}
	
	public static List<StudentP> ls2lp(List<Student> studentList) {
		
		return null;
	}	
}
