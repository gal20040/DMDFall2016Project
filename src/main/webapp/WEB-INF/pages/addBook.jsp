<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <form:form method="post" action="addBook" commandName="bookq">
        <table>
            <tr>
                <td><form:label path="name">
                    City
                </form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors cssClass="error" path="name"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="genre">
                    Room type
                </form:label></td>
                <td><form:input path="genre"/></td>
                <td><form:errors cssClass="error" path="genre"></form:errors> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Search room"/></td>
            </tr>
        </table>
    </form:form>

    <c:if test = "${!empty wishfulRoomData}">
        <h5>Это запрошенные данные:</h5> <%--TODO надо решить проблему с кодировкой--%>
        <table class="book-list-table">
            <tr>
                    <%--<th>ID</th>--%>
                <th>City</th>
                <th>Room type</th>
                <th>Check in date</th>
                <th>Check out date</th>
                    <%--<sec:authorize access="hasRole('admin')">--%>
                    <%--<th>&nbsp;</th>--%>
                    <%--</sec:authorize>--%>
            </tr>
            <%--<c:forEach items = "${books}" var = "book">--%>
                <tr>
                    <td>${wishfulRoomData.cityName}</td>
                    <td>${wishfulRoomData.roomType}</td>
                    <td>${wishfulRoomData.checkInDate}</td>
                    <td>${wishfulRoomData.checkOutDate}</td>
                <%--<sec:authorize access="hasRole('admin')">--%>
                        <%--<td><a href="javascript:BookUtil.deleteBook(${book.id})">Delete</a></td>--%>
                    <%--</sec:authorize>--%>
                </tr>
            <%--</c:forEach>--%>
                <%--<c:forEach items = "${rooms}" var = "room">--%>
                <%--<tr>--%>
                <%--<td>${room.roomID}</td>--%>
                <%--<td>${room.typeID}</td>--%>
                <%--<td>${room.genre}</td>--%>
                <%--&lt;%&ndash;<sec:authorize access="hasRole('admin')">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<td><a href="javascript:RoomUtil.deleteRoom(${room.roomID})">Delete</a></td>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</sec:authorize>&ndash;%&gt;--%>
                <%--</tr>--%>
                <%--</c:forEach>--%>
        </table>
    </c:if>
</t:template>