package jp.co.infrontinc.studentmanager.app.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.infrontinc.studentmanager.domain.common.code.AgeCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.code.GenderCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.code.PrefCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.code.SubjectCodeMaster;
import jp.co.infrontinc.studentmanager.domain.student.service.StudentService;

/**
 * 生徒情報コントローラの基底クラス
 * 
 * @author 市丸聡
 */
public abstract class AbstractStudentController {
	
	@Autowired
	protected StudentService studentService;
	
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

}
