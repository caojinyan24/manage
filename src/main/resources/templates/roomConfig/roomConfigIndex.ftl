<html>
<#import "../common/defaultLayout.ftl" as defaultLayout>

<@defaultLayout.layout>



<table border="1">
    <tr>
        <th>编码:layer-pid</th>
        <th>所属层级</th>
        <th>层级编码:0,1,2</th>
        <th>展示名称</th>
        <th>所在上一层级编码</th>
        <th>是否可用：0-不可用，1-可用</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>

    <#list datas as data>
        <tr>
            <td>${data.encode}</td>
            <td>${data.layer}</td>
            <td>${data.pid}</td>
            <td>${data.roomName}</td>
            <td>${data.pPid}</td>
            <td>${data.validStatus}</td>
            <td>${data.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>${data.updateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>
                <a href="/roomConfig/toEditDialog.do?id=${data.id}">编辑</a>
                <a hidden href="/roomConfig/roomConfigDelete.do?id=${data.id}">删除</a>
                <a href="/roomConfig/roomConfigDetail.do?id=${data.id}">详情</a>
            </td
        </tr>
    </#list>
</table>

</@defaultLayout.layout>
</html>
