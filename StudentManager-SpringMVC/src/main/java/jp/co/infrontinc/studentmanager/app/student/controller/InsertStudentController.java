package jp.co.infrontinc.studentmanager.app.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.co.infrontinc.studentmanager.app.student.model.StudentP;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;

/**
 * 生徒情報登録コントローラ
 * 
 * ・入力画面表示 [GET :student/insert]
 * ・確認画面表示 [POST:student/insertConfirm]
 * ・登録実行     [POST:student/insert]
 */
@Controller
@RequestMapping("student")
@SessionAttributes("studentP")
public class InsertStudentController extends AbstractStudentController {
	
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
	 */
	@GetMapping("insert")
	public String do_show() {
		return "student/insertStudent";
	}

	/**
	 * 確認画面表示
	 * 
	 * @param studentP
	 * @return
	 */
	@PostMapping("insertConfirm")
	public String do_showConfirm(@Validated StudentP studentP, BindingResult result) {
		
		if (result.hasErrors()) {
			return "student/insertStudent";
		}
		
		return "student/insertConfirmStudent";
	}
	
	/**
	 * 登録実行
	 * 
	 * @param studentP
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("insert")
	public String do_insert(StudentP studentP, SessionStatus sessionStatus) throws Exception {
				
		Student student = StudentModelHelper.p2s(studentP);
		
		studentService.insert(student);
		
		sessionStatus.setComplete();
		
		return "redirect:/student/insertComplete"; //PRGパターン実装
	}
	
	/**
	 * 登録完了画面表示（PRGパターン実装）
	 * 
	 * @param studentP
	 * @return
	 */
	@GetMapping("insertComplete")	
	public String do_insertComplete(StudentP studentP) {
		return "student/insertCompleteStudent";
	}
}