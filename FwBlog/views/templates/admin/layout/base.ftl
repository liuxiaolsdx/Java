<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="Admin page">
    <meta name="author" content="Sean">
    <link rel="icon" href="../../images/Skype.ico">

    <title><@block name="title"></@block></title>

    <!-- Bootstrap core CSS -->
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">

    <link href="../../../css/font-awesome.min.css" rel="stylesheet">
    <link href="../../../css/admin.css" rel="stylesheet">
    <link href="../../../css/simditor.css" rel="stylesheet">
    <link href="../../../css/simditor-markdown.css" rel="stylesheet">

</head>


<body>
<#include "navbar.ftl">

<div class="container main-container">
    <@block name="content"></@block>
</div>



<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../js/ieD10-viewport-bug-workaround.js"></script>
<script src="../../js/bootstrap-paginator.min.js"></script>
<script src="../../js/marked.min.js"></script>
<script src="../../js/module.js"></script>
<script src="../../js/hotkeys.js"></script>
<script src="../../js/to-markdown.js"></script>
<script src="../../js/simditor.js"></script>
<script src="../../js/simditor-markdown.js"></script>
</body>
</html>