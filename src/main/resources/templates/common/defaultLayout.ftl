<#macro layout>
<html>

<#--<div style="text-align:center; font-size:30px;">-->
    <#include "header.ftl">

    <#include "sidebar.ftl">

<div class="panel-body" style="width:90%; float:right; ">
    <#nested>
</div>

<#--<#include "footer.ftl">-->


<#--</div>-->

</html>
</#macro>
