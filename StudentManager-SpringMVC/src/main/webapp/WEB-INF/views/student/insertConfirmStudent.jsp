<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報 登録確認画面</title>
</head>
<body>

	<h4>以下の内容で登録します。</h4>
	
	<p>生徒名：<c:out value="${studentP.studentName}"/></p>
	
	<p>都道府県：<c:out value="${CL_PREF[studentP.prefId]}"/></p>
	
	<p>性別：<c:out value="${CL_GENDER[studentP.genderCd]}"/></p>
	
	<p>年齢：<c:out value="${CL_AGE[studentP.age]}"/></p>
	
	<p>生年月日：<c:out value="${studentP.getStrBirthday()}"/></p>
	
	<p>履修教科：<c:out value="${studentP.getReceiveSubjectName()}"/></p>
	
	<form:form modelAttribute="studentP" method="post" 
			action="${pageContext.request.contextPath}/student/insert">
		<input type="submit" value="登録"/>
	</form:form>
	
	<br>
	
	<form:form modelAttribute="studentP" method="get" 
			action="${pageContext.request.contextPath}/student/insert">
		<input type="submit" value="戻る"/>
	</form:form>
	
</body>
</html>
