//javascript
$(document).ready(function () {

	//首先加上这个，有几页就加几个, 加完之后再加str
	function getPage(pageId) {
		var $pagStr = $('<div id="p'+ pageId + '" class="pagedemo" style="display:none;"></div>');
		return $pagStr;
	}
	
	//执行一次返回一条内容
	function getItem(id, title, cont) {
		var $str = $('<div class="col-md-4 col-sm-4" style="width: 100%"> <div class="mainPanel panel panel-info">' + 
              '<div class="panel-heading" style="height: 40px; padding: 3px;"> ' +
              '<strong style="line-height: 34px; margin-left: 20px;">'+ 
              '[标题] ' +title + 
              '</strong> <button name="'+ 
              id +
              '" id="deleteInfo" ' + 
              'class="btn btn-warning" style="padding: 0;float:right; margin-right: 20px; margin-up:15px; display: none; height:25px; width:25px;" '+ 
              '> X </button>' +
              '</div> <div class="panel-body" style="overflow: auto;"> <p>' +
              cont +
              '</p> </div> </div> </div>');          

        return $str;
	}
	
	//最后记得添加这个脚注
	var $foot = $('<div id="page" style="height: 50px; width: 400px; margin:0 auto; padding-top: 5px;"> </div>');


	//添加新公告按钮
	$("#btnNew").click(function(event) {
		/* Act on the event */
		window.location.href = "addNotice.html";
	});

	
	//获取所有公告
	//不需要参数
	//
	var u = "/notice/getAllUseful";
	$.ajax({
		url: u,
		type: 'POST',
		dataType: 'json',
		success: function(data) {
			//对json数组进行解析
			//{"data":[{"id":1,"type":"700001","content":"test too","time":1471055191163,"status":"800001","title":"test","jumpId":0},{"id":2,"type":"700001","content":"加分项名称：足球队\n所加分数：2\n分数种类：日常行为分","time":1471059419867,"status":"800001","title":"新增加分项：足球队","jumpId":0},{"id":3,"type":"700001","content":"奖项名称：文艺标兵\n奖项介绍：鼓励学生文艺素养的发展\n获奖需要：艺术才能较为突出","time":1471059555190,"status":"800001","title":"新增奖项：文艺标兵","jumpId":0},{"id":4,"type":"700001","content":"321","time":1471445681650,"status":"800001","title":"123","jumpId":0}],"success":true}
			//这里是true的话就是data
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
				layer.msg("连接出错： " + textStatus);
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
	
	// t1 = {"data":[{"id":1,"type":"700001","content":"test too","time":1471055191163,"status":"800001","title":"test","jumpId":0},{"id":2,"type":"700001","content":"加分项名称：足球队\n所加分数：2\n分数种类：日常行为分","time":1471059419867,"status":"800001","title":"新增加分项：足球队","jumpId":0},{"id":3,"type":"700001","content":"奖项名称：文艺标兵\n奖项介绍：鼓励学生文艺素养的发展\n获奖需要：艺术才能较为突出","time":1471059555190,"status":"800001","title":"新增奖项：文艺标兵","jumpId":0},{"id":4,"type":"700001","content":"321","time":1471445681650,"status":"800001","title":"123","jumpId":0}],"success":true};
	// analysisData(t1.data);

	//解析返回来的公告数据，将他加到html中
	function  analysisData(objs) {
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
			
			$("#paginationdemo").append(getPage(i));

			//然后读取json数据添加到一个页面中
			for (var j = loadingHere; j < loadingHere+pagItem && j < leng; j++) {
				//获得最后一个元素
				$("#paginationdemo > div:last").append(getItem(objs[j].id, objs[j].title, objs[j].content));
			}

			loadingHere += pagItem;
			//换下一页
		}

		//然后给所有的button添加相应事件
		$("#paginationdemo button").click(function(event) {
			/* Act on the event */
			var $obj = $(this).parent().parent().parent();

			//询问是否删除
			layer.confirm('确定删除么，删除不可恢复哦？', {
	  				btn: ['确定删除','取消删除'],
	  				icon: 3 
				}, 
				//确定提交执行函数
				function(){
					del($obj.attr("name"), $obj);
					
				}, 
				//继续修改执行函数
				function(){
					
				});
		});

		//然后添加鼠标浮动
		$(".mainPanel").hover(function() {
			/* Stuff to do when the mouse enters the element */
			$(this).find('button').show();
		}, function() {
			/* Stuff to do when the mouse leaves the element */
			$(this).find('button').hide();
		});

		console.log("7");
		//然后记得添加脚注
		$("#paginationdemo").append($foot);

		//让第一页显示
		$("#p1").addClass('_current');
		$("#p1").show();

		//然后添加分页函数
		pagination(pagNum);
		console.log("8");

		////如果返回的数据使这种类型{data:[{}, {}, {}]};
	}

	//去除某个节点
	function removeObj(obj) {
		obj.remove();
	}

	var uCan = "/notice/cancel" ;
	//删除某一条记录
	function del(i, $obj) {
		
		$.ajax({
			url: uCan,
			type: 'POST',
			dataType: 'json',
			data: {id: i},
			success: function(data) {
				//{"message":"取消成功","success":true}
				//{"message":"取消失败","success":false}
				if (data.success) {
					layer.msg("删除成功！", {time: 2000, icon:6});
					//同时删除这条记录从页面
					removeObj($obj);

				} else {
					layer.msg("删除失败!", {time:1000, icon:5});
				}
				
			},
			error: function() {
				layer.msg("连接错误", {time: 2000, icon:6});
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

	//分页函数
	//根据传入的页数进行分页
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


});


/*

$str = $('<div class="col-md-4 col-sm-4" style="width: 100%"> <div class="panel panel-info">' + 
              '<div class="panel-heading" style="height: 40px; padding: 3px;"> ' +
              '<strong style="line-height: 34px; margin-left: 20px;">'+ 
              title + 
              '</strong> <button name="'+ 
              id +
              '" id="deleteInfo" class="btn btn-warning" style="float:right; margin-right: 20px; margin-up:10px;"> 删除 </button>' +
              '</div> <div class="panel-body"> <p>' +
              cont +
              '</p> </div> </div> </div>'); 




$str = $('<div class="col-md-4 col-sm-4" style="width: 100%"> <div class="panel panel-info">' + 
              '<div class="panel-heading"> <strong>'+ 
              title + 
              '</strong> </div> <div class="panel-body"> <p>' +
              cont +
              '</p> </div> <div class="panel-footer">' +
              ' <button name="'+ 
              id +
              '" id="deleteInfo" class="btn btn-warning"> 删除 </button>' +
              '</div> </div> </div>');      

*/