<!DOCTYPE HTML>
<html>
<head>
    <title>Contact</title>
    <%@ include file="inc/head.inc"%>
</head>

<body>
    <%@ include file="header.jsp"%>

    <!-- blank -->
   <div class="container-fluid custom-top-blank"> </div>

    <!-- Contact Us -->
    <div class="contact-us container">
        <div class="row">
            <div class="contact-form span7">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper <a href="">suscipit lobortis</a> nisl ut aliquip ex ea commodo consequat.</p>
                <form method="post" action="assets/sendmail.php">
                    <label for="name" class="nameLabel">Name</label>
                      <input id="name" type="text" name="name" placeholder="Enter your name...">
                    <label for="email" class="emailLabel">Email</label>
                      <input id="email" type="text" name="email" placeholder="Enter your email...">
                    <label for="subject">Subject</label>
                      <input id="subject" type="text" name="subject" placeholder="Your subject...">
                    <label for="message" class="messageLabel">Message</label>
                      <textarea id="message" name="message" placeholder="Your message..."></textarea>
                    <button type="submit">Send</button>
                </form>
            </div>
            <div class="contact-address span5">
                <h4>We Are Here</h4>
                <div class="map"></div>
                <h4>Address</h4>
                <p>Via Principe Amedeo 9 <br> 10100, Torino, TO, Italy</p>
                <p>Phone: 0039 333 12 68 347</p>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp"%>
</body>
</html>
