package jp.co.infrontinc.studentmanager.domain.common.util;

import java.util.List;
import java.util.Map;

import jp.co.infrontinc.studentmanager.domain.common.code.SubjectCodeMaster;
import jp.co.infrontinc.studentmanager.domain.student.model.ReceiveSubject;

/**
 * MyReceiveSubjectJSPユーティリティ
 * 
 * 
 */
public class MyReceiveSubjectJSPUtils {
	/**
	 * 教科コードの入った配列から教科名を列挙
	 * 
	 * @param mstSubjectCode 教科コードマスタ
	 * @param value 教科コードが入った配列
	 * @return 配列の中身が空でなければ教科名を列挙した文字列
	 *			配列の中身が空なら空文字（""）
	 */
	public static String showSubjectName(SubjectCodeMaster mstSubjectCode, String[] SubjectCds) {
		
		if (SubjectCds != null) {
			
			StringBuilder result = new StringBuilder();
			for(String subjectCd : SubjectCds) {
				
				result.append(mstSubjectCode.getValue(subjectCd));
				result.append(" ");
			}
		
			return result.toString();
			
		} else {
			
			return "";
		}
	}
	
	public static String showSubjectName(Map<String,String> map, String[] SubjectCds) {
		
		if (SubjectCds != null) {
			
			StringBuilder result = new StringBuilder();
			for(String subjectCd : SubjectCds) {
				
				result.append(map.get(subjectCd));
				result.append(" ");
			}
			
			return result.toString();
			
		} else {
			
			return "";
		}
	}
	
	/**
	 * 教科コードの入ったリストから教科名を列挙
	 * 
	 * @param mstSubjectCode 教科コードマスタ
	 * @param value 教科コードが入った配列
	 * @return リストの中身が空でなければ教科名を列挙した文字列
	 *			リストの中身が空なら空文字（""）
	 */
	public static String showSubjectName(SubjectCodeMaster mstSubjectCode, List<ReceiveSubject> receiveSubjectList) {
		
		if (receiveSubjectList != null) {
			
			StringBuilder result = new StringBuilder();
			for(ReceiveSubject receiveSubject : receiveSubjectList) {
				
				result.append(mstSubjectCode.getValue(receiveSubject.getSubjectCd()));
				result.append(" ");
			}
		
			return result.toString();
			
		} else {
			
			return "";
		}
	}
}
