<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Add Article</title>
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
                    <section>
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
                            <button type="button" id="_articleAddBtn" class="btn btn-primary">Submit</button>
                        </div>
                        <div class="form-group col-md-12">
                            <textarea  id="_summary" name="summary" rows="3" class="form-control" placeholder="文章摘要"></textarea>
                        </div>
                        <br/>
                        <div class="container-fluid well">
                            
                            <div class="form-group col-md-12" id="_addTagDiv">
                                <div class="btn-group">
                                    <button type="button" class="btn">标签类型</button>
                                    <button type="button" id="_typeToggleBtn" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    选择分类<span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a onclick="toggleSelect('_typeToggleBtn',1,'Article','_newTagType')">Article</a></li>
                                        <li><a onclick="toggleSelect('_typeToggleBtn',2, 'Subjtct','_newTagType')">Subjtct</a></li>
                                    </ul>
                                    <input id="_newTagType" type="hidden" name="tagType"/>
                                    <input id="_newTagName" type="text" name="tagName" class="btn btn-mini" placeholder="输入标签...">
                                    <button class="btn btn-primary" tagFun="tagClick" id="_newTagBtn">Add</button>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <div class="label-group" id="_labelGroup"></div>
                            </div>
                            <div class="form-group col-md-6">
                                <div class="label-group" id="_labelGroup2"></div>
                            </div>
                        </div>
                    </section>
                    <script id="_articleEditor" type="text/plain" style="width:1088px;height:500px;"></script>
                    <div id="_btns">
                        <div>
                            <button onclick="getAllHtml()">获得整个html的内容</button>
                            <button onclick="getContent()">获得内容</button>
                            <button onclick="setContent()">写入内容</button>
                            <button onclick="setContent(true)">追加内容</button>
                            <button onclick="getContentTxt()">获得纯文本</button>
                            <button onclick="getPlainTxt()">获得带格式的纯文本</button>
                            <button onclick="hasContent()">判断是否有内容</button>
                            <button onclick="setFocus()">使编辑器获得焦点</button>
                            <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
                            <button onmousedown="setblur(event)" >编辑器失去焦点</button>
                        </div>
                        <div>
                            <button onclick="getText()">获得当前选中的文本</button>
                            <button onclick="insertHtml()">插入给定的内容</button>
                            <button id="enable" onclick="setEnabled()">可以编辑</button>
                            <button onclick="setDisabled()">不可编辑</button>
                            <button onclick=" UE.getEditor('_articleEditor').setHide()">隐藏编辑器</button>
                            <button onclick=" UE.getEditor('_articleEditor').setShow()">显示编辑器</button>
                            <button onclick=" UE.getEditor('_articleEditor').setHeight(300)">设置高度为300默认关闭了自动长高</button>
                        </div>
                        <div>
                            <button onclick="getLocalData()" >获取草稿箱内容</button>
                            <button onclick="clearLocalData()" >清空草稿箱</button>
                        </div>
                    </div>
                    <div>
                        <button onclick="createEditor()">
                        创建编辑器</button>
                        <button onclick="deleteEditor()">
                        删除编辑器</button>
                    </div>
                    <!-- content ends -->
                </div>
            </div>
        </div>
        
        <%@ include file="../footer.jsp"%>
        </div><!--/.fluid-container-->
        
        <script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/blog/publish.js"></script>
        <script type="text/javascript">
        $().ready(function() {
            initLabel("tagClick");
            initUE();
        });
        </script>
    </body>
</html>