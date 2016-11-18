<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<!DOCTYPE html>--%>
<%--<html lang="ru">--%>

<%--<head>--%>
<%--<meta charset="utf-8">--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--<title>Reservation Page</title>--%>
<%--<link rel="stylesheet" href="../../resources/css/font-awesome.min.css ">--%>
<%--<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">--%>
<%--<link rel="stylesheet" href="../../resources/css/bootstrap-datetimepicker.min.css">--%>
<%--<script type="text/javascript" src="../../resources/script/jquery-1.11.1.min.js"></script>--%>
<%--<script type="text/javascript" src="../../resources/script/moment-with-locales.min.js"></script>--%>
<%--<script type="text/javascript" src="../../resources/script/bootstrap.min.js"></script>--%>
<%--<script type="text/javascript" src="../../resources/script/bootstrap-datetimepicker.min.js"></script>--%>
<%--</head>--%>

<%--<body style="margin:10px;">--%>
<t:template>
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#respisive-menu"> <span class="sr-only">Открыть навигацию</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="index.html"><i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a> </div>
            <div class="collaplse navbar-collapse" id="respisive-menu">
                <ul class="nav navbar-nav">
                    <li><a href="search"><i class="fa fa-arrow-left" aria-hidden="true"></i>Back</a>
                    <li>
                </ul>
            </div>
        </div>
    </div>
    <br>
    <br>
    <h3><i class="fa fa-bed" aria-hidden="true"></i>Choose your room</h3>
    <%--<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">--%>
    <table id="grid-basic" class="table table-condensed table-hover table-striped">
        <thead>
        <tr>
            <th data-column-id="hotelid" data-type="numeric" data-identifier="true">Hotel ID</th>
            <th data-column-id="hotel" data-identifier="true">Hotel</th>
            <th data-column-id="Address">Address</th>
            <th data-column-id="RoomID" data-type="numeric" data-order="desc">Room ID</th>
            <th data-column-id="Room-Type" data-order="desc">Room Type</th>
            <th data-column-id="Price" data-formatter="link" data-sortable="false">Price</th>
        </tr>
        </thead>
        <tbody>
        <c:if test = "${!empty dbResponse}">
            <c:forEach items = "${dbResponse}" var = "result">
                <tr>
                    <td>${result.hotelID}</td>
                    <td>${result.hotelName}</td>
                    <td>${result.address}</td>
                    <td>${result.roomID}</td>
                    <td>${result.roomType}</td>
                    <td>${result.price}</td>
                        <%--<sec:authorize access="hasRole('admin')">--%>
                        <%--<td><a href="javascript:BookUtil.deleteBook(${book.id})">Delete</a></td>--%>
                        <%--</sec:authorize>--%>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <%--<script type="text/javascript">--%>
    <%--$("#grid-keep-selection").bootgrid({--%>
    <%--ajax: true--%>
    <%--, post: function () {--%>
    <%--/* To accumulate custom parameter with the request object */--%>
    <%--return {--%>
    <%--id: "b0df282a-0d67-40e5-8558-c9e93b7befed"--%>
    <%--};--%>
    <%--}--%>
    <%--, url: "/api/data/basic"--%>
    <%--, selection: true--%>
    <%--, multiSelect: true--%>
    <%--, rowSelect: true--%>
    <%--, keepSelection: true--%>
    <%--, formatters: {--%>
    <%--"link": function (column, row) {--%>
    <%--return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";--%>
    <%--}--%>
    <%--}--%>
    <%--}).on("selected.rs.jquery.bootgrid", function (e, rows) {--%>
    <%--var rowIds = [];--%>
    <%--for (var i = 0; i < rows.length; i++) {--%>
    <%--rowIds.push(rows[i].id);--%>
    <%--}--%>
    <%--alert("Select: " + rowIds.join(","));--%>
    <%--}).on("deselected.rs.jquery.bootgrid", function (e, rows) {--%>
    <%--var rowIds = [];--%>
    <%--for (var i = 0; i < rows.length; i++) {--%>
    <%--rowIds.push(rows[i].id);--%>
    <%--}--%>
    <%--alert("Deselect: " + rowIds.join(","));--%>
    <%--});--%>
    <%--</script>--%>
</t:template>
<%--</body>--%>
<%--</html>--%>