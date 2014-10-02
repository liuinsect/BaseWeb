;
(function($) {
	$.fn.extend({
		// 显示平面数据
		showData : function(option) {
			var option = $.extend({
						json : {},
						underline : false
					}, option);
			var json = option.json;
			return this.each(function() {
				var $tds = $(this).find("td");
				$.each($tds, function(i, td) {
					var $td = $(td);
					var name = $(td).attr("name");
					if (name == "" || name == "undefined") {
						return true;
					}
					// 判断json对象中是否有该name属性，没有的话会返回undefined
					if (json.hasOwnProperty(name)) {
						var html = null;
						if (option.underline) {
							var $div = $("<div style=\"border-bottom: #99BBE8 1px dotted;\"/>");
							$div.html(json[name]);
							$td.append($div);
						} else {
							$td.html(json[name]);
						}
					}
				});
			});
		},

		// 清空指定容器中的input、select等数据
		clearDataInContainer : function(option) {
			var option = $.extend({
						excludeByName : []
					}, option);
			// 要排除被清空的控件名
			var excludeByName = option.excludeByName;
			var targetString = "";
			$.each(excludeByName, function(i, n) {
						targetString = targetString + "[name!=" + n + "]";
					});
			$("input" + targetString, this).val("");
			$("select" + targetString, this).val("");
			$("textarea" + targetString, this).val("");
			if (globalCurrentBrowser == "msie") {
				var domFileInput = $("input[type=file]" + targetString, this)
						.get();
				$.each(domFileInput, function(i, n) {
							// 这种选择清空的方式不可取
							// n.select();
							// document.selection.clear();
							n.outerHTML = n.outerHTML;
						});
			}
			$("img" + targetString, this).attr("src", "");// 无效
		},
		
		// 清空指定容器（应该是table）中的平面数据，仅清空有name属性的td里面的text
		clearPlainTextInContainer : function(option) {
			$("td[name]").empty();
		},

		// （未完善）在指定的$container中居中，返回绝对居中坐标
		centerAbsolutePosition : function($container) {
			var containerWidth = parseInt($container.css("width"));
			var containerHeight = parseInt($container.css("height"));
			var thisWidth = parseInt(this.css("width"));
			var thisHeight = parseInt(this.css("height"));
			var offset = $container.offset();
			var centerLeft = offset.left + (containerWidth - thisWidth) / 2;
			var centerTop = offset.top + (containerHeight - thisHeight) / 2;
			alert(centerLeft);
			return {
				"left" : centerLeft,
				"top" : centerTop
			};
		},

		// （未完善）在指定的$container中居中，返回绝对居中坐标
		centerRelativePosition : function($container) {
			var containerWidth = parseInt($container.css("width"));
			var containerHeight = parseInt($container.css("height"));
			var thisWidth = parseInt(this.css("width"));
			var thisHeight = parseInt(this.css("height"));
			var centerLeft = (containerWidth - thisWidth) / 2;
			var centerTop = (containerHeight - thisHeight) / 2;
			return {
				"left" : centerLeft,
				"top" : centerTop
			};
		}
	});
})(jQuery)