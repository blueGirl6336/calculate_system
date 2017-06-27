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

    <!--样式-->
    <link href="../js/jquery/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" />
    <link href="../js/jqgrid/ui.jqgrid.css" rel="stylesheet" type="text/css" />

    <link href="../pages/css/frame.css" rel="stylesheet" type="text/css">
    <link href="../pages/css/rank.css" rel="stylesheet" type="text/css">
    <link href="../pages/css/myPrize.css" rel="stylesheet" type="text/css">

    <!--jquery-->
    <script src="../js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
    <script src="../js/jqgrid/jquery.jqGrid.min.js" type="text/javascript"></script>

    <!--jqgrid-->
    <!--script src="../js/jqgrid/grid.locale-en.min.js" type="text/javascript"></script-->
    <!--script src="script/jquery.jqGrid.min.js" type="text/javascript"></script--> 

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <img src="http://www.hitwh.edu.cn/image/logo1.png" style="height:45px; margin-left:50px;">
            <span id="title">理学·土木综合素质考评系统</span>
            <span id="studentUnion" onclick="javascript:window.location.href='../pages/addGPA.jsp'">进入学生会权限</span>
            <span id="exit" onclick="javascript:window.location.href='../pages/login.jsp'">退出</span>
            <!--div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div-->
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
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
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>查看成绩<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/rank.jsp">查看排名</a>
                                </li>
                                <li>
                                    <a href="../pages/myScore.jsp">我的成绩</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 查看奖项<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/myPrize.jsp">我的获奖</a>
                                </li>
                                <!-- <li>
                                    <a href="../pages/allPrize.jsp">查看奖项</a>
                                </li> -->
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> 同学互评<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/valueEachOther.jsp">班内互评</a>
                                </li>
                                <li>
                                    <a href="../pages/evaluationResult.jsp">查看结果</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                         <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 我要申诉<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="../pages/appealPrize.jsp">申诉获奖</a>
                                </li>
                                <li>
                                    <a href="../pages/appealScore.jsp">修改加分</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
    </div>

    <div id="main-info">
        <p id="title1"><span>查看奖项 </span></p>
        <div id="main-table">
            <p id="see-rank"><span>我的获奖</span></p>
            <input id="appeal" type="button" value="申诉" onclick="appeal()"/>
            <!-- <button id='btnLogin' type='button'>申诉</button> -->
            <table id="see-rank-table">
                <!-- <tr id="tr0">
                    <td></td>
                    <td>奖项编号</td>
                    <td>奖项名称</td>
                    <td>获奖日期</td>
                </tr>
                <tr id="tr1" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="1"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr2">
                    <td class="checkbox"><input type="checkbox" name="prize" value="2"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr3" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="3"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr4">
                    <td class="checkbox"><input type="checkbox" name="prize" value="4"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr5" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="5"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr6">
                    <td class="checkbox"><input type="checkbox" name="prize" value="6"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr7" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="7"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr8">
                    <td class="checkbox"><input type="checkbox" name="prize" value="8"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr9" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="9"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr10">
                    <td class="checkbox"><input type="checkbox" name="prize" value="10"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>


                <tr id="tr11" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="11"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr12">
                    <td class="checkbox"><input type="checkbox" name="prize" value="12"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr13" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="13"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr14">
                    <td class="checkbox"><input type="checkbox" name="prize" value="14"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr15" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="15"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr16">
                    <td class="checkbox"><input type="checkbox" name="prize" value="16"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr17" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="17"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr18">
                    <td class="checkbox"><input type="checkbox" name="prize" value="18"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr> 
                <tr id="tr19" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="19"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr20">
                    <td class="checkbox"><input type="checkbox" name="prize" value="20"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>


                <tr id="tr21" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="21"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr22">
                    <td class="checkbox"><input type="checkbox" name="prize" value="22"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr23" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="23"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr24">
                    <td class="checkbox"><input type="checkbox" name="prize" value="24"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr25" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="25"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr26">
                    <td class="checkbox"><input type="checkbox" name="prize" value="26"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr27" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="27"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr28">
                    <td class="checkbox"><input type="checkbox" name="prize" value="28"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr29" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="29"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr30">
                    <td class="checkbox"><input type="checkbox" name="prize" value="30"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>



                <tr id="tr31" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="31"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr32">
                    <td class="checkbox"><input type="checkbox" name="prize" value="32"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr33" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="33"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr34">
                    <td class="checkbox"><input type="checkbox" name="prize" value="34"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr35" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="35"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr36">
                    <td class="checkbox"><input type="checkbox" name="prize" value="36"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr37" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="37"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr38">
                    <td class="checkbox"><input type="checkbox" name="prize" value="38"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr39" class="color">
                    <td class="checkbox"><input type="checkbox" name="prize" value="39"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr>
                <tr id="tr40">
                    <td class="checkbox"><input type="checkbox" name="prize" value="40"/></td>
                    <td class="number"></td>
                    <td class="name"></td>
                    <td class="date"></td>
                </tr> -->
            <!-- </table>
            <div id='loginDiv'>
            <iframe url='../pages/appealMyPrize.jsp'></iframe>
            <iframe style="border: 0; width: 100%; height: 100%;"></iframe>
            </div> -->
            <div id="appealMyPrize">
                <p id="systemTitle">申诉原因</p>
                <p id="tip">请在下方输入申诉原因：<p>
                <input type="text" value="" id="text"/>
                <input type="button" value="确定" id="ok" onclick="ok()"/>
                <input type="button" value="取消" id="cancel" onclick="cancel()"/>
            <div>
        </div>
    </div>
</body>
<script type="text/javascript" src="../js/myPrize.js">
</script>
</html>