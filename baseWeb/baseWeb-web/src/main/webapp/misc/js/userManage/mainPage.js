/**
 * 公司基本信息处理 edit()和view()中有部分代码重复
 */
// 当前行数据
var globalCurrentRowData = null;
// 当前行索引
var globalCurrentRowIndex = null;

// 公司对话框
var $userDialog = null;

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
        showUserList(option);
    });

    var $linkButtonReset = $("a.easyui-linkbutton:contains('重置')", $searchTable);
    $linkButtonReset.linkbutton();
    $linkButtonReset.click(function () {
        $searchTable.clearDataInContainer();
    });

    // 公司列表table的初始化
    var $userList = $('table[name=userList]', $(globalPanelId));
    $userList.datagrid({
        title: '用户列表',
        idField: 'id',
        singleSelect: true,
        fitColumns: true,
        fit: true,
        pagination: true,
        toolbar: globalMenuClass == "basicInformationView" ? null : [
            {
                text: '增加',
                iconCls: 'icon-add',
                handler: function () {
                    add();
                }
            },
            '-',
            {
                text: '删除',
                iconCls: 'icon-remove',
                handler: function () {
                    deleteRow();
                }
            },
            '-',
            {
                text: '编辑',
                iconCls: 'icon-edit',
                handler: function () {
                    edit();
                }
            }
        ],
        columns: [
            [
                {
                    field: 'account',
                    title: '账户名称',
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
                    field: 'userName',
                    title: '用户姓名',
                    width: 50,
                    align: 'center'
                },
                {
                    field: 'roleName',
                    title: '用户类型',
                    width: 50,
                    align: 'center'
                }
            ]
        ],
        onDblClickRow: function (rowIndex, rowData) {
            globalCurrentRowIndex = rowIndex;
            globalCurrentRowData = rowData;
            // 触发编辑方法
            if (globalMenuClass == "basicInformationView") {
                view();
            } else {
                edit();
            }
            ;
        },
        onClickRow: function (rowIndex, rowData) {
            globalCurrentRowIndex = rowIndex;
            globalCurrentRowData = rowData;
        }
    });
    // 公司列表中分页的初始化
    var $pager = $userList.datagrid("getPager");
    $pager.pagination({
        onSelectPage: function (pageNumber, pageSize) {
            // 此时的option包含了finalClass、criteria等信息
            option["page"] = pageNumber;
            option["pageSize"] = pageSize;
            showUserList(option);
        }
    });

    // 对话框的处理，如果存在initialized=true的对话框，那是上次的遗留，破坏掉
    // 对话框会上移到body的子元素一层，需要手动移除
    $userDialog = $("div[name=userDialog][initialized=true]");
    $userDialog.dialog('destroy');
    if (globalMenuClass == "basicInformationCollection") {
        initEditDialog();
    }
    $userDialog = $("div[name=userDialog][initialized=true]");
    $userDialog.dialog('close');

    // 进度条的处理
    $globalDivOneForRetrieve = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
    $globalDivTwoForRetrieve = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统处理中，请等待····</div>");
    $('div[region=center]', $(globalPanelId)).append($globalDivOneForRetrieve)
        .append($globalDivTwoForRetrieve);
    $globalDivOneForRetrieve.hide();
    $globalDivTwoForRetrieve.hide();

    $globalDivOneForSave = $("<div class='datagrid-mask' style='display: block; width: 100%; height: 100%;'></div>");
    $globalDivTwoForSave = $("<div class='datagrid-mask-msg' style='display: block; left: 369px; top: 165px;'>系统处理中，请等待····</div>");
    $userDialog.append($globalDivOneForSave).append($globalDivTwoForSave);
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
    var $userDialog = $("div[name=userDialog]", $(globalPanelId));

    $userDialog.show();
    $userDialog.dialog({
        title: '新增用户',
        modal: true,
        buttons: [
            {
                text: '保存',
                iconCls: 'icon-save',
                plain: true,
                handler: function () {
                    $('#userForm').form('submit',{
                        url:$('#userForm').attr("action"),
                        onSubmit: function(){
                            if ($(this).form('validate')){

                                var password = jQuery("input[name='password']").val();
                                var repassword = jQuery("input[name='rePassword']").val();
                                if( password != repassword ){
                                    alert("两次输入的密码不一致");
                                    return false;
                                }

                                return  true;
                            }
                            return false;
                        },
                        success:function(data){
                            var data = eval('(' + data + ')');
                            gUtils.fProcessResult(data, function(data){
                                showSaveProgressBar(false);
                                refreshRow();
                                $userDialog.dialog('close');
                            });
                        }
                    });
                }
            },
            {
                text: '取消',
                iconCls: 'icon-cancel',
                plain: true,
                handler: function () {
                    refreshRow();
                    $userDialog.dialog('close');

                }
            }
        ]
    });

    // 加验证
    $("input.easyui-validatebox", $userDialog).validatebox();


    // 布局tabs
    $("div.easyui-tabs", $userDialog).tabs();

    // 增加一个对话框已经初始化的标志
    $userDialog.attr("initialized", "true");
}

/**
 * 关闭时判断是否上传文章,决定是否该刷新页面
 */
function refreshRow() {

    showUserList({});

}

/**
 * 在主界面检索公司列表
 *
 * @param {}
 *            option
 */
function showUserList(option) {

    var $userList = $('table[name=userList]', $(globalPanelId));

    var option = $.extend({
        page:  $userList.datagrid("getPager").pagination("options").pageNumber,
        pageSize: $userList.datagrid("getPager").pagination("options").pageSize,
        finalClass: "Article"
    }, option);

    var $searchTable = $("table[name=query]", $(globalPanelId));

    var roleId = $.trim($("#roleId", $searchTable).val());
    var account = $.trim($("#account", $searchTable).val());
    var userName = $.trim($("#userName", $searchTable).val());

    option["roleId"] = roleId;
    option["account"] = account;
    option["userName"] = userName;
    // 拼criteria结束
    option["finalClass"] = "Article";

    var $userList = $('table[name=userList]', $(globalPanelId));
    gUtils.fAjaxRequest("/admin/userManage/search.html",option,function (json) {
//			alert("refreshRow");
        var result = json['result'];


        var userList = result['userList'];

        $userList.datagrid('loadData', {
            'total': result['pageQuery'].totalCount,//一次只能上传一个文章
            'rows': userList
        });

        $userList.datagrid("clearSelections");
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
 * 打开对话框，增加一条新的公司记录
 */
function add() {
    $userDialog.dialog('refresh', '/admin/userManage/dialogAdd.html');
    $userDialog.dialog('open');

}



/**
 * 打开对话框，编辑公司信息
 */
function edit() {
    if (!globalCurrentRowIndex) {
        return;
    }

    showRetrieveProgressBar(true);
    $userDialog.dialog('refresh', '/admin/userManage/dialogUpdate.html?userId='+globalCurrentRowData.userId);
    $userDialog.dialog('open');
    showRetrieveProgressBar(false);

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

    var param={
        'userId': globalCurrentRowData.userId
    }
    gUtils.fAjaxRequest("/admin/userManage/delUser.html",param,function(json){
        refreshRow()
    });


}