<@override name = "title">Admin Homepage</@override>

<@override name = "link">
<link href="http://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">
</@override>

<@override name = "content">
<div class="container">

    <form action="/admin/access" method="post" class="form-signin">
        <h2 class="form-signin-heading">请登录</h2>

        <label for="inputUserName" class="sr-only">用户名</label>
        <input name="account" type="text" id="inputUserName" class="form-control" placeholder="用户名" required autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>

        <input class="btn btn-lg btn-primary btn-block" type="submit" value="登录"/>
        <input class="btn btn-lg btn-primary btn-block" type="reset" value="取消"/>


    </form>
</div>
</@override>

<@extends name = "templates/admin/layout/base.ftl" />