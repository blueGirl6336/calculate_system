$.ajax({
		url:"../addScore/searchAddScore.do",
		data:{
			// apartmentId:3
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
				temp.put("scoreName",dataList[i].scoreName);
				temp.put("score",dataList[i].score);

				if (dataList[i].scoreType=="300001") {
					temp.put("scoreType","日常行为分");
				}
				if (dataList[i].scoreType=="300002") {
					temp.put("scoreType","科技竞赛个性发展分");
				}
				if (dataList[i].scoreType=="300003") {
					temp.put("scoreType","体能分");
				}
				if (dataList[i].scoreType=="300004") {
					temp.put("scoreType","学生工作个性发展分");
				}
				if (dataList[i].scoreType=="300005") {
					temp.put("scoreType","社会实践能力个性发展分");
				}
				if (dataList[i].scoreType=="300006") {
					temp.put("scoreType","辅修及计算机水平个性发展分");
				}
				if (dataList[i].scoreType=="300007") {
					temp.put("scoreType","特殊表彰");
				}

				temp.put("addDetail",dataList[i].addDetail);
				
				if(dataList[i].status=="600001"){
					temp.put("status","待审核");
				}
				if(dataList[i].status=="600002"){
					temp.put("status","审核通过");
				}
				if(dataList[i].status=="600003"){
					temp.put("status","未通过");
				}
				grid_data.push(temp.data);
			}

			jQuery("#see-rank-table").jqGrid({
			data: grid_data,
			datatype: "local",
			height: 250,
			colNames: ['分数名', '分数', '分数类型', '添加详情','申请状态'],
			colModel: [{
				name: 'scoreName',
				index: 'scoreName',
				align:"center"
			},{
				name: 'score',
				index: 'score',
				align:"center"
			},{
				name: 'scoreType',
				index: 'scoreType',
				align:"center"
			},{
				name: 'addDetail',
				index: 'addDetail',
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
			// caption: dataList[0].apartment.apartmentName,
			autowidth: true,
			});

		}
	});