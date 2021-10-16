<%@page import="dto.AddDriverDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"> <!--<![endif]-->
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <!-- Site Meta -->
    <title>SEOTime HTML5 Business Template</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

	<!-- Google Fonts -->
 	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,600,700" rel="stylesheet"> 

	<!-- Custom & Default Styles -->
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="style.css">

	<!--[if lt IE 9]>
		<script src="js/vendor/html5shiv.min.js"></script>
		<script src="js/vendor/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	
	<div id="wrapper">
		<header class="header site-header header-transparent">
			<div class="container">
				<nav class="navbar navbar-default yamm">
				    <div class="container-fluid">
				        <div class="navbar-header">
				            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				                <span class="sr-only">Toggle navigation</span>
				                <span class="icon-bar"></span>
				                <span class="icon-bar"></span>
				                <span class="icon-bar"></span>
				            </button>
							<a class="navbar-brand" href="index.html"><img src="images/bookcab.jpg" alt="Linda"></a>
				        </div>
				        </div>
				        </nav>
				        <div id="navbar" class="navbar-collapse collapse">
				            <ul class="nav navbar-nav navbar-right">
				                <li class=""><a href="index.jsp">Home</a></li>
				                
				                <li><a href="Login.jsp">Customer Login</a></li>
				                <li><a href="AdminLogin.jsp">Admin Login</a></li>
				               
				                <li> <a href="Customer.jsp">Customer Registration</a></li>
                               
                                 </ul>
                            </ul>
				        </div><!--/.nav-collapse -->
				    </div><!--/.container-fluid -->
				</nav><!-- end nav -->
			</div><!-- end container -->
		</header><!-- end header -->

		<section class="section transheader parallax" data-stellar-background-ratio="0.5" style="background-image:url('upload/bg_02.jpg');">
			<div class="container">
				<div class="row">	
					<div class="col-md-10 col-md-offset-1 col-sm-12 text-center">
						<h2>BOOK YOUR CAB NOW </h2>
						<p class="lead">Enter Cab Number To Book Your Cab And Driver</p>
						<form class="calculateform" action="complaints" method="get">
						    <input type="hidden" name="task" value="findById"/>
						    
						    <div class="item-box">
						        <div class="item-top form-inline">
						            <div class="form-group">
						                <div class="input-group2">
						                    <span class="input-addon">
												<i class="fa fa-link"></i>
											</span>
						                    <input type="text" class="form-control" id="urladres" name="id" placeholder="Enter Cab Number">
						                </div>
						            </div>
						            <input type="submit" name="send" value="BOOK" class="btn btn-default" />
						        </div>
						    </div>
						</form>
						<%
							if(request.getAttribute("complaintRegisterDTO") != null){
								AddDriverDTO complaintRegisterDTO = (AddDriverDTO)request.getAttribute("complaintRegisterDTO");
						%>
						
						<h1><%=complaintRegisterDTO.getId() %></h1>
						<h1><%=complaintRegisterDTO.getDrivername() %></h1>
						<h1><%=complaintRegisterDTO.getGender() %></h1>
						<h1><%=complaintRegisterDTO.getMobilenumber() %></h1>
						<h1><%=complaintRegisterDTO.getvehiclename() %></h1>
						<h1><%=complaintRegisterDTO.getCostperkm() %></h1>
						<%} %>
					</div><!-- end col -->
				</div><!-- end row -->
			</div><!-- end container -->
		</section><!-- end section -->

		
	<!-- jQuery Files -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/parallax.js"></script>
	<script src="js/animate.js"></script>
	<script src="js/custom.js"></script>

</body>
</html>