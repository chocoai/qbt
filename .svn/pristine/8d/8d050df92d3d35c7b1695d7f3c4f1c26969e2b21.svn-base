function TabControl(divname,tabId,tabcount,tabwidth,tabheight){//初始化，创建tab列和内容div
	$("#"+divname).append("<div class='divtop' id="+tabId+"></div><div id=content"+tabId+" class='tabcontent' style='float: left;width: 100%;'></div>");

	this.AddTab=function(tabid,tabtitle,tabcontent,openor){

		$("#"+tabId).append("<div id="+tabid+" class='tabDiv' onclick=\'tab_Click(\""+tabid+"\")\'><i class='fa fa-refresh tabIconStyle' onclick='refreshTab(\""+tabid+"\")'></i><div class='tabTextStyle'>"+tabtitle+"</div><button type='button' class='close iconstyle' id='close_" + tabid + "' onclick=\'removeTab(\""+tabid+"\",event)\'><span aria-hidden='true'>×</span></button></div>");

		// $("#content"+tabId).append("<div class='divtab embed-responsive embed-responsive-16by9' id=content"+tabid+" style='min-height:500px'>"+tabcontent+"</div>");
		$("#content"+tabId).append("<div class='divtab iframe-style' id=content"+tabid+">"+tabcontent+"</div>");
		//点击或移过
		tab_Click(tabid);
		// tab_Mouseover(tabid);
		if(openor == true){
			$("#"+tabid).addClass("tab_down");
			$("#content"+tabid).removeClass("divtab");
			$("#content"+tabid).addClass("divtab_down");
		}
	}

	 function tab_Click(tabid){//点击
		 $("#"+tabid).click(function(){
			  $("#"+tabId+">div").removeClass("tab_down");
			  $("#"+tabid).addClass("tab_down");
			  $("#content"+tabId+">div").removeClass("divtab_down");
			  $("#content"+tabId+">div").addClass("divtab");
			  $("#content"+tabid).removeClass("divtab");
			  $("#content"+tabid).addClass("divtab_down");
		})
	 }

	 function tab_Mouseover(tabid){//移过
		$("#"+tabid).mouseover(function(){
			 $("#"+tabId+">div").removeClass("tab_down");
			 $("#"+tabid).addClass("tab_down");
			 $("#content"+tabId+">div").removeClass("divtab_down");
			 $("#content"+tabId+">div").addClass("divtab");
			 $("#content"+tabid).removeClass("divtab");
			 $("#content"+tabid).addClass("divtab_down");
		})
	 }
}
