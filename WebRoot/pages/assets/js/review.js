//javascript
$(function() {

	//flag标志是分数申请还是奖项申请
	//score代表分数，prize代表奖项
	//默认是分数
	var flag = 'score';
	//url获得分数申请
	//{"data":[{"status":"600002","addDetail":null,"adsId":1,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"test1","scoreType":"300004","score":"1"},{"status":"600002","addDetail":null,"adsId":3,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"足球队","scoreType":"300001","score":"2"},{"status":"600001","addDetail":"??????","adsId":11,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"?????????","scoreType":"300003","score":"1"}],"success":true}
	var uScore = '/addScore/getAll';
	//url获得奖项申请
	//{"data":[{"status":"600002","prizeDetail":"三好中的三好","adpId":1,"addDetail":"这个奖还是加一下吧233","prizeNeed":"年级第一并超过年级第二二十分","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"六好学生"},{"status":"600002","prizeDetail":"鼓励学生文艺素养的发展","adpId":2,"addDetail":"挺好","prizeNeed":"艺术才能较为突出","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"文艺标兵"},{"status":"600001","prizeDetail":"aa","adpId":21,"addDetail":"aa","prizeNeed":"aa","apartment":null,"prizeName":"aa"},{"status":"600001","prizeDetail":"???","adpId":22,"addDetail":"???","prizeNeed":"qq","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"???"},{"status":"600001","prizeDetail":"???","adpId":23,"addDetail":"???","prizeNeed":"???","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"???"},{"status":"600001","prizeDetail":"???","adpId":24,"addDetail":"???","prizeNeed":"???","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"qq"}],"success":true}
	var uPrize = '/addPrize/getAll';
	//url审核分数项
	//{"message":"审核失败，该信息已审核过或者不存在","success":false}
	var uReviewScore = '/addScore/changeStatus';
	//url审核奖项
	//{"message":"审核失败，该信息已审核过或者不存在","success":false}
	var uReviewPrize = '/addPrize/changeStatus';
	//默认执行获得score
	getData(uScore);

	//背景颜色
	var bgColor = '';

	//获得分页的page
	function getPage(pageId) {
		var $pagStr = $('<div id="p'+ pageId + '" class="pagedemo" style="display:none;"></div>');
		return $pagStr;
	}

	//执行一次返回一条内容
	function getItem(id, cont) {
		var $str = $(
			'<div class="col-md-4 col-sm-4" style="width: 100%">' +
            '<div id = "' +id+ '_info" class="fatherPanel panel panel-info" style="">' +
            '<div class="panel-heading" style="height: 3px; padding: 0px; background:' + bgColor + ';"> ' +
			'</div><div class="panel-body" style="padding:1px;">'+
			cont +
            '</div><div id="'+id +'_footer" ' + 
            'class="panel-footer" style="height: 40px; padding: 3px 20px; display: none;">' +
			'<button id="' + id + '_refuse"' +
			'class="btn btn-danger btnRefuse" style="width: 100px; margin-left: 10px; float: right;" name="' + id + '"> 拒绝 </button>'+
			'<button id="' + id + '_ok"' + 
			'class="btn btn-success btnAgree" style="width: 100px; margin-left: 10px; float: right;" name="' + id + '"> 通过 </button>'+
			'</div></div></div>'
		);           

        return $str;
	}

	//获得table的html字符串
	//flag用来标记这个是分数申请还是奖项申请
	function getContent(d) {

		var strTable = '';
		var status = '';

		switch(d.status) {
			case "600001": status = "<strong style='color: #0000CC' class='status'>待审核</strong>"; bgColor='yellow'; break;
			case "600002": status = "<strong style='color: green' class='status'>审核通过</strong>"; bgColor='green'; break;
			case "600003": status = "<strong style='color: red' class='status'>审核未通过</strong>"; bgColor='red'; break;
		}
		//奖项
		if (flag == 'prize') {
			//一个table
		    strTable = 	'<table class="table"><thead><tr><th style="width: 8%;">'+ "部门" +
						'</th><th style="width: 8%;">' + '奖项名称' +
                       	'</th><th style="width: 25%;">' + '获奖条件' +
                       	'</th><th style="width: 25%;">' + '奖项介绍' +
                       	'</th><th style="width: 25%;">' + '申请说明' +
                       	'</th><th style="width: 9%;">' + '申请状态' +
                       	'</th></tr></thead><tbody><td>' + d.apartment +
						'</td><td>' + d.prizeName +
                        '</td><td>' + d.prizeNeed +
						'</td><td>' + d.prizeDetail +
						'</td><td>' + d.addDetail +
						'</td><td id="'+ d.adpId +
						'"_status>' + status +
						'</td></tbody></table>';

		} else if (flag == 'score') {
			//分数
			//一个table
			strTable = 	'<table class="table"><thead><tr><th style="width: 10%;">'+ "部门" +
						'</th><th style="width: 10%;">' + '分数值' +
                       	'</th><th style="width: 20%;">' + '分数种类' +
                       	'</th><th style="width: 20%;">' + '分数项名称' +
                       	'</th><th style="width: 30%;">' + '申请说明' +
                       	'</th><th style="width: 10%;">' + '申请状态' +
                       	'</th></tr></thead><tbody><td>' + d.apartment.apartmentName +
						'</td><td>' + d.score +
                        '</td><td>' + d.scoreType +
						'</td><td>' + d.scoreName +
						'</td><td>' + d.addDetail +
						'</td><td id="'+ d.adsId +
						'"_status>' + status +
						'</td></tbody></table>';
		}

		return strTable;
	}

	//最后记得添加这个脚注
	var $foot = $('<div id="page" style="height: 50px; width: 400px; margin:0 auto; padding-top: 5px;"> </div>');


	//显示分数项的申请点击时
	$("#scoreApplication").click(function(event) {
		/* Act on the event */
		//首先flag标志变化
		flag = 'score';	
		//传入获取分数的接口	
		getData(uScore);
		// analysisData(test.data);

	});

	//显示查看奖项申请
	$("#prizeApplication").click(function(event) {
		/* Act on the event */
		//flag标志变成prize
		flag = 'prize';
		getData(uPrize);
		// analysisData(test1.data);

	});

	//获得数据,传入一个url
	function getData(u) {
		//获得数据
		$.ajax({
			url: u,
			type: 'POST',
			dataType: 'json',
			success: function(data) {
				//{"data":[{"status":"600002","addDetail":null,"adsId":1,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"test1","scoreType":"300004","score":"1"},{"status":"600002","addDetail":null,"adsId":3,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"足球队","scoreType":"300001","score":"2"},{"status":"600001","addDetail":"??????","adsId":11,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"?????????","scoreType":"300003","score":"1"}],"success":true}
				//{"data":[{"status":"600002","prizeDetail":"三好中的三好","adpId":1,"addDetail":"这个奖还是加一下吧233","prizeNeed":"年级第一并超过年级第二二十分","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"六好学生"},{"status":"600002","prizeDetail":"鼓励学生文艺素养的发展","adpId":2,"addDetail":"挺好","prizeNeed":"艺术才能较为突出","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"文艺标兵"},{"status":"600001","prizeDetail":"aa","adpId":21,"addDetail":"aa","prizeNeed":"aa","apartment":null,"prizeName":"aa"},{"status":"600001","prizeDetail":"???","adpId":22,"addDetail":"???","prizeNeed":"qq","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"???"},{"status":"600001","prizeDetail":"???","adpId":23,"addDetail":"???","prizeNeed":"???","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"???"},{"status":"600001","prizeDetail":"???","adpId":24,"addDetail":"???","prizeNeed":"???","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"qq"}],"success":true}
				//解析数据
				//如果成功
				if (data.success) {
					analysisData(data.data);
				} else {
					layer.alert(data.message, {
					  skin: 'layui-layer-molv' 
					  ,closeBtn: 0
					  ,shift: 1
					});
				}
				
			},
			error: function (jqXHR, textStatus, errorThrown) {
				layer.msg("连接出错： " + textStatus, {icon: 2});
			}
		})
		.done(function() {
			console.log("success");
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
	}

	//返回数据, 传入一个用于返回的url接口，一个返回的数据
	function returnData(u, d, $obj) {
		//返回数据
		$.ajax({
			url: u,
			type: 'POST',
			dataType: 'json',
			data: d,
			success: function(data) {
				//显示返回信息
				//{"message":"审核失败，该信息已审核过或者不存在","success":false}
				//{"message":"审核成功","success":true}
				layer.msg(data.message);
				//成功后隐藏面板
				//判断状态
				//2通过，3未通过

				//先判断是不是申请成功了
				if (data.success) {

					if (d.status == '600002') {
						layer.msg("您同意了该请求", {icon: 1});
						//设置申请状态
						$obj.find(".status").text("审核通过");
						$obj.find('.panel-info"').css("background", "green");
						$obj.find('.panel-heading').css("background", "green");

					} else if (d.status == '600003') {
						layer.msg("您同拒绝了该请求", {icon: 1});
						$obj.find(".status").text("审核未通过");
						$obj.find('.panel-info"').css("background", "red");
						$obj.find('.panel-heading').css("background", "red");
					} else {
						//这里基本上不会来了
						layer.alert(data.message, {
						  skin: 'layui-layer-molv' 
						  ,closeBtn: 0
						  ,shift: 1
						});
					}

				}
				
			},
			error: function (jqXHR, textStatus, errorThrown) {
				layer.msg("连接出错： " + textStatus);
			}
		})
		.done(function() {
			console.log("success");
		})
		.fail(function() {
			console.log("get data error");
		})
		.always(function() {
			console.log("complete");
		});

	}

	var test = {"data":[{"status":"600002","addDetail":null,"adsId":1,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"test1","scoreType":"300004","score":"1"},{"status":"600002","addDetail":null,"adsId":3,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"足球队","scoreType":"300001","score":"2"},{"status":"600001","addDetail":"??????","adsId":11,"apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"scoreName":"?????????","scoreType":"300003","score":"1"}],"success":true};
	var test1 = {"data":[{"status":"600002","prizeDetail":"三好中的三好","adpId":1,"addDetail":"这个奖还是加一下吧233","prizeNeed":"年级第一并超过年级第二二十分","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"六好学生"},{"status":"600002","prizeDetail":"鼓励学生文艺素养的发展","adpId":2,"addDetail":"挺好","prizeNeed":"艺术才能较为突出","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"文艺标兵"},{"status":"600001","prizeDetail":"aa","adpId":21,"addDetail":"aa","prizeNeed":"aa","apartment":null,"prizeName":"aa"},{"status":"600001","prizeDetail":"???","adpId":22,"addDetail":"???","prizeNeed":"qq","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"???"},{"status":"600001","prizeDetail":"???","adpId":23,"addDetail":"???","prizeNeed":"???","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"???"},{"status":"600001","prizeDetail":"???","adpId":24,"addDetail":"???","prizeNeed":"???","apartment":{"remark":null,"apartmentId":3,"apartmentName":"学习部"},"prizeName":"qq"}],"success":true};

	// analysisData(test.data);

	//解析数据
	function  analysisData(objs) {
		//如果返回的数据使这种类型m:[{}, {}, {}];
		//获得json数据
		
		// $("#paginationdemo > div").remove();
		$("#paginationdemo").empty();
		//id
		var getId = '';
		//获得长度,
		var leng = objs.length;
		//每页条目数量
		var pagItem = 6;
		//计算需要的页数
		var pagNum = Math.ceil(leng/pagItem);
		//表示加载的数据到第几条了
		var loadingHere = 0;
		//首先添加页面
		for (var i = 1; i <= pagNum; i++) {
			
			//添加页面
			$("#paginationdemo").append(getPage(i));
			
			//然后读取json数据添加到一个页面中
			for (var j = loadingHere; j < loadingHere+pagItem && j < leng; j++) {
				//进行判断，判断是奖项还是加分
				if (flag == 'score') {
					getId = objs[j].adsId;
				} else {
					getId = objs[j].adpId;
				}

				//获得最后一个元素然后添加
				$("#paginationdemo > div:last").append(getItem( getId, getContent(objs[j]) ));

				//判断申请状态，如果审核通过或者拒绝，那么就不显示按钮或者按钮不可点击
				//600001待审核600002通过600003未通过
				
				// if (objs[j].status == '600002' || objs[j].status == '600003') {
				// 	//那么隐藏底部按钮
				// 	$("#" + getId + "_footer").hide();
					
				// } 
			}

			loadingHere += pagItem;
			//换下一页
		}

		//通过按钮添加点击事件
		$(".btnAgree").click(function(event) {
			/* Act on the event */
			/*var $obj = $(this).parent().parent().parent();*/
			//不删除，只是显示审核状态
			//假设一直是成功的
			//进行数据请求
			
			//b包装数据
			var d = {};
			//同时隐藏底部面板
			var $obj = $("#" + $(this).attr('name') + "_info");

			//判断当前的状态，是score还是prize
			//但是都是同意按钮，所以状态时通过
			if (flag == 'score') {
				//name的值等于id
				d = {
						"adsId": $(this).attr('name'),
						"status": "600002"
					}

				//如果是score，那么执行returnData函数
				ask("确定通过么？", "确定", "取消", returnData, uReviewScore, d, $obj);
			} else {
				d = {
						"adpId": $(this).attr('name'),
						"status": "600002"
					}

				ask("确定通过么？", "确定", "取消", returnData, uReviewPrize, d, $obj);
			}


		});

		//拒绝按钮添加点击事件
		$(".btnRefuse").click(function(event) {
			/* Act on the event */
			var d = {};
			//同时隐藏底部面板
			var $obj = $("#" + $(this).attr('name') + "_info");

			//判断当前的状态，是score还是prize
			//但是都是同意按钮，所以状态时通过
			if (flag == 'score') {
				//name的值等于id
				d = {
						"adsId": $(this).attr('name'),
						"status": "600003"
					}

				//如果是score，那么执行returnData函数
				ask("确定拒绝么？", "确定", "取消", returnData, uReviewScore, d, $obj);
			} else {
				d = {
						"adpId": $(this).attr('name'),
						"status": "600003"
					}

				ask("确定拒绝么？", "确定", "取消", returnData, uReviewPrize, d, $obj);
			}
		});

		//鼠标浮动
		$(".fatherPanel").hover(function() {
			/* Stuff to do when the mouse enters the element */
			
			if ($(this).find('.status').text() == '待审核') {
				$(this).find('.panel-footer').show();
			}
		}, function() {
			/* Stuff to do when the mouse leaves the element */
			$(this).find('.panel-footer').hide();
		});

		console.log("7");
		//然后记得添加脚注
		$("#paginationdemo").append($foot);

		//让第一页显示
		$("#p1").addClass('_current');
		$("#p1").show();

		//然后添加分页函数
		pagination(pagNum);

		////如果返回的数据使这种类型{data:[{}, {}, {}]};
	}

	//询问函数,传入一个函数，一个参数
	function ask(strTips, strBtnLeft, strBtnRight, fun, paraU, paraD, $paraObj) {
		//询问是否删除
		layer.confirm(strTips, {
	  			btn: [strBtnLeft, strBtnRight],
	  			icon: 3 
			}, 
			//确定提交执行函数
			function(){
				//显示等待
				fun(paraU, paraD, $paraObj);
				//执行通过函数
					
			}, 
			//继续修改执行函数
			function(){
					
			});
	}

	//进行分页
	function pagination(pageCount) {

        $("#page").paginate({
            count       : pageCount,
            start       : 1,
            display     : 8,
            border                  : true,
            border_color            : '#fff',
            text_color              : '#fff',
            background_color        : '#ccc',  
            border_hover_color      : '#ccc',
            text_hover_color        : '#000',
            background_hover_color  : '#fff', 
            images                  : false,
            mouse                   : 'press',
            onChange                : function(page){
                                        $('._current','#paginationdemo').removeClass('_current').hide();
                                        $('#p'+page).addClass('_current').show();
                                     }
        });
    }
})