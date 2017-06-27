

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

var dailyTitle = [];
var personalityTitle = [];

var dailyNum = [];
var personalityNum = [];

var dailyCol = [];
var personalityCol = [];

dailyTitle.push("学号");
dailyTitle.push("姓名");

var temp = new Dictionary();
temp.put("name","number");
temp.put("index","number");
temp.put("align","center");
dailyCol.push(temp.data);

var temp = new Dictionary();
temp.put("name","name");
temp.put("index","name");
temp.put("align","center");
dailyCol.push(temp.data);

$.ajax({
		url:"../scoreItem/getAll.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{

			var dataList = [];

			dataList = data;

			//alert(dataList.length);

			for(var i=0;i<dataList.length;i++)
			{
				//alert("进入"+i+"统计日常行为个性发展循环");


				if(dataList[i].scoreType == 300001)
				{

					dailyTitle.push(dataList[i].itemName);

					//alert("姓名成功");

					dailyNum.push(dataList[i].siId);

					//alert(dataList[i].siId);

					var temp = new Dictionary();
					temp.put("name",dataList[i].siId);
					temp.put("index",dataList[i].siId);
					temp.put("align","center");
					temp.put("width",100);
					dailyCol.push(temp.data);

					//alert("col成功");
				}
				if((dataList[i].scoreType == 300002)||(dataList[i].scoreType == 300004)||(dataList[i].scoreType == 300005)||(dataList[i].scoreType == 300006))
				{
					personalityTitle.push(dataList[i].itemName);

					personalityNum.push(dataList[i].siId);

					var temp = new Dictionary();
					temp.put("name",dataList[i].siId);
					temp.put("index",dataList[i].siId);
					temp.put("align","center");
					temp.put("width",100);
					personalityCol.push(temp.data);
				}
				//alert(i+"日常行为："+dailyTitle.length);
				//alert(i+"个性发展："+personalityTitle.length); 
			}

			for(var i = 0;i<personalityTitle.length;i++)
			{
				dailyTitle.push(personalityTitle[i]);
			}
			for(var i = 0;i<personalityCol.length;i++)
			{
				dailyCol.push(personalityCol[i]);
			}
		}
});

//alert(personalityTitle.length);



//console.log(dailyTitle.length);

// alert(dailyTitle.length);
// alert(personalityTitle.length);

// Array.prototype.push.apply(dailyTitle, personalityTitle);
// alert(dailyTitle.length);

// Array.prototype.push.apply(dailyCol, personalityCol);


$.ajax({
		url:"../student/allMajorScore.do",
		data:{
		},
		type:"get",
		dataType:"json",
		success:function(data)
		{
			//alert("allClassScore");

			var dataList = [];

			dataList = data;

			var grid_data = [];

			for(var i=0;i<dataList.length;i++)
			{
				//alert("进入"+i+"学生循环");

				//每个学生的奖项id数组
				var daily = [];
				var personality = [];

				//每个学生的加分项加分分数数组
				var daily_score = [];
				var personality_score = [];

				var temp = new Dictionary();

				temp.put("number",dataList[i].studentNumber);
				temp.put("name",dataList[i].studentName);

				for(var j = 0;j<dataList[i].winScoreTempList.length;j++)
				{
					//alert("进入加分项循环");

					if(dataList[i].winScoreTempList[j].scoreType == "日常行为分")
					{
						daily.push(dataList[i].winScoreTempList[j].siId);
						daily_score.push(dataList[i].winScoreTempList[j].score);

					}
					if(dataList[i].winScoreTempList[j].scoreType == "个性发展分")
					{
						personality.push(dataList[i].winScoreTempList[j].siId);
						personality_score.push(dataList[i].winScoreTempList[j].score);
					}
				}

				//alert("出加分项循环");

				//alert(dailyNum.length);

				//向数据中填入日常行为分的加分情况
				for(var k = 0;k < dailyNum.length;k++)
				{

					var result = daily.indexOf(dailyNum[k]);
					if(result < 0)
					{
						temp.put(dailyNum[k]," ");
					}else if(result >= 0)
					{
						temp.put(dailyNum[k],daily_score[result]);
					}
				}

				//向数据中填入个性发展分的加分情况
				// alert("有数据项长度："+personality.length);
				// alert("个性分长度："+personalityNum.length);
				// alert(personalityNum[0]);
				// alert(personality[0]);
				for(var k = 0;k < personalityNum.length;k++)
				{
					//alert("进入个性发展分数据填充循环");

					var result = personality.indexOf(personalityNum[k]);
					//alert(k+":"+result);
					if(result < 0)
					{
						temp.put(personalityNum[k]," ");
						//alert("判断小于0");
					}else
					if(result >= 0)
					{
						temp.put(personalityNum[k],personality_score[result]);
						//alert("判断大于等于0");
					}
				}

				grid_data.push(temp.data);
			}

			//alert("列标题："+dailyTitle[0]);
			//alert("col:"+col[0].get("name"));

			var titleName = [];
			titleName = dailyTitle;
			//alert(titleName.length);

			var col = [];
			col = dailyCol;

			jQuery("#see-rank-table").jqGrid({
			data: grid_data,
			datatype: "local",
			height: 600,
			colNames: titleName,
			colModel: col,
			rowNum:40,
			width:900,
			sortname: 'number',
			viewrecords: true,
			sortorder: "dsc",
			autowidth: true,
			});


			jQuery("#see-rank-table").jqGrid('setGroupHeaders', {
  				useColSpanStyle: true, 
  				groupHeaders:
  				[
    				{startColumnName: dailyNum[0], numberOfColumns: dailyNum.length, titleText: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日常行为'},
    				{startColumnName: personalityNum[0], numberOfColumns: personalityNum.length, titleText: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个性发展'}
  				]
			});
		}
	});

