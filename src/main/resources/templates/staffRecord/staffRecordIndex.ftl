<#import "../common/defaultLayout.ftl" as defaultLayout>
<@defaultLayout.layout>

<table border="1">
    <tr>
        <th>预定日期</th>
        <th>预定时间</th>
        <th>编码:layer-pid</th>
        <th>是否已取消：0-取消，1-未取消</th>
        <th>预订人姓名</th>
        <th>预定用途</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th></th>
    </tr>


    <#list datas as data>
        <tr>
            <td>${data.date?string("yyyy-MM-dd")}</td>
            <td>${data.timePeriodList}</td>
            <td>${data.encode}</td>
            <td>${data.validStatus}</td>
            <td>${data.staffName}</td>
            <td>${data.comment}</td>
            <td>${data.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>${data.updateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>
                <#if data.validStatus.code==1>
                    <button type="button" onclick="cancel(${data.id})" value="取消">取消</button>
                </#if>
            </td>
        </tr>
    </#list>

</table>

<script>
    function cancel(id) {
        window.open("/manage/toCancelReserve?id=" + id);

    }
</script>

</@defaultLayout.layout>
