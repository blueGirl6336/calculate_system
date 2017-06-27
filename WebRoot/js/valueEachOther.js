//创建键值对数组
function Dictionary(){
	this.data = new Array();
	 
	this.put = function(key,value){
	  	this.data[key] = value;
	};

	this.get = function(key){
	  	return this.data[key];
	};
	this.remove = function(key){
	  	this.data[key] = null;
	};
	 
	this.isEmpty = function(){
	  	return this.data.length == 0;
	};

	this.size = function(){
	  	return this.data.length;
	};
}


var all_num;
var number = [];


$.ajax({
	url:"../student/allClassScore.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{
			var dataList = data;
			all_num = dataList.length;

			for(var i = 0; i< all_num;i++)
			{
				document.getElementById("tr"+(i+1)).style.display="table-row";
				$("#tr"+(i+1)+ " .number").text(dataList[i].studentNumber);
				$("#tr"+(i+1)+ " .name").text(dataList[i].studentName);


				number.push(dataList[i].studentNumber);
			}

			for(;i<40;i++)
			{
				document.getElementById("tr"+(i+1)).style.display="none";
			}

		}
});


function judge()
{
	var good_num = 0;
	var ok_num = 0;
	var middle_num = 0;
	var normal_num = 0;

	var excellent = [];
	var good = [];
	var moder = [];
	var common = [];


	var result = document.getElementsByTagName("input");
	for(var i = 0;i<result.length;i++)
	{

		if((result[i].checked)&&(result[i].value=="good"))
		{
			good_num++;
			excellent.push(number[parseInt((i-1)/4)].toString());
			//alert("优"+i+number[parseInt(i/4)]);
		}
		if((result[i].checked)&&(result[i].value=="ok"))
		{
			ok_num++;
			good.push(number[parseInt((i-1)/4)].toString());
			//alert("良"+i+number[parseInt(i/4)]);
		}
		if((result[i].checked)&&(result[i].value=="middle"))
		{
			middle_num++;
			moder.push(number[parseInt((i-1)/4)].toString());
			//alert("中"+i+number[parseInt(i/4)]);
		}
		if((result[i].checked)&&(result[i].value=="normal"))
		{
			normal_num++;
			common.push(number[parseInt((i-1)/4)].toString());
			//alert("一般"+i+number[parseInt(i/4)]);
		}
	}

	// var submit = new Dictionary();
	// submit.put("stringExc",excellent);
	// submit.put("stringGood",good);
	// submit.put("stringMod",moder);
	// submit.put("stringCom",common);

	// var submit = {};

	// for (var i = 0; i < excellent.length; i++) 
	// {  
 //    	submit["stringExc[" + i + "]"] = excellent[i];  
	// } 
	// for (var i = 0; i < good.length; i++) 
	// {  
 //    	submit["stringGood[" + i + "]"] = good[i];  
	// } 
	// for (var i = 0; i < moder.length; i++) 
	// {  
 //    	submit["stringMod[" + i + "]"] = moder[i];  
	// } 
	// for (var i = 0; i < common.length; i++) 
	// {  
 //    	submit["stringCom[" + i + "]"] = common[i];  
	// } 

	var sum;
	sum = good_num+ok_num+middle_num+normal_num;
	if(sum != all_num)
	{
		alert("请对所有人做出评价！");
	}else
	if(good_num > (all_num*0.4))
	{
		alert("优的数量必须不超过" + all_num*0.4);
	}else 
	if(ok_num > (all_num*0.4))
	{
		alert("良的数量必须不超过" + all_num*0.4);
	}else 
	if(middle_num > (all_num*0.2))
	{
		alert("中的数量必须不超过" + all_num*0.2);
	}else
	{
		var test;
		$.ajax({
			url:"../PeerEvaluation/makePeerEvaluation.do",
			traditional:true,
			data:{
				"stringExc":excellent,
				"stringGood":good,
				"stringMod":moder,
				"stringCom":common
			},
			type:"get",
			dataType:"json",
			success:function(data)
			{
				alert(data);
			}
		});
	}


}
