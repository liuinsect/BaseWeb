/**
 * 图像类型白名单
 * 
 * @type 数组
 */
var imageWhiteList = [".jpg", ".jpeg", ".gif", ".png", ".bmp"];

// jQuery全局设置
$.ajaxSettings.traditional = true;
$.ajaxSetup({
			cache : false
		});

/**
 * 浏览器类型，msie/mozilla/other
 * 
 * @type 字符串
 */
var globalCurrentBrowser = $.browser.msie ? "msie" : ($.browser.mozilla
		? "mozilla"
		: "other");

/**
 * 获取屏幕尺寸
 * 
 * @return {}
 */
function getScreenSize() {
	// 网页可见区域宽
	var clientWidth = document.body.clientWidth;
	// 网页可见区域高
	var clientHeight = document.body.clientHeight;

	// 屏幕分辨率的宽
	var screenWidth = window.screen.width;
	// 屏幕分辨率的高
	var screenHeight = window.screen.height;

	return {
		clientWidth : clientWidth,
		clientHeight : clientHeight,
		screenWidth : screenWidth,
		screenHeight : screenHeight
	};
}

// 取当前时间
function getCurrentDate(options) {
	var time = new Date();
	var year = time.getFullYear();
	var month = time.getMonth() + 1;// 注意月份要加1
	var day = time.getDate();
	var hour = time.getHours();
	var minute = time.getMinutes();
	var second = time.getSeconds();

	month = month < 10 ? '0' + month : month;
	day = day < 10 ? '0' + day : day;
	hour = hour < 10 ? '0' + hour : hour;
	minute = minute < 10 ? '0' + minute : minute;
	second = second < 10 ? '0' + second : second;

	var date = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":"
			+ second;
	options = $.extend({
				date : "yyyy-MM-dd",
				time : "hh:mm"
			}, options);
	if (options.time == "hh:mm") {
		return date.substring(0, 16);
	}
	return date;
}

// 格式化date为string
// author: meizz
Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
		// 毫秒
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4
						- RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1)
							? (o[k])
							: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
};

/**
 * 将String类型解析为Date类型 <br>
 * parseDate('2006-1-1') return new Date(2006,0,1) <br>
 * parseDate(' 2006-1-1 ') return new Date(2006,0,1) <br>
 * parseDate('2006-1-1 15:14:16') return new Date(2006,0,1,15,14,16) <br>
 * parseDate(' 2006-1-1 15:14:16 ') return new Date(2006,0,1,15,14,16); <br>
 * parseDate('2006-1-1 15:14:16.254') return new Date(2006,0,1,15,14,16,254)
 * <br>
 * parseDate(' 2006-1-1 15:14:16.254 ') return new Date(2006,0,1,15,14,16,254)
 * <br>
 * parseDate('不正确的格式') retrun null
 */
function parseDate(str) {
	if (typeof str == 'string') {
		var results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);
		if (results && results.length > 3)
			return new Date(parseInt(results[1], 10), parseInt(results[2], 10) - 1,
					parseInt(results[3], 10));
		results = str
				.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);
		if (results && results.length > 6)
			return new Date(parseInt(results[1], 10), parseInt(results[2], 10) - 1,
					parseInt(results[3], 10), parseInt(results[4], 10),
					parseInt(results[5], 10), parseInt(results[6], 10));
		results = str
				.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);
		if (results && results.length > 7)
			return new Date(parseInt(results[1], 10), parseInt(results[2], 10) - 1,
					parseInt(results[3], 10), parseInt(results[4], 10),
					parseInt(results[5], 10), parseInt(results[6], 10),
					parseInt(results[7], 10));
	}
	return null;
}

// 去掉input中的null
function clearNullInInput(container) {
	var $input = $("input[type=text]", container);
	$input.val('');
}

/**
 * 去掉json对象中的null值，替换为""(注：不要用'')
 * 
 * @param {}
 *            json
 * @return {}
 */
function clearNullInJson(json) {
	var stringOriginal = JSON2.stringify(json);
	// json中应该使用双引号
	var stringNotNull = stringOriginal.replace(/:null/g, ":\"\"");
	return JSON2.parse(stringNotNull);
}

