<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>UserList画面</title>

	<style type="text/css">
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}

		table{
			text-align:center;
			margin:0 auto;
			border:1px solid black;
		}
		/* ========ID LAYOUT======== */
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#header{
			width:100%;
			height:80px;
			background-color:black;
		}

		#main{
			width:100%;
			height:500px;
			text-align:center;
		}

		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}
	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div id="userList">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>ユーザーID</th>
					<th>パスワード</th>
					<th>名前</th>
					<th>登録日時</th>
					<th>更新日時</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="id"/></td>
						<td><a href='<s:url action="UserInfoAction"><s:param name="id" value="%{id}"/></s:url>'><s:property value="userId"/></a></td>
						<td><s:property value="userPass"/></td>
						<td><s:property value="userName"/></td>
						<td><s:property value="insertDate"/></td>
						<td><s:property value="updatedDate"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div id="text-center">
			<p>Admin画面に戻る場合は
				<a href='<s:url action="GoAdminAction"/>'>こちら</a></p>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>