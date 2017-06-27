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

    <style>

    <style type="text/css">
    #textarea
    {
        width:300px;
        height:100px;
    }
    #ok
    {
        width:80px;
        height:30px;
        position:absolute;
        margin-top: 140px;
        left: 80px;
    }
    #cancel
    {
        width:80px;
        height:30px;
        position:absolute;
        margin-top: 140px;
        left: 230px;
    }
    </style>
</head>

<body>
    <p>请输入申诉原因：</p>
    <textarea rows="5" cols="50"></textarea>
    <input type="button" value="确定" id="ok"/>
    <input type="button" value="取消" id="cancel"/
</body>
<script type="text/javascript" src="../js/myPrize.js">
</script>
</html>



<!-- login.jsp
<style>
.loginDiv { width: 400px; height: 450px; }
</style>
<center>
<div class="loginDiv">
<from>
    账号：<input type='text' id='name' />
    账号：<input type='password' id='pwd' />
    <button type='submit'>登录</button>
</form>
</center>
</div>
 
other.jsp
#loginDiv { width: 400px; height: 450px; z-index: 99999; }
<script>
    //jQuery语言
    $(
        $('#loginDiv').hide();
        $('#btnLogin').click(function() {
              $('#loginDiv').dialog({
                width: 400,
                height: 450,
                modal: true,
                resizable: false,
                title: dialogTitle,
                close: function(e, u) {
                    $('#loginDiv').empty();
                    $(this).dialog("destroy");
              });
         });
     );
</script>
<button id='btnLogin' type='button'>登录</button>
<div id='loginDiv'>
    <iframe url='login.jsp'></iframe>
    <iframe style="border: 0; width: 100%; height: 100%;"></iframe>
</div> -->