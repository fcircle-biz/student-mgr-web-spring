package jp.co.infrontinc.studentmanager.app.student.model;

import lombok.Data;

// 生徒テーブルに対応したデータ格納用のクラス
// 性別、都道府県名称、履修教科の情報も持たせる


@Data
public class StudentCP {

	private Integer studentId;
	private String studentName;
	private Integer prefId;
	
	public StudentCP() {
	}
	
	private boolean isSearched;
}
