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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<!-- Vendor CSS File -->
<!--  -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="vendor/slick/slick.css" rel="stylesheet">
<link href="vendor/slick/slick-theme.css" rel="stylesheet">
<!-- <link href="vendor/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" /> -->
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
						<li><a href="sign_in_controller">Sign in</a></li>
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

	<!-- History Section Start -->
	<div id="booking">
		<div class="mx-5 my-5">
			<div class="section-header">
				<h2>Booking History</h2>
			</div>
			<div>

				<div class="table-responsive mt-3">
					<table class="table table-bordered table-hover" border="1"
						width="100%">
						<thead class="table-dark">
							<tr>
								<th class="col-sm-1 text-center">ID</th>
								<th class="col-sm-2 text-center">Reservation ID</th>
								<th class="col-sm-3 text-center">Booking date</th>
								<th class="col-sm-3 text-center">Payment status</th>
								<th class="col-sm-2 text-center">Action</th>
							</tr>
						</thead>
						<c:forEach var="item" items="${ds}" varStatus="status">
							<tr class="table-warning">
								<td class="text-center align-middle">${status.index + 1}</td>
								<td class="text-center align-middle">${item.getReservation_id()}</td>
								<td class="text-center align-middle">${item.getBooking_date()}</td>
								<td class="text-center align-middle">${item.getPayment_status()}</td>
								<td class="text-center align-middle">
									<div class="actions_btn_icon">
										<a class="btn btn-primary text-light text-decoration-none"
											href="history_detail_controller?rid=${item.getReservation_id()}">Detail<i
											class="ms-1 fa-solid fa-circle-info"></i></a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				</form>

			</div>
		</div>
	</div>
	<!-- History Section End -->

	<!-- Footer Section Start -->
	<div id="footer">
		<div class="container mt-5">
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
