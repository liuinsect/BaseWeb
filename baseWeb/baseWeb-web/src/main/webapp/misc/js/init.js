/**
 * 当前公司的实际类名（对应的实际子类）
 * 
 * @type 字符串
 */
var globalFinalClass = null;

/**
 * 当前公司操作界面包含的panel的id名，命名规则可以保证id在系统中唯一
 * 
 * @type 字符串
 */
var globalPanelId = null;

/**
 * 当前操作的菜单大类，在company列表中点击时用来判断调用edit()还是view()
 * 
 * @type
 */
var globalMenuClass = null;

/**
 * 地区json
 *
 * @type json
 */
var globalListAreas = null;
/**
 * 经营性质json
 *
 * @type json
 */
var globalListManageCharacter = null;


var $globalMaskForTree = null;

$(document).ready(function() {
	$("#background_panel").panel();

	var $divOne = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
	var $divTwo = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统初始化中，请稍后····</div>");
	$('#background_panel').append($divOne).append($divTwo);

	// 检索地区和经营性质数据，并生成适合ComboTree的json，赋值给对应的全局变量
	// 开启同步
	$.ajaxSetup({
				async : false
			});


	$("ul.navigator-tree").tree();

	// 基础信息采集菜单
	var $basicInformationCollection = $("a[class='basicInformationCollection']");
	$basicInformationCollection.click(function() {
				$globalMaskForTree.show();
				var finalClass = $(this).attr("finalClass");
				var panelId = "#basicInformationCollection_" + finalClass
						+ "_panel";

				globalFinalClass = finalClass;
				globalPanelId = panelId;
				globalMenuClass = "basicInformationCollection";
				$("#main").load($(this).attr("url"), {
							'timestamp' : new Date()
						}, function() {
							// 加载页面后，构造panel和布局
							$(panelId).panel().children("div.easyui-layout")
									.layout();
							$globalMaskForTree.hide();
						});
			});
	
			
	$divOne.hide();
	$divTwo.hide();

	// 关闭同步
	$.ajaxSetup({
				async : true
			});

	// 生成进度条
	$globalMaskForTree = $("<div class='custom-mask'></div>");
	// $globalMaskForTree.css("filter", "alpha(opacity = 0)");
	// $globalMaskForTree.css("opacity", "0");
	$("body.easyui-layout").layout("panel", "west").append($globalMaskForTree);
});

