<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報 登録確認画面</title>
</head>
<body>

	<h4>以下の内容で更新します。</h4>
	
	<p>生徒ID：<c:out value="${student.studentId}"/></p>
	
	<p>生徒名：<c:out value="${studentP.studentName}"/></p>
	
	<p>都道府県：<c:out value="${CL_PREF[studentP.prefId]}"/></p>
	
	<p>性別：<c:out value="${CL_GENDER[studentP.genderCd]}"/></p>
	
	<p>年齢：<c:out value="${CL_AGE[studentP.age]}"/></p>
	
	<p>生年月日：<c:out value="${studentP.getStrBirthday()}"/></p>
	
	<p>履修教科：<c:out value="${studentP.getReceiveSubjectName()}"/></p>
	
	<form:form method="post" 
			action="${pageContext.request.contextPath}/student/update">
		<input type="submit" value="更新"/>
	</form:form>
	
	<br>
	
	<form:form method="get" 
			action="${pageContext.request.contextPath}/student/update">
		<input type="hidden" name="studentId" value="${studentP.studentId}"/>
		<input type="submit" value="戻る"/>
	</form:form>
	
</body>
</html>
