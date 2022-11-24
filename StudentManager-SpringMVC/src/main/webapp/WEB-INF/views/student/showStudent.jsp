<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報詳細</title>
</head>
<body>

	<h4>生徒情報詳細</h4>
	
	<p>生徒ID：<c:out value="${student.studentId}"/></p>
	
	<p>生徒名：<c:out value="${student.studentName}"/></p>
	
	<p>都道府県：<c:out value="${student.prefName}"/></p>
	
	<p>性別：<c:out value="${student.genderName}"/></p>
	
	<p>年齢：<c:out value="${student.age}"/>歳</p>
	
	<p>生年月日：<c:out value="${student.birthday}"/></p>
	
	<p>履修教科：<c:out value="${student.receiveSubjectName}"/></p>
	
	<form:form method="get" 
			action="${pageContext.request.contextPath}/student/update">
		<input type="hidden" name="studentId" value="${student.studentId}"/>
		<input type="submit" value="更新"/>
	</form:form>
	
	<br>
	
	<form:form method="post" 
			action="${pageContext.request.contextPath}/student/deleteConfirm?studentId=${student.studentId}">
		<input type="submit" value="削除"/>
	</form:form>
	
	<br>
	
	<form:form modelAttribute="studentP" method="get" 
			action="${pageContext.request.contextPath}/student/showList">
		<input type="submit" value="検索一覧"/>
	</form:form>
	
</body>
</html>
