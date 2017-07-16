<html>
<#import "../common/defaultLayout.ftl" as defaultLayout>

<@defaultLayout.layout>


<#--<select id="startYear" name="startYear">-->
<#--<option value="2012">2012年</option>-->
<#--<option value="2013" selected="selected">2013年</option>-->
<#--<option value="2014">2014年</option>-->
<#--<option value="2015">2015年</option>-->
<#--</select>-->


<table>
    <tr>
        <td>房间编码</td>
        <#list timePeriods as timePeriod>
            <th>${timePeriod}</th>
        </#list>
        <th></th>

    </tr>
    <#list records?keys as encode>
        <tr>
            <td>${encode}</td>
            <#list records[encode] as record>
                <#if record.isvalid==0>
                <#--<td><a href="">预定</a></td>-->
                    <td width="4%" height="26" align="center">
                        <input type="checkbox" name="timeChecked" id="timeChecked"
                               value=${record.timePeriod}>
                    </td>
                <#else>
                    <td></td>
                </#if>
            </#list>
            <td>
                <button onclick="reserve('${encode}','${date}')">申请预定</button>
            </td>

        </tr>
    </#list>
</table>


<script>
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
</script>
</@defaultLayout.layout>
</html>

<#--页面解析出错会导致页面后续的内容无法加载-->