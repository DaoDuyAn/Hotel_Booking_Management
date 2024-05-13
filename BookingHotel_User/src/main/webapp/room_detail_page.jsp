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
<style>
@media (max-width : 739px) {
	.responsive-size {
		height: 200px;
		width: 300px;
	}
}

@media (min-width : 740px) and (max-width: 1023px) {
	.responsive-size {
		height: 300px;
		width: 460px;
	}
}

@media (min-width : 1024px) {
	.responsive-size {
		height: 500px;
		width: 800px;
	}
}
</style>
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

	<!-- Modal for Room Section Start -->
	<div id="login">
		<div class="container">
			<div class="row">
				<div class="d-flex justify-content-center">
					<div class="responsive-size shadow-lg bg-body rounded">
						<div id="carouselExampleIndicators"
							class="carousel slide carousel-fade rounded" data-bs-ride="carousel">

							<div class="carousel-inner">
								<c:forEach var="i" items="${lst_img}" varStatus="loopStatus">
									<c:choose>
										<c:when test="${loopStatus.index == 0}">
											<div class="carousel-item active responsive-size">
												<img src="${i.image_link}"
													class="d-block w-100 h-100 object-fit-cover img-fluid rounded"
													alt="anh-${i.image_id}">
											</div>
										</c:when>
										<c:otherwise>
											<div class="carousel-item responsive-size">
												<img src="${i.image_link}"
													class="d-block w-100 h-100 object-fit-cover img-fluid rounded"
													alt="anh-${i.image_id}">
											</div>
										</c:otherwise>
									</c:choose>
								</c:forEach>

							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
						</div>
					</div>

				</div>
				<div class="mt-5">
					<div>
						<h2>${rt.getRoom_type_name()}</h2>
						<p class="my-3 fs-6">${rt.getDescription()}</p>

						<div class="mt-5 d-flex justify-content-center flex-wrap gap-3">
							<form class="" action="room_controller" method="POST">
								<div class="button d-flex justify-content-center">
									<button class="btn btn-primary  py-3 px-3 fs-5" type="submit">Back to list</button>
								</div>
							</form>
							
							<div>
								<a class="btn btn-dark text-warning fs-5 py-3 px-3 text-decoration-none" 
										href="booking_controller?rtid=${rt.getRoom_type_id()}&rtn=${rt.getRoom_type_name()}&rtp=${rt.getPrice()}">Book Now</a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>

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
					<a href="https://htmlcodex.com">Đào Duy An - 20T1020293</a>
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
