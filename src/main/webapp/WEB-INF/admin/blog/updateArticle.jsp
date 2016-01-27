<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>index</title>
    <%@ include file="../inc/head.inc"%>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script type="text/javascript" charset="utf-8" src="<%= path%>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%= path%>/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="<%= path%>/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
    <%@ include file="../header.jsp"%>

    <div class="ch-container">
    <div class="row">
        
        <%@ include file="../leftMenu.jsp"%>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <%@ include file="../breadcrumb.jsp"%>

            
                
            <section>
                    <input id="_articleId"  type="hidden" name="title">
                    <div class="form-group col-md-8">
                        <input id="_articleTitle"  type="text" name="title" class="form-control" placeholder="输入标题">
                    </div>
                    
                    <div class="form-group col-md-3">
                        <div class="btn-group">
                                <button type="button" class="btn">文章类型</button>
                                <button type="button" id="_articleToggleBtn" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                选择分类<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a onclick="toggleSelect('_articleToggleBtn',1,'Article','_articleType')">Article</a></li>
                                    <li><a onclick="toggleSelect('_articleToggleBtn',2, 'Subjtct','_articleType')">Subjtct</a></li>

                                </ul>
                                <input id="_articleType" type="hidden" name="tagType"/>
                        </div>
                    </div>
               
                    <div class="form-group col-md-1">
                        <button type="button" id="_articleUpdateBtn" class="btn btn-primary">Submit</button>
                    </div>
            <div class="form-group col-md-12">
                <textarea  id="_summary" name="summary" rows="3" class="form-control" placeholder="文章摘要"></textarea>
            </div>

            <br/>
            <div class="container-fluid well">
                <div class="form-group col-md-12">
                        <div class="btn-group">
                                <button type="button" class="btn">标签类型</button>
                                <button type="button" id="_typeToggleBtn" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                选择分类<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a onclick="toggleSelect('_typeToggleBtn',1,'Article','_newTagType')">Article</a></li>
                                    <li><a onclick="toggleSelect('_typeToggleBtn',2, 'Subjtct','_newTagType')">Subjtct</a></li>
                                    <!-- <li role="separator" class="divider"></li>
                                    <li><a>选择分类</a></li> -->
                                </ul>
                                <input id="_newTagType" type="hidden" name="tagType"/>
                                <input id="_newTagName" type="text" name="tagName" class="btn btn-mini" placeholder="输入标签...">
                              <button class="btn btn-primary" tagFun="tagClick" id="_newTagBtn">Add</button>
                        </div>

                    <!-- <div class="btn-group">
                          <input id="_newTagName" type="text" name="tagName" class="btn btn-mini" placeholder="输入标签...">
                          <button class="btn btn-mini" tagFun="tagClick" id="_newTagBtn">
                            <span class="caret"></span>
                          </button>
                        </div> -->
                </div>
                <div class="form-group col-md-6">
                    <div class="label-group" id="_labelGroup"></div>
                </div>
                <div class="form-group col-md-6">
                    <div class="label-group" id="_labelGroup2"></div>
                </div>

                <!-- <div class="form-group col-md-3">
                    <div class="btn-group">
                      <input id="_newTagName" type="text" name="tagName" class="btn btn-mini" placeholder="输入标签...">
                      <button class="btn btn-mini" tagFun="tagClick" id="_newTagBtn">
                        <span class="caret"></span>
                      </button>
                    </div>
                </div> -->
            </div>
            </section>  
            <script id="_articleEditor" type="text/plain" style="width:1088px;height:500px;"></script>
            <div id="_tempContent" style="display:none;">${article.content}</div>
            <!-- content ends -->
        </div>
    </div>
    </div>
    
    <%@ include file="../footer.jsp"%>
</div><!--/.fluid-container-->

<script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/blog/publish.js"></script>
<script type="text/javascript">
    var ue;
    $().ready(function(){
        
        ue = initUE();
        initArticlePage();

        $("#_articleUpdateBtn").on("click",function(){
            var title = $("#_articleTitle").val()
            var summary = $("#_summary").val()
            var articleType = $("#_articleType").val()
            var content = UE.getEditor('_articleEditor').getContent()
            
            if(title == "" || summary =="" || articleType =="" || content == "") {
                alert("Blank ...");
                return;
            }

            var article = {
                "articleId": $("#_articleId").val(),
                "title": title,
                "articleType": articleType,
                "summary": summary,
                "tags": tagIdStr,
                "content": content
            };

            $.ajax({
                beforeSend:function(){$('.table').html("正在保存，请稍候……");},
                type: "post",
                dataType: "json",
                url: PRE_URI_AA + "/updateArticle",
                data: article,
                success: function(res){
                    alert(res.retMsg);
                }
            });
        });
    });

    function initArticlePage() {
        var title = '${article.title}';
        var articleId = '${article.articleId}';
        // tagIdStr = '${article.tags}';
        var articleType = '${article.articleType}';
        
        var articleTypeName = articleType == 1? 'Article':'Subject';
        
        var tagList = JSON.parse('${article.tagList}');
        for (var i = 0; i < tagList.length; i++) {
            var tag = tagList[i]
           
            tagIdStr += tag.tagId + ",";
        };

        $("#_articleId").val(articleId);
        $("#_articleTitle").val(title);
        $("#_summary").val('${article.summary}');

        toggleSelect('_articleToggleBtn',articleType,articleTypeName,'_articleType')

        initLabel("tagClick");
        
        ue.ready(function() {
            this.setContent($("#_tempContent").html());
            $("#_tempContent").empty();
        })
    }
</script>
</body>
</html>
