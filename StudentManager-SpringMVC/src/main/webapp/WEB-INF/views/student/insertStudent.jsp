<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報 登録入力画面</title>
</head>
<body>
	
	<h4>生徒情報登録</h4>
	
	<form:form modelAttribute="studentP" method="post"
		action="${pageContext.request.contextPath}/student/insertConfirm">
		
		生徒名：<form:input type="text" path="studentName"/>
			<form:errors path="studentName"/>
		
		<br>
		<br>
		
		都道府県：<form:select path="prefId">
			<form:option value="" label="(未選択)"/>
			<form:options items="${CL_PREF}" />
		</form:select>
		<form:errors path="prefId"/>
		
		<br>
		<br>
		
		性別：<form:radiobuttons items="${CL_GENDER}" path="genderCd"/>
			<form:errors path="genderCd"/>
		
		<br>
		<br>
		
		年齢：<form:select path="age">
			<form:option value="" label="(未選択)"/>
			<form:options items="${CL_AGE}"/>
		</form:select>
		<form:errors path="age"/>
		
		<br>
		<br>
		
		生年月日：<form:input type="date" path="birthday"/>
			<form:errors path="birthday"/>
		
		<br>
		<br>
		
		履修教科：<form:checkboxes items="${CL_SUBJECT}" path="receiveSubjectArr"/>
			<form:errors path="receiveSubjectArr"/>
		
		<br>
		<br>
		
		<input type="submit" value="登録確認"/>
		
	</form:form>
	
	<br>
	
	<form:form method="post" action="${pageContext.request.contextPath}/student/showList">
		<input type="submit" value="検索一覧"/>
	</form:form>
	
</body>
</html>