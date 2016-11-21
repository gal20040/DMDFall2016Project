<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:template>
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#respisive-menu">
                    <span class="sr-only">Открыть навигацию</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">
                    <i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a>
            </div>
            <div class="collaplse navbar-collapse" id="respisive-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>Login<b class="caret"></b>
                    </a>
                        <ul class="dropdown-menu">
                            <li><a href="sign-in-page.jsp"><i class="fa fa-user" aria-hidden="true"></i>Sign in</a></li>
                            <li class="divider"></li>
                            <li><a href="sign-up-page.jsp"><i class="fa fa-user-plus"  aria-hidden="true"></i>Sign up</a></li>
                        </ul>
                    </li>
                    <li><a href="search"><i class="fa fa-search" aria-hidden="true"></i>Just Search Ticket</a>
                    <li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <br>
            <br>
            <h1>Explore world with us</h1>
        </div>
    </div>
</t:template>