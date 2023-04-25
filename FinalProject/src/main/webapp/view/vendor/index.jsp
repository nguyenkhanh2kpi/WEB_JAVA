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
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
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

                        <!-- /.card-header -->
 
     						
     						
<section style="background-color: #eee;">
  <div class="container py-5">

    <div class="row">
    
      <div class="col-lg-4">
        <div class="card mb-4">
          <div class="card-body text-center">
            <img src="${pageContext.request.contextPath}/assets/images/userVendor/${user.avatar}" alt="avatar"
              class="rounded-circle img-fluid" style="width: 150px;">
            <h5 class="my-3">${user.full_name}</h5>
            <p class="text-muted mb-1">Your Profile</p>
          </div>
        </div>
      </div>
      
      
      <div class="col-lg-8">
        <div class="card mb-4">
          <div class="card-body">
          
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Full Name</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.full_name}</p>
              </div>
            </div>
            <hr>
            
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Username</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.slug}</p>
              </div>
            </div>
            <hr>
            
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Phone</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.phone }</p>
              </div>
            </div>
            <hr>
            
            
             <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Join Date</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0">${user.createdAt}</p>
              </div>
            </div>
            <hr>
            
            
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
     						
     						
     						
     						
     						
     						
     						
     						
     						

                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>

    </section>
    <!-- /.content -->
</div>