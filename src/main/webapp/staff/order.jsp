<%@ page import="model.Entities.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
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
            <form action="/AddNewOrder" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new order</legend>
                    <!-- Text input-->

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="orderStatus">Order status</label>
                        <div class="col-md-4">
                            <select id="orderStatus" name="orderStatus" class="form-control" required>
                                <option value="">Choose order status</option>
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
        <div class="col-sm-12">
            <table class="table table-striped table-hover table-condensed table-responsive">
                <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Status
                    </th>
                    <th>
                        Cargoes
                    </th>
                    <th>
                    </th>
                    <th>
                        Wagon
                    </th>
                    <th>
                        Driver
                    </th>
                    <th>
                    </th>
                    <th>
                        Waypoints Set
                    </th>
                    <th>
                        Weight(kg)
                    </th>
                    <th>
                        Volume(m3)
                    </th>
                    <th>
                        Distance(km)
                    </th>
                    <th>
                        Duration(h)
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
                    <%--id--%>
                    <td>
                        <%=id%>
                    </td>
                    <%--status--%>
                    <td>
                        <%=order.getOrderStatus()%>
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#myModalES<%=id%>">
                            Edit
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModalES<%=id%>" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit status</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodalES">Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodalES" value="<%=order.getOrderId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderStatusModal1">Order
                                                    status</label>
                                                <div class="col-md-4">
                                                    <select id="orderStatusModal1" name="orderStatusId"
                                                            class="form-control">
                                                        <option selected disabled>Choose order status</option>
                                                        <option value="1">Not done</option>
                                                        <option value="2">Done</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!-- Button -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="submit">Save changes</label>
                                                <div class="col-md-4">
                                                    <button id="submitEditStatus" type="submit" class="btn btn-primary">
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
                    <%--cargoes--%>
                    <td>
                        <%
                            Set<Cargo> cargoList = order.getCargoSet();
                            for (Cargo cargo : cargoList) {
                        %>
                        <%=cargo.getName()%><br>
                        <%}%>
                    </td>
                    <%--button--%>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#myModalEC<%=id%>">
                            Edit
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModalEC<%=id%>" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit status</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post" action="/CargoesToOrder">
                                        <fieldset>

                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodalSC">Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodalSC" value="<%=order.getOrderId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <!-- Multiple Checkboxes -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label">Choose cargoes</label>
                                                <div class="col-md-6">
                                                    <%
                                                        List<Cargo> cargoesList = (List<Cargo>) request.getAttribute("cargoesList");
                                                        for (Cargo cargo : cargoesList) {
                                                            int cargoId = cargo.getCargoId();
                                                    %>
                                                    <div class="checkbox">
                                                        <label for="checkboxes<%=cargoId%>">
                                                            <input name="addedCargoes" id="checkboxes<%=cargoId%>"
                                                                   value="<%=cargoId%>" type="checkbox">
                                                            <%=cargo.getName()%> | <%=cargo.getVolume()%>m3 | <%=cargo.getWeight()%>kg
                                                        </label>
                                                    </div>
                                                    <%}%>
                                                </div>
                                            </div>

                                            <!-- Button -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="submit">Save changes</label>
                                                <div class="col-md-4">
                                                    <button id="submitCargo" type="submit" class="btn btn-primary">
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
                    <%--wagon--%>
                    <td>
                        <%=order.getOrderWagon()%>
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#myModalEW<%=id%>">
                            Edit
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModalEW<%=id%>" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit wagon</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post" action="/EditOrderWagon">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodalW">Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodalW" value="<%=order.getOrderId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderWagonEdit">Order
                                                    wagon</label>
                                                <div class="col-md-4">
                                                    <select id="orderWagonEdit" name="orderWagon"
                                                            class="form-control">
                                                        <option selected disabled>Choose wagon</option>
                                                        <%
                                                            List<Wagon> wagonsList = (List<Wagon>) request.getAttribute("wagonsList");
                                                            for (Wagon wagon : wagonsList) {
                                                                if (wagon.getMaxVolume() >= order.getMaxVolume()
                                                                        && wagon.getMaxWeight() >= order.getMaxWeight()) {
                                                        %>
                                                        <option value="<%=wagon.getWagonId()%>"><%=wagon.getLicensePlate()%>
                                                        </option>
                                                        <%
                                                                }
                                                            }
                                                        %>
                                                    </select>
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
                    <%--drivers--%>
                    <td>
                        <%
                            List<Driver> driverSet = order.getDriverSet();
                            for (Driver driver : driverSet) {
                        %>
                        <%=driver.getFirstName()%> <%=driver.getLastName()%><br>
                        <%}%>
                    </td>
                    <%--button--%>
                    <td>
                        <button type="button" class="btn btn-success" data-toggle="modal"
                                data-target="#myModalD<%=id%>">
                            Edit
                        </button>
                        <!-- Modal -->
                        <div class="modal fade" id="myModalD<%=id%>" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Edit wagon</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post" action="/EditOrderDriver">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodalD">Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodalD" value="<%=order.getOrderId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <%
                                                List<Driver> driversList = (List<Driver>) request.getAttribute("driversList");
                                            %>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderDriverEdit">Order
                                                    driver</label>
                                                <div class="col-md-4">
                                                    <select id="orderDriverEdit" name="orderDriver"
                                                            class="form-control">
                                                        <option selected disabled>Choose driver</option>
                                                        <%
                                                            for (Driver driver : driversList) {
                                                        %>
                                                        <option value="<%=driver.getDriverId()%>"><%=driver.getFirstName()%> <%=driver.getLastName()%>
                                                        </option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <!-- Button -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="submit">Save
                                                    changes</label>
                                                <div class="col-md-4">
                                                    <button id="submit-driver1" type="submit"
                                                            class="btn btn-primary">
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
                    <%--waypoints--%>
                    <td>
                        <%
                            List<Waypoint> waypointList = order.getWaypointList();
                            for (Waypoint waypoint : waypointList) {
                        %>
                        <%=waypoint.getWaypointCity()%> - <%=waypoint.getWaypointType().getWaypointStatusName()%> <br>
                        <%}%>
                    </td>
                    <%--weight--%>
                    <td>
                        <%=order.getMaxWeight()%>

                    </td>
                    <%--volume--%>
                    <td>
                        <%=order.getMaxVolume()%>
                    </td>
                    <%--distance--%>
                    <td>
                        <%=order.getRouteDistance()%>
                    </td>
                    <%--duration--%>
                    <td>
                        <%=order.getRouteDuration()%>
                    </td>
                    <%--main edit--%>
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
                                        <h4 class="modal-title">Edit user</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=order.getOrderId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderStatusModal">Order
                                                    status</label>
                                                <div class="col-md-4">
                                                    <select id="orderStatusModal" name="orderStatusId"
                                                            class="form-control">
                                                        <option selected disabled>Choose order status</option>
                                                        <option value="1">Not done</option>
                                                        <option value="2">Done</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="orderWagonId">Order wagon
                                                    ID</label>
                                                <div class="col-md-4">
                                                    <input id="orderWagonId" name="orderWagonId"
                                                           value="<%=order.getOrderWagon()%>"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="waypointList">Order waypoint
                                                    list</label>
                                                <div class="col-md-4">
                                                    <input id="waypointList" value="<%=order.getWaypointList()%>"
                                                           name="waypointList" class="form-control input-md" type="text"
                                                           disabled>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="driverSet">Order driver
                                                    set</label>
                                                <div class="col-md-4">
                                                    <input id="driverSet" value="<%=order.getDriverSet()%>"
                                                           name="driverSet" class="form-control input-md" type="text"
                                                           disabled>
                                                </div>
                                            </div>

                                            <!-- Button -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="submit">Save changes</label>
                                                <div class="col-md-4">
                                                    <button id="submit-modalMain" type="submit" class="btn btn-primary">
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
                    <%--delete--%>
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
<%@include file="../footer.html" %>
</body>
</html>

