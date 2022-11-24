package jp.co.infrontinc.studentmanager.app.student.controller;

import java.util.Map;

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
import jp.co.infrontinc.studentmanager.domain.common.code.AgeCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.code.GenderCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.code.PrefCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.code.SubjectCodeMaster;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;
import jp.co.infrontinc.studentmanager.domain.student.service.StudentService;

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
public class InsertStudentController {
	
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
	 * 都道府県コードマスタの初期設定
	 * 
	 * @return
	 */
	@ModelAttribute("CL_PREF")
	public Map<Integer, String> setupPrefCodeList() {
		return new PrefCodeMaster().getMap();
	}
	
	/**
	 * 性別コードマスタの初期設定
	 * 
	 * @return
	 */
	@ModelAttribute("CL_GENDER")
	public Map<String, String> setupGenderCodeList() {
		return new GenderCodeMaster().getMap();
	}
	
	/**
	 * 年齢コードマスタの初期設定
	 * 
	 * @return
	 */
	@ModelAttribute("CL_AGE")
	public Map<Integer, String> setupAgeCodeList() {
		return new AgeCodeMaster().getMap();
	}
	
	/**
	 * 履修教科コードマスタの初期設定
	 * 
	 * @return
	 */
	@ModelAttribute("CL_SUBJECT")
	public Map<String, String> setupSubjectCodeList() {
		return new SubjectCodeMaster().getMap();
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
		StudentService service = new StudentService();
		service.insert(student);
		
		sessionStatus.setComplete();
		
		return "student/insertCompleteStudent";
	}
}