<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報	 削除確認画面</title>
</head>
<body>

	<h4>以下の生徒情報を削除します。</h4>
	
	<p>生徒ID：<c:out value="${student.studentId}"/></p>
	
	<p>生徒名：<c:out value="${student.studentName}"/></p>
	
	<p>都道府県：<c:out value="${student.prefName}"/></p>
	
	<p>性別：<c:out value="${student.genderName}"/></p>
	
	<p>年齢：<c:out value="${student.age}"/>歳</p>
	
	<p>生年月日：<c:out value="${student.birthday}"/></p>
	
	<p>履修教科：<c:out value="${student.getReceiveSubjectName()}"/></p>
	
	<form:form method="post" 
			action="${pageContext.request.contextPath}/student/deleteComplete?studentId=${student.studentId}">
		<input type="submit" value="削除"/>
	</form:form>
	
	<br>
	
	<form:form method="get" 
			action="${pageContext.request.contextPath}/student/show">
		<input type="hidden" name="studentId" value="${student.studentId}"/>
		<input type="submit" value="戻る"/>
	</form:form>
	
</body>
</html>
