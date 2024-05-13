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
                    <li><a href="amenities_controller">Amenities</a></li>
                    <li><a href="booking_controller">Booking</a></li>
                    <li><a href="history_controller">History</a></li>
                     <c:choose>
						<c:when test="${sessionScope.dn == null}">
							<li><a href="sign_in_controller">Sign in</a></li>
                   			<li class="active"><a href="sign_up_controller">Sign up</a></li>
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
        
        <c:set var="un" value="${un}" />
		<c:set var="name" value="${name}" />
		<c:set var="email" value="${email}" />
		<c:set var="phone_number" value="${phone_number}" />
		<c:set var="dob" value="${dob}" />
	
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
        <div id="login">
            <div class="container">
                <div class="section-header">
                    <h2>Sign up</h2>
                   
                </div>
                     <div class="login-form d-flex justify-content-center">
                         <form action="sign_up_controller" method="POST">
                             <div class="form-row">
                                 <div class="control-group col-sm-12">
                                     <label>Name</label>
                                     <input name="txtname" type="text" class="form-control" required="required" value="${name}"/>
                                 </div>
                                 </div>
                             <div class="form-row">
                                 <div class="control-group col-sm-12">
                                     <label>Email</label>
                                     <input name="txtemail" type="email" class="form-control" required="required" value="${email}"/>
                                 </div>
                             </div>
                             <div class="form-row">
                             	<div class="control-group col-sm-6">
                                     <label>Date or birth</label>
                                     <input name="txtdob" type="date" class="form-control" required="required" value="${dob}"  min="1997-01-01" max="2030-12-31"/>
                                 </div>
                                 <div class="control-group col-sm-6">
                                     <label>Phone number</label>
                                     <input name="txtphone" type="number" class="form-control" required="required" value="${phone_number}"/>
                                 </div>
                             </div>
                             <div class="form-row">
                             	<div class="control-group col-sm-12">
                                     <label>Username</label>
                                     <input name="txtun" type="text" class="form-control" required="required" value="${un}"/>
                                 </div>
                             </div>
                             <div class="form-row">
                                 <div class="control-group col-sm-12">
                                     <label>Your Password</label>
                                     <input name="txtpass" type="password" class="form-control" required="required" />
                                 </div>
                             </div>
                             <div class="form-row">
                                 <div class="control-group col-sm-12">
                                     <label>Confirm Password</label>
                                     <input name="txtconfirm" type="password" class="form-control" required="required" />
                                 </div>
                             </div>
                             <div class="button d-flex justify-content-center"><button type="submit">Sign up</button></div>
                         </form>
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
        
        <!-- Contact Javascript File -->
        <script src="js/jqBootstrapValidation.min.js"></script>
        <script src="js/contact.js"></script>
        
        <!-- Main Javascript File -->
        <script src="js/main.js"></script>
    </body>
</html>
