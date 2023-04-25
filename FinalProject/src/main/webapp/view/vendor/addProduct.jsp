<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<script language="javascript">
	function ChangeToSlug() {
		var title, slug;
		title = document.getElementById("name").value;
		slug = title.toLowerCase();
		slug = slug.replace(/á|à|ả|ạ|ã|ă|ắ|ằ|ẳ|ẵ|ặ|â|ấ|ầ|ẩ|ẫ|ậ/gi, 'a');
		slug = slug.replace(/é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ/gi, 'e');
		slug = slug.replace(/i|í|ì|ỉ|ĩ|ị/gi, 'i');
		slug = slug.replace(/ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ/gi, 'o');
		slug = slug.replace(/ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự/gi, 'u');
		slug = slug.replace(/ý|ỳ|ỷ|ỹ|ỵ/gi, 'y');
		slug = slug.replace(/đ/gi, 'd');
		slug = slug
				.replace(
						/\`|\~|\!|\@|\#|\||\$|\%|\^|\&|\*|\(|\)|\+|\=|\,|\.|\/|\?|\>|\<|\'|\"|\:|\;|_/gi,
						'');
		slug = slug.replace(/ /gi, "-");
		slug = slug.replace(/\-\-\-\-\-/gi, '-');
		slug = slug.replace(/\-\-\-\-/gi, '-');
		slug = slug.replace(/\-\-\-/gi, '-');
		slug = slug.replace(/\-\-/gi, '-');
		slug = '@' + slug + '@';
		slug = slug.replace(/\@\-|\-\@|\@/gi, '');
		document.getElementById('slug').value = slug;
	}
</script>

<div class="content-wrapper">

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1></h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a
							href="">Home</a></li>
						<li class="breadcrumb-item"><a
							href="">Add Product</a></li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<!-- /.card -->
					<div class="card">
						<div class="card-header">
							<h3 class="card-title">Add Product</h3>
						</div>

						<form id="demo-form" role="form" action="add" method="POST"  enctype="multipart/form-data">
							<label>Your Store Id :</label> 
							<input type="number" name="storeId" class="form-control" value="${storeId}" /> 
						
							<label>Product name :</label> 
							<input type="text" name="name" id="name" class="form-control" onkeyup="ChangeToSlug();" /> 
							
							<label>Category: </label> 
							<br/>
							<select id="cateName" name="categoryId" class="form-control" >
								<c:forEach items="${categorys}" var="cate">
									<option value="${cate.id}">${cate.name}</option>
								</c:forEach>
							</select> 
							<br/>
							
							<label>Slug :</label> 
							<input type="text" name="slug" id="slug"  class="form-control" required /> 
							
							<label>Description :</label> 
							<input type="text" name="description" class="form-control"/> 
							
							<label>Price :</label>
							<input type="number" name="price" class="form-control" /> 
								
							<label>Quantity :</label>
							<input type="number" name="quantity" class="form-control" /> 
							
							<label>Images :</label>
							<input class="form-control" type="file" name="image"/>

							<button type="submit" class="btn btn-primary">ADD</button>
						</form>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
		</div>

	</section>
	<!-- /.content -->
</div>


    
