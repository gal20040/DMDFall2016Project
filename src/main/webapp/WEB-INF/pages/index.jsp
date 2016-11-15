<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:template>
    <c:if test = "${!empty allRecords}">
        <table class="book-list-table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Genre</th>
                <sec:authorize access="hasRole('admin')">
                    <th>&nbsp;</th>
                </sec:authorize>
            </tr>
            <c:forEach items = "${allRecords}" var = "book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.genre}</td>
                    <sec:authorize access="hasRole('admin')">
                        <td><a href="javascript:BookUtil.deleteBook(${book.id})">Delete</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <%--<sec:authorize access="isAuthenticated()">--%>
    <a href="search">Search room</a> <%--addBook--%>
    <%--</sec:authorize>--%>
</t:template>