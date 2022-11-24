<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報 検索画面</title>
</head>
<body>

	<h4>生徒情報検索</h4>
	
	<form:form modelAttribute="studentCP" method="post" 
		action="${pageContext.request.contextPath}/student/showList">
		
		生徒名：<form:input path="studentName" type="text"/>
		
		<br>
		<br>
		
		都道府県：<form:select path="prefId">
				<form:option value="" label="(未選択)"/>
				<form:options items="${CL_PREF}"/>
			</form:select>
			
		<br>
		<br>
		
		<input type="submit" value="検索"/>
		
	</form:form>
	
	<br>
	
	<c:if test="${studentList != null}">
		<table border="1">
		
			<tr>
				<th>生徒ID</th>
				<th>生徒名</th>
				<th>都道府県</th>
				<th>性別</th>
				<th>年齢</th>
				<th>生年月日</th>
				<th>履修教科</th>
			</tr>
			
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/student/show?studentId=${student.studentId}">
							<c:out value="${student.studentId}"/>
						</a>
					</td>
					<td><c:out value="${student.studentName}"/></td>
					<td><c:out value="${student.prefName}"/></td>
					<td><c:out value="${student.genderName}"/></td>
					<td><c:out value="${student.age}"/></td>
					<td><c:out value="${student.birthday}"/></td>
					<td><c:out value="${student.getReceiveSubjectName()}"/></td>
				</tr>
			</c:forEach>
			
		</table>
		<br>
	</c:if>
	
	<form:form method="get" 
			action="${pageContext.request.contextPath}/student/insert">
		<input type="submit" value="新規登録">
	</form:form>
		
</body>
</html>