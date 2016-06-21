<%@ page import="java.util.List" %>
<%@ page import="model.Entities.Driver" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <%@include file="staffmenu.html" %>
        <br>
        <div class="col-sm-10">
            <form action="/AddNewDriver" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
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
        <div class="col-sm-12">
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
                    <th>
                        Edit
                    </th>
                    <th>
                        Delete
                    </th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Driver> resultList = (List) request.getAttribute("resultList");
                    for (Driver driver : resultList) {
                        int id = driver.getDriverId();
                %>
                <tr>
                    <td>
                        <%=id%>
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
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal<%=id%>">
                            Edit
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal<%=id%>" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit driver</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="firstName">Driver ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=id%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="firstName">First Name</label>
                                                <div class="col-md-4">
                                                    <input id="modalFname" value="<%=driver.getFirstName()%>"
                                                           name="firstName" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="lastName">Last Name</label>
                                                <div class="col-md-4">
                                                    <input id="modalLname" name="lastName"
                                                           value="<%=driver.getLastName()%>"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="hours">This month
                                                    hours</label>
                                                <div class="col-md-4">
                                                    <input id="hours" value="<%=driver.getThisMonthHours()%>"
                                                           name="hours" placeholder="placeholder"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="city">Current city ID</label>
                                                <div class="col-md-4">
                                                    <input id="city" value="<%=driver.getCurrentCity()%>" name="city"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Select Basic -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="driverStatus">Driver
                                                    status</label>
                                                <div class="col-md-4">
                                                    <select id="driverStatus" name="driverStatus" class="form-control">
                                                        <option disabled selected>Choose status</option>
                                                        <option value="1">Rest</option>
                                                        <option value="2">Drive</option>
                                                        <option value="3">Relay</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="wagon">Current wagon
                                                    ID</label>
                                                <div class="col-md-4">
                                                    <input id="wagon" value="<%=driver.getCurrentWagon()%>" name="wagon"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderId">Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="orderId" name="orderId"
                                                           value="<%=driver.getCurrentOrder()%>"
                                                           class="form-control input-md" type="text">

                                                </div>
                                            </div>

                                            <!-- Button -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="submit">Save changes</label>
                                                <div class="col-md-4">
                                                    <button id="submit-modal" type="submit" class="btn btn-primary">
                                                        Save
                                                    </button>
                                                </div>
                                            </div>

                                        </fieldset>
                                    </form>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </td>
                    <td>
                        <form action="/Driver" method="post">
                            <div class="form-group">
                                <button type="submit" id="delete" name="delete" value="<%=id%>"
                                        class="btn btn-danger">Delete</button>
                            </div>
                        </form>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="../footer.html" %>
</body>
</html>

