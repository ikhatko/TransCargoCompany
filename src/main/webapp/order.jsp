<%@ page import="model.Entities.Order" %>
<%@ page import="java.util.List" %>
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
        <%@include file="menu.html" %>
        <br>
        <div class="col-sm-10">
            <form action="/AddNewOrder" method="post" class="form-horizontal">
                ${errorMsg}
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new order</legend>
                    <!-- Text input-->

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="orderStatus">Order status</label>
                        <div class="col-md-4">
                            <select id="orderStatus" name="orderStatus" class="form-control" required>
                                <option value="">Choose user role</option>
                                <option value="1">Not done</option>
                                <option value="2">Done</option>
                            </select>
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
                        Order Status
                    </th>
                    <th>
                        Order Wagon
                    </th>
                    <th>
                        Waypoint List
                    </th>
                    <th>
                        Driver Set
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
                    List<Order> resultList = (List) request.getAttribute("resultList");
                    for (Order order : resultList) {
                        int id = order.getOrderId();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=order.getOrderStatus()%>
                    </td>
                    <td>
                        <%=order.getOrderWagon()%>
                    </td>
                    <td>
                        <%=order.getWaypointList()%>
                    </td>
                    <td>
                        <%=order.getDriverSet()%>
                    </td>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal<%=id%>">Edit</button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal<%=id%>" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit user</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">User ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=order.getOrderId()%>" name="id" class="form-control input-md" type="text" readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderStatusModal">User role</label>
                                                <div class="col-md-4">
                                                    <select id="orderStatusModal" name="orderStatusId" class="form-control">
                                                        <option selected disabled>Choose order status</option>
                                                        <option value="1">Not done</option>
                                                        <option value="2">Done</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderWagonId">Order wagon ID</label>
                                                <div class="col-md-4">
                                                    <input id="orderWagonId" name="orderWagonId" value="<%=order.getOrderWagon()%>" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="waypointList">Order waypoint list</label>
                                                <div class="col-md-4">
                                                    <input id="waypointList" value="<%=order.getWaypointList()%>" name="waypointList" class="form-control input-md" type="text" disabled>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="driverSet">Order driver set</label>
                                                <div class="col-md-4">
                                                    <input id="driverSet" value="<%=order.getDriverSet()%>" name="driverSet" class="form-control input-md" type="text" disabled>
                                                </div>
                                            </div>

                                            <!-- Button -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="submit">Save changes</label>
                                                <div class="col-md-4">
                                                    <button id="submit-modal" type="submit" class="btn btn-primary">Save</button>
                                                </div>
                                            </div>

                                        </fieldset>
                                    </form>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </td>
                    <td>
                        <form action="/Order" method="post">
                            <div class="form-group">
                                <button type="submit" id="delete" name="delete" value="<%=id%>"
                                        class="btn btn-danger">Delete
                                </button>
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
<%@include file="footer.html" %>
</body>
</html>

