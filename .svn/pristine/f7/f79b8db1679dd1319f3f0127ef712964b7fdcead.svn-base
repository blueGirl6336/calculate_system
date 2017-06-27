
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


var number = [];


$.ajax({
		url:"../student/studentScore.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{
			var dataList = [];

			dataList = data;

			var all_num = dataList.length;

			var grid_data = [];

			
			// for(var i=0;i<dataList.length;i++)
			// {
				var temp = new Dictionary();
				//temp.push("number":dataList[i].id.studentNumber,"name":dataList[i].id.studentName,"score":dataList[i].id.score,"gradeSort":dataList[i].id.gpaSort);
				temp.put("number",data.studentNumber);
				temp.put("name",data.studentName);
				temp.put("base",35);
				temp.put("daily",data.daily);
				temp.put("body",5);
				temp.put("peerEvaluation",data.peerEvaluation);

				var thinkSum = 35 + data.daily + 5 + data.peerEvaluation;
				temp.put("thinkSum",thinkSum);

				temp.put("gpa",data.gpa);
				var baseSum = thinkSum * 0.5 + data.gpa * 0.5;
				temp.put("baseSum",baseSum);

				temp.put("personality",data.personalityDevelopment);
				temp.put("comprehensive",data.comprehensiveScore);
				temp.put("gpaSort",data.gpaSort);
				temp.put("comprehensiveScoreSort",data.comprehensiveScoreSort);
				grid_data.push(temp.data);
			//}

			jQuery("#see-rank-table").jqGrid({
			data: grid_data,
			datatype: "local",
			height: 450,
			colNames: ['学号', '姓名','基础分', '行为分','体能分', '他评分','合计',"文化分",'基础素质总分',"个性发展分","综合素质总分","学习专业排名","综合素质专业排名"],
			colModel: [{
				name: 'number',
				index: 'number',
				width: 90,
				//height:30,
				align:"center"
			},{
				name: 'name',
				index: 'name',
				width: 65,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			}
			,{
				name: 'base',
				index: 'base',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'daily',
				index: 'daily',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'body',
				index: 'body',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'peerEvaluation',
				index: 'peerEvaluation',
				width: 58,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'thinkSum',
				index: 'thinkSum',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'gpa',
				index: 'gpa',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'baseSum',
				index: 'baseSum',
				width: 103,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'personality',
				index: 'personality',
				width: 85,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'comprehensive',
				index: 'comprehensive',
				width: 105,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'gpaSort',
				index: 'gpaSort',
				width: 113,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'comprehensiveScoreSort',
				index: 'comprehensiveScoreSort',
				width: 135,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			}],
			rowNum:all_num,
			width:900,
			//rowList: [10, 20, 30],
			//pager: '#prowed3',
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			//editurl: "server.html",
			//caption: dataList[0].id.classNumber,
			autowidth: true,
			//autoheigth: true,
			});

			jQuery("#see-rank-table").jqGrid('setGroupHeaders', {
  				useColSpanStyle: true, 
  				groupHeaders:
  				[
    				{startColumnName: 'base', numberOfColumns: 5, titleText: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;思想道德及身心'}
  				]
			});


			var dataList = [];

			dataList = data.winScoreTempList;

			var grid_data = [];

			
			for(var i=0;i<dataList.length;i++)
			{
				var temp = new Dictionary();

				temp.put("number",dataList[i].winScoreId);

				number.push(dataList[i].winScoreId);

				temp.put("name",dataList[i].scoreName);
				temp.put("type",dataList[i].scoreType);
				temp.put("score",dataList[i].score);
				grid_data.push(temp.data);
			}

			jQuery("#prize-table").jqGrid({
			data: grid_data,
			datatype: "local",
			colNames: ['加分编号', '加分项目', '加分类型', '分值'],
			colModel: [{
				name: 'number',
				index: 'number',

				align:"center"
			},{
				name: 'name',
				index: 'name',

				align:"center",
				sortable:false

			},{
				name: 'type',
				index: 'type',

				align:"center",
				sortable:false

			},{
				name: 'score',
				index: 'score',

				align:"center",
				sortable:false

			}],
			rowNum: 40,
			height: 260,
			width:900,
			multiselect:true,
			//rowList: [10, 20, 30],
			//pager: '#prowed3',
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			//editurl: "server.html",
			//caption: dataList[0].id.classNumber,
			autowidth: true,
			//autoheigth: true,
			});

		}
});
			/*
			var dataList = [];

			dataList = data;

			var all_num = dataList.length;

			var grid_data = [];

			
			// for(var i=0;i<dataList.length;i++)
			// {
				var temp = new Dictionary();
				//temp.push("number":dataList[i].id.studentNumber,"name":dataList[i].id.studentName,"score":dataList[i].id.score,"gradeSort":dataList[i].id.gpaSort);
				temp.put("number",data.studentNumber);
				temp.put("name",data.studentName);
				temp.put("base",35);
				temp.put("daily",data.daily);
				temp.put("body",5);
				temp.put("peerEvaluation",data.peerEvaluation);

				var thinkSum = 35 + data.daily + 5 + data.peerEvaluation;
				temp.put("thinkSum",thinkSum);

				temp.put("gpa",data.gpa);
				var baseSum = thinkSum * 0.5 + data.gpa * 0.5;
				temp.put("baseSum",baseSum);

				temp.put("personality",data.personalityDevelopment);
				temp.put("comprehensive",data.comprehensiveScore);
				temp.put("gpaSort",data.gpaSort);
				temp.put("comprehensiveScoreSort",data.comprehensiveScoreSort);
				grid_data.push(temp.data);
			//}

			jQuery("#see-rank-table").jqGrid({
			data: grid_data,
			datatype: "local",
			height: 600,
			colNames: ['学号', '姓名','基础分', '行为分','体能分', '他评分','合计',"文化分",'基础素质总分',"个性发展分","综合素质总分","学习专业排名","综合素质专业排名"],
			colModel: [{
				name: 'number',
				index: 'number',
				width: 90,
				//height:30,
				align:"center"
			},{
				name: 'name',
				index: 'name',
				width: 65,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			}
			,{
				name: 'base',
				index: 'base',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'daily',
				index: 'daily',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'body',
				index: 'body',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'peerEvaluation',
				index: 'peerEvaluation',
				width: 58,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'thinkSum',
				index: 'thinkSum',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'gpa',
				index: 'gpa',
				width: 55,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'baseSum',
				index: 'baseSum',
				width: 103,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'personality',
				index: 'personality',
				width: 85,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			},{
				name: 'comprehensive',
				index: 'comprehensive',
				width: 105,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'gpaSort',
				index: 'gpaSort',
				width: 113,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'comprehensiveScoreSort',
				index: 'comprehensiveScoreSort',
				width: 135,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			}],
			rowNum:all_num,
			width:900,
			//rowList: [10, 20, 30],
			//pager: '#prowed3',
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			//editurl: "server.html",
			//caption: dataList[0].id.classNumber,
			autowidth: true,
			//autoheigth: true,
			});

			jQuery("#see-rank-table").jqGrid('setGroupHeaders', {
  				useColSpanStyle: true, 
  				groupHeaders:
  				[
    				{startColumnName: 'base', numberOfColumns: 5, titleText: '思想道德及身心'}
  				]
			});

*/


