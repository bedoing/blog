<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <title>Registe</title>
    <%@ include file="inc/head.inc"%>
</head>

<body>
    <!-- Contact Us -->
    <div class="contact-us container">
        <div class="row">
            <div class="contact-form span7">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper <a href="">suscipit lobortis</a> nisl ut aliquip ex ea commodo consequat.</p>
                <p><label for="msg" class="alert alert-danger" role="alert">${msg }</label></p>
                <form id="_userRegiste" method="post" action="/d/user/userRegiste">
                    <label for="loginAccount" class="nameLabel">loginAccount</label>
                      <input id="loginAccount" value="${user.loginAccount}" type="text" name="loginAccount" placeholder="Enter your name...">
                    <label for="password" class="emailLabel">password</label>
                      <input id="password" value="${user.password}" type="text" name="password" placeholder="Enter your password...">
                    <label for="repPassword" class="emailLabel">repeat password</label>
                      <input id="repPassword" value="${user.passwordRep}" type="text" name="passwordRep" placeholder="repeat password...">
                    <label for="mobilePhone">mobilePhone</label>
                      <input id="mobilePhone" value="${user.mobilePhone}" type="text" name="mobilePhone" placeholder="Your mobilePhone...">
                    <label for="verCode">verCode</label>
                      <input id="verCode" value="${user.verCode}" type="text" name="verCode" placeholder="Your verCode...">
                    <!-- <label for="message" class="messageLabel">sex</label>
                      <textarea id="message" name="sex" placeholder="Your sex..."></textarea> -->

                    <!-- <input type="checkbox" name="" aria-label="..."> Male
                    <input type="checkbox" name="" aria-label="..."> Female -->

                    <button type="submit" id="_userRegisteBtn">Submit</button>
                </form>
            </div>
            <div class="contact-address span5">
                <h4>Head Img</h4>
                <div class="map"></div>
                <h4>Address</h4>
                <p>Via Principe Amedeo 9 <br> 10100, Torino, TO, Italy</p>
                <p>Phone: 0039 333 12 68 347</p>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="<%=path%>/static/js/default/default.js"></script>
</body>
</html>
