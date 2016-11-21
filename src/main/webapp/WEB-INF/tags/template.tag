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
    <link rel="stylesheet" href="../../resources/css/font-awesome.min.css ">
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="../../resources/css/style.css">

    <script src="../../resources/script/reserveUtil.js"></script>
    <script src="../../resources/script/jquery-3.1.1.min.js"></script>
    <script src="../../resources/script/validator.min.js"></script>
    <script src="../../resources/script/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../resources/script/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="../../resources/script/bootstrap-datetimepicker.min.js"></script>
</head>

<body>
<div id="myCarousel" class="carousel container slide">
    <div class="carousel-inner">
        <div class="active item one"></div>
        <div class="item two"></div>
        <div class="item three"></div>
    </div>
</div>
<div class="navbar navbar-inverse navbar-fixed-bottom">
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
<script type="text/javascript">
    $(document).ready(function () {
        $('.carousel').carousel({
            interval: 7000
        });
    });
</script>
<br>
<br>
<jsp:doBody/> </body>
</html>