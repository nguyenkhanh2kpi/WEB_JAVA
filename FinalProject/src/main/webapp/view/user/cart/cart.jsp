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
			<table class="table table-bordered text-center mb-0">
				<thead class="bg-secondary text-dark">
					<tr>
						<th>Tên shop</th>
						<th>Tên sản phẩm</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Tổng tiền</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody class="align-middle">
				<c:set var = "total" value = "0"/>
					<c:forEach items="${cartList}" var="cart">
						<c:forEach items="${cartItems}" var="cartItem">
							<c:if test="${cartItem.cartId == cart.id}">
								<c:forEach items="${products}" var="product">
									<c:if test="${product.id == cartItem.productId}">
										<tr>
											<td class="align-middle">${cart.id}</td>
											<td class="align-middle"><img
												src="${pageContext.request.contextPath}/assets/images/product/${product.images}"
												alt="" style="width: 50px;"> ${product.name}</td>
											<td class="align-middle">${product.price}</td>
											<td class="align-middle">
												<div class="input-group quantity mx-auto"
													style="width: 100px;">
													<div class="input-group-btn">
														<button class="btn btn-sm btn-primary btn-minus">
															<i class="fa fa-minus"></i>
														</button>
													</div>
													<input type="text"
														class="form-control form-control-sm bg-secondary text-center"
														value="${cartItem.count}">
													<div class="input-group-btn">
														<button class="btn btn-sm btn-primary btn-plus">
															<i class="fa fa-plus"></i>
														</button>
													</div>
												</div>
											</td>
											<td class="align-middle">${product.price * cartItem.count}</td>
											<c:set var = "total" value = "${total +(product.price * cartItem.count)}"/>
											<td class="align-middle"><button
													class="btn btn-sm btn-primary">
													<i class="fa fa-times"
														onclick="window.location.href='${pageContext.request.contextPath }/user/delete?cartId=${cartItem.cartId}&productId=${cartItem.productId}'"></i>
												</button></td>
										</tr>
									</c:if>
								</c:forEach>
							</c:if>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-4">
			<form class="mb-5" action="">
				<div class="input-group">
					<input type="text" class="form-control p-4"
						placeholder="Mã freeship">
					<div class="input-group-append">
						<button class="btn btn-primary">Mã khuyến mãi</button>
					</div>
				</div>
			</form>
			<div class="card border-secondary mb-5">
				<div class="card-header bg-secondary border-0">
					<h4 class="font-weight-semi-bold m-0">Thanh toán</h4>
				</div>
				<div class="card-body">
					<div class="d-flex justify-content-between mb-3 pt-1">
						<h6 class="font-weight-medium">Tổng tiền</h6>
						<h6 class="font-weight-medium">${total}</h6>
					</div>
					<div class="d-flex justify-content-between">
						<h6 class="font-weight-medium">Phí ship</h6>
						<h6 class="font-weight-medium">50000</h6>
					</div>
				</div>
				<div class="card-footer border-secondary bg-transparent">
					<div class="d-flex justify-content-between mt-2">
						<h5 class="font-weight-bold">Tổng</h5>
						<h5 class="font-weight-bold">${total+50000}</h5>
					</div>
					<button class="btn btn-block btn-primary my-3 py-3" onclick="window.location.href='${pageContext.request.contextPath }/user/checkout'">Xác nhận thanh toán</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Cart End -->