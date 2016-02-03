<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>upload page</title>
    <%@ include file="inc/head.inc"%>
    
</head>

<body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <form role="form" action="<%=path%>/app/upload/ueUpload" enctype="multipart/form-data" method="post">
                        <div class="form-group">
                            <label for="exampleInputFile">
                                File input
                            </label>
                            <input type="file" id="exampleInputFile" name="articleImg" />
                            <p class="help-block">
                                Max size of the file is 30M.
                            </p>
                        </div>
                        <button type="submit" class="btn btn-default">
                            Upload
                        </button>
                    </form>
                </div>
            </div>
        </div>
<script>
</script>
</body>
</html>
