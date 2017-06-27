//javascript
$(function() {	
	var suffix = '';	//后缀
	var fullPath = '';
	var upData = [];

	$('#chooseFile').click(function() {
		//相当于上传文件点击
		return $("#file").click();
	});

	//选择完成之后，上传文件
	$("#file").change(function(event) {
	/* Act on the event */
		//判断文件类型
		fullPath = $("#file").val();
		suffix = fullPath.split('.').pop().toLowerCase();

		//判断文件后缀
		if (suffix != 'xls') {
                        layer.alert("请选择xls文件", {
							  skin: 'layui-layer-molv' 
							  ,closeBtn: 0
							  ,shift: 1
						});
		} else {
			//文件正确就上传
			upload();
		}

	});

	function upload() {
		$.ajaxFileUpload
            (
                {
                    url: '/ce_system/student/uploadFile',
                    secureuri: false, 
                    fileElementId: 'file', //文件上传域的id
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data)  //服务器成功响应处理函数
                    {
                    	//显示信息
                    	if (data.success) {
                    		showInf(data.data);
                    	} else {
                    		layer.alert("打开失败，请确保内容格式正确，学号，姓名，班级，寝室号", {
							  skin: 'layui-layer-molv' 
							  ,closeBtn: 0
							  ,shift: 1
							});
                    	}
                    	
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        layer.alert("连接出错", {
							  skin: 'layui-layer-molv' 
							  ,closeBtn: 0
							  ,shift: 1
						});
                    }
                }
            )
        
        return false;
	}

	// var t = [{"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"1122", "dormitoryNumber":"12"},
	// {"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"121", "dormitoryNumber":"12"},
	// {"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"1132", "dormitoryNumber":"12"},
	// {"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"12", "dormitoryNumber":"12"},
	// {"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"123", "dormitoryNumber":"12"},
	// {"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"121", "dormitoryNumber":"12"},
	// {"userName":"123", "studentName":"asdfasf", "classNumber":"asdfasdf", "id":"122", "dormitoryNumber":"12"}];

	// showInf(t);

	//显示学生数据
	function showInf(d) {
		$.each(d, function(index, el) {
			$("#tbd").append(getTr(el));
		});
		

	}

	//返回一条数据
	function getTr(d) {

		$str = $('<tr class="">'+
		            '<td style="width: 20px;"><input type="checkbox" name="choose" class="choose" checked=true></td>' + 
		            '<td class="userName">'+ d.userName +'</td>' +
		            '<td class="name">'+ d.studentName +'</td>' +
		            '<td class="class">'+ d.classNumber +'</td>' +
		            '<td class="dor">' + d.dormitoryNumber + '</td>' +
		        '</tr>');

		return $str;
	}


	//全选按钮
	$("#chooseAll").click(function(event) {
		/* Act on the event */
		//全选与全部选
		if (this.checked) {
			$(".choose").attr("checked", true);
		} else {
			$(".choose").attr("checked", false);
		}
	});

	//提交按钮
	$("#submitFile").click(function(event) {
		if ($("#tbd > tr:has(input:checked)").size() <= 0) {
			layer.alert("请选择至少一名学生", {
							  skin: 'layui-layer-molv' 
							  ,closeBtn: 0
							  ,shift: 1
			});

			return false;
		}
		/* Act on the event */
		$("#tbd > tr:has(input:checked)").each(function(index, el) {
			//构造json数组
			packData($(this));
		});

		//提交数据
		subAjax(upData);
	});	

	//将数据变成一个json数组
	function packData(el) {
		var stuName = el.children('.name').text();
		var stuUName = el.children('.userName').text();
		var stuClass = el.children('.class').text();
		var stuDor = el.children('.dor').text();

		var sList = {
					"classNumber": stuClass,
					"studentName": stuName,
					"userName": stuUName,
					"dormitoryNumber": stuDor,
					"password": stuUName,
				};
		upData.push(sList);
	}

	//提交数据
	function subAjax(sList) {

		$.ajax({
			url: '/ce_system/student/registStudents',
			type: 'POST',
			dataType: 'json',
			data:  JSON.stringify(sList) ,
		    contentType : 'application/json;charset=utf-8', //设置请求头信息  
			success: function(data) {
				alert(data.message);
			},
			error:  function (jqXHR, textStatus, errorThrown) {
				layer.msg("网络连接出错： " + textStatus);
			}
		})
		.done(function() {
			console.log("success");
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
		
	}
})