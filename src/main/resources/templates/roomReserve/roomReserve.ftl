<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<form class="form-horizontal" role="form" id="dailogForm" name="dailogForm">
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">预定时期：
            <input type="text" name="reserveDate" id="reserveDate" class="form-control" readonly="readonly"
                   value="${date?string("yyyy-MM-dd")}"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">预定房间：
            <input type="text" name="roomName" id="roomName" class="form-control" readonly="readonly"
                   value="${roomConfig.roomName}"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">预定时段：
            <input type="text" name="time" id="time" class="form-control" readonly="readonly"
                   value="${showTime}"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">申请用途：
            <input type="text" name="reserveReason" id="reserveReason" class="form-control"
                   placeholder="申请用途"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">申请人姓名：
            <input type="text" name="name" id="name" class="form-control"
                   placeholder="申请人姓名"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">申请人手机号：
            <input type="text" name="phone" id="phone" class="form-control"
                   placeholder="手机号"/>
        </label>
    </div>
    <button onclick="submitReserve('${date?string("yyyy-MM-dd")}',${roomConfig.id},'${timePeriods}')">确定</button>
    <button onclick="window.close()">取消</button>
</form>

<script>
    function submitReserve(date, configId, timePeriods) {
        var reserveReason = document.getElementById("reserveReason").value;
        var name = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
        jQuery.ajax({
            type: "GET",
            url: "/reserve/reserveSubmit",
            data: {
                configId: configId,
                reserveDate: date,
                timePeriodStr: timePeriods,
                reserveReason: reserveReason,
                reserveStaffName: name,
                reserveStaffPhone: phone
            },
            contentType: "json",
            async: false,
            success: function (data) {
                alert(data);
            }
        });
        window.close();
        window.opener.document.location.reload();
    }
</script>
