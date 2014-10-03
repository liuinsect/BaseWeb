/**
 * 公司基本信息处理 edit()和view()中有部分代码重复
 */
// 当前行数据
var globalCurrentRowData = null;
// 当前行索引
var globalCurrentRowIndex = null;

// 公司对话框
var $companyDialog = null;

// 进度条
var $globalDivOneForRetrieve = null;
var $globalDivTwoForRetrieve = null;
var $globalDivOneForSave = null;
var $globalDivTwoForSave = null;
//var isFirstOpen = true;//决定是否清空dialog

$(document).ready(function() {
	// 查询界面的初始化
//	var $selectAreaId = $("table[name=query] select[alias=areaId]",
//			$(globalPanelId));
//	$selectAreaId.combotree();
//	$selectAreaId.combotree('loadData', globalListAreas);

	var $selectManageCharacter = $(
			"table[name=query] select[alias=manageCharacterId]",
			$(globalPanelId));
	$selectManageCharacter.combobox({
				valueField : 'manageCharacterId',
				textField : 'manageCharacter'
			});
	$selectManageCharacter.combobox('loadData', globalListManageCharacter);

	$("table[name=query] input.easyui-numberbox", $(globalPanelId)).numberbox();

	var option = {
		"finalClass" : globalFinalClass
	};
	var $searchTable = $("table[name=query]", $(globalPanelId));
	var $linkButtonSearch = $("a.easyui-linkbutton:contains('查找')",
			$searchTable);
	$linkButtonSearch.linkbutton();
	$linkButtonSearch.click(function() {
				showCompanyList(option);
			});
	var $linkButtonReset = $("a.easyui-linkbutton:contains('重置')", $searchTable);
	$linkButtonReset.linkbutton();
	$linkButtonReset.click(function() {
				$searchTable.clearDataInContainer();
			});

	// 公司列表table的初始化
	var $companyList = $('table[name=companyList]', $(globalPanelId));
	$companyList.datagrid({
				title : '文章列表',
				idField : 'id',
				singleSelect : true,
				fitColumns : true,
				fit : true,
				pagination : true,
				toolbar : globalMenuClass == "basicInformationView" ? null : [{
							text : '增加',
							iconCls : 'icon-add',
							handler : function() {
								add();
							}
						}, '-', {
							text : '删除',
							iconCls : 'icon-remove',
							handler : function() {
								deleteRow();
							}
						}, '-', {
							text : '编辑',
							iconCls : 'icon-edit',
							handler : function() {
								edit();
							}
						}],
				columns : [[{
					field : 'title',
					title : '文章标题',
					width : 50,
					align : 'center',
					formatter : function(value, rowData, rowIndex) {
						return "<a href='javascript:void(0)' style='color: #000000'"
								+ "onclick='listLinkClick(this)'>"
								+ value
								+ "</a>";
					}
				}, {
					field : 'author',
					title : '文章发布人',
					width : 50,
					align : 'center'
				}, {
                    field : 'moduleName',
                    title : '文章所属模块',
                    width : 50,
                    align : 'center'
                }, {
					field : 'createTime',
					title : '文章发布时间',
					width : 50,
					align : 'center'
				}]],
				onDblClickRow : function(rowIndex, rowData) {
					globalCurrentRowIndex = rowIndex;
					globalCurrentRowData = rowData;
					// 触发编辑方法
					if (globalMenuClass == "basicInformationView") {
						view();
					} else {
						edit();
					};
				},
				onClickRow : function(rowIndex, rowData) {
					globalCurrentRowIndex = rowIndex;
					globalCurrentRowData = rowData;
				}
			});
	// 公司列表中分页的初始化
	var $pager = $companyList.datagrid("getPager");
	$pager.pagination({
				onSelectPage : function(pageNumber, pageSize) {
					// 此时的option包含了finalClass、criteria等信息
					option["pageNumber"] = pageNumber;
					option["pageSize"] = pageSize;
					showCompanyList(option);
				}
			});

	// 对话框的处理，如果存在initialized=true的对话框，那是上次的遗留，破坏掉
	// 对话框会上移到body的子元素一层，需要手动移除
	$companyDialog = $("div[name=companyDialog][initialized=true]");
	$companyDialog.dialog('destroy');
	if (globalMenuClass == "basicInformationCollection") {
		initEditDialog();
	} else if (globalMenuClass == "basicInformationView") {
		initViewDialog();
	}
	$companyDialog = $("div[name=companyDialog][initialized=true]");
	$companyDialog.dialog('close');

	// 进度条的处理
	$globalDivOneForRetrieve = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
	$globalDivTwoForRetrieve = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统处理中，请等待····</div>");
	$('div[region=center]', $(globalPanelId)).append($globalDivOneForRetrieve)
			.append($globalDivTwoForRetrieve);
	$globalDivOneForRetrieve.hide();
	$globalDivTwoForRetrieve.hide();

	$globalDivOneForSave = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
	$globalDivTwoForSave = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统处理中，请等待····</div>");
	$companyDialog.append($globalDivOneForSave).append($globalDivTwoForSave);
	$globalDivOneForSave.hide();
	$globalDivTwoForSave.hide();
	
	
	
	
	
});

