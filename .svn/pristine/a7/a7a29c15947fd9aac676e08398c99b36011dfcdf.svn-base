//javascript

/*读取文件按钮单机事件传递给文件上传*/
$(function() {
    var path = '';
    var fileName = '';

    /*文件选择按钮*/
    $('#chooseFile').click(function(event) {
        /* Act on the event */
        $('#inputFile').click();

        path = getFullPath($('#inputFile')[0]);

        alert(path);
        if (path='') {
            return;
        }

        if (isExecl(path)) {
            upLoad();
        } else {
            alert(path);
        }

    });


    /*判断文件类型是不是execl是的话返回真，不是返回假*/
    function isExecl(path) {
            return false;
    }

    /*获取文件路径*/
    function getFullPath(obj){ 
        if(obj) 
        { 
         //ie 
             if (window.navigator.userAgent.indexOf("MSIE")>=1) { 
                obj.select(); 
                 return document.selection.createRange().text; 
             } 
             //firefox 
             else if(window.navigator.userAgent.indexOf("Firefox")>=1) { 
                 if(obj.files) 
                 { 
                    return obj.files.item(0).getAsDataURL(); 
                 } 
                 return obj.value; 
             } 
             return obj.value; 
        } 

    } 

    /*文件上传*/
    function upLoad() {
        $.ajaxFileUpload({
            url: 'load',
            //填写input的id
            fileElementId: 'inputFile',
            //返回xml
            dataType: 'xml',
            //从返回的xml中获取信息追加到html中
            success: function (data) {
                alert(data.msg);
     
            },
            error: function (data) {
                alert("error adfasdfasf");
            }
        });

    }

    /*确定注册按钮*/
    $('#submitFile').click(function(event) {
        /* Act on the event */
        //批量注册
        $.ajax({
            url: "/student/registStudents",
            dataType: xml
        });
    });

    /*将学生的信息转成json*/
    function tableToJson() {

        //行数
        var rows = $("#tbd").length;
        var cols = $
        var d = {};
    }

});

