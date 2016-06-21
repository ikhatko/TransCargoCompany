<%@ page import="java.util.List" %>
<%@ page import="model.Entities.Waypoint" %>
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
            <form action="/AddNewWaypoint" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new waypoint</legend>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="city">Waypoint City</label>
                        <div class="col-md-4">
                            <input id="city" name="city" placeholder="Waypoint City"
                                   class="form-control input-md" required="" type="text">
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="waypointType">Waypoint Type</label>
                        <div class="col-md-4">
                            <select id="waypointType" name="waypointType" class="form-control" required>
                                <option value="">Choose waypoint type</option>
                                <option value="1">Loading</option>
                                <option value="2">Unloading</option>
                            </select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cargoId">Waypoint cargo ID</label>
                        <div class="col-md-4">
                            <input id="cargoId" name="cargoId" placeholder="Waypoint cargo"
                                   class="form-control input-md"
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
                        Waypoint Id
                    </th>
                    <th>
                        City
                    </th>
                    <th>
                        Type
                    </th>
                    <th>
                        Cargo
                    </th>
                    <th>
                        Order
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
                    List<Waypoint> resultList = (List) request.getAttribute("resultList");
                    for (Waypoint waypoint : resultList) {
                        int id = waypoint.getWaypointId();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=waypoint.getWaypointCity()%>
                    </td>
                    <td>
                        <%=waypoint.getWaypointType()%>
                    </td>
                    <td>
                        <%=waypoint.getWaypointCargo()%>
                    </td>
                    <td>
                        <%=waypoint.getWaypointOrder()%>
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
                                        <h4 class="modal-title">Edit waypoint</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">Waypoint ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=id%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="waypointCityModal">Waypoint
                                                    City ID</label>
                                                <div class="col-md-4">
                                                    <input id="waypointCityModal"
                                                           value="<%=waypoint.getWaypointCity()%>" name="city"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Select Basic -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="waypointTypeModal">Waypoint
                                                    Type</label>
                                                <div class="col-md-4">
                                                    <select id="waypointTypeModal" name="waypointType"
                                                            class="form-control">
                                                        <option selected disabled>Choose waypoint type</option>
                                                        <option value="1">Loading</option>
                                                        <option value="2">Unloading</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="waypointCargoModal">Waypoint
                                                    Cargo ID</label>
                                                <div class="col-md-4">
                                                    <input id="waypointCargoModal"
                                                           value="<%=waypoint.getWaypointCargo()%>" name="cargoId"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="currentCityModal">Waypoint
                                                    Order ID</label>
                                                <div class="col-md-4">
                                                    <input id="currentCityModal"
                                                           value="<%=waypoint.getWaypointOrder()%>" name="order"
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
                        <form action="/Waypoint" method="post">
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

