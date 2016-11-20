<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:template>
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#respisive-menu"> <span class="sr-only">Открыть навигацию</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="/"><i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a> </div>
            <div class="collaplse navbar-collapse" id="respisive-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-spinner fa-spin" aria-hidden="true"></i>Login<b class="caret"></b></a>
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
    <%--<div id="carousel" class="carousel slide">--%>
        <%--<!-- индикаторы слайдов-->--%>
        <%--<ol class="carousel-indicators">--%>
            <%--<li class="active" data-target="#carousel" data-slide-to="0"></li>--%>
            <%--<li data-target="#carousel" data-slide-to="1"> </li>--%>
            <%--<li data-target="#carousel" data-slide-to="2"></li>--%>
        <%--</ol>--%>
        <%--<!-- слайды-->--%>
        <%--<div class="carousel-inner">--%>
            <%--<div class="item active"> <img src="<c:url value=" /resources/images/Moscow.jpg " />"  alt="">--%>
                <%--<div class="carousel-caption">--%>
                    <%--<h3>Russia</h3>--%>
                    <%--<p>Moscow</p>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="item"> <img src="<c:url value=" /resources/images/Miami.jpg " />" alt="">--%>
                <%--<div class="carousel-caption">--%>
                    <%--<h3>USA</h3>--%>
                    <%--<p>Miami</p>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="item"> <img src="<c:url value=" /resources/images/Paris.jpg " />" alt="">--%>
                <%--<div class="carousel-caption">--%>
                    <%--<h3>France</h3>--%>
                    <%--<p>Paris</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<!-- стрелки переключиения слайдов-->--%>
        <%--<a href="#carousel" class="left carousel-control" data-slide="prev"> <span class="glyphicon glyphicon-shevron-left"></span> </a>--%>
        <%--<a href="#carousel" class="right carousel-control " data-slide="next"> <span class="glyphicon glyphicon-shevron-right"></span> </a>--%>
    <%--</div>--%>
    <%--<c:if test = "${!empty allRecords}">--%>
        <%--<table class="book-list-table">--%>
            <%--<tr>--%>
                <%--<th>ID</th>--%>
                <%--<th>Name</th>--%>
                <%--<th>Genre</th>--%>
                <%--<sec:authorize access="hasRole('admin')">--%>
                    <%--<th>&nbsp;</th>--%>
                <%--</sec:authorize>--%>
            <%--</tr>--%>
            <%--<c:forEach items = "${allRecords}" var = "book">--%>
                <%--<tr>--%>
                    <%--<td>${book.id}</td>--%>
                    <%--<td>${book.name}</td>--%>
                    <%--<td>${book.genre}</td>--%>
                    <%--<sec:authorize access="hasRole('admin')">--%>
                        <%--&lt;%&ndash;удаление не работает почему-то - вроде бы починилось&ndash;%&gt;--%>
                        <%--<td><a href="javascript:BookUtil.delete(${book.id})">Delete</a></td>--%>
                    <%--</sec:authorize>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
        <%--</table>--%>
    <%--</c:if>--%>
    <%--<sec:authorize access="isAuthenticated()">--%>
    <%--<a href="search">Search room</a>--%>
    <%--</sec:authorize>--%>
        
        <%--<div class="login-link-container">--%>
            <%--<sec:authorize access="isAnonymous()">--%>
                <%--<p> <a href="/spring_security_login">Sign In</a> </p>--%>
            <%--</sec:authorize>--%>
            <%--<sec:authorize access="isAuthenticated()">--%>
                <%--<a href="/j_spring_security_logout">Sign Out</a>--%>
            <%--</sec:authorize>--%>
        <%--</div>--%>
</t:template>