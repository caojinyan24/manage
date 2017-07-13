<#macro layout>
<html>
<head>
</head>
<body>
<div style="text-align:center; font-size:30px;">
    <#include "header.ftl">

    <#include "sidebar.ftl">
    <div class="panel-body" style="width:90%; float:right; ">

        <#nested>

    </div>

</div>
</body>
    <#--<#include "footer.ftl">-->

</html>
</#macro>