/*
			var dataList = [];

			dataList = data.winScoreTempList;

			var grid_data = [];

			
			for(var i=0;i<dataList.length;i++)
			{
				var temp = new Dictionary();

				temp.put("number",dataList[i].winScoreId);

				number.push(dataList[i].winScoreId);

				temp.put("name",dataList[i].scoreName);
				temp.put("type",dataList[i].scoreType);
				temp.put("score",dataList[i].score);
				grid_data.push(temp.data);
			}

			jQuery("#prize-table").jqGrid({
			data: grid_data,
			datatype: "local",

			colNames: ['加分编号', '加分项目', '加分类型', '分值'],
			colModel: [{
				name: 'number',
				index: 'number',

				align:"center"
			},{
				name: 'name',
				index: 'name',

				align:"center",
				sortable:false

			},{
				name: 'type',
				index: 'type',

				align:"center",
				sortable:false

			},{
				name: 'score',
				index: 'score',

				align:"center",
				sortable:false

			}],
			rowNum: 40,
			height: 260,
			width:900,
			multiselect:true,
			//rowList: [10, 20, 30],
			//pager: '#prowed3',
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			//editurl: "server.html",
			//caption: dataList[0].id.classNumber,
			autowidth: true,
			//autoheigth: true,
			});
			*/
	



