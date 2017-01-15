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
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<c:if test="${msg != null }">
	<script type="text/javascript">
			alert( "${msg}");
		</script>
</c:if>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<!-- <li><a href="Test">test</a></li> -->
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="form">

			<ul class="tab-group">
				<li class="tab active"><a href="#signup">Sign Up</a></li>
				<li class="tab"><a href="#login">Log In</a></li>
			</ul>

			<div class="tab-content">
				<div id="signup">
					<h1>Sign Up for Free</h1>

					<form action="UserSubmit" method="post">

						<div class="top-row">
							<div class="field-wrap">
								<label> First Name<span class="req">*</span>
								</label> <input name="firstName" type="text" required autocomplete="off" />
							</div>

							<div class="field-wrap">
								<label> Last Name<span class="req">*</span>
								</label> <input name="lastName" type="text" required autocomplete="off" />
							</div>
						</div>

						<div class="field-wrap">
							<label> Email Address<span class="req">*</span>
							</label> <input name="email" type="email" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Set A Password<span class="req">*</span>
							</label> <input name="password" type="password" required
								autocomplete="off" />
						</div>

						<button type="submit" class="button button-block">Get
							Started</button>

					</form>

				</div>

				<div id="login">
					<h1>Welcome Back!</h1>

					<form action="loginSubmit" method="post">

						<div class="field-wrap">
							<label> Email Address<span class="req">*</span>
							</label> <input name="email" type="email" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Password<span class="req">*</span>
							</label> <input name="password" type="password" required autocomplete="off" />
						</div>

						<!--  <p class="forgot">
							<a href="#">Forgot Password?</a>
						</p>-->

						<button class="button button-block">Log In</button>

					</form>

				</div>

			</div>
			<!-- tab-content -->

		</div>

	</div>
	<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>