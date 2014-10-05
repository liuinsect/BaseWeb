
(function($,w){
	w.gUtils = w.gUtils || {};
	
	$.extend(w.gUtils,
	{
		fProcessResult: function(data, successHandler, errorHandler) {
			if (data) {
				if (data['success'] && data['success'] == true) {
					successHandler.call(this,data);
				} else {
					if (errorHandler) {
						errorHandler.call(this,data);
					} else {
						var sMessage=data['message'];
				 		if(sMessage==null){
							sMessage='处理异常，请联系管理员！';
						}

				 		alert("提示："+sMessage);
					}

				}
			}
		},
        //ajax简单封装
        fAjaxRequest: function(url, param, scallback, ecallback, dt) {
            var that = this;
            if (!url || !param  ) {
                alert('ajaxRequest错误，请提供完整的参数列表！');
                return;
            }
            if (!dt) dt = 'json';
            showRetrieveProgressBar(true);
            $.ajax({
                url: url,
                dataType: dt,
                data: param,
                success: function(data, textStatus) {
                    showRetrieveProgressBar(false);
                    gUtils.fProcessResult(data, function() {
                        scallback.call(this,data, textStatus);
                    });
                },
                error: function(xhr, status, errMsg) {
                    showRetrieveProgressBar(false);
                    if (ecallback) {
                        ecallback.call(this, xhr, status, errMsg);
                    } else {
                    }
                }
            });
        }



    });
})(jQuery,window);