//javascript
//添加新的公告
$(function() {
	//输入验证
	//当点击提交时
	$("#inpTitle").focus(function(event) {
		/* Act on the event */
		if ($(this).val() == '') {
			this.value = '';
		} 
	}).blur(function(event) {
		/* Act on the event */
		if ($(this).val() == '') {
			this.value = '';
		}
	});


	//当点击提交按钮的时候
	$("#confirmContent").click(function(event) {
		/* Act on the event */
		//首先判断有没有标题
		if ($("#inpTitle").val() == '') {
			layer.alert('请输入标题，亲！', {
			  skin: 'layui-layer-molv' 
			  ,closeBtn: 0
			  ,shift: 1
			});
		} else if ($("#inpContent").val() == '') {
			layer.alert('请输入内容，亲！', {
			  skin: 'layui-layer-molv' 
			  ,closeBtn: 0
			  ,shift: 4
			});
		} else {
			layer.confirm('确定提交么亲？', {
  				btn: ['确定提交','继续修改'] 
			}, 
			//确定提交执行函数
			function(){
				//显示等待
				layer.msg('正在提交，请稍后', {icon: 6});
				submitData();
			}, 
			//继续修改执行函数
			function(){
				
			});
		}
	});

	var uAdd = '/notice/add';

	//提交数据的函数
	function submitData() {
		//获得标题和内容
		var t = $('#inpTitle').val();
		var c = $('#inpContent').val();

		//传递参数添加公告
		$.ajax({
			url: uAdd,
			type: 'POST',
			dataType: 'text',
			data: {
				title: t,
				content: c
			},
			//成功
			success: function(data) {
				//成功的返回信息提示
				//{"message":"发布成功","success":true};
				//不管成功失败都是message
					layer.alert(data.message, {
					  skin: 'layui-layer-molv' 
					  ,closeBtn: 0
					  ,shift: 1
					});
			},
			error: function (jqXHR, textStatus, errorThrown) {
				layer.msg("添加失败： "+textStatus, {icon: 2});
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

	//点击清空按钮的时候
	$('#cancelContent').click(function(event) {
		/* Act on the event */
		layer.confirm('确定清空么亲？', {
  				btn: ['确定清空','取消清空'] 
			}, 
			//确定提
			function(){
				//显示等待
				layer.msg('正在清空，请稍后', {time: 100, icon: 6});
				//清空
				cleanTitleContent($('#inpTitle'), $('#inpContent'));
			}, 

			//继续修改执行函数
			function(){
				
			});

	});

	//清空函数
	function cleanTitleContent(t, c) {
		t.val('');
		c.val('');
	}


})