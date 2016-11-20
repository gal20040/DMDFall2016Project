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
    <%--<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">--%>
    <table id="grid-basic" class="table table-condensed table-hover table-striped">
        <thead>
        <tr>
                <%--<th data-column-id="hotelid" data-type="numeric" data-identifier="true">Hotel ID</th>--%>
            <th data-column-id="hotel" data-identifier="true">Hotel</th>
            <th data-column-id="Address">Address</th>
                <%--<th data-column-id="RoomID" data-type="numeric" data-order="desc">Room ID</th>--%>
            <th data-column-id="Room-Type" data-order="desc">Room Type</th>
            <th data-column-id="Price" data-formatter="link" data-sortable="false">Price</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
            <c:if test="${!empty dbResponse}">
            <c:forEach items="${dbResponse}" var="result">
            <%--<form:form class="form-horizontal" method="post" id="form" action="reserver" commandName="result">--%>
            <%--<form:input disabled="true" type="text" path="hrID"/>${result.hrID}--%>
            <%--<form:input disabled="true" type="text" path="hotelID"/>${result.hotelID}--%>
            <%--<form:input disabled="true" type="text" path="roomID"/>${result.roomID}--%>
            <%--<form:input disabled="true" type="text" path="price"/>${result.price}--%>
            <%--<button type="submit" id="submit" class="btn btn-primary">--%>
            <%--Reserve--%>
            <%--</button>--%>
            <%--</form:form>--%>
        <tr>
                <%--<td>${result.hrID}</td>--%>
                <%--<td>${result.hotelID}</td>--%>
            <td>${result.hotelName}</td>
            <td>${result.address}</td>
                <%--<td>${result.roomID}</td>--%>
            <td>${result.roomType}</td>
            <td>${result.price}</td>
            <td>
                    <%--<a href="javascript:BookUtil.deleteBook(${result.hotelID})">Reserve1 </a>--%>

                <a href="javascript:reserveUtil.reserveRoom(${result.hotelName})">Reserve room</a>
                    <%--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"> Choose this room </button>--%>
            </td>
            <!-- Modal -->
        </tr>
            </c:forEach>
            </c:if>
        </tbody>
    </table>
    <!-- Button trigger modal -->
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">System message</h4></div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                    <button type="button" class="btn btn-primary">Yes</button>
                </div>
            </div>
        </div>
    </div>

</t:template>