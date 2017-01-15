<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/member.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<!--  <li><a href="Test">test</a></li> -->
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="form">


			<div class="tab-content">
				<div id="signup">
					<c:choose>
						<c:when test="${firstJoin != null }">
							<h1>${msg}</h1>
						</c:when>
						<c:otherwise>
							<h1>${msg}</h1>
						</c:otherwise>
					</c:choose>




				</div>
				<div class="top-row">
					<table>
						<tr class="field-wrap">
							<td>First Name:</td>
							<td class="detail">${LoginOK.firstName }</td>
						</tr>
						<tr class="field-wrap">
							<td>Last Name:</td>
							<td class="detail">${LoginOK.lastName }</td>
						</tr>
						<tr class="field-wrap">
							<td>Email:</td>
							<td class="detail">${LoginOK.email }</td>
						</tr>
						<tr class="field-wrap">
							<td>CreateDate:</td>
							<td class="detail">${LoginOK.createDate }</td>
						</tr>
					</table>
				</div>
				<a href="/" class="btn btn-default logout">LogOut</a>

			</div>
			<!-- tab-content -->

		</div>
		<!-- /form -->

	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>

</html>