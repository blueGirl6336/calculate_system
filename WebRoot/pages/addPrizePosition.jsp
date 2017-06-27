<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>理学·土木综合素质考评系统</title>
    
    <link rel="stylesheet" type="text/css" href="css/mainbody.css">
    <link rel="stylesheet" type="text/css" href="css/addScoreItem.css">

    <!-- Bootstrap Core CSS -->
    <link href="../bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    
     <!-- MetisMenu CSS -->
    <link href="../bootstrap/metisMenu.min.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="../bootstrap/sb-admin-2.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="../bootstrap/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- DateTimePicker -->
    <link href="../bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">

    <link href="css/frame.css" rel="stylesheet" type="text/css">

    <!--样式-->
    <link href="../js/jquery/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="../js/jqgrid/ui.jqgrid.css" rel="stylesheet" type="text/css" />

    <!--jquery-->
    <script src="../js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
    <script src="../js/jqgrid/jquery.jqGrid.min.js" type="text/javascript"></script>


    <link href="../pages/css/addPrizePosition.css" rel="stylesheet" type="text/css">


</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <img src="http://www.hitwh.edu.cn/image/logo1.png" style="height:45px; margin-left:50px;">
            <span id="title">理学·土木综合素质考评系统</span>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                     <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <center>
                            <button type="submit" id="update" class="btn btn-primary">更新  2015-01-10 19:22:33</button>
                            </center>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>录入成绩<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/addGPA.jsp">录入学分绩</a>
                                </li>
                                <li>
                                    <a href="../pages/addScore.jsp">录入加分</a>
                                </li>
                                <li>
                                    <a href="../pages/addPrize.jsp">录入奖项</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 导出成绩<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/outGrades.jsp">导出成绩</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> 申请加分项<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/addScoreItem.jsp">申请添加</a>
                                </li>
                                <li>
                                    <a href="../pages/addScorePosition.jsp">查看状态</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                         <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 申请奖项<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/addPrizeItem.jsp">申请添加</a>
                                </li>
                                <li>
                                    <a href="../pages/addPrizePosition.jsp">查看状态</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>审核处理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/judgeScore.jsp">审核加分项</a>
                                </li>
                                <li>
                                    <a href="../pages/judgePrize.jsp">审核奖项</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li> 
                    </ul>
                </div>
                <div></div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
       </div>

    <div class="temp">
    	<div class="bigtitle">申请奖项</div>
    	<div class="mainboby box-body">
			<table id="rowed3"></table>
			<div id="prowed3"></div>
		</div>
		<div class="addtitle">查看状态</div>
        <table id="see-rank-table"></table>
</div>   	
</body>
<script type="text/javascript" src="../js/addPrizePosition.js">
</script>
</html>