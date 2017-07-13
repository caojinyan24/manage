<div class="col-md-10" style="width:100%">
    <div class="panel panel-default minHeight">
        <div class="panel-heading">查看详情</div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <fieldset disabled>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label"
                               style="text-align:left;">编码:layer-pid</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.encode}" name="encode" id="encode"
                                   class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label" style="text-align:left;">所属层级</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.layer}" name="layer" id="layer"
                                   class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label"
                               style="text-align:left;">层级编码:0,1,2</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.pid}" name="pid" id="pid" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label" style="text-align:left;">展示名称</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.roomName}" name="roomName" id="roomName" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label"
                               style="text-align:left;">所在上一层级编码</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.pPid}" name="pPid" id="pPid" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label"
                               style="text-align:left;">是否可用：0-不可用，1-可用</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.isvalid}" name="isvalid" id="isvalid"
                                   class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label" style="text-align:left;">创建时间</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.createTime?string("yyyy-MM-dd HH:mm:ss")}"
                            name="createTime" id="createTime" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group mno">
                        <label for="inputEmail3" class="col-sm-1 control-label" style="text-align:left;">更新时间</label>
                        <div class="col-sm-2">
                            <input type="text" value="${roomConfig.updateTime?string("yyyy-MM-dd HH:mm:ss")}"
                            name="updateTime" id="updateTime" class="form-control"/>
                        </div>
                    </div>
                </fieldset>
                <div class="form-group">
                    <span class="col-sm-1"></span>
                    <a href="#" class="btn btn-primary" id="returnButton" role="button">返回</a>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $("#returnButton").bind("click", function () {
        window.opener.location.reload();
    });
</script>