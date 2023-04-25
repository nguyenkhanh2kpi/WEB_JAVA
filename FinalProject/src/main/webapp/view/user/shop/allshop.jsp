<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="bg-main">
	<div class="container">
		<div class="row">
			<div class="col-6">
				<div class="box">
					<br> <br> <br>
					<div class="search">
						<form action="${pageContext.request.contextPath }/user/findshop">
							<div class="input-group">
								<input type="text" class="form-control border-white p-4"
									placeholder="Tìm kiếm cửa hàng tại đây" name="name" style="background: #a52a2a1a">
								<div class="input-group-append">
									<button class="btn btn-primary px-4">Tìm kiếm</button>
								</div>
							</div>
						</form>
						<br>
					</div>
				</div>
			</div>
			<br> <br>
		</div>
		<br>
		<div class="row">
			<div class="col-12">
				<c:forEach items="${allshop}" var="shop">
					<div class="box">
						<div class="row" id="products">
							<div class="col-3 col-md-3 col-sm-3">
								<img
									src="${pageContext.request.contextPath}/assets/images/product/${shop.avatar}"
									alt="" style="width: 50%">
							</div>
							<div class="col-9 col-md-9 col-sm-9">
								<div class="product-card">
									<div class="product-card-info">
										<div class="product-card-name">${shop.name}</div>
										<div class="product-card-price">
											<span class="curr-price">${shop.bio}</span>
										</div>
										<div class="product-btn" style="bottom: 0%;">
											<a href="${pageContext.request.contextPath }/user/detail-shop?id=${shop.id}"
												class="btn-flat btn-hover btn-shop-now">Tham quan cửa
												hàng</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<hr>
				</c:forEach>
				<br> <br>
			</div>
		</div>
	</div>
</div>