<!DOCTYPE HTML>
<html>
<head>
    <title>default</title>
    <%@ include file="inc/head.inc"%>
</head>

<body>
    <%@ include file="header.jsp"%>

    <!-- blank -->
   <div class="container-fluid custom-top-blank"> </div>
   
    <!-- About Us Text -->
    <div class="about-us container">
        <div class="row">
            <div class="about-us-text span12">
                <h4>About Andia</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper <span class="violet">suscipit lobortis</span> nisl ut aliquip ex ea commodo consequat. Lorem ipsum <strong>dolor sit amet</strong>, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do <strong>eiusmod tempor</strong> incididunt.</p>
                <h4>Our Mission</h4>
                <p>Lorem ipsum dolor sit amet, <span class="violet">consectetur adipisicing</span> elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, <strong>consectetur adipisicing</strong> elit, sed do eiusmod <span class="violet">tempor incididunt</span> ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
                <h4>Why Choose Us</h4>
                <p>Lorem ipsum dolor sit amet, <strong>consectetur adipisicing elit</strong>, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Ut wisi enim ad minim veniam, quis <span class="violet">nostrud exerci</span> tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.</p>
            </div>
        </div>
    </div>

    <!-- Meet Our Team -->
    <div class="team container">
        <div class="team-title">
            <h3>Meet Our Team</h3>
        </div>
        <div class="row">
            <div class="team-text span3">
                <img src="<%= path%>/default/assets/img/team/1.jpg" alt="">
                <h4>John Doe</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
                <div class="social-links">
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                    <a class="linkedin" href=""></a>
                    <a class="email" href=""></a>
                </div>
            </div>
            <div class="team-text span3">
                <img src="<%= path%>/default/assets/img/team/2.jpg" alt="">
                <h4>Jane Doe</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor...</p>
                <div class="social-links">
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                    <a class="linkedin" href=""></a>
                    <a class="email" href=""></a>
                </div>
            </div>
            <div class="team-text span3">
                <img src="<%= path%>/default/assets/img/team/3.jpg" alt="">
                <h4>Tim Brown</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod...</p>
                <div class="social-links">
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                    <a class="linkedin" href=""></a>
                    <a class="email" href=""></a>
                </div>
            </div>
            <div class="team-text span3">
                <img src="<%= path%>/default/assets/img/team/4.jpg" alt="">
                <h4>Sarah Red</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod...</p>
                <div class="social-links">
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                    <a class="linkedin" href=""></a>
                    <a class="email" href=""></a>
                </div>
            </div>
        </div>
    </div>

    <!-- Testimonials -->
    <div class="testimonials container">
        <div class="testimonials-title">
            <h3>Testimonials</h3>
        </div>
        <div class="row">
            <div class="testimonial-list span12">
                <div class="tabbable tabs-below">
                    <div class="tab-content">
                        <div class="tab-pane active" id="A">
                            <img src="<%= path%>/default/assets/img/testimonials/1.jpg" title="" alt="">
                            <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Lorem ipsum dolor sit amet, consectetur..."<br /><span class="violet">Lorem Ipsum, dolor.co.uk</span></p>
                        </div>
                        <div class="tab-pane" id="B">
                            <img src="<%= path%>/default/assets/img/testimonials/2.jpg" title="" alt="">
                            <p>"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat..."<br /><span class="violet">Minim Veniam, nostrud.com</span></p>
                        </div>
                        <div class="tab-pane" id="C">
                            <img src="<%= path%>/default/assets/img/testimonials/3.jpg" title="" alt="">
                            <p>"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et. Lorem ipsum dolor sit amet, consectetur..."<br /><span class="violet">Lorem Ipsum, dolor.co.uk</span></p>
                        </div>
                        <div class="tab-pane" id="D">
                            <img src="<%= path%>/default/assets/img/testimonials/1.jpg" title="" alt="">
                            <p>"Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat..."<br /><span class="violet">Minim Veniam, nostrud.com</span></p>
                        </div>
                    </div>
                   <ul class="nav nav-tabs">
                       <li class="active"><a href="#A" data-toggle="tab"></a></li>
                       <li class=""><a href="#B" data-toggle="tab"></a></li>
                       <li class=""><a href="#C" data-toggle="tab"></a></li>
                       <li class=""><a href="#D" data-toggle="tab"></a></li>
                   </ul>
               </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp"%>
</body>
</html>
