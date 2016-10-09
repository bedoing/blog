$(document).ready(function(){
        initTitle();

        var indexMore = $("button[id=index-more]");
        indexMore.attr("disabled", "true");
        indexMore.text("正在加载");
        var articleVO = {
            "articleType": 2
        };
        initPage("/article/list", "_news_content", articleVO, function(flag){
            if(flag){
                indexMore.text("没有更多的文章")
            }else{
                indexMore.removeAttr("disabled");
                indexMore.text("加载更多")
            }
        });
        listTitle("/article/hot", articleVO, '_ranking');

//        myTags(2);

        refreshData(1, function(data) {
                var tagDiv = $("#_myTags").empty();

                console.log(data)
                data.forEach(function(d) {
                    tagDiv.append('<span class="label label-info label-nav-custom" onClick="tagClick(' + d.tagId + ',\'' + d.tagName + '\')" id="tagId_' + d.tagId + '">' + d.tagName + '  <span class="badge">' + d.articleNum + '</span></span>')
                });
            });

    $("button[id=index-more]").click(function(){
            var newsContent = $("div[id=_news_content]");

    	var indexMore = $("button[id=index-more]");
    	var pageNo = $("input[name='_index_news_content_pageNo']");

    	indexMore.attr("disabled", "true");
    	var pageNoVal = pageNo.val();
    	pageNo.val(++pageNoVal);
    	indexMore.text("正在加载");
    	var newsVo = {
                "pageNo" : pageNo.val(),
                "articleType": 1
	};
    	more("/article/list", newsVo, newsContent, 'Y', function(flag){
    		if(flag){
    			indexMore.text("没有更多的文章")	
    		}else{
    			indexMore.removeAttr("disabled");
    			indexMore.text("加载更多")
    		}
    	});
    });
});

var initTitle = function(){
        var tagName = "${tagName}";
        if(tagName != null && tagName != "") {
            $("#_tagTitle").removeAttr("display");
        }else {
            $("#_tagTitle").attr("display", "none");
        }
    }

function initPage(url, targetDivId, paramObj, callback) {
        var targetDiv = $("div[id=" + targetDivId +"]");
        more(url, paramObj, targetDiv, 'Y', callback);
}

function more(url, paramObj, targetDiv, style, callback){
    GETWithBody(url, paramObj, function(data) {
        for (var i = 0; i < data.result.length; i++) {
            var newsObj = data.result[i];
            targetDiv.append(initSubjetContent(newsObj, i+1, style));
        };
        var flag = (data.pageNo * data.pageSize) >= data.total;
        if(callback){
            callback(flag);
        }
    });

	/*$.ajax({
                type: "post",  
                url: url,
                dataType: "json",
                data: paramObj,     
                success: function(response) {
                    for (var i = 0; i < response.result.length; i++) {
                    	var newsObj = response.result[i];
                    	targetDiv.append(initSubjetContent(newsObj, i+1, style));
                    };
                    var flag = (response.pageNo * response.pageSize) >= response.total;
                    if(callback){
                    	callback(flag);
                    }
                },  
                error: function(response) {  
                    console.error(response);  
                }  
            });*/
}

function initSubjetContent(newsObj, idx, style){
	var divVal;
	if(style == 'Y'){
		divVal = '<div class="row-fluid card-status-custom well-custom"><div class="span12"><h3><a href="' + "/subject/"   + newsObj['articleId'] +'">';
		divVal += newsObj['title'];
		divVal += '</a></h3><blockquote><p>';
		divVal += '<p>';
		divVal += '<div class="title-two">';
		// divVal += '<small>' + idx + '</small>';
		// divVal += '<i class="icon-time"> </i><a href="#"><time>' + newsObj['createTimeStr'] + '</time></a> ';
                         divVal += '<i class="icon-tags"></i> ';

                         for (var i = 0; i < newsObj['tagList'].length; i++) {
                                var tag = newsObj['tagList'][i];
                                divVal += '<a href="#" onclick="tagClick(' + tag.tagId + ',\'' + tag.tagName + '\')"><em>' + tag.tagName + '</em>';
                                if(newsObj['tagList'].length - i != 1) {
                                    divVal += ',   ';
                                }
                         };
                         
                         divVal += '</a>';
                         divVal += '</div></p>';
		divVal += '<p>';
		divVal += newsObj['summary'];
		divVal += '</p></blockquote></p>';	
		divVal += '</div></div>';
	}else{
		divVal = '<div class="row-fluid card-status-custom well-custom"><div class="span12"><h3><a href="' + "/subject/" + newsObj['articleId'] +'">';
		divVal += newsObj['title'];
		divVal += '</a></h3><p>';
		divVal += '<p>';
		divVal += '<div class="title-two">';
		// divVal += '<i class="icon-time"> </i><time>' + newsObj['createTimeStr'] + '</time>';
		divVal += '</div></p>';
		divVal += '</p>';	
		divVal += '</div></div>';
	}

	return divVal;
}

