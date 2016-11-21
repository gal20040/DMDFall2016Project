<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Валидация формы</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/font-awesome.min.css ">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
 

    <body>
        <div id="myCarousel" class="carousel container slide">
            <div class="carousel-inner">
                <div class="active item one"></div>
                <div class="item two"></div>
                <div class="item three"></div>
            </div>
        </div>
        
        <div class="navbar navbar-default navbar-fixed-top">
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
        </div>
        <br>
        <br>
            <br>
        <div class="container content">
            <form class="form-horizontal" method="post" id="form">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Name<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name" pattern="[a-zA-Zа-яА-ЯёЁ ]+" required> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Last Name<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Last" pattern="[a-zA-Zа-яА-ЯёЁ ]+" required> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email <span class="red">*</span></label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" required> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">Phone number <span class="red">*</span></label>
                    <div class="col-sm-6">
                        <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone number Format (XXX) XXX-XX-XX" pattern="\(\d{3}\) \d{3}-\d{2}-\d{2}" required> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                 <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password<span class="red">*</span></label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password" name="password" placeholder="password" required> <span class="glyphicon form-control-feedback" aria-hidden="true"></span> </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-6">
                        <button type="submit" id="submit" class="btn btn-primary">Отправить</button>
                        <div></div>
                    </div>
                </div>
            </form>
        </div>
        <div class="navbar navbar-inverse navbar-fixed-bottom">
            <div class="container">
                <div class="navbar-header"> <a class="navbar-brand">Разработчики</a> </div>
                <div class="collaplse navbar-collapse" id="respisive-menu">
                    <ul class="nav navbar-nav">
                        <li><a>Антон Залалдинов</a>
                            <li>
                                <li><a>Артём Гродецкий</a>
                                    <li>
                                        <li><a>Илья Жингалов</a>
                                            <li>
                    </ul>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                $('.carousel').carousel({
                    interval: 7000
                });
            });
        </script>
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
    </body>

</html>