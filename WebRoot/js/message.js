// $(function(){
// 		aaa("<%=bPath%>");
// 	});

//function aaa(bPath)
//{
	$.ajax({
		url:"../notice/getAllUseful.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{
			//var dataInter = data;
			alert("success");
			var interText = doT.template($("#news").text());
			$("#main").html(interText(data.data));
		}
	});
//}
