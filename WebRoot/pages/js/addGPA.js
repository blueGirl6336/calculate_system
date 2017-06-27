var courses=[];	
$.ajax({
		url:"../course/getAllCourse.do",
		data:{},
		type:"get",
		dataType:"json",
		success:function(data){		
			courses=data.data;
			for(var i=0;i<5;i++){   
				$(".courseId").append('<option value="'+courses[i].courseId+'">'+courses[i].courseName+'</option>');
			}
		}
	});
$(".enter").click(function(){
	$.ajax({
		url:"../chooseClass/modifyChooseClass.do",
		data:{
			userName:$(".userName").val(),
			courseId:$(".courseId").val(),
			score:$(".point").val()
		},
		type:"get",
		dataType:"json",
		success:function(data){
			if (data.success==true) {
				alert("录入成功！");
			}else{
				alert("录入失败！");
			}
		}
	});
});

$(".search").click(function(){
	$.ajax({
	url:"../chooseClass/searchByMajorNameAndGradeNumber.do",
	data:{
		majorName:$(".major").val(),
		gradeNumber:$(".grade").val()
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
		var col_model=[];
		var col_names=[];
		var col_size=courses.length;
		
		col_names[0]="学号";
		col_names[1]="姓名";
		col_names[2]="班级";
		for (var k=0; k <col_size; k++) {
			col_names[3+k]=courses[k].courseName+"("+courses[k].point+")";
		}

		var temp1 = new Dictionary();
		temp1.put("name","userName");
		temp1.put("index","userName");
		temp1.put("align","center");
		col_model.push(temp1.data);

		var temp1 = new Dictionary();
		temp1.put("name","studentName");
		temp1.put("index","studentName");
		temp1.put("align","center");
		col_model.push(temp1.data);

		var temp1 = new Dictionary();
		temp1.put("name","classNumber");
		temp1.put("index","classNumber");
		temp1.put("align","center");
		col_model.push(temp1.data);

		for(var k=0; k <col_size; k++){	
			var temp1 = new Dictionary();		
			temp1.put("name","score"+k);
			temp1.put("index","score"+k);	
			temp1.put("align","center");	
			col_model.push(temp1.data);			
		}

		if (dataList!=null) {
			var temp2=new Dictionary();
			temp2.put("userName",dataList[0].student.users.userName);
			temp2.put("studentName",dataList[0].student.studentName);
			temp2.put("classNumber",dataList[0].student.classes.classNumber);
			for (var j = 0; j<col_size; j++) {
				if (dataList[0].course.courseId==courses[j].courseId) {
					temp2.put("score"+j,dataList[0].score);
					break;
				}
			}
		}
		for (var i = 1; i <dataList.length; i++) {
			if (dataList[i].student.users.userName!=dataList[i-1].student.users.userName) {
				grid_data.push(temp2.data);
				var temp2=new Dictionary();
				temp2.put("userName",dataList[i].student.users.userName);
				temp2.put("studentName",dataList[i].student.studentName);
				temp2.put("classNumber",dataList[i].student.classes.classNumber);
			}
			for (var j = 0; j<col_size; j++) {
				if(dataList[i].course==null){
					break;
				}
				if (dataList[i].course.courseName==courses[j].courseName) {
					temp2.put("score"+j,dataList[i].score);
					break;
				}
			}
			
		}
		grid_data.push(temp2.data);

   		jQuery("#editgrid").jqGrid({
        	data: grid_data,
			datatype: "local",
			height: 250,
			colNames: col_names,
			colModel: col_model,
			rownumbers:true,
        	rowNum : 10,
        	rowList : [ 10, 20, 30 ],
        	pager : '#pagered',
        	sortname : 'id',
        	viewrecords : true,
        	sortorder : "desc",
        	caption: dataList[0].student.classes.major.majorName,
        	autowidth: true,
        	multiselect: false,
         	// editurl : "../chooseClass/modifyChooseClass.do"
      	});

		$("#editgrid").navGrid("#pagered", {
				search: true, // 检索
				add: false, //添加 （只有editable为true时才能显示属性）
				edit: false, //修改（只有editable为true时才能显示属性）
				del: false, //删除
				refresh: true //刷新
			}, {closeAfterSearch: true, reloadAfterSubmit: true}, // edit options
			{}, // add options
			{}, // delete options
			{
				multipleSearch: true
			} // search options - define multiple search
		);

   	}
});


  $.ajax({
	url:"../chooseClass/searchByMajorNameAndGradeNumber.do",
	data:{
		majorName:$(".major").val(),
		gradeNumber:$(".grade").val()
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
		var col_model=[];
		var col_names=[];
		var col_size=0;
		for (var i = 1; i < dataList.length; i++) {
			if (dataList[0].course.courseId==dataList[i].course.courseId) {
				col_size=i;
				break;
			}
		}
		col_names[0]="学号";
		col_names[1]="姓名";
		col_names[2]="班级";
		for (var k=0; k <col_size; k++) {
			col_names[3+k]=dataList[k].course.courseName+"("+dataList[k].course.point+")";
		}
		col_names[3+col_size]="GPA";
		col_names[4+col_size]="排名";
		col_names[5+col_size]="综合成绩";
		col_names[6+col_size]="排名";

		var temp1 = new Dictionary();
		temp1.put("name","userName");
		temp1.put("index","userName");
		temp1.put("align","center");
		temp1.put("editable",true);
		col_model.push(temp1.data);
		var temp1 = new Dictionary();
		temp1.put("name","studentName");
		temp1.put("index","studentName");
		temp1.put("align","center");
		col_model.push(temp1.data);
		var temp1 = new Dictionary();
		temp1.put("name","classNumber");
		temp1.put("index","classNumber");
		temp1.put("align","center");
		col_model.push(temp1.data);
		for(var k=0; k <col_size; k++){	
			var temp1 = new Dictionary();		
			temp1.put("name","score"+k);
			temp1.put("index","score"+k);	
			temp1.put("align","center");
			temp1.put("editable",true);		
			col_model.push(temp1.data);			
		}
		var temp1 = new Dictionary();
		temp1.put("name","gpa");
		temp1.put("index","gpa");
		temp1.put("align","center");
		col_model.push(temp1.data);
		var temp1 = new Dictionary();
		temp1.put("name","gpaSort");
		temp1.put("index","gpaSort");
		temp1.put("align","center");
		col_model.push(temp1.data);
		var temp1 = new Dictionary();
		temp1.put("name","comprehensivePerformance");
		temp1.put("index","comprehensivePerformance");
		temp1.put("align","center");
		col_model.push(temp1.data);
		var temp1 = new Dictionary();
		temp1.put("name","comprehensivePerformanceRanking");
		temp1.put("index","comprehensivePerformanceRanking");
		temp1.put("align","center");
		col_model.push(temp1.data);

		for (var i = 0; i <(dataList.length)/col_size; i++) {
			var temp2=new Dictionary();
			temp2.put("userName",dataList[i*col_size].student.users.userName);
			temp2.put("studentName",dataList[i*col_size].student.studentName);
			temp2.put("classNumber",dataList[i*col_size].student.classes.classNumber);
			for (var j=0; j <col_size; j++) {
				temp2.put("score"+j,dataList[i*col_size+j].score);
			}
			temp2.put("gpa",dataList[i*col_size].student.gpa);
			temp2.put("gpaSort",dataList[i*col_size].student.gpaSort);
			temp2.put("comprehensivePerformance",dataList[i*col_size].student.comprehensivePerformance);
			temp2.put("comprehensivePerformanceRanking",dataList[i*col_size].student.comprehensivePerformanceRanking);
			grid_data.push(temp2.data);
		}

   		jQuery("#editgrid1").jqGrid({
        	data: grid_data,
			datatype: "local",
			height: 250,
			colNames: col_names,
			colModel: col_model,
			rownumbers:true,
        	rowNum : 10,
        	rowList : [ 10, 20, 30 ],
        	pager : '#pagered1',
        	sortname : 'id',
        	viewrecords : true,
        	sortorder : "desc",
        	caption: dataList[0].student.classes.major.majorName,
        	autowidth: true,
        	multiselect: false,
      	});

		$("#editgrid1").navGrid("#pagered1", {
				search: true, // 检索
				add: false, //添加 （只有editable为true时才能显示属性）
				edit: false, //修改（只有editable为true时才能显示属性）
				del: false, //删除
				refresh: true //刷新
			}, {}, // edit options
			{}, // add options
			{}, // delete options
			{
				multipleSearch: true
			} // search options - define multiple search
		);

   	}
});

});

