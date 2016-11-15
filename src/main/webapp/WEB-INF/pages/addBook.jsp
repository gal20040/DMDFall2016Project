<%--<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--<t:template>--%>
    <%--<form:form method="post" action="search" commandName="bookq"> &lt;%&ndash;addBook&ndash;%&gt;--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<td><form:label path="name">--%>
                    <%--City--%>
                <%--</form:label></td>--%>
                <%--<td><form:input path="name"/></td>--%>
                <%--<td><form:errors cssClass="error" path="name"></form:errors></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td><form:label path="genre">--%>
                    <%--Room type--%>
                <%--</form:label></td>--%>
                <%--<td><form:input path="genre"/></td>--%>
                <%--<td><form:errors cssClass="error" path="genre"></form:errors> </td>--%>
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
<%--</t:template>--%>