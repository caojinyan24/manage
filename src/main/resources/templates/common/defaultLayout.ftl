<#macro layout>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="/script/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/script/css/dashboard.css" rel="stylesheet">
    <link href="/script/css/sticky-footer-navbar.css" rel="stylesheet">
    <link href="/script/bootstrap/dist/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="/script/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/script/bootstrap/assets/js/vendor/holder.min.js"></script>

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Manage</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login">login</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/reserve/roomReserveIndex">预定</a></li>
                <li><a href="/staffRecord/staffRecordIndex">历史</a></li>
                <li><a href="/roomConfig/roomConfigIndex">配置</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="table-responsive">
                <#nested>
            </div>
        </div>
        <footer class="footer">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <p>powered by swa@jinyan.cao</p>
            </div>
        </footer>
    </div>
</div>


</body>
</html>
</#macro>