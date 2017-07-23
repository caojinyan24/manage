<#import "../common/defaultLayout.ftl" as defaultLayout>

<@defaultLayout.layout>

<table border="1">
    <tr>
        <th>预定日期</th>
        <th>预定时间段，如0代表00:00-00:30，1代表00:30-1:00</th>
        <th>编码:layer-pid</th>
        <th>人员预定表中关联id</th>
        <th>是否已取消：0-取消，1-未取消</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <tr>
    <tr>

        <#list datas as data>
            <td>${data.date?string("yyyy-MM-dd")}</td>
            <td>${data.timePeriod}</td>
            <td>${data.configId}</td>
            <td>${data.staffRecordId}</td>
            <td>${data.validStatus}</td>
            <td>${data.createTime?string("yyyy-MM-dd HH:mm:ss")})</td>
            <td>${data.updateTime?string("yyyy-MM-dd HH:mm:ss")})</td>
            <td class="last">
                <a href="/roomRecord/toEditDialog.do?id=$!{data.id}','编辑用户')">编辑</a>
                <a href="/roomRecord/roomRecordDelete.do?id=$!{data.id}')">删除</a>
                <a href="../roomRecord/roomRecordDetail.do?id=$!{data.id}">详情</a>
            </td>
        </#list>
    </tr>
</table>

<#--</div>-->
<#--</div>-->
<#--</form>-->
<#--</div>-->
</@defaultLayout.layout>
