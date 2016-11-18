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
    <div class="container content">
        <form:form class="form-horizontal" method="post" id="form" action="search" commandName="defaultSearchData">
            <div class="form-group">
                <form:label for="name" class="col-sm-2 control-label" path="cityName">
                    Enter City Name
                    <span class="red">*</span>
                </form:label>
                <div class="col-sm-6">
                    <form:input type="text" path="cityName" class="form-control" id="name" name="name" placeholder="City" pattern="[a-zA-Zа-яА-ЯёЁ ]+" required=""/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true">
                </span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="roomType" for="name" class="col-sm-2 control-label">
                    Choose room type
                    <span class="red">*</span>
                </form:label>
                <div class="col-sm-6">
                    <form:select path="roomType" class="selectpicker form-control">
                        <option>Not chosen</option>
                        <option>Econom</option>
                        <option>Comfort</option>
                        <option>Business</option>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <form:label path="checkInDate" for="name" class="col-sm-2 control-label">
                    Check-in-Date
                    <span class="red">*</span>
                </form:label>
                <div class="col-sm-6">
                    <form:input path="checkInDate" class="form-control" id="date" placeholder="Check-in" pattern="\d{1,2}/\d{1,2}/\d{4}" required=""/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true">
                </span>
                </div>
            </div>

            <div class="form-group">
                <form:label path="checkOutDate" for="name" class="col-sm-2 control-label">
                    Check-Out-Date
                    <span class="red">*</span>
                </form:label>
                <div class="col-sm-6">
                    <form:input path="checkOutDate" class="form-control" id="date2" placeholder="Check-out" pattern="\d{1,2}/\d{1,2}/\d{4}" required=""/>
                    <span class="glyphicon form-control-feedback" aria-hidden="true">
                </span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" id="submit" class="btn btn-primary">
                        Reserve
                    </button>
                </div>
            </div>
        </form:form>
    </div>
    <script>
        $(function () {
            $('#form').validator({
                feedback: {
                    success: 'glyphicon-thumbs-up'
                    , error: 'glyphicon-thumbs-down'
                }
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $('#date').datetimepicker({
                pickTime: false
                , language: 'en'
            });
        });
    </script>
    <script type="text/javascript">
        $(function () {
            $('#date2').datetimepicker({
                pickTime: false
                , language: 'en'
            });
        });
    </script>
</t:template>