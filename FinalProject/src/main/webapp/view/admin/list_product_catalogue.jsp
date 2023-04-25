<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<script type="text/javascript">
$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();

	
	$('table .edit').on('click', function() {
		var id = $(this).parent().find('#id').val();
		$.ajax({
			type: 'GET',
			url: '${pageContext.request.contextPath}/admin/categories/list',
			data: {action:'find', id:id},
			success: function(result){
				$('#editcategory #id').val(id);
				$('#editcategory #name').val(result.name);
				$('#editcategory #slug').val(result.slug);
				$('#editcategory #image').val(result.image);
			}
			
		});
	});
});
	
	
</script>
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
						<li class="breadcrumb-item"><a
							href="${pageContext.request.contextPath}/admin/home">Trang chủ</a></li>
						<li class="breadcrumb-item active">Quản lý danh mục</li>
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
							<h3 class="card-title">Quản lý danh mục</h3>
						</div>
						<div class="row justify-content-center">
							<div style="margin-top: 20px; margin-bottom: -45px;"></div>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr align="center">
										<th>Stt</th>
										<th>Hình ảnh</th>
										<th>Tên danh mục sản phẩm</th>
										<th>Mã định danh</th>
										<th style="width: 120px;">Hoạt động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${categoryList}" var="category"
										varStatus="STT">
										<tr>
											<td>${STT.index + 1}</td>
											<c:url value="/image?fname=${category.image}" var="imgUrl"></c:url>
											<td><img class="img-responsive" src="${imgUrl}"
												width="100px"></td>
											<td>${category.name}</td>
											<td>${category.slug}</td>
											<td><a href="#editcategory" class="edit" data-toggle="modal"><i
													class="btn btn-info" data-toggle="tooltrip" title="Edit">Edit</i></a>
												<input type="hidden" name="id" id="id" value="${category.id}">

											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
		</div>


		<!-- Modal -->
		<div id="editcategory" class="modal fade">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<form method="post" role="form"
						action="${pageContext.request.contextPath}/admin/categories/list?action=update"
						enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Sửa thông tin danh mục</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<div class="form-outline">
									<label>Tên danh mục sản phẩm</label><input type="text"
										class="form-control" required="required" name="name"
										id="name">
								</div>
								<div class="form-group">
									<label>Mã định danh</label><input type="text"
										class="form-control" required="required" name="slug"
										id="slug">
								</div>
							</div>
							<div class="form-group">
								<c:url value="/image?fname=${avatar}" var="imgUrl"></c:url>
								<label>Ảnh</label> <input type="file" class="form-control"
									name="image" value="${image}" id="image" /> <img
									class="img-responsive" width="100px" src="${imgUrl}" alt="">
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-info" value="Save"><input
								type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="hidden" name="id" id="id">
						</div>
					</form>
				</div>

			</div>
		</div>
	</section>
	<!-- /.content -->
</div>

