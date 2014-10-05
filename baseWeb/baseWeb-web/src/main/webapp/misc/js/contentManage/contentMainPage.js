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
    var $companyList = $('table[name=companyList]', $(globalPanelId));
    $companyList.datagrid({
        title: '文章列表',
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
                    field: 'title',
                    title: '文章标题',
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
                    title: '文章发布人',
                    width: 50,
                    align: 'center'
                },
                {
                    field: 'moduleName',
                    title: '文章所属模块',
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
    var $pager = $companyList.datagrid("getPager");
    $pager.pagination({
        onSelectPage: function (pageNumber, pageSize) {
            // 此时的option包含了finalClass、criteria等信息
            option["pageNumber"] = pageNumber;
            option["pageSize"] = pageSize;
            showArticleList(option);
        }
    });

    // 对话框的处理，如果存在initialized=true的对话框，那是上次的遗留，破坏掉
    // 对话框会上移到body的子元素一层，需要手动移除
    $companyDialog = $("div[name=companyDialog][initialized=true]");
    $companyDialog.dialog('destroy');
    if (globalMenuClass == "basicInformationCollection") {
        initEditDialog();
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
    var $companyDialog = $("div[name=companyDialog]", $(globalPanelId));

    $companyDialog.show();
    $companyDialog.dialog({
        title: '新增内容',
        modal: true,
        buttons: [
            {
                text: '保存',
                iconCls: 'icon-save',
                plain: true,
                handler: function () {
                    var $form = $("form", $companyDialog);
                    if ($form.form('validate')) {
                        showSaveProgressBar(true);
                        pubArticle();
                    }
                }
            },
            {
                text: '取消',
                iconCls: 'icon-cancel',
                plain: true,
                handler: function () {
                    refreshRow();
                    var doc;
                    if (document.all) {//IE
                        doc = document.frames["myFrame"].document;
                    } else {//Firefox
                        doc = document.getElementById("myFrame").contentDocument;
                    }
                    var moduleName = doc.getElementById("moduleName").value;
                    doc.location.href = "kindeditor/jsp/" + moduleName + "demo.jsp?module=" + moduleName;
//				myFrame.src = "kindeditor/jsp/demo.jsp?moduleName="+moduleName;
//				var my = document.getElementById("myFrame");
//				my.setAttribute("src", "kindeditor/jsp/demo.jsp?module="+moduleName);
                    $companyDialog.dialog('close');

                }
            }
        ]
    });

    // 加验证
    $("input.easyui-validatebox", $companyDialog).validatebox();


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
    if (document.all) {//IE
        doc = document.frames["myFrame"].document;
    } else {//Firefox
        doc = document.getElementById("myFrame").contentDocument;
    }
    var id = doc.getElementById("id");
    if (id != null) {
        id.value = "";
    }

    var articleTitle = doc.getElementById("articleTilte");
    if (articleTitle != null) {
        articleTitle.value = "";
    }

    var editFrame;
    if (document.all) {//IE
        editFrame = doc.frames["editFrame"].document;
    } else {//Firefox
        editFrame = doc.getElementById("editFrame").contentDocument;
    }
    if (editFrame != null) {
        var htmls = editFrame.getElementsByTagName("body");
        var html_element = htmls[0];
        html_element.innerHTML = "";
    }


//    html_element.innerHTML = "";
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

    var $companyList = $('table[name=companyList]', $(globalPanelId));

    var option = $.extend({
        page: 1,
        pageSize: $companyList.datagrid("getPager").pagination("options").pageSize,
        finalClass: "Article"
    }, option);

    var $searchTable = $("table[name=query]", $(globalPanelId));

    var articleTitle = $.trim($("input[name=articleTitle]", $searchTable).val());
    var articleAuthor = $.trim($("input[name=articleAuthor]", $searchTable).val());
    var moduleId = $.trim($("#moduleId", $searchTable).val());

    option["moduleId"] = moduleId;
    option["author"] = articleAuthor;
    option["title"] = articleTitle;
    // 拼criteria结束
    option["finalClass"] = "Article";


    var $companyList = $('table[name=companyList]', $(globalPanelId));
    gUtils.fAjaxRequest("/admin/contentManage/search.html",option,function (json) {
//			alert("refreshRow");
        var result = json['result'];


        var artiList = result['articleList'];

        replaceT(artiList);

        $companyList.datagrid('loadData', {
            'total': result['articleList'].length,//一次只能上传一个文章
            'rows': artiList
        });

        $companyList.datagrid("clearSelections");
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
    // 重新打开dialog
    // 用$companyDialog.show();无效，$companyDialog已被重新包装
//    $companyDialog.dialog('open');

    $companyDialog.dialog('refresh', '/admin/contentManage/dialog.html?type=add');
    $companyDialog.dialog('open');

//    var doc;
//    if (document.all) {//IE
//        doc = document.frames["myFrame"].document;
//    } else {//Firefox
//        doc = document.getElementById("myFrame").contentDocument;
//    }
//    doc.getElementById("example").action = "/admin/contentManage/contentAdd.html";
    // 清空数据
//    clearEditData();

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
        'id': globalCurrentRowData.id,
        'timestamp': new Date()
    }, function (json) {
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
        fillContent(id, title, content);

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
        'id': globalCurrentRowData.id
    }, function (json) {
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


function pubArticle() {
    var doc;
    if (document.all) {//IE
        doc = document.frames["myFrame"].document;
    } else {//Firefox
        doc = document.getElementById("myFrame").contentDocument;
    }
    var editFrame;
    if (document.all) {//IE
        editFrame = doc.frames["editFrame"].document;
    } else {//Firefox
        editFrame = doc.getElementById("editFrame").contentDocument;
    }

    var htmls = editFrame.getElementsByTagName("body");
    var html_element = htmls[0];

    var content = html_element.innerHTML;

    var articleTitle = jQuery('#articleTilte').val();

    var moduleId = jQuery('#moduleId').val();

    var url = jQuery('#contentForm').attr("action");


    $.ajax({
        url : url,
        async:false,
        type: "POST",
        dataType: "json",
        data:{
            'articleTitle':articleTitle,
            'moduleId':moduleId,
            'content':content
        },
        success : function(data,textStatus){
            gUtils.fProcessResult(data, function(data){
                showSaveProgressBar(false);
                refreshRow();
                $companyDialog.dialog('close');
            });

        },
        error: function(xhr, status, errMsg) {
            alert('Ajax请求出错啦！');
            showSaveProgressBar(false);
        }
    });

}

function fillContent(id, title, content) {
    var doc;
    if (document.all) {//IE
        doc = document.frames["myFrame"].document;
    } else {//Firefox
        doc = document.getElementById("myFrame").contentDocument;
    }
    doc.getElementById("id").value = id;
    doc.getElementById("articleTilte").value = title;
    var editFrame;
    if (document.all) {//IE
        editFrame = doc.frames["editFrame"].document;
    } else {//Firefox
        editFrame = doc.getElementById("editFrame").contentDocument;
    }
    var htmls = editFrame.getElementsByTagName("body");
    var html_element = htmls[0];
    html_element.innerHTML = content;
}

function clearData() {
    var doc;
    if (document.all) {//IE
        doc = document.frames["myFrame"].document;
    } else {//Firefox
        doc = document.getElementById("myFrame").contentDocument;
    }
    doc.getElementById("id").value = "";
    doc.getElementById("articleTilte").value = "";
    var editFrame;
    if (document.all) {//IE
        editFrame = doc.frames["editFrame"].document;
    } else {//Firefox
        editFrame = doc.getElementById("editFrame").contentDocument;
    }
    var htmls = editFrame.getElementsByTagName("body");
    var html_element = htmls[0];
    html_element.innerHTML = "";
}


