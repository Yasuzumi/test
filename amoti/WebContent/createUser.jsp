<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/amoti.css">
<title>ユーザ情報入力</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>ユーザー情報入力画面</h1>
<s:form action="CreateUserConfirmAction">
	<table class="vertical-list-table">
		<tr>
			<th class="value" scope="row"><s:label value="姓"/></th>
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
			<th>
			<div class="error">
			<div class="error-message">
				<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
			</div>
			</div>
			</th>
			</s:if>
			<td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt" /></td>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="名"/></th>
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
			<th>
			<div class="error">
			<div class="error-message">
				<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
			</div>
			</div>
			</th>
			</s:if>
			<td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名" class="txt" /></td>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="姓ふりがな"/></th>
			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
			<th>
			<div class="error">
			<div class="error-message">
				<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
			</div>
			</div>
			</th>
			</s:if>
			<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" /></td>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="名ふりがな"/></th>
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
			<th>
			<div class="error">
			<div class="error-message">
				<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
			</div>
			</div>
			</th>
			</s:if>
			<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" /></td>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="性別"/></th>
			<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別"/></td>
		</tr>
		<tr>
			<th class="value" scope="row"><s:label value="メールアドレス"/></th>
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
			<th>
			<div class="error">
			<div class="error-message">
				<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
			</div>
			</div>
			</th>
			</s:if>
			<td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
		</tr>
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
			<td><s:textfield name="loginId" value="%{#session.loginId}" label="ログインID" placeholder="ログインID" class="txt" autocomplete="new-password"/></td>
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
			<td><s:password name="password" value="" label="パスワード" placeholder="パスワード" class="txt" autocomplete="new-password"/></td>
		</tr>
	</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="登録" class="submit_btn" />
</div>
</div>
</s:form>
</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>