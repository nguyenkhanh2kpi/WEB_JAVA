<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Content Wrapper. Contains page content -->
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
							href="{{url_for('admin_manager')}}">Home</a></li>
						<li class="breadcrumb-item active" href="{{url_for('admin_manager')}}">AddStore</li>
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
							<h3 class="card-title">Add Store</h3>

						</div>

						<!-- /.card-header -->
						<form id="demo-form" role="form" action="edit" method="POST"  enctype="multipart/form-data">
							<label>StoreID :</label> 
							<input type="text" name="id" class="form-control" value="${store.id}" disabled/> 
							<label>Your ID :</label> 
							<input type="text" name="ownId" class="form-control" value="${store.ownerId}" disabled /> 
							<label>Commission ID :</label> 
							<input type="text" name="conmissionId" class="form-control" value="${store.commissionId}" disabled/> 
							<label>Shop Name :</label> 
							<input type="text" name="name" id="name" class="form-control" value="${store.name}"/> 
							<label>Bio :</label>
							<input type="text" name="bio" class="form-control" value="${store.bio}"/> 
							<label>Slug :</label> 
							<input type="text" name="slug" id="slug"  class="form-control" required  value="${store.slug}" disabled /> 
							<label>Images :</label>
							<input class="form-control" type="file" name="image" value="${store.avatar}">
							<label>Your wallet(VND) :</label>
							<input class="form-control" type="number" name="wallet" value=0  value="${store.e_wallet} " disabled>
 

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