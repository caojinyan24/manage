<#import "../common/defaultLayout.ftl" as defaultLayout>
<@defaultLayout.layout>
<table border="1">
    <tr>
        <th>所在城市</th>
        <th>所属区域</th>
        <th>所在楼层</th>
        <th>房间名称</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <#list datas as data>
        <tr>
            <td>${data.city}</td>
            <td>${data.region}</td>
            <td>${data.layer}</td>
            <td>${data.roomName}</td>
            <td>${data.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>${data.updateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>
                <#if data.validStatus.code==1>
                    <button type="button" onclick="stopReserve(${data.id})">暂停预定</button>
                <#else>
                    <button type="button" onclick="reReserve(${data.id})">恢复预定</button>
                </#if>
            </td
        </tr>
    </#list>
    <button type="button" onclick="addConfig()"
    ">添加配置</a>
</table>
</@defaultLayout.layout>

<script>
    function addConfig() {
        var url = "/roomConfig/toAddDialog";
        console.info("reserve" + url);
        window.open(url, "添加配置", 'height=800,width=600,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }

    function reReserve(id) {
        jQuery.ajax({
            url: "/roomConfig/reReserve",
            type: "GET",
            data: {id: id},
            contentType: "json",
            async: false,
            success: function (data) {
                alert(data);
            }
        });
        window.document.location.reload();
    }
    function stopReserve(id) {
        jQuery.ajax({
            url: "/roomConfig/stopReserve",
            data: {id: id},
            contentType: "json",
            type: "GET",
            async: false,
            success: function (data) {
                alert(data);
            }
        });
        window.document.location.reload();
    }
</script>

