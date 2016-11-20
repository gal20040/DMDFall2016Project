<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:template>
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#respisive-menu"> <span class="sr-only">Открыть навигацию</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="index.html"><i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a> </div>
                <div class="collaplse navbar-collapse" id="respisive-menu">
                    <form action="" class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="E-mail" value=""> </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password" value=""> </div>
                        <button type="submit" class="btn btn-primary"> <i class="fa fa-sign-in"></i>ENTER </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</t:template>