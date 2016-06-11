<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/validator.min.js"></script>
    <script src="js/login.js"></script>
    <title>Welcome to Trans Cargo Company</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link">Register</a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form data-toggle="validator" id="login-form" action="/Login" method="post" role="form"
                                  style="display: block;">
                                ${errorMsg}
                                <div class="form-group">
                                    <label for="email" class="control-label">Email</label>
                                    <input type="email" name="email" id="email" tabindex="1" class="form-control"
                                           placeholder="Email" data-error="Email address is invalid" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="control-label">Password</label>
                                    <input type="password" data-minlength="6" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="Password" required>
                                    <div class="help-block">Minimum of 6 characters</div>
                                </div>
                                <div class="form-group text-center">
                                    <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                    <label for="remember"> Remember Me</label>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login" id="login" tabindex="4"
                                                   class="form-control btn btn-login" value="Log In">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="text-center">
                                                <a href="/ForgotPassword" tabindex="5" class="forgot-password">Forgot
                                                    Password?</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <form data-toggle="validator" id="register-form" action="/Register" method="post"
                                  role="form" style="display: none;">
                                <script>$('#myForm').validator()</script>
                                <div class="form-group">
                                    <label for="firstName" class="control-label">First Name</label>
                                    <input type="text" name="firstName" id="firstName" tabindex="1" class="form-control"
                                           placeholder="Username" pattern="^[_A-z0-9]{1,}$" maxlength="15"
                                           data-error="First name is invalid" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label for="lastName" class="control-label">Last Name</label>
                                    <input type="text" name="lastName" id="lastName" tabindex="1" class="form-control"
                                           placeholder="Username" pattern="^[_A-z0-9]{1,}$" maxlength="15"
                                           data-error="Last name is invalid" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label for="emailReg" class="control-label">Email</label>
                                    <input type="email" name="emailReg" id="emailReg" tabindex="1" class="form-control"
                                           placeholder="Email Address" data-error="Email address is invalid"
                                           maxlength="50" required>
                                    <div class="help-block with-errors"></div>
                                </div>
                                <div class="form-group">
                                    <label for="passwordReg" class="control-label">Password</label>
                                    <input type="password" name="passwordReg" id="passwordReg" tabindex="2"
                                           class="form-control" placeholder="Password" data-minlength="6" maxlength="15"
                                           required>
                                    <div class="help-block">From 6 to 15 chars</div>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register" id="register"
                                                   tabindex="4" class="form-control btn btn-register"
                                                   value="Register Now">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
