<#macro layout>
<!DOCTYPE html>
<html lang="zh-CN">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link type="text/css" rel="stylesheet" href="/script/css/signin.css">
<link type="text/css" rel="stylesheet" href="/script/bootstrap/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<#--<div style="text-align:center; font-size:30px;">-->
    <#include "header.ftl">

    <#include "sidebar.ftl">

<div class="panel-body" style="width:90%; float:right; ">
    <#nested>
</div>

</html>
</#macro>
