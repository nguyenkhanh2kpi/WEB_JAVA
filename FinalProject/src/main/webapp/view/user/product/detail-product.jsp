<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<style>
.counter {
	width: 150px;
	display: flex;
	align-items: center;
	justify-content: center;
}

.counter input {
	width: 50px;
	border: 0;
	line-height: 30px;
	font-size: 20px;
	text-align: center;
	background: green;
	color: #fff;
	appearance: none;
	outline: 0;
}

.counter span {
	display: block;
	font-size: 25px;
	padding: 0 10px;
	cursor: pointer;
	color: green;
	user-select: none;
}
</style>
<!-- Page Header Start -->
<br>
<!-- Page Header End -->


<!-- Shop Detail Start -->
<div class="container-fluid py-5">
	<div class="row px-xl-5">
		<div class="col-lg-5 pb-5">
			<div id="product-carousel" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner border">
					<div class="carousel-item active">
						<img class="w-100 h-100"
							src="${pageContext.request.contextPath}/assets/images/product/${detailProduct.images}"
							alt="Image">
					</div>
					<div class="carousel-item">
						<img class="w-100 h-100"
							src="${pageContext.request.contextPath}/assets/images/product/${detailProduct.images}"
							alt="Image">
					</div>
					<div class="carousel-item">
						<img class="w-100 h-100"
							src="${pageContext.request.contextPath}/assets/images/product/${detailProduct.images}"
							alt="Image">
					</div>
					<div class="carousel-item">
						<img class="w-100 h-100"
							src="${pageContext.request.contextPath}/assets/images/product/${detailProduct.images}"
							alt="Image">
					</div>
				</div>
				<a class="carousel-control-prev" href="#product-carousel"
					data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
				</a> <a class="carousel-control-next" href="#product-carousel"
					data-slide="next"> <i class="fa fa-2x fa-angle-right text-dark"></i>
				</a>
			</div>
		</div>

		<div class="col-lg-7 pb-5">
			<h3 class="font-weight-semi-bold">${detailProduct.name}</h3>
			<div class="d-flex mb-3">
				<div class="text-primary mr-2">
					<small class="fas fa-star"></small> <small class="fas fa-star"></small>
					<small class="fas fa-star"></small> <small
						class="fas fa-star-half-alt"></small> <small class="far fa-star"></small>
				</div>
				<small class="pt-1">(50 Reviews)</small>
			</div>
			<h3 class="font-weight-semi-bold mb-4">${detailProduct.price}</h3>
			<p class="mb-4">${detailProduct.description}.</p>
			<p>Camera mắt thần bóng đêm Nightography - Ghi lại khoảnh khắc
				đêm diệu kì</p>
			<p>Mãn nhãn từng khoảnh khắc - Màn hình 6.1", Dynamic AMOLED 2X,
				120Hz</p>
			<p>Bứt phá hiệu năng - Snapdragon 8 Gen 1 (4 nm)</p>
			<p>Thỏa sức trải nghiệm chỉ với một lần sạc - Viên pin 3700 mAh,
				sạc nhanh 25W, sạc không dây</p>
			<div class="d-flex mb-4">
				<p class="text-dark font-weight-medium mb-0 mr-3">Màu:</p>
				<form>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="color-1"
							name="color"> <label class="custom-control-label"
							for="color-1">Đen</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="color-2"
							name="color"> <label class="custom-control-label"
							for="color-2">Trắng</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="color-3"
							name="color"> <label class="custom-control-label"
							for="color-3">Đỏ</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="color-4"
							name="color"> <label class="custom-control-label"
							for="color-4">Xanh dương</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
						<input type="radio" class="custom-control-input" id="color-5"
							name="color"> <label class="custom-control-label"
							for="color-5">Xanh lá</label>
					</div>
				</form>
			</div>
			<div class="d-flex align-items-center mb-4 pt-2">
				<form method="post"
					action="${pageContext.request.contextPath }/user/addItem">
					<div class="input-group quantity mr-3" style="width: 130px;">
						<div class="counter">
							<span class="down" onClick='decreaseCount(event, this)'>-</span>
							<input type="text" name="quantity" value="1"> <span
								class="up" onClick='increaseCount(event, this)'>+</span>
						</div>
						<input name="storeId" value="${detailProduct.storeId}"
							style="visibility: hidden"> <input name="productId"
							value="${detailProduct.id}" style="visibility: hidden">
					</div>
					<button class="btn btn-primary px-3" type="submit">
						<i class="fa fa-shopping-cart mr-1"></i> Thêm vào giỏ hàng
					</button>
				</form>
			</div>
			<div class="d-flex pt-2">
				<p class="text-dark font-weight-medium mb-0 mr-2">Chia sẻ:</p>
				<div class="d-inline-flex">
					<a class="text-dark px-2" href=""> <i class="fab fa-facebook-f"></i>
					</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
					</a> <a class="text-dark px-2" href=""> <i
						class="fab fa-linkedin-in"></i>
					</a> <a class="text-dark px-2" href=""> <i class="fab fa-pinterest"></i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div
				class="nav nav-tabs justify-content-center border-secondary mb-4">
				<a class="nav-item nav-link active" data-toggle="tab"
					href="#tab-pane-1">Mô tả</a> <a class="nav-item nav-link"
					data-toggle="tab" href="#tab-pane-2">Thông tin chi tiết</a> <a
					class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3">Đánh
					giá (${totalReview})</a>
			</div>
			<div class="tab-content">
				<div class="tab-pane fade show active" id="tab-pane-1">
					<h4 class="mb-3">Tổng quan</h4>
					<p>Gây ấn tượng mạnh với đông đảo người dùng đầu năm 2022,
						Samsung Galaxy S22 quả thực là siêu phẩm điện thoại top đầu trong
						các sản phẩm cùng phân khúc giá. Màn hình sắc nét công nghệ cao,
						camera phân giải lớn cùng hiệu năng ổn định của chiếc smartphone
						này sẽ làm hài lòng ngay cả những khách hàng khó tính nhất. Thiết
						kế hài hòa hấp dẫn mọi ánh nhìn Bom tấn Samsung Galaxy S22 sở hữu
						một diện mạo hài hòa qua thiết kế bo tròn 4 góc, tạo sự thuận tiện
						khi cầm nắm. Thân máy được gia công từ những chất liệu kim loại
						nhẹ với khung viền Armored Aluminum cao cấp, đạt tới độ mỏng tuyệt
						đối chỉ 7.6mm.</p>
					<p>Sản phẩm giới thiệu tới người dùng 4 phiên bản màu sắc:
						Trắng - Xanh lá - Hồng _ Đen cho bạn thỏa thích thể hiện cá tính.
						Điểm đặc biệt nhất ở Samsung Galaxy S22 nằm ở màn hình trang bị
						kính cường lực Corning Gorilla Glass Victus+ đầu tiên trên thị
						trường, hạn chế ảnh hưởng từ những tác động mạnh. Ngoài ra, thiết
						kế Infinity-O mở rộng không gian tối đa sẽ mang đến cho bạn trải
						nghiệm màn hình tuyệt vời. Bộ vi xử lý hiện đại bậc nhất Trang bị
						bộ chipset Snapdragon 8 Gen 1 - một trong những con chip mạnh mẽ
						nhất hiện tại, Samsung Galaxy S22 là một sự đột phá về hiệu năng
						sử dụng, cho phép các tác vụ chuyển cảnh hay hoạt động lướt web,
						học tập, chơi game đều trở nên mượt mà.</p>
				</div>
				<div class="tab-pane fade" id="tab-pane-2">
					<h4 class="mb-3">Thông tin chi tiết</h4>
					<p>Qua kiểm nghiệm tại các phần mềm chấm điểm hiệu năng chuyên
						dụng, Samsung Galaxy S22 đều cho những kết quả đầy ấn tượng với số
						điểm 13440 trên PCMark, hay điểm đơn nhân 1212 và đa nhân 3107
						trên Benchmark. Bên cạnh đó, tần số quét lớn lên tới 120Hz của
						thiết bị sẽ giúp bạn có những thao tác ổn định với màn hình cảm
						ứng mà không lo giật lag hay đứng hình.</p>
					<p>Camera nâng cấp tối đa cho trải nghiệm quay chụp tuyệt vời

						Sở hữu tới 3 camera sau, bao gồm camera chính 50MP, camera góc
						siêu rộng 12MP và camera chụp cận 10MP, S22 đúng là mơ ước của
						những tín đồ ưa thích chụp ảnh. Chiếc smartphone này còn được
						trang bị tính năng chụp ban đêm, tạo ra những bức hình ăn ý trong
						mọi điều kiện ánh sáng. Không chỉ thế, tính năng xóa phông cùng
						camera selfie đục lỗ 10MP cũng dễ dàng khiến bạn trở thành tâm
						điểm của mọi khung hình.</p>
					<p>Dung lượng pin ổn cho các tác vụ thông thường Mặc dù Samsung
						Galaxy S22 chỉ sở hữu một dung lượng pin khiêm tốn khoảng 3700mAh,
						song máy vẫn đảm bảo kéo dài thời gian sử dụng lên đến vài giờ cho
						các tác vụ thông thường. Tuy nhiên, công nghệ sạc siêu nhanh với
						tốc độ 25W, và đặc biệt là tính năng sạc không dây 15W của sản
						phẩm sẽ nhanh chóng giúp nạp lại năng lượng cho dế yêu của bạn mỗi
						khi pin cạn kiệt.</p>
				</div>
				<div class="tab-pane fade" id="tab-pane-3">
					<div class="row">
						<div class="col-md-6">
							<h4 class="mb-4">${totalReview} đánh giá cho
								"${detailProduct.name}"</h4>
							<c:forEach items="${reviewList}" var="review">
								<div class="media mb-4">
									<img
										src="${pageContext.request.contextPath}/assets/images/user/avatar.png"
										alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
									<div class="media-body">
										<h6>
											${review.guestName}<small> - <i>${review.dateReview}</i></small>
										</h6>
										<div class="text-primary mb-2">
											<c:if test="${review.rating == 5}">
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
											</c:if>
											<c:if test="${review.rating == 4}">
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="far fa-star"></i>
											</c:if>
											<c:if test="${review.rating == 3}">
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="far fa-star"></i>
												<i class="far fa-star"></i>
											</c:if>
											<c:if test="${review.rating == 2}">
												<i class="fas fa-star"></i>
												<i class="fas fa-star"></i>
												<i class="far fa-star"></i>
												<i class="far fa-star"></i>
												<i class="far fa-star"></i>
											</c:if>
											<c:if test="${review.rating == 1}">
												<i class="fas fa-star"></i>
												<i class="far fa-star"></i>
												<i class="far fa-star"></i>
												<i class="far fa-star"></i>
												<i class="far fa-star"></i>
											</c:if>
										</div>
										<p>${review.review}</p>
									</div>
								</div>
							</c:forEach>


							<c:if test="${maxPage>1}">
								<div class="col-12 pb-1">
									<nav aria-label="Page navigation">
										<ul class="pagination justify-content-center mb-3">
											<c:if test="${backPage>0}">
												<li class="page-item"><a class="page-link"
													href="<c:url value='/user/detail?id=${detailProduct.id}&pageReviewIndex=${backPage}'/>"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
														<span class="sr-only">Previous</span>
												</a></li>
											</c:if>
											<c:forEach begin="1" end="${maxPage}" step="1" var="i">
												<c:if test="${i == pageIndex}">
													<li class="page-item active"><a class="page-link"
														href="<c:url value='/user/detail?id=${detailProduct.id}&pageReviewIndex=${i}'/>">${i}</a></li>
												</c:if>
												<c:if test="${i != pageIndex}">
													<li class="page-item"><a class="page-link"
														href="<c:url value='/user/detail?id=${detailProduct.id}&pageReviewIndex=${i}'/>">${i}</a></li>
												</c:if>
											</c:forEach>
											<c:if test="${nextPage < maxPage + 1}">
												<li class="page-item"><a class="page-link"
													href="<c:url value='/user/detail?id=${detailProduct.id}&pageReviewIndex=${nextPage}'/>"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
														<span class="sr-only">Next</span>
												</a></li>
											</c:if>
										</ul>
									</nav>
								</div>
							</c:if>

						</div>
						<div class="col-md-6">
							<h4 class="mb-4">Đánh giá sản phẩm</h4>
							<small>Bạn xin chờ vài phút, hệ thống chúng tôi sẽ phản
								hồi câu trả lời của bạn *</small>
							<form method="post"
								action="${pageContext.request.contextPath }/user/addreview">
								<input type="hidden" name="productId"
									value="${detailProduct.id}">
								<div class="d-flex my-3">
									<p class="mb-0 mr-2">Your Rating * :</p>
									<div class="text-primary">
										<i class="far fa-star" onclick="test1()" id="1"></i> <i
											class="far fa-star" onclick="test2()" id="2"></i> <i
											class="far fa-star" onclick="test3()" id="3"></i> <i
											class="far fa-star" onclick="test4()" id="4"></i> <i
											class="far fa-star" onclick="test5()" id="5"></i> <input
											type="hidden" name="rating" id="select" value="5">
									</div>
								</div>
								<div class="form-group">
									<label for="message">Your Review *</label>
									<textarea id="review" cols="30" rows="5" class="form-control"
										name="review"></textarea>
								</div>
								<div class="form-group">
									<label for="name">Your Name *</label> <input type="text"
										class="form-control" id="name" name="guestName">
								</div>
								<div class="form-group">
									<label for="email">Your Email *</label> <input type="email"
										class="form-control" id="email" name="email">
								</div>
								<div class="form-group mb-0">
									<input type="submit" value="Leave Your Review"
										class="btn btn-primary px-3">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Shop Detail End -->


