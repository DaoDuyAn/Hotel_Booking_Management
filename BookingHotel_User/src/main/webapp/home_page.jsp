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
<link href="vendor/animate/animate.min.css" rel="stylesheet">
<link href="vendor/slick/slick.css" rel="stylesheet">
<link href="vendor/slick/slick-theme.css" rel="stylesheet">
<!-- <link href="vendor/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" /> -->
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
		height: 250px;
		
	}
}

@media (min-width : 740px) and (max-width: 1023px) {
	.responsive-size {
		height: 500px;
	
	}
}

@media (min-width : 1024px) {
	.responsive-size {
		height: 700px;
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
				<li class="active"><a href="home_controller">Home</a></li>
				<li><a href="room_controller">Rooms</a></li>
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

	<!-- Header Slider Start -->
	<div class="responsive-size">
		<div id="headerSlider" class="carousel slide carousel-fade" data-bs-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#headerSlider" data-slide-to="0" class="active"></li>
				<li data-target="#headerSlider" data-slide-to="1"></li>
				<li data-target="#headerSlider" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active responsive-size">
					<img class="object-fit-cover img-fluid" src="img/slider/header-slider-1.jpg" alt="Royal Hotel">
					<div class="carousel-caption">
						<h1 class="animated fadeInRight">Nullam mattis</h1>
					</div>
				</div>
	
				<div class="carousel-item responsive-size">
					<img class="object-fit-cover img-fluid" src="img/slider/header-slider-2.jpg" alt="Royal Hotel">
					<div class="carousel-caption">
						<h1 class="animated fadeInLeft">Lorem ipsum</h1>
					</div>
				</div>
	
				<div class="carousel-item responsive-size">
					<img class="object-fit-cover img-fluid" src="img/slider/header-slider-3.jpg" alt="Royal Hotel">
					<div class="carousel-caption">
						<h1 class="animated fadeInRight">Phasellus ultrices</h1>
					</div>
				</div>
			</div>
	
			<a class="carousel-control-prev" href="#headerSlider" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#headerSlider" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- Header Slider End -->

	<!-- Search Section Start -->
	<div id="search" style="background: #f2f2f2;">
		<div class="container">

			<form action="room_controller" method="POST">
				<div class="form-row d-flex justify-content-center">
					<div class="control-group col-md-6">
						<div class="form-row">
							<div class="control-group col-md-6">
								<label class="fs-6">Types of rooms</label> <select
									class="custom-select" name="typeOfRoom">
									<option value="0" selected>Select types of rooms</option>
									<c:forEach var="l" items="${lst_roomType_search}">
										<option value="${l.room_type_id}">${l.room_type_name}</option>
									</c:forEach> <
								</select>
							</div>
							<div class="control-group col-md-6">
								<label class="fs-6">Person</label> <select class="custom-select"
									name="numberOfPersons">
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

	<!-- Welcome Section Start -->
	<div id="welcome">
		<div class="container">
			<h3>Welcome to Royal Hotel</h3>
			<p>Welcome to the Royal Hotel, where sophistication meets
				comfort. Immerse yourself in unparalleled luxury and exceptional
				service during your stay with us.</p>
		</div>
	</div>
	<!-- Welcome Section End -->

	<!-- Amenities Section Start -->
	<div id="amenities" class="home-amenities">
		<div class="container">
			<div class="section-header">
				<h2>Amenities & Services</h2>

			</div>
			<div class="row">
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-2"></i>
					<h3>Air Conditioner</h3>
					<p>Indulge in Comfort with Our Superior Hotel Air Conditioning.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-3"></i>
					<h3>Bathtub</h3>
					<p>Soak, Relax, and Unwind in Absolute Comfort.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-4"></i>
					<h3>Shower</h3>
					<p>Modern, Refreshing, and Equipped for a Rejuvenating
						Experience.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-6"></i>
					<h3>Television</h3>
					<p>In-Room Television for Your Viewing Pleasure, Featuring a
						Range of Channels.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-7"></i>
					<h3>WiFi</h3>
					<p>High-speed WiFi for Instant Access, Keeping You Connected
						Anytime, Anywhere.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-8"></i>
					<h3>Telephone</h3>
					<p>In-Room Telephone for Quick and Convenient Connection,
						Ensuring Effortless Communication.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-9"></i>
					<h3>Mini Bar</h3>
					<p>Mini Bar Service for Indulgent In-Room Enjoyment and
						Relaxation.</p>
				</div>
				<div class="col-md-3 col-sm-6 icons">
					<i class="icon icon-10"></i>
					<h3>Kitchen</h3>
					<p>Well-Equipped Kitchen for Your Cooking Pleasure and Culinary
						Comfort.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- Amenities Section Start -->

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
												<img class="object-fit-scale" src="${img.image_link}">
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
										href="booking_controller?rtid=${rt.getRoom_type_id()}&rtn=${rt.getRoom_type_name()}&rtp=${rt.getPrice()}">Book
										Now</a>
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
								<div>
									<img src="img/Single/single_1.jpg">
								</div>
								<div>
									<img src="img/Single/single_2.jpg">
								</div>
								<div>
									<img src="img/Single/single_3.jpg">
								</div>
								<div>
									<img src="img/Single/single_4.jpg">
								</div>
								<div>
									<img src="img/Single/single_5.jpg">
								</div>
								<div>
									<img
										src="https://media-cdn.tripadvisor.com/media/photo-s/12/60/f7/e8/executive-quadruple-room.jpg">
								</div>
							</div>
							<div class="port-slider-nav">
								<div>
									<img src="img/Single/single_1.jpg">
								</div>
								<div>
									<img src="img/Single/single_2.jpg">
								</div>
								<div>
									<img src="img/Single/single_3.jpg">
								</div>
								<div>
									<img src="img/Single/single_4.jpg">
								</div>
								<div>
									<img src="img/Single/single_5.jpg">
								</div>
								<div>
									<img
										src="https://media-cdn.tripadvisor.com/media/photo-s/12/60/f7/e8/executive-quadruple-room.jpg">
								</div>
							</div>
						</div>
						<div class="col-12">
							<h2>Lorem ipsum dolor</h2>
							<p>Lorem ipsum dolor viverra purus imperdiet rhoncus
								imperdiet. Suspendisse vulputate condimentum ligula sollicitudin
								hendrerit. Phasellus luctus, elit et ultrices interdum, neque mi
								pellentesque massorci. Nam in cursus ex, nec mattis lectus.
								Curabitur quis elementum nunc. Mauris iaculis, justo eu aliquam
								sagittis, arcu eros cursus libero, sit amet eleifend dolor odio
								at lacus.</p>
							<div class="modal-link">
								<a href="#">Book Now</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="modal-id_2" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-12">
							<div class="port-slider">
								<div>
									<img src="img/room-slider/room-1.jpg">
								</div>
								<div>
									<img src="img/room-slider/room-2.jpg">
								</div>
								<div>
									<img src="img/room-slider/room-3.jpg">
								</div>
								<div>
									<img
										src="https://koreanahotel.com/kr/images/sub/rooms/business_quad_01_04.jpg">
								</div>
								<div>
									<img
										src="https://www.belvederehoteldublin.com/wp-content/uploads/quad_room.jpg">
								</div>
								<div>
									<img
										src="https://media-cdn.tripadvisor.com/media/photo-s/12/60/f7/e8/executive-quadruple-room.jpg">
								</div>
							</div>

						</div>
						<div class="col-12">
							<h2>Lorem ipsum dolor</h2>
							<p>Lorem ipsum dolor viverra purus imperdiet rhoncus
								imperdiet. Suspendisse vulputate condimentum ligula sollicitudin
								hendrerit. Phasellus luctus, elit et ultrices interdum, neque mi
								pellentesque massorci. Nam in cursus ex, nec mattis lectus.
								Curabitur quis elementum nunc. Mauris iaculis, justo eu aliquam
								sagittis, arcu eros cursus libero, sit amet eleifend dolor odio
								at lacus.</p>
							<div class="modal-link">
								<a href="#">Book Now</a>
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
