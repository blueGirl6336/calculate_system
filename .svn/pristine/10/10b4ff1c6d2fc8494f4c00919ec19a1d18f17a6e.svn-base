$(function() {

	var u = '/baseFunction/ changeTerm';
	var uCal = 'baseFunction/calculate';

	//当点击结束本学期的时候进行提示
	//提示两次
	$("#btover").click(function(event) {
		/* Act on the event */
		//提示
		layer.confirm('确定结束本学期么亲？', {
  				btn: ['确定结束','取消'] 
			}, 
			//确定
			function(){
				//再次提示
				layer.confirm('为防止误操作，请再次确认？', {
	  				btn: ['确定结束','取消'] 
				}, 
				//确定
				function(){
					//显示等待
					finishTerm();					
				}, 
				//继续修改执行函数
				function(){
					
				});
			}, 
			//继续修改执行函数
			function(){
				
			});
	});

	$("#btcal").click(function(event) {
		/* Act on the event */
		//提示
		layer.confirm('即将计算本学期成绩', {
  				btn: ['确定计算','取消'] 
			}, 
			//确定
			function(){
				cal();
				
			}, 
			//继续修改执行函数
			function(){
				
			});
	});

	//结束本学期的函数
	function finishTerm() {
		//结束本学期的接口

		$.ajax({
			url: u,
			type: 'POST',
			dataType: 'json',
			success: function(data) {
				//返回的纯json
				//{"message":"成功","success":true}
				//如果结束成功
				if (data.success) {
					layer.alert('本学期已经结束！', {
					  skin: 'layui-layer-molv' 
					  ,closeBtn: 0
					  ,shift: 1
					});
				} else {
					layer.alert(data.message, {
					  skin: 'layui-layer-molv' 
					  ,closeBtn: 0
					  ,shift: 1
					});
				}
			},
			error: function (jqXHR, textStatus, errorThrown) {
				layer.msg("连接发生故障： "+textStatus, {icon: 2});
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

	//计算成绩
	function cal() {
		$.ajax({
			url: uCal,
			type: 'POST',
			success: function(data) {
				layer.alert('成绩计算完毕亲！', {
				  skin: 'layui-layer-molv' 
				  ,closeBtn: 0
				  ,shift: 2
				});
			},
			error: function (jqXHR, textStatus, errorThrown) {
				layer.msg("连接发生故障： "+textStatus, {icon: 2});
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