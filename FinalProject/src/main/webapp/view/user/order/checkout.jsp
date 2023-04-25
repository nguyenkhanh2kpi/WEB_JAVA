<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<br>

<!-- Checkout Start -->
<div class="container-fluid pt-5">
	<form method="post"  action="${pageContext.request.contextPath }/user/checkout">
	<div class="row px-xl-5">
		<div class="col-lg-4">
			<div class="mb-4">
				<h4 class="font-weight-semi-bold mb-4">Thông tin xác nhận đơn
					hàng</h4>
				<div class="row">
					<div class="col-md-6 form-group">
						<label>Tên khách hàng</label>
						<input class="form-control" type="text" placeholder="John" value="${user.fullName}">
					</div>
					<div class="col-md-6 form-group">
						<label>Số điện thoại</label> <input class="form-control" type="text"
							placeholder="+123 456 789" value="${user.phone}"  name="phone">
					</div>
					<div class="col-md-6 form-group">
						<label>Address Line 1</label> <input class="form-control"
							type="text" placeholder="123 Street" value="12 Đình Phong Phú, Thủ Đức" name="address">
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-8">
			<div class="card border-secondary mb-5">
				<div class="card-header bg-secondary border-0">
					<h4 class="font-weight-semi-bold m-0">Tổng đơn hàng</h4>
				</div>
				<div class="card-body">
					<h5 class="font-weight-medium mb-3">Sản phẩm</h5>
					<c:set var = "total" value = "0"/>
					<c:forEach items="${cartList}" var="cart">
						<c:forEach items="${cartItems}" var="cartItem">
							<c:if test="${cartItem.cartId == cart.id}">
								<c:forEach items="${products}" var="product">
									<c:if test="${product.id == cartItem.productId}">
										<div class="d-flex justify-content-between">
											<p>Tên sản phẩm: ${product.name}</p>
											<p>Giá: ${product.price}</p>
											<p>Số lượng: ${cartItem.count}</p>
											<p>Shop: ${cart.storeId}</p>
											<c:set var = "total" value = "${total +(product.price * cartItem.count)}"/>
										</div>
									</c:if>
								</c:forEach>
							</c:if>
						</c:forEach>
						<p>Phí ship: ${shipcost}</p>
						<c:set var = "total" value = "${total +(shipcost)}"/>
						<hr class="mt-0">
					</c:forEach>
					<hr class="mt-0">
					<div class="d-flex justify-content-between mb-3 pt-1">
						<h6 class="font-weight-medium">Tổng tiền</h6>
						<h6 class="font-weight-medium">${total}</h6>
						<input type="hidden" value="${total}" name="total">
					</div>
				</div>
			</div>
			<div class="card border-secondary mb-5">
				<div class="card-header bg-secondary border-0">
					<h4 class="font-weight-semi-bold m-0">Phương thức thanh toán</h4>
				</div>
				<div class="card-body">
					<div class="form-group">
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" name="payment"
								id="paypal"> <label class="custom-control-label"
								for="paypal">MoMo</label>
						</div>
					</div>
					<div class="form-group">
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" name="payment"
								id="directcheck"> <label class="custom-control-label"
								for="directcheck">Thanh toán trực tiếp</label>
						</div>
					</div>
					<div class="">
						<div class="custom-control custom-radio">
							<input type="radio" class="custom-control-input" name="payment"
								id="banktransfer"> <label class="custom-control-label"
								for="banktransfer">Thanh toán bằng ngân hàng</label>
						</div>
					</div>
				</div>
				<div class="card-footer border-secondary bg-transparent">
					<button type="submit"
						class="btn btn-lg btn-block btn-primary font-weight-bold my-3 py-3">Xác nhận thanh toán</button>
				</div>
			</div>
		</div>
	</div>
	</form>
</div>
<!-- Checkout End -->