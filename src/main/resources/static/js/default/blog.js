$(document).ready(function(){
	
    $("button[id=index-more]").click(function(){
        var newsContent = $("div[id=_news_content]");
    	var indexMore = $("button[id=index-more]"); 
    	// var imgMore = $("#_index_news_content_more");
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

function initPage(url, targetDivId, paramObj, callback) {
    var targetDiv = $("div[id=" + targetDivId +"]");

    more(url, paramObj, targetDiv, 'Y', callback);
}

function more(url, paramObj, targetDiv, style, callback){
    GETWithBody(url, paramObj, function(res) {
        for (var i = 0; i < res.result.length; i++) {
            var newsObj = res.result[i];
            targetDiv.append(initNewsContent(newsObj, i+1, style));
        };
        var flag = (res.pageNo * res.pageSize) >= res.total;
        if(callback){
            callback(flag);
        }
    });
}

function initNewsContent(newsObj, idx, style){
	var divVal;
	if(style == 'Y'){
		divVal = '<div class="row-fluid card-status-custom well-custom"><div class="span12"><h3><a href="' + "/article/"  + newsObj['articleId'] +'">';
		divVal += newsObj['title'];
		divVal += '</a></h3><p>';
		divVal += '<p>';
		divVal += '<div class="title-two">';
		// divVal += '<small>' + idx + '</small>';
		/*divVal += '<i class="icon-time"> </i><a href="#"><time>' + newsObj['createTimeStr'] + '</time></a> ';*/
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
		divVal += '<blockquote><p>';
		divVal += newsObj['summary'];
		divVal += '</p></blockquote></p>';	
		divVal += '</div></div>';
	}else{
		divVal = '<div class="row-fluid card-status-custom well-custom"><div class="span12"><h3><a href="' + "/article/" + newsObj['articleId'] +'">';
		divVal += newsObj['title'];
		divVal += '</a></h3><p>';
		divVal += '<p>';
		divVal += '<div class="title-two">';
		/*divVal += '<i class="icon-time"> </i><time>' + newsObj['createTimeStr'] + '</time>';*/
		divVal += '</div></p>';
		divVal += '</p>';	
		divVal += '</div></div>';
	}

	return divVal;
}

function listTitle(url, paramObj, targetDivId, callback) {
    var targetDiv = $("ul[id=" + targetDivId +"]");
    targetDiv.empty();

    GETWithBody(url, paramObj, function(res) {
        for (var i = 0; i < res.result.length; i++) {
            var newsObj = res.result[i];
            targetDiv.append(listTitleContent(newsObj));
        };
    });
}

function listTitleContent(newsObj) {
    var divVal = "";
    divVal += '<li class="links-item" >';
        divVal += '<a href="' + "/article/" + newsObj['articleId'] +'">';
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

function myTags(tagType) {
    var myTags = echarts.init(document.getElementById('_myTags'));

    var option = {
        calculable: false,
        grid: {
            borderWidth: 0,
            y: 80,
            y2: 60
        },
        xAxis: [
            {
                type: 'category',
                show: false,
                data: []
            }
        ],
        yAxis: [
            {
                type: 'value',
                show: false
            }
        ],
        series: [
            {
                name: '标签统计',
                type: 'bar',
                itemStyle: {
                    normal: {
                        barBorderRadius: 5,
                        color: function(params) {
                            var colorList = [
                              '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                               '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                               '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true,
                            position: 'top',
                            formatter: '{b}: {c}'
                        }
                    },
                    emphasis: {
                        barBorderRadius: 0,
                        // color: '#26C0C0',
                        barBorderWidth: 1,
                        barBorderColor: '#FFF'
                    }
                },
                data: [],
            }
        ]
    };

    refreshData(tagType, function(res) {
            option.xAxis[0].data = res.tagNames;
            option.series[0].data = res.counts;

            //加载数据
            if(myTags) {
                myTags.clear();
            }
            myTags.setOption(option); 
            /*myTags.on(echarts.config.EVENT.DBLCLICK, dbClickTag);*/
            myTags.on("click", clickTag);
    });    
}

function refreshData(tagType, callback) {
    GET("/tag/group/", tagType, function(res) {
        callback(res);
    });
}

/*function dbClickTag(param) {
        window.location = PRE_URI_TAG + "/" + param.name;
}*/

function clickTag(param) {

        $("#_news_content").empty();
        var indexMore = $("button[id=index-more]"); 
        var pageNo = $("input[name='_index_news_content_pageNo']");
        pageNo.val(1);
        indexMore.attr("disabled", "true");
        indexMore.text("正在加载");
        var newsVo = {
            "tagName" : param.name
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

        GET("/tag/list", null, function(res) {
            for (var i = 0; i < res.length; i++) {
                var tag = res[i];
                $("#_tagsCloud").append('<span class="label label-info label-page-custom" onClick="' + funName + '(' + tag.tagId + ',\'' + tag.tagName + '\')" id="' + tag.tagId +'">' + tag.tagName + '</span>');
            };
        });
}

function tagClick(tagId, tagName) {
        window.location = "/articles/tag=" + tagName;
}

function statistics() {

    GET("/article/counts", null, function(res){
        $("#_articlesCount").text(res.retData.articleCount);
        $("#_subjectsCount").text(res.retData.subjectCount);
        $("#_days").text(res.retData.dayCount);
    });
}