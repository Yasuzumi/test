<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./css/amoti.css">
<title>ログイン</title>

<script>
function goLoginAction(){
	document.getElementById("form").action="LoginAction";
}
function goCreateUserAction(){
	document.getElementById("form").action="CreateUserAction";
}
function goResetPasswordAction(){
	document.getElementById("form").action="ResetPasswordAction";
}
</script>

</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>ログイン画面</h1>
<s:form id="form" action="LoginAction">
	<table class="vertical-list-table">
		<tr>
			<th class="value" scope="row"><s:label value="ログインID"/></th>
			<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
					<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<s:if test="#session.savedLoginIdFlg==true">
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" value='%{#session.savedLoginId}' autocomplete="new-password"/></td>
			</s:if>
			<s:else>
			<td><s:textfield name="loginId" class="txt" placeholder="ログインID" autocomplete="new-password"/></td>
			</s:else>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="パスワード"/></th>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
					<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="new-password"/></td>
		</tr>
	</table>
	<div class="box">
		<s:if test="#session.savedLoginIdFlg==true">
			<s:checkbox name="savedLoginIdFlg" checked="checked"/>
		</s:if>
		<s:else>
			<s:checkbox name="savedLoginIdFlg"/>
		</s:else>
		<s:label value="ログインID保存"/><br>
	</div>
	<div class="submit_btn_box">
		<s:submit value="ログイン" class="submit_btn" onclick="goLoginAction();"/>
	</div>
</s:form>
<br>
<div class="submit_btn_box">
	<div id=".contents-btn-set">
		<s:form action="CreateUserAction">
			<s:submit value="新規ユーザー登録" class="submit_btn" />
		</s:form>
	</div>
</div>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:form action="ResetPasswordAction">
	<s:submit value="パスワード再設定" class="submit_btn" />
</s:form>
</div>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>