<!-- Products Start -->
<div class="container-fluid py-5">
	<div class="text-center mb-4">
		<h2 class="section-title px-5">
			<span class="px-2">Bạn có thể thích</span>
		</h2>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div class="owl-carousel related-carousel">
				<div class="card product-item border-0">
					<div
						class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
						<img class="img-fluid w-100" src="img/product-1.jpg" alt="">
					</div>
					<div
						class="card-body border-left border-right text-center p-0 pt-4 pb-3">
						<h6 class="text-truncate mb-3">Colorful Stylish Shirt</h6>
						<div class="d-flex justify-content-center">
							<h6>$123.00</h6>
							<h6 class="text-muted ml-2">
								<del>$123.00</del>
							</h6>
						</div>
					</div>
					<div
						class="card-footer d-flex justify-content-between bg-light border">
						<a href="" class="btn btn-sm text-dark p-0"><i
							class="fas fa-eye text-primary mr-1"></i>View Detail</a> <a href=""
							class="btn btn-sm text-dark p-0"><i
							class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
					</div>
				</div>




			</div>
		</div>
	</div>
</div>
<!-- Products End -->
<script>
	function increaseCount(a, b) {
		var input = b.previousElementSibling;
		var value = parseInt(input.value, 10);
		value = isNaN(value) ? 0 : value;
		value++;
		input.value = value;
	}

	function decreaseCount(a, b) {
		var input = b.nextElementSibling;
		var value = parseInt(input.value, 10);
		if (value > 1) {
			value = isNaN(value) ? 0 : value;
			value--;
			input.value = value;
		}
	}

	function test1() {
		document.getElementById("1").className = "fas fa-star";
		document.getElementById("2").className = "far fa-star";
		document.getElementById("3").className = "far fa-star";
		document.getElementById("4").className = "far fa-star";
		document.getElementById("5").className = "far fa-star";
		document.getElementById("select").value = 1;
	}
	function test2() {
		document.getElementById("1").className = "fas fa-star";
		document.getElementById("2").className = "fas fa-star";
		document.getElementById("3").className = "far fa-star";
		document.getElementById("4").className = "far fa-star";
		document.getElementById("5").className = "far fa-star";
		document.getElementById("select").value = 2;
	}
	function test3() {
		document.getElementById("1").className = "fas fa-star";
		document.getElementById("2").className = "fas fa-star";
		document.getElementById("3").className = "fas fa-star";
		document.getElementById("4").className = "far fa-star";
		document.getElementById("5").className = "far fa-star";
		document.getElementById("select").value = 3;
	}
	function test4() {
		document.getElementById("1").className = "fas fa-star";
		document.getElementById("2").className = "fas fa-star";
		document.getElementById("3").className = "fas fa-star";
		document.getElementById("4").className = "fas fa-star";
		document.getElementById("5").className = "far fa-star";
		document.getElementById("select").value = 4;
	}
	function test5() {
		document.getElementById("1").className = "fas fa-star";
		document.getElementById("2").className = "fas fa-star";
		document.getElementById("3").className = "fas fa-star";
		document.getElementById("4").className = "fas fa-star";
		document.getElementById("5").className = "fas fa-star";
		document.getElementById("select").value = 5;
	}
</script>