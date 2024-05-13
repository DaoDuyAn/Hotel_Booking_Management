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
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" />
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
		<a class="navbar-brand ps-3" href="home_controller">Royal Hotel - Admin</a>
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
						</a> <a class="nav-link active collapsed" href="#"
							data-bs-toggle="collapse" data-bs-target="#collapseLayouts1"
							aria-expanded="false" aria-controls="collapseLayouts">
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
								 <a class="nav-link" href="#">Account</a> <a
									class="nav-link active" href="room_type_management_controller">Room
									type</a> <a class="nav-link" href="#">Room</a>
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
						</a> <a class="nav-link" href="statistic_controller">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Statistics
                                
                            </a>



					</div>
				</div>

			</nav>
		</div>
		<div id="layoutSidenav_content">

			<c:set var="rtid" value="${rtid}" />
			<c:set var="rtn" value="${rtn}" />
			<c:set var="size" value="${size}" />

			<c:choose>
				<c:when test="${rtid == null and rtn == null and size == null}">
					<c:set var="rtid" value="" />
					<c:set var="rtn" value="" />
					<c:set var="size" value="" />

				</c:when>
			</c:choose>


			<div class="container-fluid px-4">
				<h1 class="mt-4">Images Management</h1>
				<c:set var="success" value="${success}" />
				<c:if test="${success != null}">
					<div class="alert alert-success">${success}</div>
				</c:if>
				<div>
					<a class="mt-3 btn btn-primary fs-5"
						href="room_type_management_controller"><i
						class="fa-regular fa-circle-left me-2"></i>Go back</a>
				</div>
				<div class="container">
					<div
						class="row mt-3 d-flex justify-content-center align-items-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-body">
									<form id="imageForm" action="images_management_controller?rtid=${roomtypeid}"
										method="POST" enctype="multipart/form-data">
										<div class="my-3">
											<label for="txtimgid" class="form-label fw-bold">Image
												ID</label> <input type="number" class="form-control" id="txtimgid"
												name="txtimgid" value="${img.getImage_id()}">

										</div>
										<div class="my-3">
											<label for="txtfile" class="form-label fw-bold">Image</label>
											<input type="file" class="form-control" id="txtfile"
												name="txtfile" multiple> <input type="text"
												value="${img.getImage_link()}" name="txtlink" hidden>
										</div>
										<%-- <div class="my-3">
											<label for="txtrtid" class="form-label fw-bold">Room
												type ID</label> <input type="number" class="form-control"
												id="txtrtid" name="txtrtid" value="${img.getRoom_type_id()}">
										</div> --%>


										<div
											class="d-flex align-items-center justify-content-around mt-4 mb-0">

											<button class="btn fs-6 btn-primary" name="btnadd"
												value="btnadd">
												<i class="fa-regular fa-square-plus me-1"></i> Add
											</button>
											<button class="btn fs-6 btn-success" name="btnupdate"
												value="btnupdate">
												<i class="fa-regular fa-pen-to-square me-1"></i>Update
											</button>
											<button id="confirmDelete" class="btn fs-6 btn-danger"
												data-bs-toggle="modal" data-bs-target="#staticBackdrop">
												<i class="fa-regular fa-trash-can me-1"></i> Delete
											</button>

										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="card my-5">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> Room type
					</div>

					<div class="card-body">
						<table id="datatablesSimple"
							class="table table-hover text-center custom-table">
							<thead class="text-center">
								<tr class="text-center">
									<th class="col-sm-1 text-center">Image ID</th>
									<th class="col-sm-1 text-center">Image</th>
									<th class="col-sm-1 text-center">Room type ID</th>
									<th class="col-sm-1 text-center">Select</th>

								</tr>
							</thead>
							<tfoot class="text-center">
								<tr class="text-center">
									<th class="col-sm-1 text-center">Image ID</th>
									<th class="col-sm-1 text-center">Image</th>
									<th class="col-sm-1 text-center">Room type ID</th>
									<th class="col-sm-1 text-center">Select</th>

								</tr>
							</tfoot>
							<tbody>
								<c:forEach var="item" items="${ds}">
									<tr>
										<td class="col-sm-1 text-center align-middle">${item.getImage_id()}</td>
										<td class="col-sm-1 text-center align-middle"><img
											alt="i-${item.getImage_id()}" src="${item.getImage_link()}"
											style="width: 280px; height: 180px"></td>
										<td class="col-sm-1 text-center align-middle">${item.getRoom_type_id()}</td>

										<td class="text-center align-middle">

											<form
												action="images_management_controller?rtid=${roomtypeid}"
												method="post" enctype="multipart/form-data">

												<button class="btn btn-warning"
													value="${item.getImage_id()}" name="btnselect">
													<i class="fa-solid fa-eye"></i>
												</button>

											</form>
										</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Delete image item</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Are you sure you want to delete this item?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					
						<button form="imageForm" name="btndel" value="confirm" type="submit" class="btn btn-danger">Confirm</button>
				
				</div>
			</div>
		</div>
	</div>

	<script>
		document.getElementById('confirmDelete').addEventListener('click',
				function(event) {
					event.preventDefault();
				});
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/scripts.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<!-- <script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script> -->

	<script
		src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
	<script src="js/datatables-simple-demo.js"></script>
</body>
</html>