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
	<c:set var="name" value="${name}" />
	<c:set var="email" value="${email}" />
	<c:set var="phone_number" value="${phone_number}" />
	<c:set var="dob" value="${dob}" />

	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">

			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-7">
						<div class="card shadow-lg border-0 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">Create
									Account</h3>
							</div>
							<div class="card-body">
								<form action="sign_up_controller" method="POST">
									<div class="row mb-3">
										<div class="col-md-6">
											<div class="form-floating mb-3 mb-md-0">
												<input name="txtname" required="required" value="${name}" class="form-control" id="inputFirstName" type="text"
													placeholder="..." /> <label for="inputFirstName">Name</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-floating">
												<input name="txtemail" required="required" value="${email}" class="form-control" id="inputEmail" type="email"
													placeholder="..." /> <label for="inputEmail">Email</label>
											</div>
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-md-6">
											<div class="form-floating mb-3 mb-md-0">
												<input name="txtdob" required="required" value="${dob}" class="form-control" id="inputFirstName" type="date"
													placeholder="..." min="1997-01-01" max="2030-12-31"/> <label for="inputFirstName">Date
													of birth</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-floating">
												<input name="txtphone" required="required" value="${phone_number}" class="form-control" id="inputEmail" type="number"
													placeholder="..." /> <label for="inputEmail">Phone
													number</label>
											</div>
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-md-12">
											<div class="form-floating mb-3 mb-md-0">
												<input name="txtun" required="required" value="${un}" class="form-control" id="inputPassword"
													type="password" placeholder="..." /> <label
													for="inputPassword">Username</label>
											</div>
										</div>
									
									</div>
									<div class="row mb-3">
										<div class="col-md-6">
											<div class="form-floating mb-3 mb-md-0">
												<input name="txtpass" required="required" class="form-control" id="inputPassword"
													type="password" placeholder="..." /> <label
													for="inputPassword">Password</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-floating mb-3 mb-md-0">
												<input name="txtconfirm" required="required" class="form-control" id="inputPasswordConfirm"
													type="password" placeholder="..." /> <label
													for="inputPasswordConfirm">Confirm Password</label>
											</div>
										</div>
									</div>
									<div class="mt-4 mb-0">
										<div class="d-grid">
											<button class="btn btn-primary btn-block">Create
												Account</button>
										</div>
									</div>
								</form>
							</div>
							<div class="card-footer text-center py-3">
								<div class="small">
									<a href="sign_in_controller">Have an account? Go to login</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
