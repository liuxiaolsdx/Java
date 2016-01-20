<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="Admin page">
    <meta name="author" content="Sean">
    <link rel="icon" href="../../../images/Skype.ico">

    <title><@block name="title"></@block></title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../../css/admin.css" rel="stylesheet">
    <link href="../../../bower_components/simditor/styles/simditor.css" rel="stylesheet">
    <link href="../../../bower_components/simditor-markdown/styles/simditor-markdown.css" rel="stylesheet">
    <@block name = "link"></@block>
</head>


<body>
<#include "templates/admin/layout/navbar.ftl">

<@block name="content"></@block>


<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/3.0.0-beta1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.2/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../../js/ie10-viewport-bug-workaround.js"></script>
<script src="../../../js/bootstrap-paginator.min.js"></script>
<script src="https://cdn.bootcss.com/marked/0.3.5/marked.min.js"></script>
<script src="../../../bower_components/simple-module/lib/module.js"></script>
<script src="../../../bower_components/simple-hotkeys/lib/hotkeys.js"></script>
<script src="../../../bower_components/to-markdown/dist/to-markdown.js"></script>
<script src="../../../bower_components/simditor/lib/simditor.js"></script>
<script src="../../../bower_components/simditor-markdown/lib/simditor-markdown.js"></script>
</body>
</html>