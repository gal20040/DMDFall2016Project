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
                    <li><a href="index.html"><i class="fa fa-arrow-left" aria-hidden="true"></i>Back</a>
                    <li>
                </ul>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container content">
        <%--<c:if test="${!empty wishfulRoomData}">--%>
            <%--${wishfulRoomData.checkInDate}--%>
        <%--</c:if>--%>

        <form class="form-horizontal" method="post" id="form">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Check-in date<span class="red">*</span></label>
                <div class="col-sm-6">
                    <p class="form-control-static">11/13/2016</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Check-out date<span class="red">*</span></label>
                <div class="col-sm-6">
                    <p class="form-control-static">11/15/2016</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">City<span class="red">*</span></label>
                <div class="col-sm-6">
                    <p class="form-control-static">Kazan</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Hotel name<span class="red">*</span></label>
                <div class="col-sm-6">
                    <p class="form-control-static">Hayat</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Room type<span class="red">*</span></label>
                <div class="col-sm-6">
                    <p class="form-control-static">Business</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">All information bellow is correct<span class="red">*</span></label>
                <div class="col-sm-6">
                    <input type="checkbox" data-switch-always required> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>

            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name<span class="red">*</span></label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Name" pattern="[a-zA-Zа-яА-ЯёЁ ]+" required>Anton<span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Last Name<span class="red">*</span></label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="lastname" name="name" placeholder="Last" pattern="[a-zA-Zа-яА-ЯёЁ ]+" required>Zalaldinov<span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email <span class="red">*</span></label>
                <div class="col-sm-6">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>email@gmail.com
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">Phone number <span class="red">*</span></label>
                <div class="col-sm-6">
                    <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone number Format (XXX) XXX-XX-XX" pattern="\(\d{3}\) \d{3}-\d{2}-\d{2}" required>
                    +7(906)123-45-67
                    <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" id="submit" class="btn btn-primary">Reserve</button>
                    <div></div>
                </div>
            </div>
        </form>
    </div>
    <script>
        $(function () {
            $('#form').validator({
                feedback: {
                    success: 'glyphicon-thumbs-up',
                    error: 'glyphicon-thumbs-down'
                }
            });
        });
    </script>

</t:template>