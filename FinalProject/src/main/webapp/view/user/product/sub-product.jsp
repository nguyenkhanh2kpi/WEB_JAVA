<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Page Header Start -->
<br>
<!-- Page Header End -->


<!-- Cart Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5">
		<div class="col-lg-8 table-responsive mb-5">
			<h4>Sản phẩm đang theo dõi</h4>
			<table class="table table-bordered text-center mb-0">
				<thead class="bg-secondary text-dark">
					<tr>
						<th>Tên sản phẩm</th>
						<th>Chi tiết</th>
						<th>Thêm vào giỏ hàng</th>
					</tr>
				</thead>
				<tbody class="align-middle">
					<c:forEach items="${subProducts}" var="subProduct">
						<tr>
							<td class="align-middle">${subProduct.productName}</td>
							<td class="align-middle"><a href="${pageContext.request.contextPath }/user/detail?id=${subProduct.productId}&pageReviewIndex=1">Xem chi tiết</a></td>
							<td class="align-middle"><a href="">Thêm vào giỏ hàng</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4 table-responsive mb-5">
			<h4>Cửa hàng đang theo dõi</h4>
			<table class="table table-bordered text-center mb-0">
				<thead class="bg-secondary text-dark">
					<tr>
						<th>Tên shop</th>
						<th>Tham quan shop</th>
					</tr>
				</thead>
				<tbody class="align-middle">
					<c:set var="total" value="0" />
					<c:forEach items="${subStores}" var="subStore">
						<tr>
							<td class="align-middle">${subStore.shopName}</td>
							<td class="align-middle"><a href="${pageContext.request.contextPath }/user/detail-shop?id=${subStore.storeId}">Tham quan cửa hàng</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row px-xl-5">
		<div class="col-lg-9 table-responsive mb-5"></div>
		<div class="col-lg-3 table-responsive mb-5">
			<button class="btn btn-primary btn-block border-0 py-3">Tham
				quan người dùng</button>
		</div>
	</div>
</div>