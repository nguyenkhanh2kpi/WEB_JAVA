<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>



<script language="javascript">
	function ChangeToSlug() {
		var title, slug;

		//Lấy text từ thẻ input title 
		title = document.getElementById("title").value;

		//Đổi chữ hoa thành chữ thường
		slug = title.toLowerCase();

		//Đổi ký tự có dấu thành không dấu
		slug = slug.replace(/á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ/gi, 'a');
		slug = slug.replace(/é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ/gi, 'e');
		slug = slug.replace(/i|í|ì|ỉ|ĩ|ị/gi, 'i');
		slug = slug.replace(/ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ/gi, 'o');
		slug = slug.replace(/ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự/gi, 'u');
		slug = slug.replace(/ý|ỳ|ỷ|ỹ|ỵ/gi, 'y');
		slug = slug.replace(/đ/gi, 'd');
		//Xóa các ký tự đặt biệt
		slug = slug
				.replace(
						/\`|\~|\!|\@|\#|\||\$|\%|\^|\&|\*|\(|\)|\+|\=|\,|\.|\/|\?|\>|\<|\'|\"|\:|\;|_/gi,
						'');
		//Đổi khoảng trắng thành ký tự gạch ngang
		slug = slug.replace(/ /gi, "-");
		//Đổi nhiều ký tự gạch ngang liên tiếp thành 1 ký tự gạch ngang
		//Phòng trường hợp người nhập vào quá nhiều ký tự trắng
		slug = slug.replace(/\-\-\-\-\-/gi, '-');
		slug = slug.replace(/\-\-\-\-/gi, '-');
		slug = slug.replace(/\-\-\-/gi, '-');
		slug = slug.replace(/\-\-/gi, '-');
		//Xóa các ký tự gạch ngang ở đầu và cuối
		slug = '@' + slug + '@';
		slug = slug.replace(/\@\-|\-\@|\@/gi, '');
		//In slug ra textbox có id “slug”
		document.getElementById('slug').value = slug;
	}
</script>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<section class="content">
		<form method="post" role="form"
			action="${pageContext.request.contextPath}/admin/categories/add"
			enctype="multipart/form-data">
			<div class="modal-header">
				<h4 class="modal-title">Thêm danh mục sản phẩm</h4>
				<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
			</div>
			<div class="modal-body">
				<div class="form-group">
					<div class="form-outline">
						<label>Tên danh mục sản phẩm</label><input type="text"
							class="form-control" required="required" id="title" name="title"
							onkeyup="ChangeToSlug();" />
					</div>
				</div>
				<div class="form-group">
					<div class="form-outline">
						<label>Mã định danh</label><input type="text" class="form-control"
							required="required" id="slug" name="slug" />
					</div>
				</div>
				<div class="form-group">
					<c:url value="/image?fname=${avatar}" var="imgUrl"></c:url>
					<label>Ảnh</label> <input type="file" class="form-control"
						name="avatar" value="${avatar}" id="avatar" /> <img
						class="img-responsive" width="100px" src="${imgUrl}" alt="">
				</div>
			</div>
			<div class="modal-footer">
				<input type="submit" class="btn btn-info" value="Save"> <input
					type="reset" class="btn btn-primary" value="Reset"><input
					type="hidden" name="id" id="id">
			</div>
		</form>
	</section>
</div>