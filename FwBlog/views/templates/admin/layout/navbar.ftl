<nav class="navbar navbar-fixed-top navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapse" type="button" data-toggle="collapse" aria-expanded="false" ,
                    aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin">
                <span>
                <@block name="SiteName"></@block>
                </span>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li><a href="/admin/posts">Posts</a></li>
                <li><a href="/admin/settings">Settings</a></li>
                <li><a href="/admin/profile">Profile</a></li>
                <li><a href="/">Site Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-user">
                <li>
                    <a href="javascript:$('#form').submit();">Logout</a>
                    <form id="form" style="visibility: hidden" method="post" action="/logout">
                        <input type="hidden" name="user" value="${user.account}"/>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>