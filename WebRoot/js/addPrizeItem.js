$(function(){
    $(".Check").click(function(){
        $.ajax({
            url:"../addPrize/addAddPrize.do",
            data:{
                // apartmentId:3,
                prizeName:$(".prizeName").val(),
                prizeNeed:$(".prizeNeed").val(),
                prizeDetail:$(".prizeDetail").val(),
                addDetail:$(".addDetail").val()
            },
            type:"get",
            dataType:"json",
            success:function(data){
                if (data.success==true) {
                    alert("添加申请成功！");
                }else{
                    alert("添加申请失败！");
                }
            }
        });     
    }); 
}); 
	