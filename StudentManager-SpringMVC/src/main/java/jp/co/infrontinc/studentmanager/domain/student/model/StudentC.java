package jp.co.infrontinc.studentmanager.domain.student.model;

// 生徒テーブルに対応したデータ格納用のクラス
// 性別、都道府県名称、履修教科の情報も持たせる
public class StudentC {

	private final String KEY = "SESSION_KEY_STUNDENT_C";
	private Integer studentId;
	private String studentName;
	private Integer prefId;
	
	public StudentC() {
	}
	
	public StudentC(String studentName,Integer prefId) {
		this.studentName = studentName;
		this.prefId = prefId;
	}
	
	public String getKey() {
		return KEY;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public String getStudentName() {
		return this.studentName;
	}

	public Integer getPrefId() {
		return prefId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setPrefId(Integer prefId) {
		this.prefId = prefId;
	}
}
