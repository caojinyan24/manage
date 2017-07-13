<form role="form" class="form-inline" action="../roomRecord/roomRecordIndex.do" method="post" id="formSubmit">
    <div class="col-md-10" style="width:100%">
        <div class="panel panel-default">
            <div class="panel-heading">会议室预定记录表列表</div>
            <div class="panel-body">
                <div class="search">
                    <div class="form-group col-sm-3">
                        <label for="date"
                               class="control-label col-sm-3 line34">预定日期</label>
                        <div class="col-sm-8">
                            <input type="text" name="date"
                                   id="date"
                                   value="${data.date?string("yyyy-MM-dd")}"
                                   class="form-control" placeholder="预定日期">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="timePeriod"
                               class="control-label col-sm-3 line34">预定时间段，如0代表00:00-00:30，1代表00:30-1:00</label>
                        <div class="col-sm-8">
                            <input type="text" name="timePeriod"
                                   id="timePeriod"
                                   value="${roomRecord.timePeriod}" class="form-control"
                                   placeholder="预定时间段，如0代表00:00-00:30，1代表00:30-1:00">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="encode"
                               class="control-label col-sm-3 line34">编码:layer-pid</label>
                        <div class="col-sm-8">
                            <input type="text" name="encode"
                                   id="encode"
                                   value="${roomRecord.encode}" class="form-control"
                                   placeholder="编码:layer-pid">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="staffRecordId"
                               class="control-label col-sm-3 line34">人员预定表中关联id</label>
                        <div class="col-sm-8">
                            <input type="text" name="staffRecordId"
                                   id="staffRecordId"
                                   value="${roomRecord.staffRecordId}" class="form-control"
                                   placeholder="人员预定表中关联id">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="isvalid"
                               class="control-label col-sm-3 line34">是否已取消：0-取消，1-未取消</label>
                        <div class="col-sm-8">
                            <input type="text" name="isvalid"
                                   id="isvalid"
                                   value="${roomRecord.isvalid}" class="form-control"
                                   placeholder="是否已取消：0-取消，1-未取消">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="createTime"
                               class="control-label col-sm-3 line34">创建时间</label>
                        <div class="col-sm-8">
                            <input type="text" name="createTime"
                                   id="createTime"
                                   value="${roomRecord.createTime?string("yyyy-MM-dd HH:mm:ss")}"
                                   class="form-control" placeholder="创建时间">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="updateTime"
                               class="control-label col-sm-3 line34">更新时间</label>
                        <div class="col-sm-8">
                            <input type="text" name="updateTime"
                                   id="updateTime"
                                   value="${roomRecord.updateTime?string("yyyy-MM-dd HH:mm:ss")}"
                                   class="form-control" placeholder="更新时间">
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <button type="submit" class="btn btn-primary">搜 索</button>
                </div>

                <table class="table table-striped">
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
                        <td>${data.encode}</td>
                        <td>${data.staffRecordId}</td>
                        <td>${data.isvalid}</td>
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
            </div>
        </div>
    </div>
</form>
#parse("common/modal.vm")

<script type="text/javascript">
    $(document).ready(function () {
        $("#addButton").bind("click", function () {
            location.href = "../roomRecord/toAdd.do";
        });
        $("#dialogFormSubmit").bind("click", function () {
            $("#btn_sub").click();
        });
    });

</script>