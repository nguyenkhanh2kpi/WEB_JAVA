<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- products content -->
<div class="container">
	<br>
	<br>
	<div class="row">
		<div class="col-4">
			<span class="filter-header"> Quản lí thông tin cá nhân </span>
			<ul class="filter-list">
				<li><a href="${pageContext.request.contextPath }/user/manageorder">Đơn hàng</a></li>
				<li><a href="#">Lịch sử mua hàng</a></li>
				<li><a
					href="${pageContext.request.contextPath }/user/myaccount">Thông
						tin cá nhân</a></li>
				<li><a
					href="${pageContext.request.contextPath }/user/myLocation">Thông
						tin địa chỉ giao hàng</a></li>
			</ul>
		</div>
		<div class="col-2">
			<div class="product-img" id="product-img">
				<img
					src="${pageContext.request.contextPath}/assets/images/user/${user.avatar}" style="width:100%"
					alt="">
			</div>
		</div>
		<div class="col-6">
			<div class="product-info">
				<h2>Tên khách hàng: ${user.fullName}</h2>
				<div class="product-info-detail">
					<span class="product-info-detail-title">Tên đăng nhập:</span> <a
						href="#">${user.slug}</a>
				</div>
				<div class="product-info-detail">
					<span class="product-info-detail-title">CMND/CCCD:</span> <a
						href="#">${user.id_card}</a>
				</div>
				<div class="product-info-detail">
					<span class="product-info-detail-title">Số điện thoại:</span> <a
						href="#">${user.phone}</a>
				</div>
				<div class="product-info-detail">
					<span class="product-info-detail-title">Địa chỉ:</span> <a href="#">12
						Đình Phong Phú, Thủ Đức</a>
				</div>
				<div>
				<hr>
					<button class="btn-flat btn-hover"
						style="background: rgb(233, 142, 142); border-radius: 1em;"
						onclick="myFunction1()">Đổi mật khẩu</button>
				</div>
				<br>
				<div>
					<button class="btn-flat btn-hover"
						style="background: rgb(180, 240, 180); border-radius: 1em;"
						onclick="myFunction()">Cập nhật thông tin</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row product-row">
		<div class="col-6"></div>
		<div class="col-6" id="formUpdate" style="display: none;">
		<hr>
		<h6>Form cập nhật</h6>
			<form method="post" class="formOrder" action="${pageContext.request.contextPath }/user/updateInfo" enctype="multipart/form-data">
				<span style="font-size: 1em;">Họ và tên</span> 
				<input type="text" name="full_name" value="${user.fullName}" placeholder="Tên đầy đủ" class="form-control py-4">
				<span style="font-size: 1em;">CCCD/CMND</span> 
				<input type="text" name="id_card" value="${user.id_card}"class="form-control py-4"> 
				<span style="font-size: 1em;">SĐT</span> 
				<input type="text" name="phone" value="${user.phone}" class="form-control py-4"> 
				<span style="font-size: 1em;">Ảnh bìa:</span> 
				<input type="file" name="image" class="form-control py-4"> <br> <br> 
				<input type="submit" style="background: green; width: 30%;">
			</form>
		</div>
	</div>
	<div class="row product-row">
		<div class="col-6 "></div>
		<div class="col-6 " id="formChangePass" style="display: none;">
		<hr>
		<h6>Đổi mật khẩu</h6>
			<form method="post" class="formOrder"
				action="${pageContext.request.contextPath }/user/changePass"
				enctype="multipart/form-data">
				<span style="font-size: 1em;">Mật khẩu mới</span> <input
					type="password" name="password" required class="form-control py-4"> <br> <span
					style="font-size: 1em;">Nhập lại mật khẩu mới</span> <input
					type="password" name="repassword" required class="form-control py-4"> <br> <br>
				<input type="submit" style="background: green; width: 30%;">
			</form>
		</div>
	</div>
</div>
<script>
	function myFunction() {
		var x = document.getElementById("formUpdate");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
<script>
	function myFunction1() {
		var x = document.getElementById("formChangePass");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>