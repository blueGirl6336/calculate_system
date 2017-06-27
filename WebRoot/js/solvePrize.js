$.ajax({
	url:"../auditPrize/searchPrizeApplication.do",
	data:{
		apartmentId:"3"
	},
	type:"get",
	dataType:"json",
	success:function(data){

	var dataList = data.data;

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

			var grid_data = [];

			for(var i=0;i<dataList.length;i++){
				var temp = new Dictionary();
				temp.put("studentName",dataList[i].studentByApplicantId.studentName);
				temp.put("userName",dataList[i].studentByApplicantId.users.userName);
				temp.put("gpa",dataList[i].studentByApplicantId.gpa);
				temp.put("gpaSort",dataList[i].studentByApplicantId.gpaSort);
				temp.put("comprehensivePerformance",dataList[i].studentByApplicantId.comprehensivePerformance);
				temp.put("comprehensivePerformanceRanking",dataList[i].studentByApplicantId.comprehensivePerformanceRanking);
				temp.put("prizeName",dataList[i].prize.prizeName);
				temp.put("type",dataList[i].type);
				temp.put("prizeNeed",dataList[i].prize.prizeNeed);
				temp.put("prizeDetail",dataList[i].prize.prizeDetail);
				temp.put("time",dataList[i].time);
				temp.put("status",dataList[i].status);

				if(dataList[i].type=="400001"){
					temp.put("type","申请");
				}
				if(dataList[i].type=="400002"){
					temp.put("type","申诉");
				}
				if(dataList[i].type=="400003"){
					temp.put("type","奖项申请");
				}
				if(dataList[i].type=="400004"){
					temp.put("type","加分申请");
				}
				if(dataList[i].type=="400005"){
					temp.put("type","奖项申诉");
				}
				if(dataList[i].type=="400006"){
					temp.put("type","加分申诉");
				}

				if(dataList[i].status=="200001"){
					temp.put("status","未审核");
				}
				if(dataList[i].status=="200002"){
					temp.put("status","已同意");
				}
				if(dataList[i].status=="200003"){
					temp.put("status","已拒绝");
				}
				if(dataList[i].status=="900001"){
					temp.put("status","审核中");
				}
				if(dataList[i].status=="200002"){
					temp.put("status","审核成功");
				}
				if(dataList[i].status=="200003"){
					temp.put("status","审核失败");
				}
				grid_data.push(temp.data);
			}

			jQuery("#see-rank-table").jqGrid({
			data: grid_data,
			datatype: "local",
			height: 250,
			colNames: ['姓名', '学号', 'GPA', '排名','综合成绩','排名','奖项名','奖项类型','奖项需要','奖项详情','申请时间','状态'],
			colModel: [{
				name: 'studentName',
				index: 'studentName',
				width:100,
				align:"center"
			},{
				name: 'userName',
				index: 'userName',
				width:170,
				align:"center"
			},{
				name: 'gpa',
				index: 'gpa',
				width:80,
				align:"center"
			},{
				name: 'gpaSort',
				index: 'gpaSort',
				width:70,
				align:"center"
			},{
				name: 'comprehensivePerformance',
				index: 'comprehensivePerformance',
				width:130,
				align:"center"
			},{
				name: 'comprehensivePerformanceRanking',
				index: 'comprehensivePerformanceRanking',
				width:70,
				align:"center"
			},{
				name: 'prizeName',
				index: 'prizeName',
				align:"center"
			},{
				name: 'type',
				index: 'type',
				align:"center"
			},{
				name: 'prizeNeed',
				index: 'prizeNeed',
				width:320,
				align:"center"
			},{
				name: 'prizeDetail',
				index: 'prizeDetail',
				align:"center"
			},{
				name: 'time',
				index: 'time',
				width:175,
				align:"center"
			},{
				name: 'status',
				index: 'status',
				align:"center"
			}],
			rowNum: 10,
			height: 450,
			width:900,
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			caption: dataList[0].prize.apartment.apartmentName,
			autowidth: true,
			});
			
		}
	});