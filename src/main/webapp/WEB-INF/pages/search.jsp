<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="ru">--%>

<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<title>Search</title>--%>
<%--<link rel="stylesheet" href="../../resources/css/font-awesome.min.css ">--%>
<%--<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" href="../../resources/css/bootstrap-datetimepicker.min.css">--%>
<%--<link rel="stylesheet" href="../../resources/css/style.css">--%>
<%--<script src="../../resources/js/jquery-3.1.1.min.js"></script>--%>
<%--<script src="../../resources/js/bootstrap.js"></script>--%>
<%--<script src="../../resources/js/validator.min.js"></script>--%>
<%--<script type="text/javascript" src="../../resources/js/moment-with-locales.min.js"></script>--%>
<%--<script src="../../resources/js/bootstrap.min.js"></script>--%>
<%--<script type="text/javascript" src="../../resources/js/bootstrap-datetimepicker.min.js"></script>--%>
<%--</head>--%>

<%--<body style="margin:20px;">--%>
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
                <a class="navbar-brand" href="index.html"><i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a>
            </div>
            <div class="collaplse navbar-collapse" id="respisive-menu">
                <ul class="nav navbar-nav">
                    <li><a href="search"><i class="fa fa-search" aria-hidden="true"></i>Just Search Ticket</a>
                    <li>
                </ul>
            </div>
        </div>
    </div>
    <br>
    <br>
    <%--<form>--%>
    <form:form method="post" action="search" commandName="defaultSearchData">
        <fieldset>
            <legend>Let's Get Ready to Travel!</legend>
            <form:label path="cityName">Enter City Name</form:label>
            <form:input path="cityName" type="text" class="form-control" placeholder="City"/>

            <form:label path="roomType">Room Type</form:label>
            <form:select path="roomType" class="selectpicker form-control">
                <option>Not chosen</option>
                <option>Econom</option>
                <option>Comfort</option>
                <option>Business</option>
            </form:select>

            <form:label path="checkInDate">Check-in Date</form:label>
            <form:input path="checkInDate" type="text" class="form-control" id="datetimepicker4" placeholder="Check-in"/>

            <form:label path="checkOutDate">Check-out Date</form:label>
            <form:input path="checkOutDate" type="text" class="form-control" id="datetimepicker5" placeholder="Check-out"/>

            <label class="checkbox">
                <input type="checkbox"> I am fully agree with everything </label>

                <%--<input type="button" onclick="location.href='reservation.html';" value="Make a reservation" />--%>
            <button type="submit" class="btn">Make a reservation</button>
        </fieldset>
    </form:form>
    <%--</form>--%>

    <%--<c:if test = "${!empty wishfulRoomData}">--%>
    <%--<h5>wishfulRoomData:</h5>--%>
    <%--<table class="book-list-table">--%>
    <%--<tr>--%>
    <%--&lt;%&ndash;<th>ID</th>&ndash;%&gt;--%>
    <%--<th>City</th>--%>
    <%--<th>Room type</th>--%>
    <%--<th>Check in date</th>--%>
    <%--<th>Check out date</th>--%>
    <%--&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<th>&nbsp;</th>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
    <%--</tr>--%>
    <%--&lt;%&ndash;<c:forEach items = "${books}" var = "book">&ndash;%&gt;--%>
    <%--<tr>--%>
    <%--<td>${wishfulRoomData.cityName}</td>--%>
    <%--<td>${wishfulRoomData.roomType}</td>--%>
    <%--<td>${wishfulRoomData.checkInDate}</td>--%>
    <%--<td>${wishfulRoomData.checkOutDate}</td>--%>
    <%--&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><a href="javascript:BookUtil.deleteBook(${book.id})">Delete</a></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
    <%--</tr>--%>
    <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<c:forEach items = "${rooms}" var = "room">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${room.roomID}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${room.typeID}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${room.genre}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;&ndash;%&gt;--%>
    <%--&lt;%&ndash;&lt;%&ndash;<td><a href="javascript:RoomUtil.deleteRoom(${room.roomID})">Delete</a></td>&ndash;%&gt;&ndash;%&gt;--%>
    <%--&lt;%&ndash;&lt;%&ndash;</sec:authorize>&ndash;%&gt;&ndash;%&gt;--%>
    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
    <%--</table>--%>
    <%--</c:if>--%>

    <%--<div class="navbar navbar-inverse navbar-static-bottom">--%>
    <%--<div class="container">--%>
    <%--<div class="navbar-header"> <a class="navbar-brand">Developers</a> </div>--%>
    <%--<div class="collaplse navbar-collapse" id="respisive-menu">--%>
    <%--<ul class="nav navbar-nav">--%>
    <%--<li><a>Anton Zalaldinov</a>--%>
    <%--<li>--%>
    <%--<li><a>Artem Grodetskiy</a>--%>
    <%--<li>--%>
    <%--<li><a>Ilya Zhingalov</a>--%>
    <%--<li>--%>
    <%--</ul>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <script type="text/javascript">
        $(function () {
            $('#datetimepicker4').datetimepicker({
                pickTime: false
                , language: 'en'
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $('#datetimepicker5').datetimepicker({
                pickTime: false
                , language: 'en'
            });
        });
    </script>
</t:template>
<%--</body>--%>
<%--</html>--%>


<%--<t:template>--%>
<%--<form:form method="post" action="search" commandName="defaultSearchData"> &lt;%&ndash;addB ook&ndash;%&gt; &lt;%&ndash;b ookq&ndash;%&gt;--%>
<%--<table>--%>
<%--<tr>--%>
<%--<td><form:label path="cityName">--%>
<%--City--%>
<%--</form:label></td>--%>
<%--<td><form:input path="cityName"/></td>--%>
<%--<td><form:errors cssClass="error" path="cityName"></form:errors></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td><form:label path="roomType">--%>
<%--Room type--%>
<%--</form:label></td>--%>
<%--<td><form:input path="roomType"/></td>--%>
<%--<td><form:errors cssClass="error" path="roomType"></form:errors> </td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan="2"><input type="submit" value="Search room"/></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</form:form>--%>

<%--<c:if test = "${!empty wishfulRoomData}">--%>
<%--<h5>Это запрошенные данные:</h5> &lt;%&ndash;TODO надо решить проблему с кодировкой&ndash;%&gt;--%>
<%--<table class="book-list-table">--%>
<%--<tr>--%>
<%--&lt;%&ndash;<th>ID</th>&ndash;%&gt;--%>
<%--<th>City</th>--%>
<%--<th>Room type</th>--%>
<%--<th>Check in date</th>--%>
<%--<th>Check out date</th>--%>
<%--&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;--%>
<%--&lt;%&ndash;<th>&nbsp;</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
<%--</tr>--%>
<%--<c:forEach items = "${wishfulRoomData}" var = "book">--%>
<%--<tr>--%>
<%--<td>${wishfulRoomData.cityName}</td>--%>
<%--<td>${wishfulRoomData.roomType}</td>--%>
<%--<td>${wishfulRoomData.checkInDate}</td>--%>
<%--<td>${wishfulRoomData.checkOutDate}</td>--%>
<%--&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;--%>
<%--&lt;%&ndash;<td><a href="javascript:BookUtil.deleteBook(${book.id})">Delete</a></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--&lt;%&ndash;<c:forEach items = "${rooms}" var = "room">&ndash;%&gt;--%>
<%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>${room.roomID}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>${room.typeID}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>${room.genre}</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;<td><a href="javascript:RoomUtil.deleteRoom(${room.roomID})">Delete</a></td>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;</sec:authorize>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
<%--</table>--%>
<%--</c:if>--%>
<%--</t:template>--%>