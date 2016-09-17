<!DOCTYPE HTML>
<html>
<head>
    <title>index</title>
    <%@ include file="inc/head.inc"%>
</head>

<body>
    <%@ include file="header.jsp"%>

    <div class="ch-container">
    <div class="row">
        
        <%@ include file="leftMenu.jsp"%>

        <!-- table -->
        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <%@ include file="breadcrumb.jsp"%>

            <%-- <div class="row">
                <div class="contact-form span7">
                    <form id="_userRegiste" method="post" action="<%= path%>/app/user/userRegiste">
                        
                        
                        <div class="form-group has-success col-md-3">
                            <label class="control-label" for="inputSuccess1">Account</label>
                            <input id="loginAccount" value="${user.loginAccount}" type="text" name="loginAccount" class="form-control span7" >
                        </div>
                        <div class="form-group has-success col-md-3">
                            <label class="control-label" for="inputSuccess1">密码</label>
                            <input id="password" value="${user.password}" type="text" name="password"  class="form-control">
                        </div>
                        <div class="form-group has-success col-md-3">
                            <label class="control-label" for="inputSuccess1">Rep Password</label>
                            <input id="repPassword" value="${user.passwordRep}" type="text" name="passwordRep" class="form-control">
                        </div>
                        <div class="form-group has-success col-md-3">
                            <label class="control-label" for="inputSuccess1">Phone</label>
                            <input id="mobilePhone" value="${user.mobilePhone}" type="text" name="mobilePhone" class="form-control">
                        </div>
                        <div class="form-group has-success col-md-3">
                        <button type="submit" id="_userRegisteBtn" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>
            </div> --%>

            <div id="toolbar">
                <!-- <button id="_userRemove" class="btn btn-danger" disabled>
                    <i class="glyphicon glyphicon-remove"></i> Delete
                </button> -->
                <button id="_userAdd" class="btn btn-primary">
                    <i class="glyphicon glyphicon-plus"></i> Add
                </button>
            </div>
            <table id="_userMngList"
                data-toolbar="#toolbar"
                data-search="true"
                data-show-refresh="true"
                data-show-toggle="true"
                data-show-columns="true"
                data-show-export="true"
                data-detail-view="true"
                data-detail-formatter="detailFormatter"
                data-minimum-count-columns="2"
                data-show-pagination-switch="true"
                data-pagination="true"
                data-id-field="id"
                data-page-list="[10, 25, 50, 100, ALL]"
                data-show-footer="true"
                >
            </table>
            <!--data-side-pagination="server" 
                data-url="/examples/bootstrap_table/data" -->

            <!-- content ends -->
        </div>
    </div>
    </div>
    
    <%@ include file="footer.jsp"%>
</div><!--/.fluid-container-->

<script src="<%= path%>/js/admin/userMng.js"></script>
</body>
</html>
