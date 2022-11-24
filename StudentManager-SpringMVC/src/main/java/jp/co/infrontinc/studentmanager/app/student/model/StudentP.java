package jp.co.infrontinc.studentmanager.app.student.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import jp.co.infrontinc.studentmanager.domain.common.code.SubjectCodeMaster;
import jp.co.infrontinc.studentmanager.domain.common.util.MyDateUtils;
import jp.co.infrontinc.studentmanager.domain.student.model.ReceiveSubject;
import lombok.Data;

@Data
public class StudentP {
	
	private Integer studentId;
	
	@NotBlank
	@Size(max = 30, message = "生徒名は30桁以内で入力してください。")
	private String studentName;
	
	@NotNull
	private String genderCd;
	
	@NotNull
	private Integer prefId;
	
	@NotNull
	private Integer age;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	public String getStrBirthday() {
		return MyDateUtils.dateToString(birthday,"yyyy-MM-dd");
	}
	
	@NotEmpty
	private String[] receiveSubjectArr = new String[0];
	
	public void listToArray(List<ReceiveSubject> receiveSubjectList) {
		
		String[] tempArr = new String[receiveSubjectList.size()];
		for (int i = 0; i < receiveSubjectList.size(); i++) {
			tempArr[i] = receiveSubjectList.get(i).getSubjectCd();
		}
		this.receiveSubjectArr = tempArr;
	}
	
	public String getReceiveSubjectName() {
		
		SubjectCodeMaster mstSubjectCodeMaster = new SubjectCodeMaster();
		StringBuilder sb = new StringBuilder();
		
		for (String sub : receiveSubjectArr) {
			sb.append(mstSubjectCodeMaster.getValue(sub));
			sb.append(" ");
		}
		return sb.toString();
	}
	
	private List<ReceiveSubject> receiveSubjectList;
	
	public List<ReceiveSubject> getReceiveSubjectList() {
		
		receiveSubjectList = new ArrayList<>();
		for (String subCd : receiveSubjectArr) {
			ReceiveSubject receiveSubject = new ReceiveSubject();
			receiveSubject.setSubjectCd(subCd);
			receiveSubjectList.add(receiveSubject);
		}
		return receiveSubjectList;
	}
	
	private boolean isConfirmed;
}
