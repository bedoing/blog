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

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
        <ul class="breadcrumb">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">Forms</a>
            </li>
        </ul>
    </div>

    <div class="row">
        <div class="box col-md-12">
            <div class="box-inner">
                <div class="box-header well" data-original-title="">
                    <h2><i class="glyphicon glyphicon-edit"></i> Form Elements</h2>

                    <div class="box-icon">
                        <a href="#" class="btn btn-setting btn-round btn-default"><i
                                class="glyphicon glyphicon-cog"></i></a>
                        <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                class="glyphicon glyphicon-chevron-up"></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default"><i
                                class="glyphicon glyphicon-remove"></i></a>
                    </div>
                </div>
                <div class="box-content">
                    <div class="control-group">
                        <label class="control-label" for="selectError">Modern Select</label>

                        <div class="controls">
                            <select id="selectError" data-rel="chosen">
                                <option>Option 1</option>
                                <option>Option 2</option>
                                <option>Option 3</option>
                                <option>Option 4</option>
                                <option>Option 5</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="selectError1">Multiple Select / Tags</label>

                        <div class="controls">
                            <select id="selectError1" multiple class="form-control" data-rel="chosen">
                                <option>Option 1</option>
                                <option selected>Option 2</option>
                                <option>Option 3</option>
                                <option>Option 4</option>
                                <option>Option 5</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="selectError2">Group Select</label>

                        <div class="controls">
                            <select data-placeholder="Your Favorite Football Team" id="selectError2" data-rel="chosen">
                                <option value=""></option>
                                <optgroup label="NFC EAST">
                                    <option>Dallas Cowboys</option>
                                    <option>New York Giants</option>
                                    <option>Philadelphia Eagles</option>
                                    <option>Washington Redskins</option>
                                </optgroup>
                                <optgroup label="NFC NORTH">
                                    <option>Chicago Bears</option>
                                    <option>Detroit Lions</option>
                                    <option>Green Bay Packers</option>
                                    <option>Minnesota Vikings</option>
                                </optgroup>
                                <optgroup label="NFC SOUTH">
                                    <option>Atlanta Falcons</option>
                                    <option>Carolina Panthers</option>
                                    <option>New Orleans Saints</option>
                                    <option>Tampa Bay Buccaneers</option>
                                </optgroup>
                                <optgroup label="NFC WEST">
                                    <option>Arizona Cardinals</option>
                                    <option>St. Louis Rams</option>
                                    <option>San Francisco 49ers</option>
                                    <option>Seattle Seahawks</option>
                                </optgroup>
                                <optgroup label="AFC EAST">
                                    <option>Buffalo Bills</option>
                                    <option>Miami Dolphins</option>
                                    <option>New England Patriots</option>
                                    <option>New York Jets</option>
                                </optgroup>
                                <optgroup label="AFC NORTH">
                                    <option>Baltimore Ravens</option>
                                    <option>Cincinnati Bengals</option>
                                    <option>Cleveland Browns</option>
                                    <option>Pittsburgh Steelers</option>
                                </optgroup>
                                <optgroup label="AFC SOUTH">
                                    <option>Houston Texans</option>
                                    <option>Indianapolis Colts</option>
                                    <option>Jacksonville Jaguars</option>
                                    <option>Tennessee Titans</option>
                                </optgroup>
                                <optgroup label="AFC WEST">
                                    <option>Denver Broncos</option>
                                    <option>Kansas City Chiefs</option>
                                    <option>Oakland Raiders</option>
                                    <option>San Diego Chargers</option>
                                </optgroup>
                            </select>
                        </div>
                    </div>
                    <br>


                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="">
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                    <div class="checkbox disabled">
                        <label>
                            <input type="checkbox" value="" disabled>
                            Option two is disabled
                        </label>
                    </div>

                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
                            Option one is this and that&mdash;be sure to include why it's great
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
                            Option two can be something else and selecting it will deselect option one
                        </label>
                    </div>
                    <div class="radio disabled">
                        <label>
                            <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
                            Option three is disabled
                        </label>
                    </div>

                    <label class="checkbox-inline">
                        <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
                    </label>
                    <label class="checkbox-inline">
                        <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
                    </label>

                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 1
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 3
                    </label>

                    <br>
                    <br>
                    <br>

                    <div class="form-group has-success col-md-4">
                        <label class="control-label" for="inputSuccess1">Input with success</label>
                        <input type="text" class="form-control" id="inputSuccess1">
                    </div>
                    <div class="form-group has-warning col-md-4">
                        <label class="control-label" for="inputWarning1">Input with warning</label>
                        <input type="text" class="form-control" id="inputWarning1">
                    </div>
                    <div class="form-group has-error col-md-4">
                        <label class="control-label" for="inputError1">Input with error</label>
                        <input type="text" class="form-control" id="inputError1">
                    </div>

                    <form class="form-inline" role="form">
                        <div class="form-group has-success has-feedback">
                            <label class="control-label" for="inputSuccess4">Input with success</label>
                            <input type="text" class="form-control" id="inputSuccess4">
                            <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                        </div>
                    </form>

                    <br>
                    <div class="input-group col-md-4">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                        <input type="text" class="form-control" placeholder="Username">
                    </div>
                </div>
            </div>
        </div>
        <!--/span-->

    </div><!--/row-->

    <div class="row">
        <div class="box col-md-12">
            <div class="box-inner">
                <div class="box-header well" data-original-title="">
                    <h2><i class="glyphicon glyphicon-edit"></i> Form Elements</h2>

                    <div class="box-icon">
                        <a href="#" class="btn btn-setting btn-round btn-default"><i
                                class="glyphicon glyphicon-cog"></i></a>
                        <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                class="glyphicon glyphicon-chevron-up"></i></a>
                        <a href="#" class="btn btn-close btn-round btn-default"><i
                                class="glyphicon glyphicon-remove"></i></a>
                    </div>
                </div>
                <div class="box-content">
                    <form role="form">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputFile">File input</label>
                            <input type="file" id="exampleInputFile">

                            <p class="help-block">Example block-level help text here.</p>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> Check me out
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>

                </div>
            </div>
        </div>
        <!--/span-->

    </div><!--/row-->

        <!-- content ends -->
        </div><!--/#content.col-md-0-->
    </div><!--/fluid-row-->

        <!-- Ad, you can remove it -->
        <div class="row">
            <!-- <div class="col-md-9 col-lg-9 col-xs-9 hidden-xs">
                <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
                
                <ins class="adsbygoogle"
                     style="display:inline-block;width:728px;height:90px"
                     data-ad-client="ca-pub-5108790028230107"
                     data-ad-slot="3193373905"></ins>
                <script>
                    (adsbygoogle = window.adsbygoogle || []).push({});
                </script>
            </div> -->
            <div class="col-md-2 col-lg-3 col-sm-12 col-xs-12 email-subscription-footer">
                <div class="mc_embed_signup">
                    <form action="//halalit.us3.list-manage.com/subscribe/post?u=444b176aa3c39f656c66381f6&amp;id=eeb0c04e84" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
                        <div>
                            <label>Keep up with my work</label>
                            <input type="email" value="" name="EMAIL" class="email" placeholder="Email address" required>

                            <div class="power_field"><input type="text" name="b_444b176aa3c39f656c66381f6_eeb0c04e84" tabindex="-1" value=""></div>
                            <div class="clear"><input type="submit" value="Subscribe" name="subscribe" class="button"></div>
                        </div>
                    </form>
                </div>

                <!--End mc_embed_signup-->
            </div>

        </div>
        <!-- Ad ends -->

        <hr>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">×</button>
                        <h3>Settings</h3>
                    </div>
                    <div class="modal-body">
                        <p>Here settings can be configured...</p>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                        <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                    </div>
                </div>
            </div>
        </div>
    
    <%@ include file="footer.jsp"%>
</div><!--/.fluid-container-->

    
</body>
</html>