/**
 * 去掉json对象中时间字段的T00:00:00部分，替换为""(注：不要用'')
 * 
 * @param {}
 *            json
 * @return {}
 */
function clearTimePartInJson(json) {
	var stringOriginal = JSON2.stringify(json);
	// json中应该使用双引号
	var stringNotTime = stringOriginal.replace(/T\d{2}:\d{2}:\d{2}/g, "");
	return JSON2.parse(stringNotTime);
}

/**
 * （未实际使用）取上传文件的大小，仅支持ff
 * 
 * @param {}
 *            $obj 一个file控件的jQuery对象
 */
function getUploadFileSize($obj) {
	// FireFox中file控件不能取到客户端文件的完整路径，需要其files属性来处理
	if (globalCurrentBrowser == "mozilla") {
		return $obj.get(0).files[0].fileSize;
	}
	return -1;
}

/**
 * 取上传文件的后缀名，并转换成小写
 * 
 * @param {}
 *            $obj 一个file控件的jQuery对象
 * @return {} 返回.jpg这样的后缀名字符串，没有后缀则返回null
 */
function getUploadFileSuffixName($obj) {
	var filename = $.trim($obj.val());
	// ie下file控件可以内容可以通过键盘删除，此时其值为''，ff则无法用键盘删除
	if (filename != "" && filename != null) {
		var pos = filename.lastIndexOf(".");// 找不到匹配字符串将返回-1
		if (pos != -1) {
			return filename.substring(pos).toLowerCase();
		}
	}
	return null;
}

/**
 * 取上传文件的后缀名，并判断是否在白名单内
 * 
 * @param {}
 *            $obj 一个file控件的jQuery对象
 * @param {}
 *            whiteList 允许的文件后缀白名单数组
 * @return {} 返回ture表示后缀名匹配，返回false则说明后缀名不合要求
 */
function fileTypeAllowed($obj, whiteList) {
	var match = false;
	var suffix = getUploadFileSuffixName($obj);
	if (suffix != null) {
		if ($.isArray(whiteList)) {
			$.each(whiteList, function(i, n) {
						if (suffix == n) {
							match = true;
							return false;
						}
					});
		}
	}
	return match;
}

/**
 * 取上传文件的后缀名，并判断是否在白名单内
 * 
 * @param {}
 *            $objects 一个file控件的jQuery对象数组
 * @param {}
 *            whiteList whiteList 允许的文件后缀白名单数组
 * @return {} 返回ture表示后缀名匹配，返回false则说明有file控件后缀名不合要求
 */
function filesTypeAllowed($objects, whiteList) {
	var match = true;
	$.each($objects, function(i, obj) {
				if (!fileTypeAllowed($(obj), whiteList)) {
					match = false;
					return false;
				}
			});
	return match;
}

/**
 * 格式化数字为一个定长的字符串，前面补0
 * 
 * @param {}
 *            source 待格式化的字符串或者整数
 * @param {}
 *            length 需要得到的字符串的长度
 * @return {}
 */
function formatNum(source, length) {
	source = source.toString();
	var strTemp = "";
	for (var i = 1; i <= length - source.length; i++) {
		strTemp += "0";
	}
	return strTemp + source;
}

/**
 * 修改指定容器中的name
 * 
 * @param {}
 *            $container
 * @param {}
 *            prefix
 * @param {}
 *            type 指定服务器端的模型类型，List、Set等，默认List
 * @param {}
 *            index
 */
function modifyNameToModelDriven($container, prefix, index, type) {
	var excludeName = [];
	var $noModelDriven = $(".noModelDriven", $container);
	$.each($noModelDriven, function(i, one) {
				if ($(one).attr("name")) {
					excludeName.push($(one).attr("name"));
				}
				if ($(one).attr("comboname")) {
					excludeName.push($(one).attr("comboname"));
				}
			});
	var $input = $("input[name], textarea[name], select[name]", $container);

	$.each($input, function(i, one) {
				if ($.inArray($(one).attr("name"), excludeName) != -1) {
					return true;
				}

				var name = null;
				if (index != undefined && index != null) {
					if (type == "Set") {
						name = prefix + ".makeNew[" + index + "]."
								+ $(one).attr("name");
					} else {
						name = prefix + "[" + index + "]."
								+ $(one).attr("name");
					}

				} else {
					name = prefix + "." + $(one).attr("name");
				};
				$(one).attr("name", name).addClass("modelDriven");
			});
}

