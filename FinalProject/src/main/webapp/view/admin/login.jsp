<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static/" var="template" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin | Log in</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${template}admin/plugins/fontawesome-free/css/all.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${template}admin/plugins/fontawesome-free/css/all.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="${template}admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${template}admin/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
	<div class="login-box login-lg">
		<div class="login-logo">
			<b>Login</b>Admin
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in to start your session</p>
				<c:if test="${mess != null}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong> ${mess}</strong>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>

				<form action="${pageContext.request.contextPath}/login"
					method="post" autocomplete="on">
					<div class="input-group mb-3">
						<input type="text" id="inputEmail" required="required"
							class="form-control" placeholder="Account" name="username"
							value="${username}">
						<div class="input-group-append">
							<div class="input-group-text">
								<span><i class="fa fa-id-badge" aria-hidden="true"></i></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" id="inputPassword" required="required"
							class="form-control" placeholder="Password" name="password"
							value="${password}">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-8">
							<div class="icheck-primary">
								<input type="checkbox" id="remember" name="remember" value="1"> <label
									for="remember"> Remember Me </label>
								
								
							</div>
						</div>
						<!-- /.col -->
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block"
								value="Login">Sign In</button>
						</div>
						<!-- /.col -->
					</div>
				</form>

				<!--       <div class="social-auth-links text-center mb-3">
        <p>- OR -</p>
        <a href="#" class="btn btn-block btn-primary">
          <i class="fab fa-facebook mr-2"></i> Sign in using Facebook
        </a>
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google-plus mr-2"></i> Sign in using Google+
        </a>
      </div> -->
				<!-- /.social-auth-links -->

<!-- 				<p class="mb-1">
					<a href="forgot-password.html">I forgot my password</a>
				</p> -->
				<!--       <p class="mb-0">
        <a href="register.html" class="text-center">Register a new membership</a>
      </p> -->
			</div>
			<!-- /.login-card-body -->
		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="${template}admin/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="${template}admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${template}admin/js/adminlte.min.js"></script>
</body>
</html>
