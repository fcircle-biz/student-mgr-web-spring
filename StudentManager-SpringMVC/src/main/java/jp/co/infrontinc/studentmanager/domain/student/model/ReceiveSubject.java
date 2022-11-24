package jp.co.infrontinc.studentmanager.domain.student.model;

// 生徒別履修教科テーブルに対応したデータ格納クラス。教科マスタの情報も持たせる
public class ReceiveSubject {
	
	private int studentId;
	private String subjectCd;
	private String subjectName;
	
	public ReceiveSubject() {
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public String getSubjectCd() {
		return subjectCd;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public void setSubjectCd(String subjectCd) {
		this.subjectCd = subjectCd;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	// オブジェクト情報取得（生徒ID[?], 教科コード[?], 教科[?]を出力する）
	public String toString() {
		return "生徒ID：" + studentId 
			 + "\t教科コード：" + subjectCd 
			 + "\t教科：" + subjectName;
	}
}