var scoreNum = [];

var one_name = [];
var one_num = [];

var two_tech_name = [];
var two_tech_num = [];

var two_stu_name = [];
var two_stu_num = [];

var two_social_name = [];
var two_social_num = [];

var two_cpu_name = [];
var two_cpu_num = [];

var two_spec_name = [];
var two_spec_num = [];


$.ajax({
	url:"../scoreItem/getAll.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{
			var dataList = data;

			for(var i = 0;i<dataList.length;i++)
			{
				scoreNum.push(dataList[i].siId);

				switch(dataList[i].scoreType)
				{
					case "300001":one_name.push(dataList[i].itemName);
								  one_num.push(i);
								  break;
					case "300002":two_tech_name.push(dataList[i].itemName);
								  two_tech_num.push(i);
								  break;
					case "300004":two_stu_name.push(dataList[i].itemName);
								  two_stu_num.push(i);
								  break;
					case "300005":two_social_name.push(dataList[i].itemName);
								  two_social_num.push(i);
								  break;
					case "300006":two_cpu_name.push(dataList[i].itemName);
								  two_cpu_num.push(i);
								  break;
					case "300007":two_spec_name.push(dataList[i].itemName);
								  two_spec_num.push(i);
								  break;

				}
			}
		}
});


function appeal()
{
	var select = 0;

	var appealNum = [];

	var result = document.getElementsByTagName("input");
	for(var i = 0;i<result.length;i++)
	{
		if(result[i].checked)
		{
			select++;
			appealNum.push(number[i-1]);
		}
	}
	if(select<=0)
	{
		alert("请选择奖项");
	}
	else if(select>1)
	{
		alert("只能选择一个奖项");
	}
	else
	{
		apply = appealNum[0];
		document.getElementById("appealMyPrize").style.display="block";
	}
}

function ok1()
{

	var reason;
	reason = document.getElementById("text1").value;

	var type0 = "updateScore";

	$.ajax({
			url:"../scoreApplication/makeScoreApplication.do",
			traditional:true,
			data:{
				itemId:apply,
				type:type0,
				news:reason,
				objectId:0
			},
			type:"get",
			dataType:"json",
			success:function(data)
			{
				alert("申诉成功！");
				document.getElementById("appealMyPrize").style.display="none";

			}
		});
}


function cancel1()
{
	document.getElementById("appealMyPrize").style.display="none";
}




function apply()
{
	document.getElementById("applyNewPrize").style.display="block";
	document.getElementById("prize1").options[0].selected = true;
	document.getElementById("prize2").options[0].selected = true;
	document.getElementById("prize3").options[0].selected = true;
}


// var type=[    
// 			["","","","",""],  
//             ["科技竞赛","学生工作","社会实践","辅修及计算机水平","特殊表彰"]
//          ];


