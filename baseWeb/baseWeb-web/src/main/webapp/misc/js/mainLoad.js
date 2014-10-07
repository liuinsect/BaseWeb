///**
// * ajax分页
// * @param moduleName
// * @returns
// */
//function load(){
//	//gzdtContent
////	var pageNumber = document.getElementById("pageNumber").value;
//	var gzdtCondition = "moduleName='gzdt'";//开头不能有空格
//	var option = {
//				"pageNumber" : 1,
//				"condition" : gzdtCondition,
//				"pageSize" : 4,//写死每页4个
//				"entityName" : "Article"
//			};
//	$.post("pageAction!page.action?timestamp=" + new Date().valueOf(), option,
//		function(json) {
//			if(  json['message'] == "success" ){
//
//				var gzdtList = json['resultList'];
//
//				var gzdtDiv = document.getElementById("gzdtContent");
//				var gzdtContent="";
//				var gzdtLength = gzdtList.length;
//				for (var i=0;i<=gzdtLength-1;i++)
//				{
////					alert(aa[i].createTime.replace("T"," ").length);
//					var gzdtCreateTime = gzdtList[i].createTime.replace("T"," ");
//					gzdtCreateTime = gzdtCreateTime.substring(0,10);
//
//					var rowData = "<div  height=20>" +
//									"<div  style=\"float:right;padding-right:10px;\" >"+gzdtCreateTime+"</div>" +
//									"<div  style=\"display:inline;\"><img src=\"images/c_round.gif\"></div>" +
//									"<div  style=\"display:inline;padding-left:8px\">" +
//									"    <a href='Detail.jsp?id="+gzdtList[i].id+"&&moduleName="+gzdtList[i].moduleName+"'>" +gzdtList[i].title +"</a></div>" +
//								  "</div>";
//
//					gzdtContent = gzdtContent + rowData;
//				}
////				alert(gzdtContent);
//				gzdtDiv.innerHTML = gzdtContent;
//			}else{
//
//		   	}
//		}, "json");
//
//
//	//kxyjContent
//
//	var kxyjCondition = "moduleName='kxyj' or moduleName='yjfx' or moduleName='xsgg'";//开头不能有空格
//	var option = {
//				"pageNumber" : 1,
//				"condition" : kxyjCondition,
//				"pageSize" : 4,//写死每页4个
//				"entityName" : "Article"
//			};
//	$.post("pageAction!page.action?timestamp=" + new Date().valueOf(), option,
//		function(json) {
//			if(  json['message'] == "success" ){
//
//				var kxyjList = json['resultList'];
//
//				var kxyjDiv = document.getElementById("kxyjContent");
//				var kxyjContent="";
//				var kxyjLength = kxyjList.length;
//				for (var i=0;i<=kxyjLength-1;i++)
//				{
////					alert(aa[i].createTime.replace("T"," ").length);
//					var kxyjCreateTime = kxyjList[i].createTime.replace("T"," ");
//					kxyjCreateTime = kxyjCreateTime.substring(0,10);
//
//					var rowData = "<div  height=20>" +
//									"<div  style=\"float:right;padding-right:10px;\" >"+kxyjCreateTime+"</div>" +
//									"<div  style=\"display:inline;\"><img src=\"images/c_round.gif\"></div>" +
//									"<div  style=\"display:inline;padding-left:8px\">" +
//									"    <a href='Detail.jsp?id="+kxyjList[i].id+"&&moduleName="+kxyjList[i].moduleName+"'>" +kxyjList[i].title +"</a></div>" +
//								  "</div>";
//
//					kxyjContent = kxyjContent + rowData;
//				}
////				alert(kxyjContent);
//				kxyjDiv.innerHTML = kxyjContent;
//			}else{
//
//		   	}
//		}, "json");
//
//	//xsjlContent
//
//	var xsjlCondition = "moduleName='xsjl'";//开头不能有空格
//	var option = {
//				"pageNumber" : 1,
//				"condition" : xsjlCondition,
//				"pageSize" : 4,//写死每页4个
//				"entityName" : "Article"
//			};
//	$.post("pageAction!page.action?timestamp=" + new Date().valueOf(), option,
//		function(json) {
//			if(  json['message'] == "success" ){
//
//				var xsjList = json['resultList'];
//
//				var xsjlDiv = document.getElementById("xsjlContent");
//				var xsjlContent="";
//				var xsjlLength = xsjList.length;
//				for (var i=0;i<=xsjlLength-1;i++)
//				{
////					alert(aa[i].createTime.replace("T"," ").length);
//					var xsjlCreateTime = xsjList[i].createTime.replace("T"," ");
//					xsjlCreateTime = xsjlCreateTime.substring(0,10);
//
//					var rowData = "<div  height=20>" +
//									"<div  style=\"float:right;padding-right:10px;\" >"+xsjlCreateTime+"</div>" +
//									"<div  style=\"display:inline;\"><img src=\"images/c_round.gif\"></div>" +
//									"<div  style=\"display:inline;padding-left:8px\">" +
//									"    <a href='Detail.jsp?id="+xsjList[i].id+"&&moduleName="+xsjList[i].moduleName+"'>" +xsjList[i].title +"</a></div>" +
//								  "</div>";
//
//					xsjlContent = xsjlContent + rowData;
//				}
////				alert(xsjlContent);
//				xsjlDiv.innerHTML = xsjlContent;
//			}else{
//
//		   	}
//		}, "json");
//
//}
//
//
//
//
//
