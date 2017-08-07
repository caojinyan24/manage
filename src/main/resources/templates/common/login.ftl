<#import "../common/defaultLayout.ftl" as defaultLayout>
<@defaultLayout.layout>

<div class="container">
    <form class="form-signin">
        <h2 class="form-signin-heading">登录</h2>
        <input id="inputUserName" class="form-control" placeholder="用户名" required autofocus>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login()">登录</button>
    </form>
</div>

</@defaultLayout.layout>

<script>
    function login() {
        var userName = document.getElementById("inputUserName").value;
        var password = document.getElementById("inputPassword").value;
        window.location = "/manage/index?userName=" + userName + "&password=" + password;
    }
</script>

