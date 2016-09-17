<%@ page language="java" pageEncoding="UTF-8" %>
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

        <div class="contact-form span12">
            <form id="_salaryAdd" method="post" >
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper <a href="">suscipit lobortis</a> nisl ut aliquip ex ea commodo consequat.</p>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">标准工资</label>
                    <input id="standardWage"  type="text" name="standardWage" class="form-control" >
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">岗位工资</label>
                    <input id="postWage"  type="text" name="postWage"  class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">浮动工资</label>
                    <input id="floatingWage"  type="text" name="floatingWage" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">实际浮动</label>
                    <input id="actualFloating"  type="text" name="actualFloating" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">加班费</label>
                    <input id="overtimePay"  type="text" name="overtimePay" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">通讯津贴</label>
                    <input id="communicationAllowance"  type="text" name="communicationAllowance" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">税前补退</label>
                    <input id="preTaxCompensation"  type="text" name="preTaxCompensation" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">本月收入</label>
                    <input id="total"  type="text" name="total" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">考勤</label>
                    <input id="checkingAttendance"  type="text" name="checkingAttendance" class="form-control span7" >
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">计税工资</label>
                    <input id="taxableSalary"  type="text" name="taxableSalary"  class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">社保金额</label>
                    <input id="socialInsuranceAmount"  type="text" name="socialInsuranceAmount" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">公积金 公司</label>
                    <input id="partOfTheFundCompany"  type="text" name="partOfTheFundCompany" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">公积金 个人</label>
                    <input id="providentFundIndividualPart"  type="text" name="providentFundIndividualPart" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">计税基数</label>
                    <input id="taxBase"  type="text" name="taxBase" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">税</label>
                    <input id="tax"  type="text" name="tax" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">保证金</label>
                    <input id="bail"  type="text" name="bail" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">税后补退</label>
                    <input id="taxRefund"  type="text" name="taxRefund" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">消费金额</label>
                    <input id="consumptionAmount"  type="text" name="consumptionAmount" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">实得工资</label>
                    <input id="actualWage"  type="text" name="actualWage" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">&nbsp;</label>
                    <input value="" type="button" class="form-control" >
                </div>
                <div class="form-group has-success col-md-1">
                    <button type="button" id="_addSalaryBtn" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
        <br/>
        <hr/>
        <div class="contact-form span12">
            <form id="_salaryAdd" method="post" >
                <p><h5>考勤、加班、补退</h5></p>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">迟到</label>
                    <input id="standardWage"  type="text" name="standardWage" class="form-control" >
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">早退</label>
                    <input id="postWage"  type="text" name="postWage"  class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">缺打卡</label>
                    <input id="floatingWage"  type="text" name="floatingWage" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">事假</label>
                    <input id="actualFloating"  type="text" name="actualFloating" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">病假</label>
                    <input id="overtimePay"  type="text" name="overtimePay" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">哺乳假</label>
                    <input id="communicationAllowance"  type="text" name="communicationAllowance" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">平时加班</label>
                    <input id="preTaxCompensation"  type="text" name="preTaxCompensation" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">周末加班</label>
                    <input id="total"  type="text" name="total" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">节日加班</label>
                    <input id="checkingAttendance"  type="text" name="checkingAttendance" class="form-control span7" >
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">旷工</label>
                    <input id="taxableSalary"  type="text" name="taxableSalary"  class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">补退</label>
                    <input id="socialInsuranceAmount"  type="text" name="socialInsuranceAmount" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">消费</label>
                    <input id="partOfTheFundCompany"  type="text" name="partOfTheFundCompany" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">变动日期</label>
                    <input id="providentFundIndividualPart"  type="text" name="providentFundIndividualPart" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <label class="control-label" for="inputSuccess1">变动</label>
                    <input id="taxBase"  type="text" name="taxBase" class="form-control">
                </div>
                <div class="form-group has-success col-md-1">
                    <button type="button" id="_addSalaryBtn" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>


    </div></div>

    <%@ include file="footer.jsp"%>
</div><!--/.fluid-container-->

    <script type="text/javascript" src="<%=path%>/js/admin/salaryMng.js"></script>
</body>
</html>
