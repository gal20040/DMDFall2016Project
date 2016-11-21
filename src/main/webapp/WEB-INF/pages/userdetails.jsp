<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <a class="navbar-brand" href="/">
                    <i class="fa fa-home fa-fw" aria-hidden="true"></i>Home</a>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container content">
        <c:if test="${!empty choosenHotelRoom}">
            <form class="form-horizontal" method="post" id="form">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Check-in date<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <p class="form-control-static">${choosenHotelRoom.checkInDate}</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Check-out date<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <p class="form-control-static">${choosenHotelRoom.checkOutDate}</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">City<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <p class="form-control-static">${choosenHotelRoom.cityName}</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Hotel name<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <p class="form-control-static">${choosenHotelRoom.hotelName}</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Room type<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <p class="form-control-static">${choosenHotelRoom.roomType}</p> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>

                <form:form class="form-horizontal" method="post" id="form" action="reservation" commandName="userdata">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">
                            All information bellow is correct
                            <span class="red">*</span>
                        </label>
                        <div class="col-sm-6">
                            <input type="checkbox" data-switch-always required>
                            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">First name<span class="red">*</span></label>
                        <div class="col-sm-6">
                            <form:input type="text" path="firstName" class="form-control" id="name" name="name" placeholder="First name" pattern="[a-zA-Z]{3,}" required="[a-zA-Z]{3,}"/>
                            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Last Name<span class="red">*</span></label>
                        <div class="col-sm-6">
                            <form:input type="text" path="lastName" class="form-control" id="lastname" name="name" placeholder="Last name" pattern="[a-zA-Z]{3,}" required="[a-zA-Z]{3,}"/>
                            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email <span class="red">*</span></label>
                        <div class="col-sm-6">
                            <form:input type="email" path="email" class="form-control" id="email" name="email" placeholder="Email" pattern="[a-z0-9._]{2,50}@[a-z0-9._]{2,50}.[a-z]{2,10}" required="[a-z0-9._]{2,50}@[a-z0-9]{2,50}.[a-z]{2,10}"/>
                            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">Phone number <span class="red">*</span></label>
                        <div class="col-sm-6">
                            <form:input type="tel" path="phone" class="form-control" id="phone" name="phone" placeholder="Phone number Format (XXX) XXX-XX-XX" pattern="\(\d{3}\)\s+\d{3}-\d{2}-\d{2}" required="\(\d{3}\)\s+\d{3}-\d{2}-\d{2}"/>
                            <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-6">
                            <button type="submit" id="submit" class="btn btn-primary">Reserve room</button>
                            <div></div>
                        </div>
                    </div>
                </form:form>
            </form>
        </c:if>
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