//javascript
$(function() {

	var uLogin = 'http://123.207.138.101:8080/ce_system//apartment/distribute?apartmentId=4&studentId=24';

	$('#userName').focus(function() {
		$('#userClue').text('');
		$('#passClue').text('');
		$("#returnClue").text('');
		if ($(this).val() == '用户名') {
			this.value = '';
		}
	}).blur(function() {
		if ($(this).val() == '') {
			this.value = '用户名';
		}
	});
	
	$('#userPass').focus(function() {
		$('#userClue').text('');
		$('#passClue').text('');
		$("#returnClue").text('');
		if (this.value == '密码') {
				this.type = 'password';
				this.value = '';
			}
		}).blur(function() {
			if (this.value == '') {
				this.type='text';
				this.value='密码';
			}
	});
	
	$('#btnLogin').click(function() {
		var $name = $("#userName");
		var $pass = $("#userPass");
		
		if ($name.val() == $name[0].defaultValue) {
			$('#userClue').text('请输入用户名');
			return false;
		}
		
		if ($pass.val() == $pass[0].defaultValue) {
			$('#passClue').text('请输入密码');
			return false;
		}

		sbm($name, $pass);

	});

	//提交用户名和密码
	function sbm(uName, uPass) {
		$.ajax({
			url: uLogin,
			type: 'POST',
			dataType: 'json',
			data: {username: uName, userpass: uPass},
			success: function(data) {
				//成功的话,添加session，然后页面跳转
				
				//如果错误的话
				$("#returnClue").text('用户名或者密码错误');
			},
			error: function() {
				/* Act on the event */
				layer.msg("未知错误！");
				
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