// JavaScript Document
// copyright c by zhangxinxu 2009-10-17
// http://www.zhangxinxu.com
/*
 * 由于大图绑定在href属性中，故一般而言，需使用a标签的href指向大图。仅支持png,gif,jpg,bmp四种格式的图片。用法是：目标.preview();
 * 例如：<a href="xx.jpg">图片</a> $("a").preview();就可以了
 */
$(document).ready(function() {
	$("body")
			.append("<div id='imageEnlargePreview'><div><img/><p></p></div></div>");
	$("#imageEnlargePreview").css({
				position : "absolute",
				padding : "4px",
				border : "1px solid #f3f3f3",
				backgroundColor : "#eeeeee",
				display : "none",
				"z-index" : "30000"
			});
	$("#imageEnlargePreview > div").css({
				padding : "5px",
				backgroundColor : "white",
				border : "1px solid #cccccc"
			});
	$("#imageEnlargePreview > div > img").css({
				width : "350px",
				height : "350px"
			});		
	$("#imageEnlargePreview > div > p").css({
				textAlign : "center",
				fontSize : "12px",
				padding : "8px 0 3px",
				margin : "0"
			});
});

;
(function($) {
	$.fn.imageEnlargePreview = function() {
		var xOffset = 10;
		var yOffset = 10;

		// 网页可见区域宽
		var clientWidth = document.body.clientWidth;
		// 网页可见区域高
		var clientHeight = document.body.clientHeight;
		
		$(this).each(function() {
			$(this).hover(function(e) {
				$("#imageEnlargePreview > div > img").attr("src",
						$(this).attr('href'));
				$("#imageEnlargePreview > div > p").html($(this).attr('title'));
			}, function() {
				$("#imageEnlargePreview").hide();
			}).mousemove(function(e) {
				var left = "auto", right = "auto", top = "auto", bottom = "auto";

				left = (e.clientX < clientWidth / 2) ? (e.clientX + xOffset)
						+ "px" : "auto";
				right = (e.clientX > clientWidth / 2) ? (clientWidth
						- e.clientX + xOffset)
						+ "px" : "auto";
				top = (e.clientY < clientHeight / 2) ? (e.clientY + yOffset)
						+ "px" : "auto";
				bottom = (e.clientY > clientHeight / 2) ? (clientHeight
						- e.clientY + yOffset)
						+ "px" : "auto";

				$("#imageEnlargePreview").css({
							"left" : left,
							"right" : right,
							"top" : top,
							"bottom" : bottom
						}).show();

			});
		});
		return this;
	};
})(jQuery);