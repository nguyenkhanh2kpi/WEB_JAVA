<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common/taglib.jsp"%>
 
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
							href="">Edit Product</a></li>
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
							<h3 class="card-title">Edit Product</h3>
						</div>

						<form id="demo-form" role="form" action="edit" method="POST"  enctype="multipart/form-data">
							<label>Your Store Id :</label> 
							<input type="text" name="storeId" class="form-control" value="${product.storeId}" disabled/> 
						
							<label>Product name :</label> 
							<input type="text" name="name" id="name" class="form-control" value="${product.name}"/> 
							
							<label>Category: </label> 
							<input type="text" name="categoryId" class="form-control" value="${product.categoryId}" disabled/> 
							
							<label>Slug :</label> 
							<input type="text" name="slug" id="slug"  class="form-control" value="${product.slug}" disabled/> 
							
							<label>Description :</label> 
							<input type="text" name="description" class="form-control" value="${product.description} "/> 
							
							<label>Price :</label>
							<input type="number" name="price" class="form-control" value="${product.price}" /> 
								
							<label>Quantity :</label>
							<input type="number" name="quantity" class="form-control" value="${product.quantity}" /> 
							
							<label>Images :</label>
							<input class="form-control" type="file" name="images" value="${product.images}"/>

							<button type="submit" class="btn btn-primary">Edit</button>
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

