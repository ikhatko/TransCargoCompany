<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <title>Welcome to Trans Cargo Company</title>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <%@include file="drivermenu.html" %>
        <br>
        <div class="col-sm-10">
            <form class="form-horizontal" action="/CurrentOrder">
                <fieldset>
                    <!-- Form Name -->
                    <legend>Input your personal ID to view your order</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="driverId">Input your ID</label>
                        <div class="col-md-4">
                            <input id="driverId" name="driverId" placeholder="your id" class="form-control input-md"
                                   required="" type="text">
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="button"></label>
                        <div class="col-md-4">
                            <button id="button" class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
</body>
</html>
