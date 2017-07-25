<#--<#import "../common/defaultLayout.ftl" as defaultLayout>-->

<#--<@defaultLayout.layout>-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<form class="form-horizontal" role="form" id="dailogForm" name="dailogForm">
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">所在城市:
            <input type="text" name="city" id="city" class="form-control"
                   placeholder="所在城市"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">所属区域:
            <input type="text" name="region" id="region" class="form-control"
                   placeholder="所属区域"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">所在楼层
            <input type="text" name="layer" id="layer" class="form-control"
                   placeholder="所在楼层"/>
        </label>
    </div>
    <div class="form-group mno">
        <label for="inputEmail3" class="col-sm-2 control-label" style="text-align:left;">房间名称
            <input type="text" name="roomName" id="roomName" class="form-control"
                   placeholder="展示名称"/>
        </label>
    </div>
    <input type="button" name="submit" value="保存" onclick="saveConfig()">
</form>

<#--</@defaultLayout.layout>-->
<script>
    function saveConfig() {
        jQuery.ajax({
            type: "GET",
            url: "/roomConfig/roomConfigAdd",
            data: $("#dailogForm").serialize(),
            contentType: "json",
            async: false,
            success: function (data) {
                alert(data);
            }
        });
        window.close();
        window.opener.location.reload();
    }
</script>