<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>生徒情報 登録完了画面</title>
</head>
<body>

	<h4>生徒情報の登録が完了しました。</h4>
	
	<form:form modelAttribute="studentP" method="get" 
			action="${pageContext.request.contextPath}/student/showList">
		<input type="submit" value="検索一覧"/>
	</form:form>
	
</body>
</html>
