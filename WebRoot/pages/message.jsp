<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
String bPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>理学·土木综合素质考评系统</title>
    
    <!-- Bootstrap Core CSS -->
    <!-- <link href="../bootstrap/bootstrap.css" rel="stylesheet" type="text/css"> -->
    
     <!-- MetisMenu CSS -->
    <!-- <link href="../bootstrap/metisMenu.min.css" rel="stylesheet" type="text/css"> -->

    <!-- Custom CSS -->
    <link href="sb-admin-2.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <!-- <link href="../bootstrap/font-awesome.min.css" rel="stylesheet" type="text/css"> -->
    
    <!-- DateTimePicker -->
    <!-- <link href="../bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"> -->

    <!--样式-->
    <!-- <link href="../js/jquery/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="../js/jqgrid/ui.jqgrid.css" rel="stylesheet" type="text/css" /> -->

    <link href="frame.css" rel="stylesheet" type="text/css">
    <!-- <link href="../pages/css/rank.css" rel="stylesheet" type="text/css"> -->
    <link href="message.css" rel="stylesheet" type="text/css">

    <!--jquery-->
    <script src="jquery-2.0.3.min.js" type="text/javascript"></script>
    <!--script src="../js/jqgrid/jquery.jqGrid.min.js" type="text/javascript"></script-->

    <!--dot.js-->
    <script type="text/javascript" src="doT.min.js"></script>

    <!--jqgrid-->
    <!--script src="../js/jqgrid/grid.locale-en.min.js" type="text/javascript"></script-->
    <!--script src="script/jquery.jqGrid.min.js" type="text/javascript"></script--> 

    <script id="news" type="text/x-dot-template">
    {{~it:value:index}}
         <div id="news1">
             <p id="news-title">{{=value.title}}</p>
             <p id="news-time">{{=value.time}}</p>
             <p id="news-content">{{=value.content}}</p>
         </div>
     {{~}}
     </script>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <img src="http://www.hitwh.edu.cn/image/logo1.png" style="height:45px; margin-left:50px;">
            <span id="title">理学·土木综合素质考评系统</span>
            <span id="exit" onclick="javascript:window.location.href='pages/login.jsp'">登录</span>
        </nav>
    </div>

     <div id="main">
    </div>
</body>
<script type="text/javascript" src="message.js">
</script>
</html>