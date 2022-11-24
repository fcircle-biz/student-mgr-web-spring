package jp.co.infrontinc.studentmanager.domain.student.model;

import java.util.Date;
import java.util.List;

import jp.co.infrontinc.studentmanager.domain.common.code.SubjectCodeMaster;

// 生徒テーブルに対応したデータ格納用のクラス
// 性別、都道府県名称、履修教科の情報も持たせる
public class Student {
	
	private int studentId;
	private String studentName;
	private String genderCd;
	private String genderName;
	private int prefId;
	private String prefName;
	private int age;
	private Date birthday;
	private List<ReceiveSubject> receiveSubjectList;
	
	public Student() {
	}
	
	public int getStudentId() {
		return this.studentId;
	}
	
	public String getStudentName() {
		return this.studentName;
	}
	
	public String getGenderCd() {
		return this.genderCd;
	}
	
	public String getGenderName() {
		return this.genderName;
	}
	
	public int getPrefId() {
		return this.prefId;
	}
	
	public String getPrefName() {
		return this.prefName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public List<ReceiveSubject> getReceiveSubjectList() {
		return this.receiveSubjectList;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setGenderCd(String genderCd) {
		this.genderCd = genderCd;
	}
	
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	
	public void setPrefId(int prefId) {
		this.prefId = prefId;
	}
	
	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public void setReceiveSubjectList(List<ReceiveSubject> receiveSubjectList) {
		this.receiveSubjectList = receiveSubjectList;
	}
	
	public String getReceiveSubjectName() {
		
		SubjectCodeMaster mstSubjectCode = new SubjectCodeMaster(); 
		
		StringBuilder result = new StringBuilder();
		for (ReceiveSubject rs : this.receiveSubjectList) {
			
			result.append(mstSubjectCode.getValue(rs.getSubjectCd()));
			result.append(" ");
		}
		return result.toString();
	}
	
	/**
	 * リストがnullかを判別する
	 * 
	 *@param value
	 *@return nullの場合はture。それ以外はfalse
	 */
	public boolean isEmpty( List<ReceiveSubject> value) {
		
		if (value == null || value.size() == 0) {
			
			return true;
		}
		return false;
	}
	
	/**
	 * リストがnullではないかを判別する
	 * 
	 *@param value
	 *@return nullではない場合はtrue。それ以外はfalse。
	 */
	public boolean isNotEmpty( List<ReceiveSubject> value) {
		
		return !isEmpty(value);
	}
	
	// オブジェクト情報取得（生徒ID[?], 生徒名[?], 性別コード[?], 性別[?], 都道府県ID[?], 都道府県[?], 年齢[?], 生年月日[?]と履修教科のtoStringを出力する）
	public String toString() {
		return "生徒ID：" + studentId + "\t生徒名：" + studentName + "\t性別コード：" + genderCd
				+ "\t性別：" + genderName + "\t都道府県ID：" + prefId + "\t都道府県：" + prefName + "\t年齢：" + age
				+ "\t生年月日：" + birthday + "\t履修教科" + receiveSubjectList + "\n";
	}
}