/**
 * 还原指定容器中的name
 * 
 * @param {}
 *            container
 */
function restoreNameFromModelDriven($container) {
	var $input = null;
	if ($container) {
		$input = $(".modelDriven", $container);
	} else {
		$input = $(".modelDriven");
	}
	$.each($input, function(i, one) {
				var name = $(one).attr("name");
				$(one).attr("name", name.substring(name.lastIndexOf(".") + 1))
						.removeClass("modelDriven");
			});
}

/**
 * 定义递归函数，为每个节点增加特殊标志，针对tree
 * 
 * @param {}
 *            json json tree结构的json
 * @param {}
 *            attributes node中的attributes对象
 * @param {}
 *            iconCls 可以为一个简单的表示class的字符串，或者一个复杂判断的function（暂未实现函数功能）
 */
var recursiveJsonForTree = function(json, attributes, iconCls) {
	$.each(json, function(i, one) {
				if (one.hasOwnProperty("children") && one.children.length > 0) {
					recursiveJsonForTree(one.children, attributes, iconCls);
				}

				if (!(one.hasOwnProperty("attributes"))) {
					one["attributes"] = {};
				}

				$.extend(one["attributes"], attributes);

				if (iconCls) {
					one["iconCls"] = iconCls;
				}
			});
};

/**
 * 遍历tree查找指定的节点
 * 
 * @param {}
 *            id
 * @param {}
 *            type tree节点中通过设置在flag上的自定义类型
 */
function findTreeNode($tree, id, type) {
	var root = $tree.tree("getRoot");
	// getChildren返回所有级次的子node
	var children = $tree.tree('getChildren', root.target);
	for (var i = 0; i < children.length; i++) {
		if (children[i].id == id && children[i].attributes.flag == type) {
			return children[i];
		}
	}
	return null;
}

/**
 * js获取网站根路径(站点及虚拟目录)，获得网站的根目录或虚拟目录的根地址，最后不带“/”
 * 
 * @return {}
 */
function getRootPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName
					.indexOf('/'));
	return window.location.protocol + '//' + window.location.host + '/'
			+ webName;
}

/**
 * 倒计时
 * 
 * @param {}
 *            endDate 结束时间
 * @param {}
 *            interval 运行间隔（1000表示1秒）
 * @param {}
 *            $object 显示时间的jQuery对象，一般是span
 */
function countdown(endDate, interval, $object) {
	var getRemainingTime = function() {
		var now = new Date();

		if (endDate == null || endDate < now) {
			$object.html("考试结束");
			return;
		}

		var days = (endDate - now) / 1000 / 60 / 60 / 24;
		var daysRound = Math.floor(days);
		var hours = (endDate - now) / 1000 / 60 / 60 - (24 * daysRound);
		var hoursRound = Math.floor(hours);
		var minutes = (endDate - now) / 1000 / 60 - (24 * 60 * daysRound)
				- (60 * hoursRound);
		var minutesRound = Math.floor(minutes);
		var seconds = (endDate - now) / 1000 - (24 * 60 * 60 * daysRound)
				- (60 * 60 * hoursRound) - (60 * minutesRound);
		var secondsRound = Math.round(seconds);

		var show = "";

		if (daysRound > 0) {
			show = show + daysRound + " 天 ";
		}
		if (daysRound > 0 || hoursRound > 0) {
			show = show + hoursRound + ":";
		}
		if (daysRound > 0 || hoursRound > 0 || minutesRound > 0) {
			show = show + minutesRound + ":";
		}
		show = show + secondsRound;
		$object.html(show);
	};

	return setInterval(getRemainingTime, interval);
}