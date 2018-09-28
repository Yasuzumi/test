<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/amoti.css">
<title>宛先情報入力</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>宛先情報入力画面</h1>

<s:form action="CreateDestinationConfirmAction">
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
	<td><s:textfield name="familyName" class="txt" value="%{#session.familyName}"/></td>
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
	<td><s:textfield name="firstName" class="txt" value="%{#session.firstName}"/></td>
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
	<td><s:textfield name="familyNameKana" class="txt" value="%{#session.familyNameKana}"/></td>
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
	<td><s:textfield name="firstNameKana" class="txt" value="%{#session.firstNameKana}"/></td>
</tr>

<tr>
	<th class="value" scope="row"><s:label value="性別"/></th>
	<td><s:radio name="sex" list="sexList" value="defaultSexValue" label="性別" placeholder="性別"/></td>
</tr>

<tr>
	<th class="value" scope="row"><s:label value="住所"/></th>
	<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
	<th>
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</th>
	</s:if>
	<td><s:textfield name="userAddress" class="txt" value="%{#session.userAddress}"/></td>
</tr>

<tr>
	<th class="value" scope="row"><s:label value="電話番号"/></th>
	<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
	<th>
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
	</th>
	</s:if>
	<td><s:textfield name="telNumber" class="txt" value="%{#session.telNumber}"/></td>
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
	<td><s:textfield name="email" class="txt" value="%{#session.email}"/></td>
</tr>
</table>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:submit value="宛先情報確認" class="submit_btn" />
</div>
</div>
</s:form>
</div>
<s:include value="footer.jsp"/>
</body>
</html>