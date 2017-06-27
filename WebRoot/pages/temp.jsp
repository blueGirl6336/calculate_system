<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">
<head>  
    <title>导入</title>  

    <script src="js/jquery/jquery-2.0.3.min.js"></script>  
    <script src="js/jquery-form.js"></script>  
    <script src="js/jquery.validate.min.js"></script>  
    <!-- <script src="js/bootstrap.min.js"></script>  
    <script src="js/bootstrap.file-input.js"></script>   -->
</head>  
<body>  
    <div class="container">  
        <h3>导入Excel</h3>  
        <form id="uploadimg-form"  action="" method="post">  
            <input type="file" title="选择文件" name="fileUpload" id="fileUpload"/><br /><br />  
            <input id="fileBtn" type="submit" class="btn" value="文件上传"/><br /><br />  
        </form>  
  
        <div id="showData" style="display: none;">  
            <div>  
                <p>导入数据如下：</p>  
                <p id="jsonShow"></p>  
            </div>  
        </div>  
    </div>  
  
    <script type="text/javascript">  
        $(function() {  
            $("#uploadimg-form").resetForm().validate({  
                rules: {  
                    "fileUpload": {  
                        required: true,  
                        accept: "xls"  
                    }  
                },  
                messages: {  
                    "fileUpload": {  
                        required: "请选择上传文件",  
                        accept: "文件格式不支持，请上传 xls 格式的文件"  
                    }  
                },  
                submitHandler: function() {  
                    $("#uploadimg-form").ajaxSubmit({  
                        url:"ajax.jsp?m=uploadExcel",  
                        type:"post",  
                        enctype:"multipart/form-data",  
                        contentType: "application/x-www-form-urlencoded; charset=utf-8",  
                        dataType:"json",  
                        success: function(data){  
                            var str = "";  
                            for (var i=0, len=data.length; i < len; i++) {  
                                str += "<p>";  
                                str += data[i]["deparement"] + "," + data[i]["name"] + "," + data[i]["date"];  
                                str += "</p>";  
                            }  
                            $("#jsonShow").append(str);  
                            $("#showData").removeAttr("style");  
                            $("#jsonBtn").removeAttr("disabled").removeAttr("title");  
                        },  
                        error: function() {  
                            alert('error');  
                        }  
                    });  
                    return false;  
                }  
            });  
        });  
    </script>  
</body>  
</html>  
