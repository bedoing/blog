<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="zh-CN">
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
    <div class="container">
        <div class="row">
            <%-- <%@ include file="../leftMenu.jsp"%>--%>
            <div id="content" class="col-md-12">
                <!-- content starts -->
                <section>
                    <div class="col-md-7">
                        <div class="input-group">
                            <span class="input-group-addon">文章标题</span>
                            <input id="_articleTitle" type="text" class="form-control" placeholder="输入标题...">
                        </div>
                    </div>
                    <div class="col-md-3">
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
                    <div class="col-md-2">
                        <button type="button" id="_articleTempAddBtn" class="btn btn-default">
                        <span class="glyphicon glyphicon-file" aria-hidden="true"></span> 存草稿</button>
                        <button type="button" id="_articleAddBtn" class="btn btn-primary pull-right">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> 发布</button>
                    </div>
                    <div class="col-md-12">
                        <div class="input-group">
                            <span class="input-group-addon">文章摘要</span>
                            <textarea  id="_summary" name="summary" rows="3" class="form-control" placeholder="文章摘要..."></textarea>
                        </div>
                    </div>
                    
                    <div class="container row well">
                        <div class="col-md-12">
                            <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#_tagModal">
                            <span class="glyphicon glyphicon-tags" aria-hidden="true"></span> 添加标签</button>
                        </div>
                        <div class="col-md-6 ">
                            <div class="label-group" id="_labelGroup"></div>
                        </div>
                        <div class="col-md-6 ">
                            <div class="label-group" id="_labelGroup2"></div>
                        </div>
                    </div>
                </section>
                <div class="row">
                    <script id="_articleEditor" type="text/plain" style="width:100%;height:500px;"></script>
                </div>
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
    
    <!-- Modal -->
    <div class="modal fade" id="_tagModal" tabindex="-1" role="dialog" aria-labelledby="_tagModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="_tagModalLabel">添加新标签</h4>
          </div>
          <div class="modal-body">
            <!-- modal begin -->
            <div class="row" id="_addTagDiv">
                <div class="col-md-8"> 
                    <div class="input-group">
                        <span class="input-group-addon">标签名称</span>
                        <input id="_newTagName" type="text" name="tagName" class="form-control" placeholder="输入标签名称...">
                    </div>
                </div>
                <div class="col-md-4 pull-right">
                    <div class="btn-group">
                        <button type="button" id="_typeToggleBtn" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        标签分类<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a onclick="toggleSelect('_typeToggleBtn',1,'Article','_newTagType')">Article</a></li>
                            <li><a onclick="toggleSelect('_typeToggleBtn',2, 'Subjtct','_newTagType')">Subjtct</a></li>
                        </ul>
                        <input id="_newTagType" type="hidden" name="tagType"/>
                    </div>
                </div>
            </div>
            <!-- modal end -->
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" tagFun="tagClick" id="_newTagBtn">添加</button>
          </div>
        </div>
      </div>
    </div>

    <%@ include file="../footer.jsp"%>
    </div><!--/container-->

    <script type="text/javascript" charset="utf-8" src="<%= path%>/static/js/admin/blog/publish.js"></script>
    <script type="text/javascript">
        $().ready(function() {
            initLabel("tagClick");
            initUE();
        });
    </script>
</body>
</html>