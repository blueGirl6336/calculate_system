$(function(){
	$(".outTotal").click(function(){
		$.ajax({
			url:"../statisticalReports/getPeerEvaluationStatisticalReports.do",
			data:{
				classNumber:$(".classNumber").val()
			},
			type:"get",
			dataType:"json",
			success:function(data){
				alert("导出的表格的本地路径为："+data.data);
			}
		});
	});
	$(".outAll").click(function(){
		$.ajax({
			url:"../statisticalReports/getPerPeerEvaluationStatisticalReports.do",
			data:{
				classNumber:$(".classNumber").val()
			},
			type:"get",
			dataType:"json",
			success:function(data){
				alert("导出的表格的本地路径为："+data.data);
			}
		});
	});
	$(".searchClass").click(function(){
		$.ajax({
			url:"../PeerEvaluation/getPeerEvaluationByClassNumber.do",
			data:{
				classNumber:$(".classNumber").val()
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

			for(var i=0;i<dataList.length;i++)
			{
				var temp = new Dictionary();
				temp.put("number",dataList[i].studentNumber);
				temp.put("name",dataList[i].studentName);
				temp.put("excellent",dataList[i].excellent);
				temp.put("good",dataList[i].good);
				temp.put("common",dataList[i].common);
				temp.put("moder",dataList[i].moder);
				temp.put("resultScore",dataList[i].resultScore);
				grid_data.push(temp.data);
			}


			jQuery("#see-rank-table").jqGrid({
			data: grid_data,
			datatype: "local",
			colNames: ['学号', '姓名', '优', '良', '中', '一般','综合得分'],
			colModel: [{
				name: 'number',
				index: 'number',
				//width: 60,
				align:"center"
			}, {
				name: 'name',
				index: 'name',
				//width: 90,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			}, {
				name: 'excellent',
				index: 'excellent',
				//width: 100,
				//height:30,
				align:"center",
				sortable:false
				//editable: true
			}, {
				name: 'good',
				index: 'good',
				//width: 80,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'moder',
				index: 'moder',
				//width: 80,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'common',
				index: 'common',
				//width: 80,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			},{
				name: 'resultScore',
				index: 'resultScore',
				//width: 80,
				//height:30,
				align:"center",
				sortable:false
				// align: "right",
				// editable: true
			}],
			rowNum: 40,
			height:600,
			//rowList: [10, 20, 30],
			//pager: '#prowed3',
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			//editurl: "server.html",
			caption: dataList[0].classNumber,
			autowidth: true,
			autoheight:true,
			forceFit:false,
			});


			}
		});
	});

});
// $.ajax({
// 	url:"../winScore/searchWinScore.do",
// 	data:{
// 		// apartmentId:"3"
// 	},
// 	type:"get",
// 	dataType:"json",
// 	success:function(data){

// 		var dataList = data.data;

// 			//创建键值对数组
// 		function Dictionary(){
// 				this.data = new Array();
				 
// 				this.put = function(key,value){
// 				  	this.data[key] = value;
// 				};

// 				this.get = function(key){
// 				  	return this.data[key];
// 				};

// 				this.remove = function(key){
// 				  	this.data[key] = null;
// 				};
				 
// 				this.isEmpty = function(){
// 				  	return this.data.length == 0;
// 				};

// 				this.size = function(){
// 				  	return this.data.length;
// 				};
// 		}

// 		var grid_data = [];

// 		for(var i=0;i<dataList.length;i++){

// 				var temp = new Dictionary();
// 				temp.put("wsId",dataList[i].wsId);
// 				temp.put("userName",dataList[i].student.users.userName);
// 				temp.put("siId",dataList[i].scoreItems.siId);
// 				temp.put("isCurrent",dataList[i].isCurrent);
// 				temp.put("time",dataList[i].time);

// 				if(dataList[i].scoreApplication==null){
// 					temp.put("saId","无申请");
// 				}else{
// 					temp.put("saId",dataList[i].scoreApplication.saId);
// 				}

// 				if(dataList[i].isCurrent==true){
// 					temp.put("isCurrent","是");
// 				}
// 				if(dataList[i].isCurrent==false){
// 					temp.put("isCurrent","否");
// 				}

// 				grid_data.push(temp.data);
// 		}
		
//    		jQuery("#editgrid").jqGrid({
//         	data: grid_data,
// 			datatype: "local",
// 			height: 250,
// 			colNames: ['编号','学号', '加分ID', '申请ID', '是否当前学期','时间'],
// 			colModel: [{
// 				name: 'wsId',
// 				index: 'wsId',
// 				key:true,
// 				// width:80,
// 				align:"center",
// 				editable:true
// 			},{
// 				name: 'userName',
// 				index: 'userName',
// 				// width:100,
// 				editable:true,
// 				align:"center"
// 			},{
// 				name: 'siId',
// 				index: 'siId',
// 				// width:170,
// 				editable:true,
// 				align:"center"
// 			},{
// 				name: 'saId',
// 				index: 'saId',
// 				// width:80,
// 				editable:true,
// 				align:"center"
// 			},{
// 				name: 'isCurrent',
// 				index: 'isCurrent',
// 				// width:70,
// 				align:"center",
// 				editable:true,
// 				edittype:"select",
// 				editoptions: {
// 					value: "1:是;0:否"
// 				}
				
// 			},{
// 				name: 'time',
// 				index: 'time',
// 				// width:130,
// 				editable:true,
// 				align:"center",

// 			}],
//         	rowNum : 10,
//         	rowList : [ 10, 20, 30 ],
//         	pager : '#pagered',
//         	sortname : 'wpId',
//         	viewrecords : true,
//         	sortorder : "desc",
//         	// caption: dataList[0].scoreItems.apartment.apartmentName,
//         	autowidth: true,
//         	multiselect: false
//       	});

// 		$("#editgrid").navGrid("#pagered", {
// 				search: true, // 检索
// 				add: true, //添加 （只有editable为true时才能显示属性）
// 				edit: true, //修改（只有editable为true时才能显示属性）
// 				del: true, //删除
// 				refresh: true //刷新
// 			}, {url:"../winScore/modifyWinScore.do",closeAfterSearch: true, reloadAfterSubmit: true}, // edit options
// 			{url:"../winScore/addWinScore.do",closeAfterSearch: true, reloadAfterSubmit: true}, // add options
// 			{url:"../winScore/deleteWinScore.do",closeAfterSearch: true, reloadAfterSubmit: true}, // delete options
// 			{
// 				multipleSearch: true
// 			} // search options - define multiple search
// 		);
//    	}
// });
// $.ajax({
// 	url:"../statisticalReports/getScoreStatisticalReports.do",
// 	data:{},
// 	type:"get",
// 	dataType:"json",
// 	success:function(data){}
// });
