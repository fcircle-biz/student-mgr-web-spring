package jp.co.infrontinc.studentmanager.app.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.infrontinc.studentmanager.app.student.model.StudentCP;
import jp.co.infrontinc.studentmanager.domain.common.code.PrefCodeMaster;
import jp.co.infrontinc.studentmanager.domain.student.model.Student;
import jp.co.infrontinc.studentmanager.domain.student.model.StudentC;
import jp.co.infrontinc.studentmanager.domain.student.service.StudentService;

/**
 * 生徒情報登録コントローラ
 * 
 * ・検索画面表示 [GET :student/showList]
 * ・検索結果表示 [POST:student/showList]
 */
@Controller
@RequestMapping("student")
@SessionAttributes("studentCP")
public class ShowListStudentController {
	
	/**
	 * プレゼンテーションモデルの初期化
	 *  
	 * @return
	 */
	@ModelAttribute
	public StudentCP setupStudent() {
		return new StudentCP();
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
	 * 検索画面表示
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("showList")
	public String do_show(StudentCP studentCP, Model model) throws Exception {
		
		if (studentCP.isSearched()) {
			return do_showList(studentCP, model);
		}
		
		List<Student> studentList = null;
		model.addAttribute("studentList", studentList);
		
		return "student/showListStudent";
	}
	
	/**
	 * 検索結果表示
	 * 
	 * @param studentP 生徒情報プレゼンテーションモデル
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("showList")
	public String do_showList(StudentCP studentCP, Model model) throws Exception {
		
		StudentC studentC = StudentModelHelper.p2s(studentCP);
		StudentService service = new StudentService();
		List<Student> studentList = service.findByCondition(studentC);
		
		model.addAttribute("studentList", studentList);
		studentCP.setSearched(true);
		
		return "student/showListStudent";
	}
}