<nav class="navbar navbar-static-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <%--HOME--%>
            <a href="/" class="navbar-brand">Home</a>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" >
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--Page Links--%>
                <li><a href="/employee">Employee</a></li>
                <li><a href="/project">Project</a></li>
                <li><a href="/contact">Contact</a></li>
                <li><a href="/admin">Admin</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--Login LInk--%>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>