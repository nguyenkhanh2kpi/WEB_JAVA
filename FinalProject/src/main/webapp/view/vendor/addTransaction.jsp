<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
   <script language="javascript">
	function SetStoreId() {
		var e = document.getElementById("storeId");
		document.getElementById("StoreIdTrans").value = e.value;
	}
	function SetIsUp(){
		var e = document.getElementById("type")
		document.getElementById("isUp").value = e.value;
	}
	function getStatus() {
		var e = document.getElementById("status");
		return document.getElementById("statusOrder").value;
	}
</script>
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
						<li class="breadcrumb-item active" href="{{url_for('admin_manager')}}">Create Transaction</li>
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
							<h3 class="card-title">Add Transaction</h3>

						</div>

						<!-- /.card-header -->
						<form id="demo-form" role="form" action="add" method="POST"  enctype="multipart/form-data">
							<label>Your Id :</label> 
							<input type="text" name="userId" class="form-control" value="${userId}"/> 
							<label>Store Id :</label> 
							<input type="text" name="storeId" id="StoreIdTrans" class="form-control"/> 
							<select id="storeId" class="form-control" onchange="SetStoreId();">
								<c:forEach items="${stores}" var="store">
									<option value="${store.id}" selected="selected">${store.name}</option>
								</c:forEach>
							</select> 
							<br/>
							<label>Type:</label> 	
							<input type="text" name="isUp" id="isUp" class="form-control" /> 
							<select id="type" class="form-control" onchange="SetIsUp();" >
								<option value="true">UP</option>
								<option value="false">DOWN</option>
							</select> 
							<br/>
							<label>Amount :</label> 
							<input type="number" name="amount" class="form-control"/> 
							
							<button type="submit" class="btn btn-primary">CREATE</button>
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
