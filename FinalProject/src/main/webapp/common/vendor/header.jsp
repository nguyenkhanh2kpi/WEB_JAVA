<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
    
 <!-- Site wrapper -->

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">WELLCOME,${sessionScope.account.slug}</a>
            </li>
            
           <li class="nav-item d-none d-sm-inline-block">
                <form action="${pageContext.request.contextPath}/vendor/logout">
                	<button type="submit" class="btn btn-info">Logout </button>
                </form>
            </li>
<!--             <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Product</a>
            </li>  -->
        </ul>
        <!-- SEARCH FORM -->
        <form class="form-inline ml-3" action="${pageContext.request.contextPath}/vendor/search">
            <div class="input-group input-group-sm">
                <input name="keyWord" class="form-control form-control-navbar" type="search" placeholder="Search in all store" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
    </nav>
    <!-- /.navbar -->
    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <a href="${pageContext.request.contextPath}/vendor/home?userId=${sessionScope.account.id}" class="brand-link">
            <span class="brand-text font-weight-light">Store Manager</span>
        </a>
        <div class="sidebar">
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
					<li class="nav-item"><a href="${pageContext.request.contextPath }/vendor/store?userId=${sessionScope.account.id}"
						class="nav-link"> <i class="nav-icon fas fa-store"></i>
							<p>Store</p>
					</a></li>
					
					<li class="nav-item"><a href="${pageContext.request.contextPath }/vendor/order?userId=${sessionScope.account.id}"
						class="nav-link"> <i class="nav-icon fas fa-circle"></i>
							<p>Order</p>
					</a></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath }/vendor/transaction?userId=${sessionScope.account.id}"
						class="nav-link"> <i class="nav-icon fab fa-amazon-pay"></i>
							<p>Transaction</p>
					</a></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath }/vendor/report?userId=${sessionScope.account.id}"
						class="nav-link"> <i class="nav-icon fas fa-caret-square-down"></i>
							<p>Report</p>
					</a></li>
				</ul>
            </nav>
        </div>

    </aside>
    


 