/**
 * 控制检索进度条的显示
 * 
 * @param {}
 *            bShow
 */
function showRetrieveProgressBar(bShow) {
	if (bShow) {
		$globalDivOneForRetrieve.show();
		$globalDivTwoForRetrieve.show();
	} else {
		$globalDivOneForRetrieve.hide();
		$globalDivTwoForRetrieve.hide();
	}
}

/**
 * 控制保存进度条的显示
 * 
 * @param {}
 *            bShow
 */
function showSaveProgressBar(bShow) {
	if (bShow) {
		$globalDivOneForSave.show();
		$globalDivTwoForSave.show();
		$("a:contains('保存')").linkbutton('disable');
	} else {
		$globalDivOneForSave.hide();
		$globalDivTwoForSave.hide();
		$("a:contains('保存')").linkbutton('enable');
	}
}

/**
 * 初始化dialog，仅调用一次
 */
function initEditDialog() {
	// 创建对话框
	var $companyDialog = $("div[name=companyDialog]", $(globalPanelId));

	$companyDialog.show();
	$companyDialog.dialog({
		title : '新增内容',
		modal : true,
		buttons : [{
			text : '保存',
			iconCls : 'icon-save',
			plain : true,
			handler : function() {
				var $form = $("form", $companyDialog);
				if ($form.form('validate')) {
					$form.form('submit', {
						onSubmit : function() {
							// 上传文章
//							alert(document.getElementById("myFrame").contentDocument.getElementById("articleTilte"));
//							alert(document.getElementById("myFrame").contentDocument.getElementById("articleTilte").value);
//							alert(myFrame.document.getElementById("articleTilte"));
							var doc;
							if (document.all){//IE
					                doc = document.frames["myFrame"].document;
					        }else{//Firefox   
					                doc = document.getElementById("myFrame").contentDocument;
					        } 
							if( doc.getElementById("articleTilte")!= null){
								showSaveProgressBar(false);
								pubArticle(doc);
								showSaveProgressBar(true);
							}
						},
						success : function(data) {
							showSaveProgressBar(false);
						}
					});

				}
			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			plain : true,
			handler : function() {
				refreshRow();
				var doc;
				if (document.all){//IE
		                doc = document.frames["myFrame"].document;
		        }else{//Firefox   
		                doc = document.getElementById("myFrame").contentDocument;
		        } 
				var moduleName = doc.getElementById("moduleName").value;
				doc.location.href = "kindeditor/jsp/"+moduleName+"demo.jsp?module="+moduleName;
//				myFrame.src = "kindeditor/jsp/demo.jsp?moduleName="+moduleName;
//				var my = document.getElementById("myFrame");
//				my.setAttribute("src", "kindeditor/jsp/demo.jsp?module="+moduleName);
				$companyDialog.dialog('close');
				
			}
		}]
	});

	// 加验证
	$("input.easyui-validatebox", $companyDialog).validatebox();
	$("input.easyui-numberbox", $companyDialog).numberbox();
	$("input.easyui-datebox", $companyDialog).datebox({
				formatter : function(date) {
					return date.format('yyyy-MM-dd');
				}
			});


	// 布局tabs
	$("div.easyui-tabs", $companyDialog).tabs();

	// 增加一个对话框已经初始化的标志
	$companyDialog.attr("initialized", "true");
}

/**
 * 清除编辑对话框中的数据，打开对话框时调用
 */
function clearEditData() {
	// demo.jsp 清空
	//myFrame.clearData();
	var doc;
	if (document.all){//IE
        doc = document.frames["myFrame"].document;
    }else{//Firefox   
        doc = document.getElementById("myFrame").contentDocument;
    } 	
	var id = doc.getElementById("id");
	if( id != null  ){
		id.value = "";
	}
	
	var articleTitle = doc.getElementById("articleTilte");
	if( articleTitle != null  ){
		articleTitle.value = "";
	}
	
	var editFrame;
	if (document.all){//IE
		editFrame = doc.frames["editFrame"].document;
    }else{//Firefox   
    	editFrame = doc.getElementById("editFrame").contentDocument;
    } 
	if( editFrame != null ){
		var htmls = editFrame.getElementsByTagName("body");
	    var html_element = htmls[0];
	    html_element.innerHTML = "";
	}
	
    
//    html_element.innerHTML = "";
}
/**
 * 关闭时判断是否上传文章,决定是否该刷新页面
 */
function refreshRow(){
	var $companyList = $('table[name=companyList]', $(globalPanelId));
	var  doc; 
	if (document.all){//IE
        doc = document.frames["myFrame"].document;
	}else{//Firefox   
	    doc = document.getElementById("myFrame").contentDocument;
	} 
	var idElement =  doc.getElementById("id");
	if( idElement == null ){
		return ;
	}
	var myFrameId = idElement.value;
	
	var isNeedRefresh = doc.getElementById("isNeedRefresh");
	if( isNeedRefresh != null && isNeedRefresh.value == "true" ){
		
		var option = {
  				"id" : myFrameId
  			};
		
		$.post("contentLoadAction!loadById.action?timestamp=" + new Date(), option,
		function(json) {
//			alert("refreshRow");
			var artiList = json['articleList'];
			replaceT( artiList );
			
			$companyList.datagrid('loadData', {
						'total' : 1,//一次只能上传一个文章
						'rows' : artiList
					});

			$companyList.datagrid("clearSelections");
			globalCurrentRowData = null;
			globalCurrentRowIndex = null;

		}, "json");
	}
	

}

/**
 * 在主界面检索公司列表
 * 
 * @param {}
 *            option
 */
function showCompanyList(option) {
	 
	var $companyList = $('table[name=companyList]', $(globalPanelId));

	showRetrieveProgressBar(true);

	var option = $.extend({
		pageNumber : 1,
		pageSize : $companyList.datagrid("getPager").pagination("options").pageSize,
		finalClass : "Article"
	}, option);
	
	
	// 拼criteria
	var criteria = null;
	var $searchTable = $("table[name=query]", $(globalPanelId));
	
	var articleTitle = $.trim($("input[name=articleTitle]", $searchTable).val());
	var articleAuthor = $.trim($("input[name=articleAuthor]", $searchTable).val());
	var moduleName = $.trim($("input[name=moduleName]", $searchTable).val());
	
	if (articleTitle != "") {
		if (criteria == null) {
			criteria = "title like '%" + articleTitle + "%'";
		} else {
			criteria = criteria + " and " + "title like '%" + articleTitle
					+ "%'";
		}
	}

	if (articleAuthor != "") {
		if (criteria == null) {
			criteria = "author like '%" + articleAuthor + "%'";
		} else {
			criteria = criteria + " and " + "author like '%"
					+ articleAuthor + "%'";
		}
	}
	
	if (moduleName != "") {
		if (criteria == null) {
			criteria = "moduleName like '%" + moduleName + "%'";
		} else {
			criteria = criteria + " and " + "moduleName like '%"
					+ moduleName + "%'";
		}
	}


	if (criteria != null) {
		option["criteria"] = criteria;
	}
	// 拼criteria结束
	option["finalClass"] = "Article";
//	alert(option.finalClass);
	
	$.post("contentLoadAction!execute.action?timestamp=" + new Date(), option,
			function(json) {
				showRetrieveProgressBar(false);
				
				//替换掉因json 时间格式引起的错误
				var aa = json['articleList'];
//				var length = aa.length;
//				for (var i=0;i<=length-1;i++) 
//				{ 
//				aa[i].createTime = aa[i].createTime.replace("T"," ");
//				}
				
				replaceT(aa);
				
				$companyList.datagrid('loadData', {
							'total' : json['total'],
							'rows' : aa
						});

				$companyList.datagrid("clearSelections");
				globalCurrentRowData = null;
				globalCurrentRowIndex = null;

			}, "json");
}

function replaceT( aa ){
	var length = aa.length;
	for (var i=0;i<=length-1;i++) 
	{ 
	aa[i].createTime = aa[i].createTime.replace("T"," ");
	}
}

/**
 * 打开对话框，增加一条新的公司记录
 */
function add() {
	// 重新打开dialog
	// 用$companyDialog.show();无效，$companyDialog已被重新包装
	$companyDialog.dialog('open');
	// 清空数据
	clearEditData();
	
}






/**
 * 列表中数据项的link调用，触发edit()
 * 
 * @param {}
 *            link
 */
function listLinkClick(link) {
	$(link).parentsUntil("tr").parent("tr").dblclick();
}

/**
 * 打开对话框，编辑公司信息
 */
function edit() {
	if (!globalCurrentRowIndex) {
		return;
	}

	showRetrieveProgressBar(true);
	
	$.post("contentLoadAction!loadById.action", {
				'id' : globalCurrentRowData.id,
				'timestamp' : new Date()
			}, function(json) {
				if (json['message'] != 'success') {
					alert(json['message']);
					return;
				}
				
				// 重新打开dialog
				// 用$companyDialog.show();无效，$companyDialog已被重新包装
				$companyDialog.dialog('open');
				// 清空数据
				clearEditData();

				showRetrieveProgressBar(false);
				
				var id = json['arti'].id;
				var title = json['arti'].title;
				var content = json['arti'].content;
				//id,title,content
				fillContent(id,title,content);

			}, 'json');
}

/**
 * 从数据库中删除一条公司以及其从表记录
 */
function deleteRow() {
	if (!globalCurrentRowIndex) {
		return;
	}
	if (!window.confirm("确定删除当前记录吗?")) {
		return;
	}
	$.post("contentUpdateAction!delete.action", {
				'id' : globalCurrentRowData.id
			}, function(json) {
				if (json['message'] != 'success') {
					alert(json['message']);
					return;
				} else {
					var $companyList = $('table[name=companyList]',
							$(globalPanelId));
					$companyList.datagrid("deleteRow", globalCurrentRowIndex);
				}
			});
}



			function pubArticle(doc){
				//在success 后 不能提交
					if( doc.getElementById("articleTilte").value == "" ){
						alert("请输入标题!");
						return;
					}
					var editFrame;
					if (document.all){//IE
						editFrame = doc.frames["editFrame"].document;
			        }else{//Firefox   
			        	editFrame = doc.getElementById("editFrame").contentDocument;
			        } 
					
					var htmls = editFrame.getElementsByTagName("body");
			        var html_element = htmls[0];
	
			        var content = html_element.innerHTML;
//			        alert("1"+content);
			        doc.getElementById("content").value = content;
//			        alert("2"+doc.getElementById("content").value);
			        doc.example.submit();
				
			}
			
			function fillContent(id,title,content){
				var  doc; 
				if (document.all){//IE
	                doc = document.frames["myFrame"].document;
		        }else{//Firefox   
		                doc = document.getElementById("myFrame").contentDocument;
		        } 				
				doc.getElementById("id").value = id;
				doc.getElementById("articleTilte").value = title;
				var editFrame;
				if (document.all){//IE
					editFrame = doc.frames["editFrame"].document;
			    }else{//Firefox   
			    	editFrame = doc.getElementById("editFrame").contentDocument;
			    } 
				var htmls =editFrame.getElementsByTagName("body");
		        var html_element = htmls[0];
		        html_element.innerHTML = content;
			}
			
			function clearData(){
				var  doc; 
				if (document.all){//IE
	                doc = document.frames["myFrame"].document;
		        }else{//Firefox   
		            doc = document.getElementById("myFrame").contentDocument;
		        } 	
				doc.getElementById("id").value = "";
				doc.getElementById("articleTilte").value = "";
				var editFrame;
				if (document.all){//IE
					editFrame = doc.frames["editFrame"].document;
			    }else{//Firefox   
			    	editFrame = doc.getElementById("editFrame").contentDocument;
			    } 
				var htmls = editFrame.getElementsByTagName("body");
		        var html_element = htmls[0];
		        html_element.innerHTML = "";
			}


