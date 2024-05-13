<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet"> 

        <!-- Vendor CSS File -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendor/slick/slick.css" rel="stylesheet">
        <link href="vendor/slick/slick-theme.css" rel="stylesheet">
        <link href="vendor/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Main Stylesheet File -->
        <link href="css/hover-style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Header Section Start -->
        <header id="header">
            <a href="home_controller" class="logo"><img src="img/logo.jpg" alt="logo"></a>
            <div class="phone"><i class="fa fa-phone"></i>+1 234 567 8900</div>
            <div class="mobile-menu-btn"><i class="fa fa-bars"></i></div>
            <nav class="main-menu top-menu">
                <ul>
                    <li><a href="home_controller">Home</a></li>
                    <li><a href="room_controller">Rooms</a></li>
                    <li class="active"><a href="amenities_controller">Amenities</a></li>
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
        
        <!-- Amenities Section Start -->
        <div id="amenities">
            <div class="container">
                <div class="section-header my-4">
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
                        <p>Modern, Refreshing, and Equipped for a Rejuvenating Experience.</p>
                    </div>
                    <div class="col-md-3 col-sm-6 icons">
                        <i class="icon icon-6"></i>
                        <h3>Television</h3>
                        <p>In-Room Television for Your Viewing Pleasure, Featuring a Range of Channels.</p>
                    </div>
                    <div class="col-md-3 col-sm-6 icons">
                        <i class="icon icon-7"></i>
                        <h3>WiFi</h3>
                        <p>High-speed WiFi for Instant Access, Keeping You Connected Anytime, Anywhere.</p>
                    </div>
                    <div class="col-md-3 col-sm-6 icons">
                        <i class="icon icon-8"></i>
                        <h3>Telephone</h3>
                        <p>In-Room Telephone for Quick and Convenient Connection, Ensuring Effortless Communication.</p>
                    </div>
                    <div class="col-md-3 col-sm-6 icons">
                        <i class="icon icon-9"></i>
                        <h3>Mini Bar</h3>
                        <p>Mini Bar Service for Indulgent In-Room Enjoyment and Relaxation.</p>
                    </div>
                    <div class="col-md-3 col-sm-6 icons">
                        <i class="icon icon-10"></i>
                        <h3>Kitchen</h3>
                        <p>Well-Equipped Kitchen for Your Cooking Pleasure and Culinary Comfort.</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Amenities Section Start -->
        
        <!-- Footer Section Start -->
        <div id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="social">
                            <a href=""><li class="fa fa-instagram"></li></a>
                            <a href=""><li class="fa fa-twitter"></li></a>
                            <a href=""><li class="fa fa-facebook-f"></li></a>
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
