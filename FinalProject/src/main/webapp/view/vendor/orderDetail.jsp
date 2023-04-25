<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>



<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
	
	
   <script language="javascript">
	function SetStatus() {
		var e = document.getElementById("status");
		document.getElementById("statusOrder").value = e.value;
	}
	function getStatus() {
		var e = document.getElementById("status");
		return document.getElementById("statusOrder").value;
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
                        <li class="breadcrumb-item"><a href="{{url_for('admin_manager')}}">Home</a></li>
                        <li class="breadcrumb-item active"><a href="{{url_for('admin_manager')}}">Order Detail</a></li>
                    </ol>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <!-- /.card -->
                    <div class="card">
                        <div class="card-header">
                            <h3 class="card-title">Order Detail</h3>
                            <div class="float-sm-right">
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div style=" margin-top: 20px; margin-bottom: -45px; ">
                            </div>
                        </div>
                        <div class="card-body">
							Status Order: 
							<form action="" role="form" method="POST" enctype="multipart/form-data">
							<input type="text" name="orderId" id="orderId" class="form-control" value="${order.id}"/> 
							<input type="text" name="statusOrder" id="statusOrder" class="form-control" value="${order.status}"/> 
							<select id="status" class="form-control" onchange="SetStatus();">
									<option value="wait_confirmation">wait_confirmation</option>
									<option value="wait_goods">wait_goods</option>
									<option value="delivering">delivering</option>
									<option value="delivered">delivered</option>
							</select> 
							<button class="btn btn-success" type=submit>Update</button>
							</form>
							<br />
						</div>
                        <div class="card-body">
                            <table id="example" class="table table-striped"
								style="width: 100%">
								<thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Product</th>
                                    <th>Order ID</th>
                                    <th>Count</th>
                                </tr>
								</thead>
								<tbody>

            					<c:forEach items="${orderItems}" var="orderItem">
            					
            					 <tr>
                                    <td>${orderItem.id}</td>
                                    <td>${orderItem.product.name}</td>
                                    <td>${orderItem.orderId}</td>
                                    <td>${orderItem.count}</td>

                                </tr>
            					
            					</c:forEach>
								</tbody>
								<tfoot>
                                <tr>
                                    <th>ID</th>
                                    <th>Product</th>
                                    <th>Order ID</th>
                                    <th>Count</th>
                                </tr>
								</tfoot>
							</table>
							<script>
								$(document).ready(function() {
									$('#example').DataTable();
								});
							</script>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>

    </section>
    <!-- /.content -->
</div>
  