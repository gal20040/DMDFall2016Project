<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:template>
    <form:form method="post" action="addBook" commandName="book"> <%--TODO отредактировать тэг--%>
        <table>
            <tr>
                <td><form:label path="name"> <%--TODO отредактировать тэг, здесь и далее--%>
                    City
                </form:label></td>
                <td><form:input path="name"/></td> <%--TODO отредактировать тэг, здесь и далее--%>
                <td><form:errors cssClass="error" path="name"></form:errors></td> <%--TODO отредактировать тэг, здесь и далее--%>
            </tr>
            <tr>
                <td><form:label path="genre">
                    Room type
                </form:label></td>
                <td><form:input path="genre"/></td>
                <td><form:errors cssClass="error" path="genre"></form:errors> </td>
            </tr>
            <tr>
                <td><form:label path="genre">
                    Check in date
                </form:label></td>
                <td><form:input path="genre"/></td>
                <td><form:errors cssClass="error" path="genre"></form:errors> </td>
            </tr>
            <tr>
                <td><form:label path="genre">
                    Check out date
                </form:label></td>
                <td><form:input path="genre"/></td>
                <td><form:errors cssClass="error" path="genre"></form:errors> </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Search room"/></td>
            </tr>
        </table>
    </form:form>
</t:template>