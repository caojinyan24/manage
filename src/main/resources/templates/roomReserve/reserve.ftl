<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<body>

<ul>
    <li>预定时期：${date?string("yyyy-MM-dd")}</li>
    <li>预定房间：${roomConfig.roomName}</li>
    <li>预定时段：${showTime}</li>
    <li>申请用途：<input type="text" id="reserveReason" name="reserveReason"/></li>
    <li>申请人姓名：<input type="text" id="name" name="name"/></li>
    <li>申请人手机号：<input type="text" id="phone" name="phone"/></li>
    <li>
        <button onclick="submitReserve('${date?string("yyyy-MM-dd")}',${roomConfig.id},'${timePeriods}')">确定</button>


    </li>
    <li>
        <button onclick="window.close()">取消</button>
    </li>

</ul>

</body>
<script>


    function submitReserve(date, configId, timePeriods) {
        var reserveReason = document.getElementById("reserveReason").value;
        var name = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
        jQuery.ajax({
            type: "GET",
            url: "/manage/reserveSubmit",
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
