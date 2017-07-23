<#import "../common/defaultLayout.ftl" as defaultLayout>

<@defaultLayout.layout>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<form action="/manage/index" method="post" name="search">
    <input name="date" id="date" type="text" value="${searchVo.date?string("yyyy-MM-dd")}">
    <select name="city" onchange="submit">
    <#--地区-->
        <option value=""></option>
        <#list citys as cityItem>
            <#if  (searchVo.city!"北京")==cityItem>
                <option value="${cityItem}" selected="selected">${cityItem}</option>
            <#else>
                <option value="${cityItem}">${cityItem}</option>
            </#if>
        </#list>
    </select>
    <select name="region">
        <option value=""></option>
        <#list regions as regionItem>
            <#if (searchVo.region!"互联网")==regionItem>
                <option value="${regionItem}" selected="selected">${regionItem}</option>
            <#else>
                <option value="${regionItem}">${regionItem}</option>
            </#if>
        </#list>
    </select>
    <input type="submit" value="搜索"/>
</form>


<table>
    <tr>
        <td>房间编码</td>
        <#list timePeriods?values as timePeriod>
            <th>${timePeriod}</th>
        <#--<th>${timePeriods}</th>-->
        <#--<th>${timePeriods.get(timePeriod)}</th>-->
        </#list>
        <th></th>

    </tr>
    <#list recordInfoVos as recordInfoVo>
        <tr>
            <td>${recordInfoVo.roomConfig.roomName}</td>
            <#list recordInfoVo.roomRecords as record>
                <#if record.validStatus.code==1>
                    <td width="4%" height="26" align="center">
                        <input type="checkbox" name="timeChecked" id="timeChecked"
                               value=${record.timePeriod.code}>
                    </td>
                <#else>
                    <td></td>
                </#if>
            </#list>
            <td>
                <button onclick="reserve('${recordInfoVo.roomConfig.id}','${searchVo.date?string("yyyy-MM-dd")}')">申请预定
                </button>
            <#--date转成String-->
            <#--date加‘’转成String，否则使用date格式转成get请求的时候会自动把date转成String，这样转换的结果是错误的-->
            </td>

        </tr>
    </#list>
</table>

<script>
    $(function () {
        $("#date").datepicker({dateFormat: "yy-mm-dd"});
    });

    function reserve(configId, date) {

        var checked = document.getElementsByName("timeChecked");
        var str = "";
        for (var i = 0; i < checked.length; i++) {
            if (checked[i].checked) {
                str = str + "," + checked[i].value;
            }
        }
        str = str.substring(1);
        console.info(str);
        var url = "/manage/reserve?configId=" + configId + "&date=" + date + "&timePeriods=" + str;
        console.info("reserve" + url);
        window.open(url, "房间预定", 'height=800,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }


</script>




</@defaultLayout.layout>

<#--页面解析出错会导致页面后续的内容无法加载-->