function listTitle(url, paramObj, targetDivId, callback) {
    var targetDiv = $("ul[id=" + targetDivId +"]");
    targetDiv.empty();
    GETWithBody(url, paramObj, function(data) {
        for (var i = 0; i < data.result.length; i++) {
            var newsObj = data.result[i];
            targetDiv.append(listTitleContent(newsObj));
        };
    });
    /*$.ajax({
                type: "post",  
                url: url,
                dataType: "json",
                data: paramObj,     
                success: function(response) {
                    for (var i = 0; i < response.result.length; i++) {
                        var newsObj = response.result[i];
                        targetDiv.append(listTitleContent(newsObj));
                    };
                },  
                error: function(response) {  
                    console.error(response);  
                }  
            });*/
}

function listTitleContent(newsObj) {
    var divVal = "";
    divVal += '<li class="links-item" >';
        divVal += '<a href="' + "/subject/" + newsObj['articleId'] +'">';
            if(newsObj['articleType'] == 1) {
                divVal += '<i class="icon-file"></i>';
            }else if(newsObj['articleType'] == 2) { 
                divVal += '<i class="icon-question-sign"></i>';
            }
            divVal += newsObj['title'];
        divVal += '</a>';
        // divVal += '<time class="pull-right"><i class="icon-time"> </i> ' + newsObj['createTimeStr']  + '</time>';
    divVal += '</li>';

    return divVal;
}

var tagClick = function(tagId, tagName) {
    console.log(tagId)
    var selected = $("#tagId_" + tagId).attr("selected");
    console.log(selected)
    if(selected) {
        return;
    }else {
        $("#_myTags span").removeAttr("selected");
        $("#tagId_" + tagId).attr("selected", "selected");
    }
    clickTag(tagName);
}

function refreshData(tagType, callback) {
    GET("/tag/group/", tagType, function(data) {
        callback(data);
    });
    /*$.ajax({
        type: "GET",  
        url:  "/group/{tagType}",
        dataType: "json",
        success: function(res) {
            callback(res);
        },  
        error: function(res) {  
            console.error(res);  
        }  
    }); */
}

/*function dbClickTag(param) {
        window.location = PRE_URI_TAG + "/" + param.name;
}*/

function clickTag(tagName) {

        $("#_news_content").empty();
        var indexMore = $("button[id=index-more]"); 
        var pageNo = $("input[name='_index_news_content_pageNo']");
        pageNo.val(1);
        indexMore.attr("disabled", "true");
        indexMore.text("正在加载");
        var newsVo = {
            "tagName" : tagName
        };
        
        more("/article/list/tag", newsVo, $("#_news_content"), "Y", function(flag){
            if(flag){
                indexMore.text("没有更多的文章")  
            }else{
                indexMore.removeAttr("disabled");
                indexMore.text("加载更多")
            }
        });
}

function initTagsCloud (funName, type) {
        $("#_tagsCloud").empty();

        $.ajax({
                type: "post",
                dataType: "json",
                url: "/tags/{type}",
                success: function(res){
                    for (var i = 0; i < res.length; i++) {
                        $("#_tagsCloud").append('<span class="label label-info label-page-custom" onClick="' + funName + '(' + res[i].tagId + ',\'' + res[i].tagName + '\')" id="' + res[i].tagId +'">' + res[i].tagName + '</span>');
                    };
                }
            });
}

function tagClick(tagId, tagName) {
    window.location = "/subjects/tag=" + tagName;
}

function statistics(){
    $.ajax({
        url: "/article/counts",
        type: "GET",
        dataType: "json",
        success: function(res) {
            $("#_articlesCount").text(res.retData.articleCount);
            $("#_subjectsCount").text(res.retData.subjectCount);
            $("#_days").text(res.retData.dayCount);
        }
    });
}