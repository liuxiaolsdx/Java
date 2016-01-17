<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Sean">
    <link rel="icon" href="../../../images/Skype.ico">

    <title>登录微博</title>

    <!-- Bootstrap core CSS -->
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <form action="admin/login" method="post" class="form-signin">
        <h2 class="form-signin-heading">请登录</h2>

        <label for="inputUserName" class="sr-only">用户名</label>
        <input name="account" type="text" id="inputUserName" class="form-control" placeholder="用户名" required autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="密码" required>

        <input class="btn btn-lg btn-primary btn-block" type="submit" value="登录"/>
        <input class="btn btn-lg btn-primary btn-block" type="reset" value="取消"/>


    </form>
</div>
</body>
</html>