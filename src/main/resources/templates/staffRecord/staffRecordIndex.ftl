<form role="form" class="form-inline" action="../staffRecord/staffRecordIndex.do" method="post" id="formSubmit">
    <div class="col-md-10" style="width:100%">
        <div class="panel panel-default">
            <div class="panel-heading">人员预定记录表列表</div>
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
                        <label for="startTime"
                               class="control-label col-sm-3 line34">预定开始时间</label>
                        <div class="col-sm-8">
                            <input type="text" name="startTime"
                                   id="startTime"
                                   value="${staffRecord.startTime}" class="form-control"
                                   placeholder="预定开始时间">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="endTime"
                               class="control-label col-sm-3 line34">预定结束时间</label>
                        <div class="col-sm-8">
                            <input type="text" name="endTime"
                                   id="endTime"
                                   value="${staffRecord.endTime}" class="form-control"
                                   placeholder="预定结束时间">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="encode"
                               class="control-label col-sm-3 line34">编码:layer-pid</label>
                        <div class="col-sm-8">
                            <input type="text" name="encode"
                                   id="encode"
                                   value="${staffRecord.encode}" class="form-control"
                                   placeholder="编码:layer-pid">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="isvalid"
                               class="control-label col-sm-3 line34">是否已取消：0-取消，1-未取消</label>
                        <div class="col-sm-8">
                            <input type="text" name="isvalid"
                                   id="isvalid"
                                   value="${staffRecord.isvalid}" class="form-control"
                                   placeholder="是否已取消：0-取消，1-未取消">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="staffName"
                               class="control-label col-sm-3 line34">预订人姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="staffName"
                                   id="staffName"
                                   value="${staffRecord.staffName}" class="form-control"
                                   placeholder="预订人姓名">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="comment"
                               class="control-label col-sm-3 line34">预定用途</label>
                        <div class="col-sm-8">
                            <input type="text" name="comment"
                                   id="comment"
                                   value="${staffRecord.comment}" class="form-control"
                                   placeholder="预定用途">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="createTime"
                               class="control-label col-sm-3 line34">创建时间</label>
                        <div class="col-sm-8">
                            <input type="text" name="createTime"
                                   id="createTime"
                                   value="${data.createTime?string("yyyy-MM-dd HH:mm:ss")}"
                                   class="form-control" placeholder="创建时间">
                        </div>
                    </div>
                    <div class="form-group col-sm-3">
                        <label for="updateTime"
                               class="control-label col-sm-3 line34">更新时间</label>
                        <div class="col-sm-8">
                            <input type="text" name="updateTime"
                                   id="updateTime"
                                   value="${data.updateTime?string("yyyy-MM-dd HH:mm:ss")}"
                                   class="form-control" placeholder="更新时间">
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <button type="submit" class="btn btn-primary">搜 索</button>
                </div>
                <div id="legend">
                    <legend class="le">
                        <button type="button" class="btn btn-primary"
                                onclick="remoteUrl('../staffRecord/toAddDialog.do','新增用户')">新增
                        </button>
                    </legend>
                </div>
                <table class="table table-striped">
                    <tr>
                        <th>预定日期</th>
                        <th>预定开始时间</th>
                        <th>预定结束时间</th>
                        <th>编码:layer-pid</th>
                        <th>是否已取消：0-取消，1-未取消</th>
                        <th>预订人姓名</th>
                        <th>预定用途</th>
                        <th>创建时间</th>
                        <th>更新时间</th>
                        <th>操作</th>
                    </tr>

                    <tr>
                    <#list datas as data>
                        <td>${data.date?string("yyyy-MM-dd")}</td>
                        <td>${info.startTime}</td>
                        <td>${info.endTime}</td>
                        <td>${info.encode}</td>
                        <td>${info.isvalid}</td>
                        <td>${info.staffName}</td>
                        <td>${info.comment}</td>
                        <td>${data.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${data.updateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>
                            <a href="/staffRecord/toEditDialog.do?id=$!{info.id}','编辑用户')">编辑</a>
                            <a href="/staffRecord/staffRecordDelete.do?id=$!{info.id}')">删除</a>
                            <a href="/staffRecord/staffRecordDetail.do?id=$!{info.id}">详情</a>
                        </td>
                    </#list>
                    </tr>
                </table>
                <div class="text-right">
                    <!--公用翻页代码-->
                    #set($attr='formSubmit')
                    #showPageList($pageInfos $attr)
                    <!--END公用翻页代码-->
                </div>
            </div>
        </div>
    </div>
</form>
#parse("common/modal.vm")

<script type="text/javascript">
    $(document).ready(function () {
        $("#addButton").bind("click", function () {
            location.href = "../staffRecord/toAdd.do";
        });
        $("#dialogFormSubmit").bind("click", function () {
            $("#btn_sub").click();
        });
    });

</script>