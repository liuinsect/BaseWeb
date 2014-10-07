/**
 * ajax分页  两个以上的moduleName 0号元素为父moduleName
 * @param moduleName
 * @returns
 */

function initPageBar(pageNum,pageSize,isBodyOnload){

    //这是一个非常简单的demo实例，让列表元素分页显示
    //回调函数的作用是显示对应分页的列表项内容
    //回调函数在用户每次点击分页链接的时候执行
    //参数page_index{int整型}表示当前的索引页
    var initPagination = function() {
        var num_entries = $("#hiddenresult div.result").length;
        // 创建分页
        $("#Pagination").paginationForForeground(pageNum, {
            num_edge_entries: 4, //边缘页数
            num_display_entries: 5, //主体页数
            callback: function(page_index, jq){


                if( !isBodyOnload ){//第一次的BodyOnload时不用再条用load方法
                    load(page_index+1,false);
                }else{
                    isBodyOnload = false;
                }

            },
            items_per_page:pageSize //每页显示1项
        });
    }();
}
function load(pageNumber,isBodyOnload){

//	var pageNumber = document.getElementById("pageNumber").value;

    var moduleId = jQuery("#moduleId").val();

//	alert(condition);

    //开头不能有空格
    var option = {
        "page" : pageNumber,
        "moduleId" : moduleId,
        "pageSize" : 10,//写死每页10个
        "entityName" : "Article"
    };

    gUtils.fAjaxRequest("/listContent.html",option,function(data){

        var result = data['result'];

        var aa = result['articleList'];

        var contentDiv = document.getElementById("content");
        var content="";
        var length = aa.length;
        for (var i=0;i<=length-1;i++)
        {
            var testDate = new Date( parseInt(aa[i].createTime) );
            var createTime = testDate.format("yyyy-MM-dd hh:mm:ss");
            createTime = createTime.substring(0,10);

            var rowData = "<div height=20 style=\"font-size:11pt;\">" +
                    "<div width=\"17\" align=left style=\"padding-left:2px;display:inline;\"><img src=\"/misc/images/c_round.gif\"></div>" +
                    "<div width=\"317\" style=\"padding-left:5px;display:inline;\" >" +
                    "	<a href='/content/"+aa[i].id+".html' >"+aa[i].title+"</a>" +
                    "</div>" +
                    "<div width=\"151\"   style=\"float:right;padding-right:20px;display:inline;\">"+createTime+"</div>"+
                "</div>";

            //clear 浮动

            rowData = rowData  + " <div class=\"clear\"></div>   "

            content = content + rowData;
        }

        var total = result['pageQuery'].totalCount;
        var pageSize = result['pageQuery'].pageSize;

        contentDiv.innerHTML = content;

        if( isBodyOnload ){//onload时调用
            console.log( jQuery("#Pagination") );
            console.log(jQuery.fn.paginationForForeground);
            console.log($("#Pagination").paginationForForeground());
            initPageBar(total,pageSize,isBodyOnload);
        }

    })

}

