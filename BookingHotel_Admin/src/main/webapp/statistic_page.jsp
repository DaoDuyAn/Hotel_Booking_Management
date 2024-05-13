<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<!-- <link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" /> -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<style>
.custom-table thead th {
	text-align: center;
}

.custom-table th, .custom-table td {
	text-align: center;
}
</style>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="home_controller">Royal Hotel -
			Admin</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<p
			class="d-none text-light d-md-inline-block  ms-auto me-0 me-md-3 my-2 my-md-0 t">
			${sessionScope.dn.getName()}</p>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="sign_out_controller">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">

						<a class="nav-link" href="home_controller">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Dashboard
						</a> <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts1" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Management
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts1"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="#">Account</a> <a class="nav-link"
									href="room_type_management_controller">Room type</a> <a
									class="nav-link" href="#">Room</a>
							</nav>
						</div>
						<a class="nav-link" href="reservation_confirm_controller">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> Room Reservation Confirmation
						</a> <a class="nav-link" href="cancellation_confirm_controller">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> Room Cancellation Confirmation
						</a> <a class="nav-link active" href="statistic_controller">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Statistics

						</a>
					</div>
				</div>

			</nav>
		</div>
		<div id="layoutSidenav_content">


			<div class="container-fluid px-4">
				<h1 class="mt-4">Statistic</h1>

				<div class="card my-5">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> Monthly Revenue
					</div>
					<div class="card-body">
						<table id="datatablesSimple"
							class="table table-hover text-center custom-table">
							<thead class="text-center">
								<tr class="text-center">
									<th class="col-sm-1 text-center">Month</th>
									<th class="col-sm-1 text-center">Revenue</th>

								</tr>
							</thead>
							<tfoot class="text-center">
								<tr class="text-center">
									<th class="col-sm-1 text-center">Month</th>
									<th class="col-sm-1 text-center">Revenue</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="item" items="${ds}">
									<tr>
										<td class="col-sm-1 text-center align-middle">${item.getMonth()}</td>
										<td class="col-sm-1 text-center align-middle">${item.getTotal()} $</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>

				<p class="fs-5 fw-bold ">Total revenue: ${total} $</p>
			</div>

		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<!-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script> 
 -->
	<script
		src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>