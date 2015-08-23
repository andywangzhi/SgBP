$(function(){
	InitLeftMenu();
	tabClose();
	tabCloseEven();
	$('#tabs').tabs('add',{
		title:'桌面',
		content:createFrame('../business/home.html'),
		icon:'icon_home',
		closable:true
	}).tabs({
        onSelect: function (title) {
           
            var currTab = $('#tabs').tabs('getTab', title);
            var iframe = $(currTab.panel('options').content);

			var src = iframe.attr('src');
			if(src)
			{
				//$('#tabs').tabs('update', { tab: currTab, options: { content: createFrame(src,title)} });
				$('#tabs').tabs('select', { tab: currTab, options: { content: createFrame(src,title)} });
				var ieset = navigator.userAgent;  
				//if(ieset.indexOf("MSIE 6.0") > -1)//对浏览器版本进行判断 如果是IE6
				//{
				//  document.frames(title).location.reload(); 
				//}
          	}
            $('.easyui-accordion li div').removeClass("selected");
            
             $('.easyui-accordion li div').each(function(i){
                if($(this).text()==title){
                  //选中相应栏目
                  $('#nav').accordion('select', $(this).attr("title"));
                  //选中点击项
                  $(this).addClass("selected");
                }
              });
        }
    });
})

//初始化左侧
function InitLeftMenu() {
	$("#nav").accordion({animate:false});
    if(_menus == undefined || _menus == null || _menus == '' ){
       alert('无权限');   
       location.href = basePath+'/logout.action';
    }else{
	    $.each(_menus.menus, function(i, n) {
			var menulist ='';
			menulist +='<ul>'; 
	        $.each(n.menus, function(j, o) {
	        	if (o.menus!=undefined){
				menulist += '<li><div style="text-align:left"> <img border="0" src="../images/' + o.icon + '.png" /><span class="nav">' + o.menuname + '</span>  ';
	        	}
	        	else
	        		{
	        		menulist += '<li><div style="text-align:left;height:18px"><a ref="' + o.menuid + '" href="#" rel="' + o.url + '" ><img border="0" src="../images/' + o.icon + '.png" /><span class="nav">' + o.menuname + '</span></a> ';
	        		
	        		}
				if (o.menus!=undefined)
				{
					menulist +='<ul>';
					 $.each(o.menus, function(k, p) {
						 if (p.menus!=undefined){
							 menulist += '<li><div style="text-align:left"><a ref="' + p.menuid + '"    ><img border="0" src="../images/' + p.icon + '.png" /><span class="nav">' + p.menuname + '</span></a></div></li> ';
						 }
						 else
							 {
							 menulist += '<li><div style="text-align:left;height:18px"><a ref="' + p.menuid + '" href="#" rel="' + p.url + '" ><img border="0" src="../images/' + p.icon + '.png" /><span class="nav">' + p.menuname + '</span></a></div></li> ';
							 }
					     if (p.menus!=undefined)
						 {
							menulist +='<ul>';
							 $.each(p.menus, function(k, m) {
							     menulist += '<li><div style="text-align:left;height:18px"><a ref="' + m.menuid + '" href="#" rel="' + m.url + '" ><img border="0" src="../images/' + m.icon + '.png" /><span class="nav">' + m.menuname + '</span></a></div></li> ';
							 })
							menulist += '</ul>';
						 }
					 })
					menulist += '</ul>';
				}
				menulist += '</div></li>';
	        })
			menulist += '</ul>';
			$('#nav').accordion('add', {
	            title: n.menuname,
	            content: menulist,
	            iconCls: 'icon-add',
	            color:'#000'
	        });
	    });
	    
		$('.easyui-accordion li a').click(function(){
			var tabTitle = $(this).children('.nav').text();
	
			var url = $(this).attr("rel");
			var menuid = $(this).attr("ref");
			var icon = getIcon(menuid,icon);
			
			addTab(tabTitle,url,icon);
		}).hover(function(){
			$(this).parent().addClass("hover");
		},function(){
			$(this).parent().removeClass("hover");
		});
	    
	    //选中第一个
		var panels = $('#nav').accordion('panels');
		var t = panels[0].panel('options').title;
	    $('#nav').accordion('select', t);
    }
}
//获取左侧导航的图标
function getIcon(menuid){
	var icon = 'icon ';
	$.each(_menus.menus, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				icon += o.icon;
			}
		 })
	})

	return icon;
}

function addTab(subtitle,url,icon){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url,subtitle),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		//$('#mm-tabupdate').click();
	}
	tabClose();
}

function createFrame(url,title)
{
 
	var s = '<iframe scrolling="no" id="'+title+'"  name="'+title+'" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
 
	return s;
}

function tabClose()
{
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}
//绑定右键菜单事件
function tabCloseEven()
{
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').corner();

		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url,'')
			}
		})
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
		
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
