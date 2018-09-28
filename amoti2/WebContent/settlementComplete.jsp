<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/amoti.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>決済完了</title>
<script>
history.pushState(null, null, null);
$(window).on("popstate", function (event) {
    if (!event.originalEvent.state) {
        history.pushState(null, null, null);
        return;
    }
});
</script>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>決済完了画面</h1>
<div class="process">
決済が完了しました。
</div>
</div>
	<s:include value="footer.jsp"/>
</body>
</html>