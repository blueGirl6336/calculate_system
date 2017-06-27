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
    <link href="../pages/css/myScore.css" rel="stylesheet" type="text/css">

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
        <p id="title1"><span>查看成绩 </span></p>
        <div id="main-table">
            <p id="see-rank"><span>我的成绩</span></p>
            <table id="see-rank-table">
            </table>
            <div id="table2">
                <table id="prize-table">
                </table>
                <input type="button" value="加分项申诉" id="appeal" onclick="appeal()"/>
                <input type="button" value="加分项申请" id="apply" onclick="apply()"/>
            </div>
            <div id="appealMyPrize">
                <p id="systemTitle1">申诉原因</p>
                <p id="tip1">请在下方输入申诉原因：<p>
                <input type="text" value="" id="text1"/>
                <input type="button" value="确定" id="ok1" onclick="ok1()"/>
                <input type="button" value="取消" id="cancel1" onclick="cancel1()"/>
            </div>


            <div id="applyNewPrize">
                <p id="systemTitle2">加分项申请</p>

                <form name="frm">
                <select id="prize1" name="s1"  onChange="getType1()">
                    <option selected>请选择</option>
                    <option value="11">日常行为</option>
                    <option value="12">个性发展</option>
                </select>
                <select id="prize2" name="s2" onChange="getType2()">
                    <option value="请选择" selected>请选择</option>
                </select>
                <select id="prize3" name="s3">
                    <option value="请选择" selected>请选择</option>
                </select>
                </form>


                <p id="tip2">请在下方输入申诉原因：<p>
                <input type="text" value="" id="text2"/>
                <input type="button" value="确定" id="ok2" onclick="ok2()"/>
                <input type="button" value="取消" id="cancel2" onclick="cancel2()"/>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="../js/myScore.js">
</script>
</html>