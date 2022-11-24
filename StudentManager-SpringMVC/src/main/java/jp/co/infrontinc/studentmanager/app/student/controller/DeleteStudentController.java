package jp.co.infrontinc.studentmanager.app.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.infrontinc.studentmanager.domain.student.model.Student;
import jp.co.infrontinc.studentmanager.domain.student.service.StudentService;

/**
 * 生徒情報削除コントローラ
 * 
 * ・確認画面表示 [POST:student/deleteConfirm]
 * ・削除実行     [POST:student/deleteComplete]
 */
@Controller
@RequestMapping("student")
//@SessionAttributes("studentP")
public class DeleteStudentController {
	
	/**
	 * 削除確認画面表示
	 * 
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("deleteConfirm")
	public String do_show(@RequestParam("studentId") String studentId, Model model) throws Exception {
		
		StudentService service = new StudentService();
		Student student = service.findById(Integer.valueOf(studentId));
		System.out.println(student);
		
		model.addAttribute("student", student);
		
		return "student/deleteConfirmStudent";
	}
	
	/**
	 * 削除実行
	 * 
	 * @param studentP
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("deleteComplete")
	public String do_delete(@RequestParam("studentId") String studentId) throws Exception {
		
		StudentService service = new StudentService();
		service.delete(Integer.valueOf(studentId));
		
		return "student/deleteCompleteStudent";
	}
}