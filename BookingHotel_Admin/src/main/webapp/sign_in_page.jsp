<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>ROYAL HOTEL - Admin</title>
<!-- Favicons -->
<link href="img/favicon.ico" rel="icon">
<link href="img/apple-favicon.png" rel="apple-touch-icon">
<link href="css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
	<c:set var="un" value="${un}" />
	<c:set var="pass" value="${pass}" />

	<c:choose>
		<c:when test="${un == null and pass == null}">
			<c:set var="un" value="" />
			<c:set var="pass" value="" />
		</c:when>
	</c:choose>

	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">

			<div class="container">
				<div
					class="row mt-5 d-flex justify-content-center align-items-center">
					<div class="col-lg-5">
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center fs-2 font-weight-light my-4">Sign in</h3>
							</div>
							<div class="card-body">
								<form action="sign_in_controller" method="POST">
									<div class="form-floating mb-3">
										<input class="form-control" id="inputUsername" type="text"
											placeholder="Username" required="required" name="txtun"
											value="${un}" /> <label for="inputEmail">Username</label>
										<c:set var="wuser" value="${wuser}" />
										<c:if test="${wuser != null}">
											<div class="mt-1 text-danger">${wuser}</div>
										</c:if>
									</div>
									<div class="form-floating mb-3">
										<input class="form-control" id="myInput" type="password"
											placeholder="Password" required="required" name="txtpass"
											value="${pass}" /> <label for="myInput">Password</label>
										<c:set var="wpass" value="${wpass}" />
										<c:if test="${wpass != null}">
											<div class="mt-1 text-danger">${wpass}</div>
										</c:if>
									</div>
									<div class="form-check mb-3">
										<input onclick="myFunction()" class="form-check-input"
											id="inputRememberPassword" type="checkbox" value="" /> <label
											class="form-check-label" for="inputRememberPassword">Show
											Password</label>
									</div>
									<c:set var="showCapcha" value="${showCapcha}" />
									<c:if test="${showCapcha != null}">
										<img src="simpleCaptcha.jpg" />
										<br />
										<div class="form-floating mb-3">
											<input class="mt-3 form-control" type="text" name="txtcapcha"
												required="required" autocomplete="off" id="inputCapcha" />
											<label for="inputCapcha">Enter Capcha</label>
											<c:set var="wcapcha" value="${wcapcha}" />
											<c:if test="${wcapcha != null}">
												<div class="mt-1 text-danger">${wcapcha}</div>
											</c:if>

										</div>

									</c:if>

									<div
										class="d-flex align-items-center justify-content-between mt-4 mb-0">
										<a class="small" href="forgot_pass_controller">Forgot
											Password?</a>
										<button class="btn px-5 fs-5 btn-primary">Login</button>
									</div>
								</form>
							</div>
							<div class="card-footer text-center py-3">
								<div class="medium">
									<a href="sign_up_controller">Need an account? Sign up!</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
