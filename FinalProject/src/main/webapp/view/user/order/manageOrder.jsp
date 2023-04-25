
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Checkout Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5">
		<div class="col-lg-10">
			<c:forEach items="${newOrders}" var="order">
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Mã đơn hàng:</h4>
					</div>
					<div class="card-body">
						<h5 class="font-weight-medium mb-3">Sản phẩm</h5>
						
						<c:forEach items="${newOrderItems}" var="item">
						<c:if test="${item.orderId == order.id}">
						<div class="d-flex justify-content-between">
							<p>${item.product.name}</p>
							<p>${item.count}</p>
						</div>
						</c:if>
						</c:forEach>
						<hr class="mt-0">
						<div class="d-flex justify-content-between mb-3 pt-1">
						<h6 class="font-weight-medium">Tổng tiền: ${order.amountToStore}</h6>
							<h6 class="font-weight-medium">Trạng thái: ${order.status}</h6>
							<h6 class="font-weight-medium">Chuyển tiền khi nhận hàng</h6>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<!-- Checkout End -->