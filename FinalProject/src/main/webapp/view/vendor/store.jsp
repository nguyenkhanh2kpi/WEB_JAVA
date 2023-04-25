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
                        <li class="breadcrumb-item active"><a href="{{url_for('admin_manager')}}">Store</a></li>
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
                            <h3 class="card-title">Manage Store</h3>
                            <div class="float-sm-right">
                                <button class="btn btn-block bg-gradient-info"
                                        onclick="/vendor/store/add"><a class="link-secondary" href="<c:url value='/vendor/store/add?userId=${sessionScope.account.id}'/> ">New A Store</a>
                                </button>
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
                                    <th>e_wallet</th>
                                    <th>createdAt</th>
                                    <th>Image</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
            					<c:forEach items="${stores}" var="store">
            					
            					 <tr>
                                    <td>${store.id}</td>
                                    <td><a href="<c:url value='/vendor/product?storeId=${store.id}'/>" class="">${store.name}</a></td>
                                    <td>${store.e_wallet}</td>
                                    <td>${store.createdAt}</td>
                                    <td><img src="${pageContext.request.contextPath}/assets/images/store/${store.avatar}" width="50" height="40"></td>
                                    <td><a href="<c:url value='/vendor/store/edit?StoreId=${store.id}'/>" class="btn btn-info ">Edit</a></td>
                                    <td><a href="<c:url value='/vendor/store/delete?StoreId=${store.id}'/>" class="btn btn-danger ">Delete</a></td>
                                </tr>
            					</c:forEach>
                                <!-- Modal -->
                                <div class="modal fade" id="staticBackdrop-{{product.id}}" data-backdrop="static"
                                   data-keyboard="false"
                                     tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="staticBackdropLabel">product.name</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <span class="text-danger">are you sure delete the product product.name</span>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-warning  btn-secondary"
                                                        data-dismiss="modal">
                                                    Cancel
                                                </button>
                                                <form action="{{url_for('deleteproduct', id=product.id)}}"
                                                      method="GET">
                                                    <button type="submit" class="btn btn-danger">Delete</button>
                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
       
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

