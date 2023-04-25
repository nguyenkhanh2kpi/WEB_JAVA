<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/template/" var="URL" />
<!-- products content -->
<div class="container">
	<div class="row product-row">
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
		<div class="col-1 col-md-12"></div>
		<div class="col-5 col-md-12">
			<div class="product-info">
				<h3>Quản lí địa chỉ</h3>
				<hr>
				<c:forEach items="${locations}" var="location">
				<div class="product-info-detail">
					<span class="product-info-detail-title">Địa chỉ:</span> <a href="#">${location.diaChi}</a>
				</div>
				<hr>
				</c:forEach>
				<div>
					<button class="btn-flat btn-hover"
						style="background: rgb(180, 240, 180);" onclick="myFunction()">Thêm
						địa chỉ</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row product-row">
		<div class="col-3 col-md-12"></div>
		<div class="col-7 col-md-12" id="formLocation" style="display: none;">
			<form method="post" class="formOrder"
				action="${pageContext.request.contextPath }/user/myLocation">
				<span style="font-size: 1em;">Địa chỉ mới</span> <input type="text"
					name="location" required class="form-control py-4"> <br> <br> <input
					type="submit" style="background: green; width: 30%;" value="Thêm">
			</form>
		</div>
	</div>
</div>
<!-- end products content -->

<!-- app js -->
<script src="${URL}js/app.js"></script>
<script src="${URL}js/products.js"></script>
<script>
	function myFunction() {
		var x = document.getElementById("formLocation");
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