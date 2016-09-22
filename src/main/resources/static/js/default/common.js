$(document).ready(function() {
	headerClass();

	jQuery(function($) {
		$(document).ready(function() {
			$.scrollUp({
				animation: 'fade',
				activeOverlay: '#00FFFF',
				scrollImg: {
					active: true,
					type: 'background',
					src: 'img/top.png'
				}
			});
			$.scrollUp({
				scrollName: 'scrollUp', // 元素ID
				topDistance: '300', // 顶部距离显示元素之前 (px)
				topSpeed: 300, // 回到顶部的速度 (ms)
				animation: 'fade', // 动画类型Fade, slide, none
				animationInSpeed: 200,
				animationOutSpeed: 200,
				scrollText: 'Scroll to top', // 元素文本
				activeOverlay: false, // 显示scrollUp的基准线，false为不显示, e.g '#00FFFF'
			});
		});
	});

	GET = function(url, paramData, callback) {
	    fetch(url, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "GET",
            data: paramData
        }).then(function(response){
            if(response.status!==200){
                console.log("WRONG, STATUS: "+response.status);
                return;
            }
            response.json().then(function(data) {
                if(callback){
                    callback(data);
                }
            });
        }).catch(function(err){
            console.log("Fetch ERROR: "+err);
        });
	}
});

function headerClass() {
	var url = window.location.href;
	$('nav ul li').removeClass("active");

	if (url.indexOf("/article/") != -1 || url.indexOf("/articles") != -1) {
		$("#blogPage").addClass("active");
	} else if (url.indexOf("/subject") != -1) {
		$("#subjectPage").addClass("active");
	} else {
		$("#defaultPage").addClass("active");
	}
}