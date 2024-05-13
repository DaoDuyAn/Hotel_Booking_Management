<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>ROYAL HOTEL</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="img/favicon.ico" rel="icon">
<link href="img/apple-favicon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<!-- Vendor CSS File -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="vendor/slick/slick.css" rel="stylesheet">
<link href="vendor/slick/slick-theme.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Main Stylesheet File -->
<link href="css/hover-style.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Header Section Start -->
	<header id="header">
		<a href="home_controller" class="logo"><img src="img/logo.jpg"
			alt="logo"></a>
		<div class="phone">
			<i class="fa fa-phone"></i>+1 234 567 8900
		</div>
		<div class="mobile-menu-btn">
			<i class="fa fa-bars"></i>
		</div>
		<nav class="main-menu top-menu">
			<ul>
				<li><a href="home_controller">Home</a></li>
				<li><a href="room_controller">Rooms</a></li>
				<li><a href="amenities_controller">Amenities</a></li>
				<li><a href="booking_controller">Booking</a></li>
				<li class="active"><a href="history_controller">History</a></li>
				<c:choose>
					<c:when test="${sessionScope.dn == null}">
						<li class="active"><a href="sign_in_controller">Sign in</a></li>
						<li><a href="sign_up_controller">Sign up</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">HELLO ${sessionScope.dn.getName()}</a></li>
						<li><a href="sign_out_controller">Sign out</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>
	<!-- Header Section End -->


	<c:set var="success" value="${success}" />
	<c:if test="${success != null}">
		<div class="alert alert-success">${success}</div>
	</c:if>

	<c:set var="danger" value="${danger}" />
	<c:if test="${danger != null}">
		<div class="alert alert-danger">${danger}</div>
	</c:if>

	<c:set var="un" value="${un}" />
	<c:set var="pass" value="${pass}" />

	<c:choose>
		<c:when test="${un == null and pass == null}">
			<c:set var="un" value="" />
			<c:set var="pass" value="" />
		</c:when>
	</c:choose>

	<c:set var="wpass" value="${wpass}" />
	<c:if test="${wpass != null}">
		<div class="alert alert-danger">${wpass}</div>
	</c:if>

	<!-- Login Section Start -->

	<div class="container my-5">

		<div class="section-header">
			<c:set var="showUpdate" value="${showUpdate}" />
			<c:choose>
				<c:when test="${showUpdate != null}">
					<h2>Update</h2>
				</c:when>
				<c:otherwise>
					<h2>Cancel</h2>
				</c:otherwise>
			</c:choose>

		</div>


		<div class="login-form d-flex justify-content-center">
			<form action="update_cancel_controller?action=${action}"
				method="POST">
				<div class="form-row">
					<div class="control-group col-md-6">
						<label>Room type name</label> <select
							class="form-select form-control" required="required" name="rtn">
							<c:forEach var="item" items="${lst_rt}">
								<option value="${item.getRoom_type_name()}"
									${item.getRoom_type_name() == rtn ? 'selected' : ''}>${item.getRoom_type_name()}</option>
							</c:forEach>
						</select>


						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group col-md-6">
						<label>Numbers of rooms</label> <input type="number" name="nor"
							value="${nor}" autocomplete="off" class="form-control"
							required="required" />
						<p class="help-block text-danger"></p>
					</div>
				</div>
				<div class="form-row">
					<div class="control-group col-md-6">
						<label>Guest count</label> <input type="number" name="gc"
							value="${gc}" class="form-control" required="required" />
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group col-md-6">
						<label>Payment status</label> <select
							class="form-select form-control" name="payment">
							<c:choose>
								<c:when test="${payment == 10}">

									<option value="10" selected>10%</option>
									<option value="100">100%</option>

								</c:when>
								<c:otherwise>

									<option value="10">10%</option>
									<option value="100" selected>100%</option>

								</c:otherwise>
							</c:choose>
						</select>
						<p class="help-block text-danger"></p>
					</div>
				</div>
				<div class="form-row">
					<div class="control-group col-md-6">
						<label>Check in</label> <input class="form-control" type="date"
							name="ci" value="${ci}" required>
						<p class="help-block text-danger"></p>
					</div>
					<div class="control-group col-md-6">
						<label>Check out</label> <input class="form-control" type="date"
							name="co" value="${co}" required>
						<p class="help-block text-danger"></p>
					</div>
				</div>


				<div class="d-flex justify-content-center">
					<c:choose>
						<c:when test="${showUpdate != null}">
							<div class="mt-3">
								<button class="btn btn-dark text-warning" value="${rid}"
									name="btnback">Go back</button>
								<button class="btn btn-success mx-3" value="${rid}"
									name="btnupdate">Update</button>
								<button class="btn btn-warning me-3" value="${rid}"
									name="btncheck">Check Availability</button>

								<c:set var="showBtnConfirm" value="${showBtnConfirm}" />
								<c:if test="${showBtnConfirm != null}">
									<button class="btn btn-primary" value="${rid}"
										name="btnconfirm">Confirm</button>
								</c:if>

							</div>
						</c:when>
						<c:otherwise>
							<div class="mt-3">
								<button class="btn btn-dark text-warning" value="${rid}"
									name="btnback">Go back</button>
								<button id="confirmCancel" class="btn btn-danger"
									data-bs-toggle="modal" data-bs-target="#cancelBookingModal"
									name="btncancel">Cancel booking</button>

							</div>
						</c:otherwise>
					</c:choose>

				</div>
			</form>

		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="cancelBookingModal" tabindex="-1"
		aria-labelledby="cancelBookingModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="cancelBookingModalLabel">Confirm
						Cancellation</h5>
				</div>
				<div class="modal-body">Are you sure you want to cancel this
					booking?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<form action="update_cancel_controller?action=${action}"
						method="POST">
						<button name="btncancel" type="submit" class="btn btn-danger"
							value="${rid}">Confirm Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Login Section End -->

	<!-- Footer Section Start -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="social">
						<a href=""><li class="fa fa-instagram"></li></a> <a href=""><li
							class="fa fa-twitter"></li></a> <a href=""><li
							class="fa fa-facebook-f"></li></a>
					</div>
				</div>
				<div class="col-12">
					<a href="#" class="text-decoration-none">Đào Duy An -
						20T1020293</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Section End -->

	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<script>
		document.getElementById('confirmCancel').addEventListener('click',
				function(event) {
					event.preventDefault();
				});
	</script>

	<!-- Vendor JavaScript File -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/jquery/jquery-migrate.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/easing/easing.min.js"></script>
	<script src="vendor/stickyjs/sticky.js"></script>
	<script src="vendor/superfish/hoverIntent.js"></script>
	<script src="vendor/superfish/superfish.min.js"></script>
	<script src="vendor/wow/wow.min.js"></script>
	<script src="vendor/slick/slick.min.js"></script>
	<script src="vendor/tempusdominus/js/moment.min.js"></script>
	<script src="vendor/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="vendor/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="js/jqBootstrapValidation.min.js"></script>
	<script src="js/contact.js"></script>

	<!-- Main Javascript File -->
	<script src="js/main.js"></script>
</body>
</html>
