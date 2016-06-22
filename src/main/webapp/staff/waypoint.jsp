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
        ${errorMsg}
        <%request.getSession().removeAttribute("errorMsg");%>
        <br>
       <%-- <div class="col-sm-10">
            <form action="/AddNewWaypoint" method="post" class="form-horizontal">

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

        </div>--%>
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

