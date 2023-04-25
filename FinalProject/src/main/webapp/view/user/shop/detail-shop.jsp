<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<br>
<!-- Page Header Start -->
<div class="container bg-secondary mb-5">
	<div class="row px-xl-5">
		<div class="col-3">
			<img class="img-fluid w-100" src="img/product-1.jpg" alt="">
		</div>
		<div class="col-3">
			<br>
			<h6>Tên shop: ${detailShop.name }</h6>
			<h6>Bio: ${detailShop.bio }</h6>
			<h6>Sản phẩm: ${Count}</h6>
		</div>
		<div class="col-1"></div>
		<div class="col-4">
			<br>
			<h6>Người Theo Dõi: 52,7k</h6>
			<h6>Đánh giá: 4.9 (6.3k đánh giá)</h6>
			<form method="post"
				action="${pageContext.request.contextPath }/user/sub-shop">
				<input name="storeId" value="${detailShop.id}" type="hidden">
				<input name="storeName" value="${detailShop.name}" type="hidden">
				<button class="btn" style="z-index: 2;">
					<i class="fas fa-plus text-primary mr-1"> Theo dõi</i>
				</button>
			</form>
		</div>
		<div class="col-1"></div>
	</div>
</div>
<!-- Page Header End -->


<!-- Shop Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5">
		<!-- Shop Product Start -->
		<div class="col-lg-12 col-md-12">
			<div class="row pb-3">
				<div class="col-12 pb-1">
					<div class="d-flex align-items-center justify-content-between mb-4">
						<form
							action="${pageContext.request.contextPath }/user/detail-shop?id={detailShop.id}&">
							<div class="input-group">
								<input type="text" placeholder="Search by name" name="id"
									value="${detailShop.id}" style="visibility: hidden; width: 0%;">
								<br> <input type="text" class="form-control"
									placeholder="Search by name" name="nameProduct">
								<div class="input-group-append">
									<span class="input-group-text bg-transparent text-primary">
										<i class="fa fa-search"></i>
										<button type="submit" style="visibility: hidden"></button>
									</span>
								</div>
							</div>
						</form>
						<div class="dropdown ml-4">
							<button class="btn border dropdown-toggle" type="button"
								id="triggerId" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false">Sort by</button>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="triggerId">
								<a class="dropdown-item" href="#">Latest</a> <a
									class="dropdown-item" href="#">Popularity</a> <a
									class="dropdown-item" href="#">Best Rating</a>
							</div>
						</div>
					</div>
				</div>

				<c:forEach items="${AllProductByShopid}" var="product">
					<div class="col-lg-4 col-md-6 col-sm-12 pb-1">
						<div class="card product-item border-0 mb-4">
							<div
								class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
								<img class="img-fluid w-100"
									src="${pageContext.request.contextPath}/assets/images/product/${product.images}"
									alt="">
							</div>
							<div
								class="card-body border-left border-right text-center p-0 pt-4 pb-3">
								<h6 class="text-truncate mb-3">${product.name}</h6>
								<div class="d-flex justify-content-center">
									<h6>${product.price * 95/100}</h6>
									<h6 class="text-muted ml-2">
										<del>${product.price}</del>
									</h6>
								</div>
							</div>
							<div
								class="card-footer d-flex justify-content-between bg-light border">
								<a
									href="${pageContext.request.contextPath }/user/detail?id=${product.id}"
									class="btn btn-sm text-dark p-0"><i
									class="fas fa-eye text-primary mr-1"></i>View Detail</a> <a href=""
									class="btn btn-sm text-dark p-0"><i
									class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- Shop Product End -->
	</div>
</div>
<!-- Shop End -->