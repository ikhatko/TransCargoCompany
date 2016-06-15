<%@ page import="java.util.List" %>
<%@ page import="model.Entities.Wagon" %>
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
        <%@include file="menu.html" %>
        <br>
        <div class="col-sm-10">
            <form action="/AddNewWagon" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new wagon</legend>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="licensePlate">License Plate</label>
                        <div class="col-md-4">
                            <input id="licensePlate" name="licensePlate" placeholder="License Plate"
                                   class="form-control input-md" required="" type="text">
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="driversChange">Drivers change</label>
                        <div class="col-md-4">
                            <select id="driversChange" name="driversChange" class="form-control" required>
                                <option value="">Choose drivers change</option>
                                <option value="1">Single</option>
                                <option value="2">Double</option>
                            </select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="maxWeight">Max Weight</label>
                        <div class="col-md-4">
                            <input id="maxWeight" name="maxWeight" placeholder="Max Weight"
                                   class="form-control input-md"
                                   required="" type="text">
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="maxVolume">Max Volume</label>
                        <div class="col-md-4">
                            <input id="maxVolume" name="maxVolume" placeholder="Max Volume"
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
        <div class="col-sm-10">
            <table class="table table-striped table-hover table-condensed table-responsive">
                <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        License Plate
                    </th>
                    <th>
                        Drivers Change
                    </th>
                    <th>
                        Max Weight
                    </th>
                    <th>
                        Max Volume
                    </th>
                    <th>
                        Current City
                    </th>
                    <th>
                        Wagon Status
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
                    List<Wagon> resultList = (List) request.getAttribute("resultList");
                    for (Wagon wagon : resultList) {
                        int id = wagon.getWagonId();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=wagon.getLicensePlate()%>
                    </td>
                    <td>
                        <%=wagon.getDriversChange()%>
                    </td>
                    <td>
                        <%=wagon.getMaxWeight()%>
                    </td>
                    <td>
                        <%=wagon.getMaxVolume()%>
                    </td>
                    <td>
                        <%=wagon.getCurrentCity()%>
                    </td>
                    <td>
                        <%=wagon.getWagonStatus()%>
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
                                        <h4 class="modal-title">Edit wagon</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">Wagon ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=wagon.getWagonId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="licensePlateModal">License
                                                    Plate</label>
                                                <div class="col-md-4">
                                                    <input id="licensePlateModal" value="<%=wagon.getLicensePlate()%>"
                                                           name="licensePlate" class="form-control input-md"
                                                           type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <!-- Select Basic -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="driversChangeModal">Drivers
                                                    change</label>
                                                <div class="col-md-4">
                                                    <select id="driversChangeModal" name="driversChange"
                                                            class="form-control">
                                                        <option selected disabled>Choose drivers change</option>
                                                        <option value="1">Single</option>
                                                        <option value="2">Double</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="maxWeightModal">Max
                                                    weight</label>
                                                <div class="col-md-4">
                                                    <input id="maxWeightModal" value="<%=wagon.getMaxWeight()%>"
                                                           name="maxWeight" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="maxVolumeModal">Max
                                                    volume</label>
                                                <div class="col-md-4">
                                                    <input id="maxVolumeModal" value="<%=wagon.getMaxVolume()%>"
                                                           name="maxVolume" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="currentCityModal">Current
                                                    city ID</label>
                                                <div class="col-md-4">
                                                    <input id="currentCityModal" value="<%=wagon.getCurrentCity()%>"
                                                           name="currentCity" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Select Basic -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="wagonStatusModal">Wagon
                                                    status</label>
                                                <div class="col-md-4">
                                                    <select id="wagonStatusModal" name="wagonStatus"
                                                            class="form-control">
                                                        <option selected disabled>Choose status</option>
                                                        <option value="1">Ready</option>
                                                        <option value="2">Broken</option>
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
                    <td>
                        <form action="/Wagon" method="post">
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

