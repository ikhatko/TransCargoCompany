<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Entities.Driver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>Welcome to Trans Cargo Company</title>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-2 sidenav hidden-xs">
            <h2>Menu</h2>
            <ul class="nav nav-pills nav-stacked">
                <li><a href="#">Overall</a></li>
                <li class="active"><a href="/Driver">Driver</a></li>
                <li><a href="wagon.html">Wagon</a></li>
                <li><a href="#">Cargo</a></li>
                <li><a href="#">Order</a></li>
                <li><a href="#">Map</a></li>
            </ul>
            <br>
        </div>
        <br>
        <div class="col-sm-10">
            <form action="/AddNewDriver" class="form-horizontal">
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new driver</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="firstName">First Name</label>
                        <div class="col-md-4">
                            <input id="firstName" name="firstName" placeholder="First Name"
                                   class="form-control input-md" required="" type="text">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="lastName">Last Name</label>
                        <div class="col-md-4">
                            <input id="lastName" name="lastName" placeholder="Last Name" class="form-control input-md"
                                   required="" type="text">

                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="submit"></label>
                        <div class="col-md-4">
                            <button type="submit" id="submit" class="btn btn-primary">Add new</button>
                        </div>
                    </div>

                </fieldset>
            </form>

        </div>
        <br>
        <div class="col-sm-10">
            <table class="table table-striped table-hover table-condensed table-responsive">
                <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        First Name
                    </th>
                    <th>
                        Last Name
                    </th>
                    <th>
                        This Month Hours
                    </th>
                    <th>
                        Current City
                    </th>
                    <th>
                        Current Wagon
                    </th>
                    <th>
                        Driver Status
                    </th>
                    <th>
                        Order id
                    </th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Driver> resultList = (List) request.getAttribute("resultList");
                    for (Driver driver : resultList) {
                %>
                <tr>
                    <td>
                        <%=driver.getDriverId()%>
                    </td>
                    <td>
                        <%=driver.getFirstName()%>
                    </td>
                    <td>
                        <%=driver.getLastName()%>
                    </td>
                    <td>
                        <%=driver.getThisMonthHours()%>
                    </td>
                    <td>
                        <%=driver.getCurrentCity()%>
                    </td>
                    <td>
                        <%=driver.getCurrentWagon()%>
                    </td>
                    <td>
                        <%=driver.getDriverStatus()%>
                    </td>
                    <td>
                        <%=driver.getCurrentOrder()%>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
</body>
</html>

