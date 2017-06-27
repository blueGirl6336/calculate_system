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

$.ajax({
		url:"../student/allClassScore.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{
			var dataList = [];

			dataList = data;

			var all_num = dataList.length;
			

			//使用 例子
			//var d = new Dictionary();
			// d.put("CN", "China");
			// d.put("US", "America");

			var grid_data = [];

			
			for(var i=0;i<dataList.length;i++)
			{
				var temp = new Dictionary();
				//temp.push("number":dataList[i].id.studentNumber,"name":dataList[i].id.studentName,"score":dataList[i].id.score,"gradeSort":dataList[i].id.gpaSort);
				temp.put("number",dataList[i].studentNumber);
				temp.put("name",dataList[i].studentName);
				temp.put("base",35);
				temp.put("daily",dataList[i].daily);
				temp.put("body",5);
				temp.put("peerEvaluation",dataList[i].peerEvaluation);

				var thinkSum = 35 + dataList[i].daily + 5 + dataList[i].peerEvaluation;
				temp.put("thinkSum",thinkSum);

				temp.put("gpa",dataList[i].gpa);
				var baseSum = thinkSum * 0.5 + dataList[i].gpa * 0.5;
				temp.put("baseSum",baseSum);

				temp.put("personality",dataList[i].personalityDevelopment);
				temp.put("comprehensive",dataList[i].comprehensiveScore);
				temp.put("gpaSort",dataList[i].gpaSort);
				temp.put("comprehensiveScoreSort",dataList[i].comprehensiveScoreSort);
				grid_data.push(temp.data);
			}

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
    				{startColumnName: 'base', numberOfColumns: 5, titleText: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;思想道德及身心'}
  				]
			});


		}
	});
