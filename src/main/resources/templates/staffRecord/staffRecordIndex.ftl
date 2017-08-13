<#import "../common/defaultLayout.ftl" as defaultLayout>
<@defaultLayout.layout>

    <table class="table table-striped">
        <thread>
        <tr>
            <th>预定日期</th>
            <th>预定时间</th>
            <th>房间名</th>
            <th>预订人姓名</th>
            <th>预定用途</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th></th>
        </tr>
        </thread>
        <tbody>

        <#list datas as data>
            <tr>
                <td>${data.staffRecord.date?string("yyyy-MM-dd")}</td>
                <td>${data.timeShow}</td>
                <td>${data.roomName}</td>
                <td>${data.staffRecord.staffName}</td>
                <td>${data.staffRecord.comment}</td>
                <td>${data.staffRecord.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td>${data.staffRecord.updateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td>
                    <#if data.staffRecord.validStatus.code==1>
                        <button type="button" onclick="cancel(${data.staffRecord.id})" value="取消">取消</button>
                    <#else >
                        已取消
                    </#if>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
<script>
    function cancel(id) {
        jQuery.ajax({
            url: "/reserve/toCancelReserve",
            data: {"id": id},
            contentType: "json",
            async: false,
            success: function (data) {
                alert(data);
            }

        });
        window.document.location.reload();
    }
</script>

</@defaultLayout.layout>
