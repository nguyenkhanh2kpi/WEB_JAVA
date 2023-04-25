<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
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
                        <li class="breadcrumb-item"><a href="{{url_for('admin_manager')}}">Home</a></li>
                        <li class="breadcrumb-item active"><a href="{{url_for('admin_manager')}}">Order</a></li>
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
                            <h3 class="card-title">Your List Store</h3>
                            <div class="float-sm-right">
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div style=" margin-top: 20px; margin-bottom: -45px; ">
                       <!--      {%include '_messages.html'%} -->
                            </div>
                        </div>
                        <!-- /.card-header -->
                        <div class="card-body">
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Store Name</th>
                                    <th>Order</th>
                                </tr>
                                </thead>
                                <tbody>
            					<c:forEach items="${stores}" var="store">
            					
            					 <tr>
                                    <td>${store.id}</td>
                                    <td><a href="<c:url value='/vendor/product?storeId=${store.id}'/>" class="">${store.name}</a></td>
                                    <td><a href="<c:url value='/vendor/order/manage?storeId=${store.id}&status=all'/>" class="btn btn-danger ">Order Management</a></td>
                                </tr>
            					
            					</c:forEach>
                               
       
                                </tbody>
                            </table>
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