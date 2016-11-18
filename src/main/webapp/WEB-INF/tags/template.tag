<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>InnoHotel</title>

    <!-- Bootstrap -->
    <%--<link href="<c:url value=" /resources/css/main.css " />" rel="stylesheet">--%>
    <link href="<c:url value=" /resources/css/bootstrap.css " />" rel="stylesheet">
    <link href="<c:url value=" /resources/css/font-awesome.css " />" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/css/font-awesome.min.css ">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../resources/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">

    <script src="<c:url value=" /resources/script/bookUtil.js"/>"></script>
    <script type="text/javascript" src="../../resources/script/jquery-1.11.1.min.js"></script>
    <script src="../../resources/script/jquery-3.1.1.min.js"></script>
    <script src="../../resources/script/bootstrap.js"></script>
    <script src="../../resources/script/validator.min.js"></script>
    <script type="text/javascript" src="../../resources/script/moment-with-locales.min.js"></script>
    <script src="../../resources/script/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../resources/script/bootstrap-datetimepicker.min.js"></script>
</head>

<body style="margin:20px;">
<jsp:doBody/>
<div class="navbar navbar-inverse navbar-static-bottom">
    <div class="container">
        <div class="navbar-header"> <a class="navbar-brand">Developers</a> </div>
        <div class="collaplse navbar-collapse" id="respisive-menu">
            <ul class="nav navbar-nav">
                <li><a>Anton Zalaldinov</a>
                <li>
                <li><a>Artem Grodetskiy</a>
                <li>
                <li><a>Ilya Zhingalov</a>
                <li>
            </ul>
        </div>
    </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../resources/script/jquery.min.js"></script>
<!--    <script src="js/bootstrap.js"></script>-->
<script src="<c:url value=" /resources/script/bootstrap.js " />"></script>
</body>
</html>