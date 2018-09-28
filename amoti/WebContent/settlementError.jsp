<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/settlementConfirm.css">
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>決済エラー</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>決済エラー</h1>
<div class="info">
<p>決済出来ません。<p>
</div>
</div>
<div id="footer">
<s:include value="footer.jsp"/>
</div>
</body>
</html>