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
        <button onclick="close()">取消</button>
    </li>

</ul>

</body>
<script>


    function submitReserve(date, configId, timePeriods) {
        var reserveReason = document.getElementById("reserveReason").value;
        var name = document.getElementById("name").value;
        var phone = document.getElementById("phone").value;
//        jQuery.ajax({
//            type: "GET",
//            url: "/manage/reserveSubmit",
//            data: {
//                encode: encode,
//                date: date,
//                timePeriods: timePeriods,
//                reserveReason: reserveReason,
//                name: name,
//                phone: phone
//            },
//            dataType: "json",
//            success: function (data) {
//                alert(data);
//            }
//        });
//        todo 优化下
        var url = "/manage/reserveSubmit?configId=" + configId + "&reserveDate=" + date + "&timePeriodStr=" + timePeriods + "&reserveReason=" + reserveReason +
                "&reserveStaffName=" + name + "&reserveStaffPhone=" + phone;
        console.info("submitReserve:" + url);
//        window.open(url, "提交页面", 'height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');

    }
</script>
