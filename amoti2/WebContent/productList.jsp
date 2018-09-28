<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/product.css">
<title>商品一覧</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<h1>商品一覧画面</h1>
	<s:if test="#session.productInfoDtoList==null">
		<div class="info">
		検索結果がありません。
		</div>
	</s:if>
	<s:else>
		<s:if test="#session.startRecordNo > #session.totalRecordSize">
			<div id="hit">
				<div class="info">[!] このページには商品情報がありません</div>
			</div>
		</s:if>
		<s:else>
		<div id="hit">
			全<s:property value='#session.totalRecordSize'/>件中 <s:property value='#session.startRecordNo'/> ～
				<s:if test="#session.endRecordNo > #session.totalRecordSize">
					<s:property value='#session.totalRecordSize'/>
				</s:if>
				<s:else>
					<s:property value='#session.endRecordNo'/>
				</s:else>
				件目を表示
		</div>
		</s:else>
<div id="product-list">
	<s:iterator value="#session.productInfoDtoList">
	<div class="product-list-box">
		<ul>
			<li class="product">
			<a href='<s:url action="ProductDetailsAction">
			<s:param name="productId" value="%{productId}"/>
			</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-200"/></a><br>
			<s:property value="productName"/><br>
			<s:property value="productNameKana"/><br>
			<s:property value="price"/>円<br>
		  </li>
		</ul>
	</div>
	</s:iterator>

<div class="pager">
<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
	<s:if test="#session.currentPageNo == #pageNo.count">
		<s:property value="%{#pageNo.count}"/>
	</s:if>
	<s:else>
		<a href="<s:url action='SearchItemAction'>
		<s:param name='pageNo' value='%{#pageNo.count}'/>
		<s:param name='categoryId' value='%{categoryId}'/>
		<s:param name='keywords' value='%{keywords}'/>
		</s:url> ">
		<s:property value="%{#pageNo.count}"/>
		</a>
	</s:else>
</s:iterator>
</div>
</div>

</s:else>
</div>
<s:include value="footer.jsp"/>
</body>
</html>