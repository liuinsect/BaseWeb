/**
 * 公司基本信息处理 edit()和view()中有部分代码重复
 */
// 当前行数据
var globalCurrentRowData = null;
// 当前行索引
var globalCurrentRowIndex = null;

// 公司对话框
var $decorateInfoDialog = null;

// 进度条
var $globalDivOneForRetrieve = null;
var $globalDivTwoForRetrieve = null;
var $globalDivOneForSave = null;
var $globalDivTwoForSave = null;
//var isFirstOpen = true;//决定是否清空dialog

$(document).ready(function () {
    // 查询界面的初始化

    var option = {
        "finalClass": globalFinalClass
    };
    var $searchTable = $("table[name=query]", $(globalPanelId));
    var $linkButtonSearch = $("a.easyui-linkbutton:contains('查找')", $searchTable);
    $linkButtonSearch.linkbutton();
    $linkButtonSearch.click(function () {
        showArticleList(option);
    });

    var $linkButtonReset = $("a.easyui-linkbutton:contains('重置')", $searchTable);
    $linkButtonReset.linkbutton();
    $linkButtonReset.click(function () {
        $searchTable.clearDataInContainer();
    });

    // 公司列表table的初始化
    var $decorateInfoList = $('table[name=decorateInfoList]', $(globalPanelId));
    $decorateInfoList.datagrid({
        title: '裝修信息列表',
        idField: 'id',
        singleSelect: true,
        fitColumns: true,
        fit: true,
        pagination: true,
//        toolbar: globalMenuClass == "basicInformationView" ? null : [
//            {
//                text: '增加',
//                iconCls: 'icon-add',
//                handler: function () {
//                    add();
//                }
//            },
//            '-',
//            {
//                text: '删除',
//                iconCls: 'icon-remove',
//                handler: function () {
//                    deleteRow();
//                }
//            },
//            '-',
//            {
//                text: '编辑',
//                iconCls: 'icon-edit',
//                handler: function () {
//                    edit();
//                }
//            }
//        ],
        columns: [
            [
                {
                    field: 'title',
                    title: '标题',
                    width: 50,
                    align: 'center',
                    formatter: function (value, rowData, rowIndex) {
                        return "<a href='javascript:void(0)' style='color: #000000'"
                            + "onclick='listLinkClick(this)'>"
                            + value
                            + "</a>";
                    }
                },
                {
                    field: 'author',
                    title: '信息发布人',
                    width: 50,
                    align: 'center'
                },
                {
                    field: 'createTime',
                    title: '文章发布时间',
                    width: 50,
                    align: 'center'
                }
            ]
        ],
        onDblClickRow: function (rowIndex, rowData) {
            globalCurrentRowIndex = rowIndex;
            globalCurrentRowData = rowData;
            // 触发编辑方法
                view();
            ;
        },
        onClickRow: function (rowIndex, rowData) {
            globalCurrentRowIndex = rowIndex;
            globalCurrentRowData = rowData;
        }
    });
    // 公司列表中分页的初始化
    var $pager = $decorateInfoList.datagrid("getPager");
    $pager.pagination({
        onSelectPage: function (pageNumber, pageSize) {
            // 此时的option包含了finalClass、criteria等信息
            option["page"] = pageNumber;
            option["pageSize"] = pageSize;
            showArticleList(option);
        }
    });

    // 对话框的处理，如果存在initialized=true的对话框，那是上次的遗留，破坏掉
    // 对话框会上移到body的子元素一层，需要手动移除
    $decorateInfoDialog = $("div[name=decorateInfoDialog][initialized=true]");
    $decorateInfoDialog.dialog('destroy');
    if (globalMenuClass == "basicInformationCollection") {
        initEditDialog();
    }
    $decorateInfoDialog = $("div[name=decorateInfoDialog][initialized=true]");
    $decorateInfoDialog.dialog('close');

    // 进度条的处理
    $globalDivOneForRetrieve = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
    $globalDivTwoForRetrieve = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统处理中，请等待····</div>");
    $('div[region=center]', $(globalPanelId)).append($globalDivOneForRetrieve)
        .append($globalDivTwoForRetrieve);
    $globalDivOneForRetrieve.hide();
    $globalDivTwoForRetrieve.hide();

    $globalDivOneForSave = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
    $globalDivTwoForSave = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统处理中，请等待····</div>");
    $decorateInfoDialog.append($globalDivOneForSave).append($globalDivTwoForSave);
    $globalDivOneForSave.hide();
    $globalDivTwoForSave.hide();

    refreshRow()
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
    var $decorateInfoDialog = $("div[name=decorateInfoDialog]", $(globalPanelId));

    $decorateInfoDialog.show();
    $decorateInfoDialog.dialog({
        title: '新增裝修进度',
        modal: true,
        buttons: [
//            {
//                text: '保存',
//                iconCls: 'icon-save',
//                plain: true,
//                handler: function () {
//                    var $form = $("form", $decorateInfoDialog);
//                    if ($form.form('validate')) {
//                        showSaveProgressBar(true);
//                        addDecorateInfo();
//                    }
//                }
//            },
            {
                text: '取消',
                iconCls: 'icon-cancel',
                plain: true,
                handler: function () {
                    refreshRow();
                    $decorateInfoDialog.dialog('close');

                }
            }
        ]
    });

    // 布局tabs
    $("div.easyui-tabs", $decorateInfoDialog).tabs();

    // 增加一个对话框已经初始化的标志
    $decorateInfoDialog.attr("initialized", "true");
}

/**
 * 关闭时判断是否上传文章,决定是否该刷新页面
 */
function refreshRow() {

    showArticleList({});

}

/**
 * 在主界面检索公司列表
 *
 * @param {}
 *            option
 */
function showArticleList(option) {

    var $decorateInfoList = $('table[name=decorateInfoList]', $(globalPanelId));

    var option = $.extend({
        page:  $decorateInfoList.datagrid("getPager").pagination("options").pageNumber,
        pageSize: $decorateInfoList.datagrid("getPager").pagination("options").pageSize,
        finalClass: "Article"
    }, option);

    var $searchTable = $("table[name=query]", $(globalPanelId));

    var title = $.trim($("#title", $searchTable).val());
    var author = $.trim($("#author", $searchTable).val());
    var userId = $.trim($("#userId", $searchTable).val());

    option["title"] = title;
    option["author"] = author;
    option["userId"] = userId;
    // 拼criteria结束
    option["finalClass"] = "Article";

    var $decorateInfoList = $('table[name=decorateInfoList]', $(globalPanelId));
    gUtils.fAjaxRequest("/admin/decorateInfoManage/viewSearch.html",option,function (json) {
//			alert("refreshRow");
        var result = json['result'];


        var decorateInfoList = result['decorateInfoList'];

        replaceT(decorateInfoList);

        $decorateInfoList.datagrid('loadData', {
            'total': result['pageQuery'].totalCount,//一次只能上传一个文章
            'rows': decorateInfoList
        });

        $decorateInfoList.datagrid("clearSelections");
        globalCurrentRowData = null;
        globalCurrentRowIndex = null;

    });

}

function replaceT(aa) {
    var length = aa.length;
    for (var i = 0; i <= length - 1; i++) {
        var testDate = new Date( parseInt(aa[i].createTime) );
        aa[i].createTime = testDate.format("yyyy-MM-dd hh:mm:ss");
    }
}

/**
 * 打开对话框，编辑公司信息
 */
function view() {
    if (!globalCurrentRowIndex) {
        return;
    }

    showRetrieveProgressBar(true);
    $decorateInfoDialog.dialog('refresh', '/admin/decorateInfoManage/dialogView.html?decorateInfoId='+globalCurrentRowData.id);
    $decorateInfoDialog.dialog('open');
    showRetrieveProgressBar(false);

}

