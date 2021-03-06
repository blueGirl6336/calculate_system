$.ajax({
		url:"../addPrize/searchAddPrize.do",
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
				temp.put("prizeName",dataList[i].prizeName);
				temp.put("prizeNeed",dataList[i].prizeNeed);
				temp.put("prizeDetail",dataList[i].prizeDetail);
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
			colNames: ['奖项名', '奖项要求', '奖项详情', '添加详情','申请状态'],
			colModel: [{
				name: 'prizeName',
				index: 'prizeName',
				align:"center"
			},{
				name: 'prizeNeed',
				index: 'prizeNeed',
				align:"center"
			},{
				name: 'prizeDetail',
				index: 'prizeDetail',
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
			sortname: 'time',
			viewrecords: true,
			sortorder: "dsc",
			// caption: dataList[0].apartment.apartmentName,
			autowidth: true,
			});

		}
	});