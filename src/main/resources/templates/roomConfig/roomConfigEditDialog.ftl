<div class="panel-body">
    <form class="form-horizontal" role="form" id="dailogForm" action="../roomConfig/roomConfigEdit.do" method="POST">
        <input type="hidden" id="btn_sub" class="btn_sub"/>
        <input type="hidden" value="$!{roomConfig.id}" name="id" id="id"/>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">编码:layer-pid</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.encode}" name="encode" id="encode" class="form-control"
                       placeholder="编码:layer-pid"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">所属层级</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.layer}" name="layer" id="layer" class="form-control"
                       placeholder="所属层级"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">层级编码:0,1,2</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.pid}" name="pid" id="pid" class="form-control"
                       placeholder="层级编码:0,1,2"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">展示名称</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.roomName}" name="roomName" id="roomName" class="form-control"
                       placeholder="展示名称"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">所在上一层级编码</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.pPid}" name="pPid" id="pPid" class="form-control"
                       placeholder="所在上一层级编码"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">是否可用：0-不可用，1-可用</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.isvalid}" name="isvalid" id="isvalid" class="form-control"
                       placeholder="是否可用：0-不可用，1-可用"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">创建时间</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.createTime?string("yyyy-MM-dd HH:mm:ss")}" name="createTime"
                id="createTime" class="form-control" placeholder="创建时间"/>
            </div>
        </div>
        <div class="form-group mno">
            <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">更新时间</label>
            <div class="col-sm-8">
                <input type="text" value="${roomConfig.updateTime?string("yyyy-MM-dd HH:mm:ss")}" name="updateTime"
                id="updateTime" class="form-control" placeholder="更新时间"/>
            </div>
        </div>
    </form>
</div>
