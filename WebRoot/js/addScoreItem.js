$(function(){
    $(".Check").click(function(){
        $.ajax({
            url:"../addScore/addAddScore.do",
            data:{
                // apartmentId:3,
                score:$(".prizeName").val(),
                scoreType:$(".prizeNeed").val(),
                scoreName:$(".prizeDetail").val(),
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