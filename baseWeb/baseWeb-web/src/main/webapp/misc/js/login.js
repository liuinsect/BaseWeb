$(document).ready(function() {
	$("#login").click(function() {
				login();
			});

	$("#cancel").click(function() {
				$("input").val("");
			});

	$("input[name=password], input[name=module]").keypress(function(event) {
				var myEvent = event || window.event;
				if (myEvent.keyCode == 13) {
					$("#login").click();
				}
			});

	// 界面处理
	// 如果分辨率高度超过900px，则换成大图片
	if (window.screen.height >= 900) {
		$("#background").css({
					"height" : "700px"
				});
		$("#input").css({
					"margin-top" : "320px"
				});
		$("#copyright").css({
					"margin-top" : "180px"
				});
	}
});

function login() {
	var account = $("input[name=account]").val();
	var password = $("input[name=password]").val();
	if ($.trim(account) == "" || $.trim(password) == "") {
		return;
	}

    var roleId = $("#role").val();
	var option = {
		"account" : account,
		"password" : password,
        "roleId":roleId
	};
	$.post("doLogin.html?timestamp=" + new Date().valueOf(), option,
    function(json) {
        if (json["success"]) {
            // 重定向
            window.location.href = "/admin/index.html";
        } else {
            alert(json["message"]);
        }

    }, "json");
}

//{"success":true,"result":{},"message":null,"resultCode":null,"resultCodeParams":null,"model":null}