<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1></h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="">Home</a></li>
						<li class="breadcrumb-item active"><a href="">Product</a></li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<!-- /.card -->
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Manage Product for All My Store</h3>
						</div>
						<div class="row justify-content-center">

							<!-- /.card-header -->
							<div class="card-body">
									<table id="example" class="table table-striped"
										style="width: 100%">
										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Sold</th>
												<th>CategoryId</th>
												<th>Images</th>
												<th></th>
												<th></th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${products}" var="product">
												<tr>
													<td>${product.id}</td>
													<td>${product.name}</td>
													<td>${product.price}</td>
													<td>${product.quantity}</td>
													<td>${product.sold}</td>
													<td>${product.categoryId}</td>
													<td><img
														src="${pageContext.request.contextPath}/assets/images/product/${product.images}"
														width="50" height="40"></td>
													<td><a
														href="<c:url value='/vendor/product/edit?productId=${product.id}'/>"
														class="btn btn-info ">Edit</a></td>
													<td><a
														href="<c:url value='/vendor/product/delete?id=${product.id}'/>"
														class="btn btn-danger ">Delete</a></td>
													</td>

												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Price</th>
												<th>Quantity</th>
												<th>Sold</th>
												<th>CategoryId</th>
												<th>Images</th>
												<th></th>
												<th></th>
											</tr>
										</tfoot>
									</table>
									<script>
										$(document).ready(function() {
											$('#example').DataTable();
										});
									</script>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
				</div>
			</div>
	</section>
	<!-- /.content -->
</div>