<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

    
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
                        <li class="breadcrumb-item active"><a href="{{url_for('admin_manager')}}">Transaction</a></li>
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
                            <h3 class="card-title">History</h3>
                            <div class="float-sm-right">
                                <button class="btn btn-block bg-gradient-info">
                                <a class="link-secondary" href="<c:url value='/vendor/transaction/add?userId=${userId}'/> ">New A Trans</a>
                                </button>
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <div style=" margin-top: 20px; margin-bottom: -45px; ">
                            </div>
                        </div>
                        <div class="card-body">
                        
                            <table id="example1" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Store ID</th>
                                    <th>Amount</th>
                                    <th>createdAt</th>
                                    <th>isUp</th>
                                </tr>
                                </thead>
                                <tbody>
            					<c:forEach items="${transactions}" var="transaction">
            					
            					 <tr>
                                    <td>${transaction.id}</td>
                                    <td>${transaction.storeId}</td>
                                    <td>${transaction.amount}</td>
                                    <td>${transaction.createdAt}</td>
                                     <td>${transaction.isUp()}</td>

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