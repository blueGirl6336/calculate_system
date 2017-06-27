//js 
$(function() {
	$("#aLogout").click(function(event) {
		/* Act on the event */

		layer.confirm('确定注销么，亲？', {
		  btn: ['确定','取消'] //按钮
		}, function(){
		  layer.msg('正在注销', {icon: 1});
		  logoutFun();

		}, function(){

		});
		
	});

	function logoutFun() {
		//跳转页面，同时取消session
		window.location.href = "login.html";
	}
})