function getType1()
{
    var value;

	value = document.getElementById("prize1").value;

	if(value == 11)
	{
		document.getElementById("prize2").options.length=1;
		document.getElementById("prize3").options.length=1;
		for(var i = 0;i<one_num.length;i++)
		{
			document.getElementById("prize3").options.add(new Option(one_name[i],one_num[i]));
		}
		
	}
	else if(value ==12)
	{
		document.getElementById("prize2").options.length=1;
		document.getElementById("prize2").options.add(new Option("科技竞赛","300002"));
		document.getElementById("prize2").options.add(new Option("学生工作","300004"));
		document.getElementById("prize2").options.add(new Option("社会实践","300005"));
		document.getElementById("prize2").options.add(new Option("辅修及计算机水平","300006"));
		document.getElementById("prize2").options.add(new Option("特殊表彰","300007"));
	}


    	// //获得对象type1  
     //    var type1=document.frm.s1;
     //    //获得对象type2   
     //    var type2=document.frm.s2;  
     //    //得到对应type1的type2数组    
     //    var type12=type[type1.selectedIndex - 1];  
     //    //清空type2下拉框，仅留提示选项    
     //    document.getElementById("prize2").options.length=1;    
     //    //将type2数组中的值填充到城市下拉框中    
     //    for(var i=0;i<type12.length;i++)
     //    {   
     //    	document.getElementById("prize2").options.add(new Option(type12[i],type12[i]));   
     //    }    
}

// var num = [];
// num.push(one_num.length);
// num.push(two_tech_num.length);
// num.push(two_stu_num.length);
// num.push(two_social_num.length);
// num.push(two_cpu_num.length);
// num.push(two_spec_num.length);


function getType2()
{
	var value = document.getElementById("prize2").value;

	switch(value)
	{
		case "300002":document.getElementById("prize3").options.length=1;
					for(var i = 0;i<two_tech_num.length;i++)
					{
						document.getElementById("prize3").options.add(new Option(two_tech_name[i],two_tech_num[i]));
					}
					break;
		case "300004":document.getElementById("prize3").options.length=1;
					for(var i = 0;i<two_stu_num.length;i++)
					{
						document.getElementById("prize3").options.add(new Option(two_stu_name[i],two_stu_num[i]));
					}
					break;
		case "300005":document.getElementById("prize3").options.length=1;
					for(var i = 0;i<two_social_num.length;i++)
					{
						document.getElementById("prize3").options.add(new Option(two_social_name[i],two_social_num[i]));
					}
					break;
		case "300006":document.getElementById("prize3").options.length=1;
					for(var i = 0;i<two_cpu_num.length;i++)
					{
						document.getElementById("prize3").options.add(new Option(two_cpu_name[i],two_cpu_num[i]));
					}
					break;
		case "300007":document.getElementById("prize3").options.length=1;
					for(var i = 0;i<two_spec_num.length;i++)
					{
						document.getElementById("prize3").options.add(new Option(two_spec_name[i],two_spec_num[i]));
					}
					break;
	}
}


function ok2()
{

	var reason;
	reason = document.getElementById("text2").value;

	var type0 = "saveScore";

	var index = document.getElementById("prize3").value;
	var id = scoreNum[index];

	$.ajax({
			url:"../scoreApplication/makeScoreApplication.do",
			traditional:true,
			data:{
				itemId:id,
				type:type0,
				news:reason,
				objectId:0
			},
			type:"get",
			dataType:"json",
			success:function(data)
			{
				alert("申请成功！");
				document.getElementById("applyNewPrize").style.display="none";

			}
		});
}


function cancel2()
{
	document.getElementById("applyNewPrize").style.display="none";
}


// var max = Math.max(one_num.length,two_tech_num.length,two_stu_num.length,two_social_num.length,two_cpu_num.length,two_spec_num.length);
// var name = [];
// var num = [];

// var one = [];




// function getType2()
// {
// 	//获得对象type1  
//     var type1=document.frm.s1;
//         //获得对象type2   
//         var type2=document.frm.s2;  
//         //得到对应type1的type2数组    
//         var type12=type[type1.selectedIndex - 1];  
//         //清空type2下拉框，仅留提示选项    
//         document.getElementById("prize2").options.length=1;    
//         //将type2数组中的值填充到城市下拉框中    
//         for(var i=0;i<type12.length;i++)
//         {   
//         	document.getElementById("prize2").options.add(new Option(type12[i],type12[i]));   
//         }    
// }
