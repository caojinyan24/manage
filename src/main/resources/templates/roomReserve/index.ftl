<#import "../common/defaultLayout.ftl" as defaultLayout>

<@defaultLayout.layout>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<form action="/manage/index" method="post" name="search">
    <input name="date" id="date" type="text" value="${date?string("yyyy-MM-dd")}">
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
    <#list records?keys as encode>
        <tr>
            <td>${configs[encode].roomName}</td>
            <#list records[encode] as record>
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
                <button onclick="reserve('${encode}','${date?string("yyyy-MM-dd")}')">申请预定</button>
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

    function reserve(encode, date) {

        var checked = document.getElementsByName("timeChecked");
        var str = "";
        for (var i = 0; i < checked.length; i++) {
            if (checked[i].checked) {
                str = str + "," + checked[i].value;
            }
        }
        str = str.substring(1);
        console.info(str);
        var url = "/manage/reserve?encode=" + encode + "&date=" + date + "&timePeriods=" + str;
        console.info("reserve" + url);
        window.open(url, "房间预定", 'height=800,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }

    function search(date) {
        window.open("/manage/index?date=" + date);
    }
</script>


</@defaultLayout.layout>

<#--页面解析出错会导致页面后续的内容无法加载-->