/** 框架基本功能**/

//预先加载标签
$(function(){
	tabClose();
	tabCloseEven();
	/*// 导航菜单绑定初始化
    $("#nav").accordion({
        animate: false,
		 
    });*/
    
	$('#tabs').tabs('add',{
		title:'主页',
		content:createFrame(basePath+'/business/home.html'),
		iconCls:'ico_home',
		closable:false
		
	})
	
	.tabs({
        onSelect: function (title) {
            //var currTab = $('#tabs').tabs('getTab', title);
            //var iframe = $(currTab.panel('options').content);

			//var src = iframe.attr('src');
			//if(src)
			//	$('#tabs').tabs('update', { tab: currTab, options: { content: createFrame(src)} });
        }
    });

	  addNav(_menus["menus"]);
	  InitLeftMenu();


})


function Clearnav() {
    var pp = $('#nav').accordion('panels');

    $.each(pp, function(i, n) {
        if (n) {
            var t = n.panel('options').title;
            $('#nav').accordion('remove', t);
        }
    });

    pp = $('#nav').accordion('getSelected');
    if (pp) {
        var title = pp.panel('options').title;
        $('#nav').accordion('remove', title);
    }
}

function GetMenuList(data, menulist) {
    if (data.menus == null)
        return menulist;
    else {
        menulist += '<ul >';
        $.each(data.menus, function(i, sm) {
			 
            if (sm.url != null) {
                /*menulist += '<li ><a ref="' + sm.menuid + '" href="#" rel="'
					+ sm.url + '" ><img border="0" src="../images/' + sm.icon + '.png" /><span class="nav">' + sm.menuname
					+ '</span></a>'*/
            	menulist += '<li ><a ref="' + sm.menuid + '" href="#" rel="'
				+ sm.url + '" ><span class="nav">' + sm.menuname
				+ '</span></a>';
            }
            else {
                menulist += '<li state="open"><span class="nav">' + sm.menuname + '</span>'
            }
             menulist = GetMenuList(sm, menulist);
        })
        menulist += '</ul>';
    }
 
    return menulist;
}
//左侧导航加载
function addNav(data) {
 
    $.each(data, function(i, sm) {
        var menulist1 = "";
        //sm 常用菜单  邮件 列表
        menulist1 = GetMenuList(sm, menulist1);
		menulist1 = "<ul id='tt1' class='easyui-tree'  animate='true' fit='true' >"+  menulist1.substring(4); 
        $('#nav').accordion('add', {
            title: sm.menuname,
            content: menulist1,
 			 iconCls: 'icon-add',
			 color:'#000'
        });

    });

    var pp = $('#nav').accordion('panels');
    var t = pp[0].panel('options').title;
    $('#nav').accordion('select', t);

}
//初始化左侧
function InitLeftMenu() {
	   // hoverMenuItem();

 
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

 
//获取左侧导航的图标
function getIcon(menuid){
	var icon = 'ico_file';
	/*$.each(_menus.menus, function(i, n) {
		 $.each(n.menus, function(j, o) {
		 	if(o.menuid==menuid){
				icon += o.icon;
			}
		 })
	})*/

	return icon;
}





function addTab(subtitle,url,iconCls){
	if(!$('#tabs').tabs('exists',subtitle)){
		if(subtitle=="主页"){
			$('#tabs').tabs('add',{
				title:subtitle,
				content:createFrame(url),
				closable:false,
				iconCls:iconCls
			});
		}else{
			$('#tabs').tabs('add',{
				title:subtitle,
				content:createFrame(url),
				closable:true,
				iconCls:iconCls
			});
		}
		
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}


function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
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
		//$('#tabs').tabs('select',subtitle);
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
		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url)
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
			if(t!="主页"){
				$('#tabs').tabs('close',t);
			}
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
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			if(t!="主页"){
				$('#tabs').tabs('close',t);
			}
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			if(t!="主页"){
				$('#tabs').tabs('close',t);
			}
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

