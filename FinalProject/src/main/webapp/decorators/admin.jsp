<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/admin/static/" var="template" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Page</title>


<!-- Font Awesome -->
<link rel="stylesheet"
	href="${template}admin/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="${template}admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${template}admin/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<link rel="stylesheet" href="${template}admin/css/style.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${template}admin/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${template}admin/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="${template}admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${template}admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet"
	href="${template}admin/plugins/jqvmap/jqvmap.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${template}admin/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="${template}admin/plugins/summernote/summernote-bs4.min.css">
</head>


<body class="hold-transition sidebar-mini layout-fixed">

	<!-- jQuery -->
	<script src="${template}admin/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${template}admin/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>

	<!-- Bootstrap 4 -->
	<script
		src="${template}admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="${template}admin/plugins/chart.js/Chart.min.js"></script>
	<!-- JQVMap -->
	<script src="${template}admin/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="${template}admin/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="${template}admin/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="${template}admin/plugins/moment/moment.min.js"></script>
	<script src="${template}admin/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="${template}admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script src="${template}admin/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="${template}admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${template}admin/js/adminlte.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${template}admin/js/demo.js"></script>
	<%-- <!-- jQuery Mapael -->
	<script
		src="${template}admin/plugins/jquery-mousewheel/jquery.mousewheel.js "></script>
	<script src="${template}admin/plugins/raphael/raphael.min.js "></script>
	<script
		src="${template}admin/plugins/jquery-mapael/jquery.mapael.min.js"></script>
	<script
		src="${template}admin/plugins/jquery-mapael/maps/usa_states.min.js"></script> --%>
	<!-- DataTables -->
	<script
		src="${template}admin/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${template}admin/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${template}admin/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${template}admin/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script>
		$(function() {
			$("#example1").DataTable({
				"responsive" : true,
				"autoWidth" : false,
			});
		});
		$(function() {
			$("#example2").DataTable({
				"responsive" : true,
				"autoWidth" : false,
			});
		});
		$(function() {
			$("#example3").DataTable({
				"responsive" : true,
				"autoWidth" : false,
			});
		});
	</script>
	
	
	
	<!--=== Header ===-->
	<%@ include file="/common/admin/header.jsp"%>

	<!--=== Left Side Bar ===-->
	<%@ include file="/common/admin/left.jsp"%>

	<!-- body -->
	<dec:body></dec:body>
	<!-- body -->

	<!--=== Footer v4 ===-->
	<jsp:include page="/common/admin/footer.jsp"></jsp:include>
</body>
</html>

