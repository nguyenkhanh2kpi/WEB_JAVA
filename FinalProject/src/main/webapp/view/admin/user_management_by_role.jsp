<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<script type="text/javascript">
	
	
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();

		$('table .block').on('click', function() {
			var id = $(this).parent().find('#id').val();
			$('#blockuser #id').val(id);
		});
	});

	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();

		$('table .unblock').on('click', function() {
			var id = $(this).parent().find('#id').val();
			$('#unblockuser #id').val(id);
		});
		
		$('table .edit').on('click', function() {
			var id = $(this).parent().find('#id').val();
			$.ajax({
				type: 'GET',
				url: '${pageContext.request.contextPath}/admin/user_management/role',
				data: {action:'find', id:id},
				success: function(result){
					$('#edituser #id').val(id);
					$('#edituser #id_role').val(result.id_role);
					$('#edituser #full_name').val(result.full_name);
					$('#edituser #id_card').val(result.id_card);
					$('#edituser #phone').val(result.phone);
					$('#edituser #slug').val(result.slug);
					$('#edituser #password').val(result.password);
					$('#edituser #avatar').val(result.avatar);
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
						<li class="breadcrumb-item active">Quản lý User</li>
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
							<h3 class="card-title">Quản lý User</h3>
							<div class="float-sm-right">
								<button class="btn btn-block bg-gradient-info"
									data-toggle="modal" data-target="#addModal">Thêm User</button>
								<!-- onclick="window.location.href='{{url_for('addproduct')}}'" -->
							</div>
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
										<th>Role</th>
										<th>Họ và tên</th>
										<th>CCCD</th>
										<th>SĐT</th>
										<th>Tài khoản</th>
										<th>Mật khẩu</th>
										<th>Ngày tạo</th>
										<th>Ngày cập nhật</th>
										<th>Hình ảnh</th>
										<th style="width: 120px;">Hoạt động</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${userList}" var="user" varStatus="STT">
										<tr>
											<td>${STT.index + 1}</td>
											<td><c:if test="${user.id_role == 1}">User</c:if> <c:if
													test="${user.id_role == 2}">Vendor</c:if> <c:if
													test="${user.id_role == 3}">Admin</c:if></td>
											<td>${user.full_name}</td>
											<td>${user.id_card}</td>
											<td>${user.phone}</td>
											<td>${user.slug}</td>
											<td>${user.password}</td>
											<td>${user.createdAt}</td>
											<td>${user.updatedAt}</td>
											<c:url value="/image?fname=${user.avatar}" var="imgUrl"></c:url>
											<td><img class="img-responsive" src="${imgUrl}"
												width="100px"></td>
											<td><a href="#edituser" class="edit" data-toggle="modal"><i
													class="btn btn-info" data-toggle="tooltrip" title="Edit">Edit</i></a>
												<input type="hidden" name="id" id="id" value="${user.id}">

												<c:if test="${user.isActive() == 'True'}">
													<a href="#blockuser" class="block" data-toggle="modal"><i
														class="btn btn-danger" data-toggle="tooltrip"
														title="Block">Block</i></a>
													<input type="hidden" name="id" id="id" value="${user.id}">
												</c:if> <c:if test="${user.isActive() == 'False'}">
													<a href="#unblockuser" class="unblock" data-toggle="modal"><i
														class="btn btn-danger" data-toggle="tooltrip"
														title="Block" style="background: green">Unblock</i></a>
													<input type="hidden" name="id" id="id" value="${user.id}">
												</c:if></td>
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
		<div id="edituser" class="modal fade">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<form method="post" role="form"
						action="${pageContext.request.contextPath}/admin/user_management/role?action=update"
						enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Sửa thông tin User</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<div class="row mb-4">
								<div class="col">
									<div class="form-group">
										<div class="form-outline">
											<label>Họ và tên</label><input type="text"
												class="form-control" required="required" name="full_name"
												id="full_name">
										</div>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>CCCD</label><input type="text" class="form-control"
											required="required" name="id_card" id="id_card">
									</div>
								</div>
							</div>
							<div class="form-group">
								<label>Sdt</label><input type="text" class="form-control"
									required="required" name="phone" id="phone">
							</div>
							<div class="form-group">
								<label>Tài khoản</label><input type="text" class="form-control"
									required="required" name="slug" id="slug">
							</div>
							<div class="form-group">
								<label>Password</label><input type="text" class="form-control"
									required="required" name="password" id="password">
							</div>
							<div>
								<label>Chọn role user</label> <select name="id_role"
									id="id_role" class="form-control" required="required">
									<c:forEach items="${roleList}" var="role">
										<option value="${role.id}">${role.roleName}</option>
									</c:forEach>
								</select>

							</div>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel"> <input type="submit"
								class="btn btn-info" value="Save"> <input type="hidden"
								name="id" id="id">
						</div>
					</form>
				</div>

			</div>
		</div>

		<div id="blockuser" class="modal fade">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<form method="post"
						action="${pageContext.request.contextPath}/admin/user_management/role?action=block">
						<div class="modal-header">
							<h4 class="modal-title">Block User</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body text-warning">
							<p>Are you sure you want to block this user ?</p>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel" /> <input type="submit" class="btn btn-danger"
								value="Block"> <input type="hidden" name="id" id="id">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="unblockuser" class="modal fade">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<form method="post"
						action="${pageContext.request.contextPath}/admin/user_management/role?action=unblock">
						<div class="modal-header">
							<h4 class="modal-title">Unblock User</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<p>Are you sure you want to unblock these user ?</p>
						</div>
						<div class="modal-footer">
							<input type="button" class="btn btn-default" data-dismiss="modal"
								value="Cancel" /> <input type="submit" class="btn btn-success"
								value="Unblock"> <input type="hidden" name="id" id="id">
						</div>
					</form>
				</div>
			</div>
		</div>

		<div id="addModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<form method="post" role="form"
						action="${pageContext.request.contextPath}/admin/user_management/role?action=create"
						enctype="multipart/form-data">
						<div class="modal-header">
							<h4 class="modal-title">Thêm thông tin User</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<div class="modal-body">
							<div class="row mb-4">
								<div class="col">
									<div class="form-group">
										<div class="form-outline">
											<label>Họ và tên</label><input type="text"
												class="form-control" required="required" name="full_name"
												id="full_name">
										</div>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label>CCCD</label><input type="text" class="form-control"
											required="required" name="id_card" id="id_card">
									</div>
								</div>
							</div>
							<div class="form-group">
								<label>Sdt</label><input type="text" class="form-control"
									required="required" name="phone" id="phone">
							</div>
							<div class="form-group">
								<label>Tài khoản</label><input type="text" class="form-control"
									required="required" name="slug" id="slug">
							</div>
							<div class="form-group">
								<label>Password</label><input type="text" class="form-control"
									required="required" name="password" id="password">
							</div>
							<div>
								<label>Chọn role user</label> <select name="id_role"
									id="id_role" class="form-control" required="required">
									<c:forEach items="${roleList}" var="role">
										<option value="${role.id}">${role.roleName}</option>
									</c:forEach>
								</select>

							</div>
							<div class="form-group">
								<c:url value="/image?fname=${avatar}" var="imgUrl"></c:url>
								<label>Ảnh đại diện</label> <input type="file"
									class="form-control" name="avatar" value="${avatar}"
									id="avatar" /> <img class="img-responsive" width="100px"
									src="${imgUrl}" alt="">
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-info" value="Save"> <input
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

