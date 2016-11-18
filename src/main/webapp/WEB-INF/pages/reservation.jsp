<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
</t:template>