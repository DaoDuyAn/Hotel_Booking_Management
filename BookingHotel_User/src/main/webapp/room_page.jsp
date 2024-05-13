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
				<li class="active"><a href="room_controller">Rooms</a></li>
				<li><a href="amenities_controller">Amenities</a></li>
				<li><a href="booking_controller">Booking</a></li>
				<li><a href="history_controller">History</a></li>
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

	<!-- Search Section Start -->
	<div id="search" style="background: #f2f2f2;">
		<div class="container">

			<form action="room_controller" method="POST">
				<div class="form-row d-flex justify-content-center">
					<div class="control-group col-md-6">
						<div class="form-row">
							<div class="control-group col-md-6">
								<label class="fs-6">Types of rooms</label> <select class="custom-select" name="typeOfRoom">
									<option value="0" selected>Select types of rooms</option>
									<c:forEach var="l" items="${lst_roomType_search}">
										<option value="${l.room_type_id}">${l.room_type_name}</option>
									</c:forEach> <
								</select>
							</div>
							<div class="control-group col-md-6">
								<label class="fs-6">Person</label> <select class="custom-select" name="numberOfPersons">
									<option value="0" selected>Select number of persons</option>
									<option value="1">1 - 2</option>
									<option value="2">3 - 4</option>
									<option value="3">> 4</option> 
								</select>
							</div>
						</div>
					</div>
					<div class="control-group col-md-3">
						<button type="submit" class="btn btn-block">Search</button>
					</div>
				</div>
			</form>

		</div>
	</div>
	<!-- Search Section End -->

	<!-- Room Section Start -->
	<div id="rooms">
		<div class="container">
			<div class="section-header mb-5">
				<h2>Our Rooms</h2>

			</div>
			<div class="row mt-5">
				<c:forEach var="rt" items="${lst_roomType}">
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-3">
								<div class="room-img">
									<div class="box12" style="height: 176px;">
										<c:set var="breakLoop" value="false" />
										<c:forEach var="img" items="${lst_img}">
											<c:if
												test="${img.room_type_id eq rt.room_type_id and not breakLoop}">
												<img class="object-fit-scale"  src="${img.image_link}">
												<c:set var="breakLoop" value="true" />
											</c:if>
										</c:forEach>
										<div class="box-content">
											<h3 class="title ">${rt.getRoom_type_name()}</h3>
											<ul class="icon">
												<li><a
													href="room_detail_controller?id=${rt.getRoom_type_id()}"><i
														class="fa fa-link"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="room-des">
									<p>
										<a class="text-uppercase fs-3 fw-bold text-decoration-none"
											href="room_detail_controller?id=${rt.getRoom_type_id()}">${rt.getRoom_type_name()}</a>
									</p>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
									<ul class="room-size">
										<li><i class="fa fa-arrow-right"></i>Size:
											${rt.getSize()} m²</li>
										<li><i class="fa fa-arrow-right"></i>Capacity:
											${rt.getCapacity()}</li>
									</ul>
									<ul class="room-icon">
										<li class="icon-1"></li>
										<li class="icon-2"></li>
										<li class="icon-3"></li>
										<li class="icon-4"></li>
										<li class="icon-5"></li>
										<li class="icon-6"></li>
										<li class="icon-7"></li>
										<li class="icon-8"></li>
										<li class="icon-9"></li>
										<li class="icon-10"></li>
									</ul>
								</div>
							</div>
							<div class="col-md-3">
								<div class="room-rate">
									<h3>From</h3>
									<h1>$ ${rt.getPrice()}</h1>
									<a class="text-decoration-none" 
										href="booking_controller?rtid=${rt.getRoom_type_id()}&rtn=${rt.getRoom_type_name()}&rtp=${rt.getPrice()}">Book Now</a>
								</div>
							</div>
						</div>
						<hr>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
	<!-- Room Section End -->

	<!-- Modal for Room Section Start -->

	<%-- <c:forEach var="r" items="${lst_roomType}">
		<div id="modal-id" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-12">
								<div class="port-slider">
									<c:forEach var="i" items="${lst_img}">
										<c:if test="${i.room_type_id eq r.room_type_id }">
											<div>
												<img src="${i.image_link}">
											</div>
										</c:if>
									</c:forEach>
									<div>
										<img src="img/Single/single_4.jpg">
									</div>
									<div>
										<img src="img/Single/single_5.jpg">
									</div>
								</div>
							</div>
							<div class="col-12">
								<h2>${rt.getRoom_type_name()}</h2>
								<p>${rt.getDescription()}</p>

								<div class="modal-link">
									<a href="#">Book Now</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach> --%>

	<!-- Modal for Room Section End -->

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
					<a href="https://htmlcodex.com" class="text-decoration-none">Đào Duy An - 20T1020293</a>
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

	<!-- Booking Javascript File -->
	<script src="js/booking.js"></script>
	<script src="js/jqBootstrapValidation.min.js"></script>

	<!-- Main Javascript File -->
	<script src="js/main.js"></script>
</body>
</html>
