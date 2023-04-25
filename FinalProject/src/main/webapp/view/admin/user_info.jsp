<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<div class="content-wrapper">
	<section class="content">
		<!-- Modal content-->

		<form method="post" role="form"
			action="${pageContext.request.contextPath}/admin/info?action=update"
			enctype="multipart/form-data">
			<div class="modal-header">
				<h4 class="modal-title">Sửa thông tin</h4>
			</div>
			<div class="col-lg-6 mb-4 mb-lg-0">
				<c:url value="/image?fname=${storeList.images}" var="imgUrl"></c:url>
				<img class="img-responsive" src="${imgUrl}" width="200px">

			</div>
			<div class="modal-body">
				<div class="row mb-4">
					<div class="col">
						<div class="form-group">
							<div class="form-outline">
								<label>Họ và tên</label><input type="text" class="form-control"
									required="required" name="full_name" id="full_name"
									value="${userLogged.full_name}">
							</div>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label>CCCD</label><input type="text" class="form-control"
								required="required" name="id_card" id="id_card"
								value="${userLogged.id_card}">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label>Sdt</label><input type="text" class="form-control"
						required="required" name="phone" id="phone"
						value="${userLogged.phone}">
				</div>
				<div class="form-group">
					<label>Tài khoản</label><input type="text" class="form-control"
						required="required" name="slug" id="slug"
						value="${userLogged.slug}">
				</div>
				<div class="form-group">
					<label>Password</label><input type="text" class="form-control"
						required="required" name="password" id="password"
						value="${userLogged.password}">
				</div>
				<div>
					<label>Chọn role user</label> <select name="id_role" id="id_role"
						class="form-control" required="required">
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id}">${role.roleName}</option>
						</c:forEach>
					</select>

				</div>
				<div class="form-group">
					<c:url value="/image?fname=${avatar}" var="imgUrl"></c:url>
					<label>Ảnh đại diện</label> <input type="file" class="form-control"
						name="avatar" value="${avatar}" id="avatar" />
				</div>
			</div>
			<div class="modal-footer">
				 <input type="submit" class="btn btn-info"
					value="Save"> <input type="hidden" name="id" id="id" value="${userLogged.id}">
			</div>
		</form>
	</section>
</div>