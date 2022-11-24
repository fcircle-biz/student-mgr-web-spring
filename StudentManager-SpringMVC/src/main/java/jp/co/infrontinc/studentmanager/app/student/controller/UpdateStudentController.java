package jp.co.infrontinc.studentmanager.app.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.infrontinc.studentmanager.app.student.model.StudentP;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;

/**
 * 生徒情報登録コントローラ
 * 
 * ・入力画面表示 [GET :student/update]
 * ・確認画面表示 [POST:student/updateConfirm]
 * ・登録実行     [POST:student/update]
 */
@Controller
@RequestMapping("student")
@SessionAttributes("studentP")
public class UpdateStudentController extends AbstractStudentController {
	
	/**
	 * プレゼンテーションモデルの初期化
	 *  
	 * @return
	 */
	@ModelAttribute
	public StudentP setupStudent() {
		return new StudentP();
	}
	
	
	/**
	 * 入力画面表示
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("update")
	public String do_show(@RequestParam("studentId") String studentId, StudentP studentP, Model model) throws NumberFormatException, Exception {
		
		if (studentP.isConfirmed()) {
			return "student/updateStudent";
		}
		
		Student student = studentService.findById(Integer.valueOf(studentId));
		studentP = StudentModelHelper.s2p(student, studentP);
		model.addAttribute("studentP", studentP);
		
		return "student/updateStudent";
	}

	/**
	 * 確認画面表示
	 * 
	 * @param studentP
	 * @return
	 */
	@PostMapping("updateConfirm")
	public String do_showConfirm(@Validated StudentP studentP, BindingResult result) {
		
		if (result.hasErrors()) {
			return "student/updateStudent";
		}
		
		studentP.setConfirmed(true);
		return "student/updateConfirmStudent";
	}
	
	/**
	 * 登録実行
	 * 
	 * @param studentP
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("update")
	public String do_update(StudentP studentP, SessionStatus sessionStatus) throws Exception {
		
		Student student = StudentModelHelper.p2s(studentP);
		
		studentService.update(student);
		
		System.out.println(student);
		
		sessionStatus.setComplete();
		
		return "student/updateCompleteStudent";
	}
}