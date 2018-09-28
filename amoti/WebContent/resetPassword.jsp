<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/amoti.css">
<title>パスワード再設定</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>パスワード再設定画面</h1>
<s:form action="ResetPasswordConfirmAction">
	<table class="vertical-list-table">
		<tr>
			<th class="value" scope="row"><s:label value="ログインID"/></th>
			<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<td><s:textfield name="loginId" placeholder="ログインID" class="txt" autocomplete="new-password"/></td>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="現在のパスワード"/></th>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.passwordErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<s:if test="!#session.passwordIncorrectErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.passwordIncorrectErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<td><s:password name="password" placeholder="現在のパスワード" class="txt" autocomplete="new-password"/></td>
		</tr>

		<tr>
			<th class="value" scope="row"><s:label value="新しいパスワード"/></th>
			<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.newPasswordErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<td><s:password name="newPassword" placeholder="新しいパスワード" class="txt" /></td>
		<tr>
			<th class="value" scope="row"><s:label value="（再確認用）"/></th>
			<s:if test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</th>
			</s:if>
			<s:if test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
			<th>
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.newPasswordIncorrectErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</th><br>
			</s:if>
			<td><s:password name="reConfirmationPassword" placeholder="新しいパスワード（再確認用）" class="txt" /></td>
		</tr>
		</table>
<div class="submit_btn_box">
<s:submit value="パスワード再設定" class="submit_btn" />
</div>
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>