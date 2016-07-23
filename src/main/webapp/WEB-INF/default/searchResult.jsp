<%@ page language="java" pageEncoding="utf-8"%>
<!-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE HTML>
<html lang="zh-CN">
    <head>
        <title>${tagName}</title>
        <%@ include file="inc/head.inc"%>
    </head>
    <body>
        <%@ include file="header.jsp"%>
        <!-- blank -->
        <!-- <div class="container custom-top-blank"> </div> -->
        <!-- Page Title -->
        <div class="page-title">
            <div class="container article-tag-page-title-custom">
                <div class="span1"></div>
                <div class="span11">
                    <i class="icon-list page-title-icon"></i>
                    <h2>${keywords} </h2>
                    <!-- <h2>${tagName} /</h2>
                    <p>Here is the work we've done so far</p> -->
                </div>
                
            </div>
        </div>
        
        <!-- <div class="container custom-top-tagsChart" id="_myTags"></div> -->
        
        <!-- News -->
        <div class="container">
            <div class="row">
                <div class="span1">
                    
                </div>
                <div class="span7">
                    <div class="row" id="_news_content">
                    
                    <c:forEach items = "${list}" var="news">
                        
                    ${news.id}
                    </c:forEach>
                    <!-- begin -->
                    <div class="row-fluid card-status-custom well-custom"><div class="span12"><h3><a href="' + PRE_URI_ARCHIVES  + newsObj['articleId'] +'">
                    newsObj['title'];
                    </a></h3><p>
                    <p>
                    <div class="title-two">
                    // <small>' + idx + '</small>
                    <i class="icon-time"> </i><a href="#"><time>' + newsObj['createTimeStr'] + '</time></a> 
                                     <i class="icon-tags"></i> 

                                     for (var i = 0; i < newsObj['tagList'].length; i++) {
                                            var tag = newsObj['tagList'][i];
                                            <a href="#" onclick="tagClick(' + tag.tagId + ',\'' + tag.tagName + '\')"><em>' + tag.tagName + '</em>
                                            if(newsObj['tagList'].length - i != 1) {
                                                ,   
                                            }
                                     };
                                     
                                     </a>
                                     </div></p>
                    <blockquote><p>
                    newsObj['summary'];
                    </p></blockquote></p>  
                    </div></div>
                    <!-- end -->

                    </div>
                    <div class="row">
                        <div class="span12">
                            <button class="btn btn-block" type="button" id="index-more">
                            </button>
                            <input type="hidden" value="1" name="_index_news_content_pageNo"/>
                        </div>
                    </div>
                </div>
                <div class="span4">
                    
                </div>
            </div>
        </div>
        <!-- blank -->
        <div class="container">
            <div class="row">
                <div class="span12">
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp"%>

    </body>
</html>