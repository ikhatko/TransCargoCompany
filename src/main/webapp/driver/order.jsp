<%@ page import="model.Entities.Order" %>
<%@ page import="model.Entities.Waypoint" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="http://maps.googleapis.com/maps/api/js"></script>
    <script>
        function initialize() {
            var mapProp = {
                center: new google.maps.LatLng(51.508742, -0.120850),
                zoom: 5,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
        }
        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
    <title>Welcome to Trans Cargo Company</title>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <%@include file="drivermenu.html" %>
        <br>
        <div class="col-sm-10">
            <div class="well">
                <% Order order = (Order) request.getAttribute("order");
                    if (order != null) {
                %>
                <table class="table table-striped table-hover table-condensed">
                    <thead>
                    <tr>
                        <th>
                            Drivers
                        </th>
                        <th>
                            Wagon plate
                        </th>
                        <th>
                            Order id
                        </th>
                        <th>
                            Waypoints Set
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <%=order.getDriverSet()%>
                        </td>
                        <td>
                            <%=order.getOrderWagon().getLicensePlate()%>
                        </td>
                        <td>
                            <%=order.getOrderId()%>
                        </td>
                        <td>
                            <%
                                List<Waypoint> waypointList = order.getWaypointList();
                                for (Waypoint waypoint : waypointList) {
                            %>
                            <%=waypoint.getWaypointCity()%> - <%=waypoint.getWaypointType()%><br>
                            <% }%>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <%} else {%>
                <p>You don't have orders!</p>
                <%}%>
            </div>
            <div id="googleMap" style="width:500px;height:380px;"></div>
        </div>
    </div>
</div>
<footer class="container-fluid text-center">
    <p>Footer Text</p>
</footer>
</body>
</html>
