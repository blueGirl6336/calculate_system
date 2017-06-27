$.ajax({
	url:"../winPrize/searchWinPrize.do",
	data:{
		// apartmentId:"3"
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
				temp.put("wpId",dataList[i].wpId);
				temp.put("userName",dataList[i].student.users.userName);
				temp.put("studentName",dataList[i].student.studentName);
				temp.put("prizeId",dataList[i].prize.prizeId);
				temp.put("isCurrent",dataList[i].isCurrent);
				temp.put("time",dataList[i].time);

				

				if(dataList[i].isCurrent==true){
					temp.put("isCurrent","是");
				}
				if(dataList[i].isCurrent==false){
					temp.put("isCurrent","否");
				}

				grid_data.push(temp.data);
		}
		
   		jQuery("#editgrid").jqGrid({
        	data: grid_data,
			datatype: "local",
			height: 250,
			colNames: ['编号','学号','姓名',  '奖项ID', '是否当前学期','时间'],
			colModel: [{
				name: 'wpId',
				index: 'wpId',
				key:true,
				// width:80,
				hidden:true,
				align:"center",
				editable:true
			},{
				name: 'userName',
				index: 'userName',
				// width:100,
				editable:true,
				align:"center"
			},{
				name: 'studentName',
				index: 'studentName',
				// width:100,
				// editable:true,
				align:"center"
			},{
				name: 'prizeId',
				index: 'prizeId',
				// width:170,
				editable:true,
				align:"center"
			},{
				name: 'isCurrent',
				index: 'isCurrent',
				// width:70,
				align:"center",
				editable:true,
				edittype:"select",
				editoptions: {
					value: "1:是;0:否"
				}
				
			},{
				name: 'time',
				index: 'time',
				// width:130,
				// editable:true,
				align:"center",

			}],
			rownumbers:true,
        	rowNum : 20,
        	rowList : [ 10, 20, 30 ],
        	pager : '#pagered',
        	sortname : 'wpId',
        	viewrecords : true,
        	sortorder : "asc",
        	caption: dataList[0].prize.apartment.apartmentName,
        	autowidth: true,
        	height:'auto',
        	multiselect: false
      	});

		$("#editgrid").navGrid("#pagered", {
				search: true, // 检索
				add: true, //添加 （只有editable为true时才能显示属性）
				edit: true, //修改（只有editable为true时才能显示属性）
				del: true, //删除
				refresh: true //刷新
			}, {url:"../winPrize/modifyWinPrize.do",closeAfterSearch: true, reloadAfterSubmit: true}, // edit options
			{url:"../winPrize/addWinPrize.do",closeAfterSearch: true, reloadAfterSubmit: true}, // add options
			{url:"../winPrize/deleteWinPrize.do",closeAfterSearch: true, reloadAfterSubmit: true}, // delete options
			{
				multipleSearch: true
			} // search options - define multiple search
		);
	
		
	
   	}
});
/*-----------------------------------------------------------------------------------*/
	/*	Dropzone
	/*-----------------------------------------------------------------------------------*/
	


	// handleDropzone();
