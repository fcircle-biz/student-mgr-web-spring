package jp.co.infrontinc.studentmanager.app.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.infrontinc.studentmanager.domain.student.model.Student;

/**
 * 生徒情報詳細コントローラ
 * 
 * ・詳細画面表示 [GET :student/show]
 */
@Controller
@RequestMapping("student")
public class ShowStudentController extends AbstractStudentController {
	
	/**
	 * 詳細画面表示
	 *
	 * @param studentId
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("show")
	public String do_show(@RequestParam("studentId") String studentId, Model model) throws Exception {
	//public String do_show(Integer studentId, Model model) throws Exception { 変数名が一致していればこれでも可
		
		Student student = studentService.findById(Integer.valueOf(studentId));
		System.out.println(student);
		
		//本来、ストアモデル→プレゼンモデルの変換が必要
		//StudentP studentP =  StudentModelHelper.s2p(student);
		
		model.addAttribute("student", student);
		
		return "student/showStudent";
	}
}