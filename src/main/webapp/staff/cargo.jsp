<%@ page import="java.util.List" %>
<%@ page import="model.Entities.Cargo" %>
<%@ page import="model.Entities.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/validator.min.js"></script>

    <title>Welcome to Trans Cargo Company</title>
</head>
<body>

<div class="container-fluid">
    <div class="row content">
        <%@include file="staffmenu.html" %>
        <br>
        <div class="col-sm-10">
            <form  data-toggle="validator" action="/AddCargoWaypoints" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new cargo</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cargoName">Cargo name</label>
                        <div class="col-md-4">
                            <input id="cargoName" name="name" placeholder="Cargo name"
                                   class="form-control input-md" required type="text" pattern="^[_A-z0-9]{1,}$" maxlength="15"
                                   data-error="Cargo name is invalid">
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="loadFrom">Load from</label>
                        <div class="col-md-4">
                            <select id="loadFrom" name="loadFrom" class="form-control" required>
                                <%
                                    List<City> list = (List) request.getAttribute("cityList");
                                    for (City city : list) {
                                %>
                                <option value="<%=city.getCityId()%>"><%=city.getCityName()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="unloadTo">Unload to</label>
                        <div class="col-md-4">
                            <select id="unloadTo" name="unloadTo" class="form-control" required>
                                <%
                                    for (City city : list) {
                                %>
                                <option value="<%=city.getCityId()%>"><%=city.getCityName()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cargoWeight">Cargo weight</label>
                        <div class="col-md-4">
                            <input id="cargoWeight" name="weight" placeholder="Cargo weight"
                                   class="form-control input-md"
                                   type="text" maxlength="10"
                                   data-error="Cargo weight is invalid"
                                   pattern="[0-9]+([\.,][0-9]+)?" required>
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cargoVolume">Cargo volume</label>
                        <div class="col-md-4">
                            <input id="cargoVolume" name="volume" placeholder="Cargo volume"
                                   class="form-control input-md"
                                   required="" type="text" maxlength="10"
                                   data-error="Cargo volume is invalid"
                                   pattern="[0-9]+([\.,][0-9]+)?" required>
                            <div class="help-block with-errors"></div>
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
                        Name
                    </th>
                    <th>
                        Cargo Weight
                    </th>
                    <th>
                        Cargo Volume
                    </th>
                    <th>
                        Cargo Status
                    </th>
                    <th>
                        Cargo Order
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
                    List<Cargo> resultList = (List) request.getAttribute("resultList");
                    for (Cargo cargo : resultList) {
                        int id = cargo.getCargoId();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=cargo.getName()%>
                    </td>
                    <td>
                        <%=cargo.getWeight()%>
                    </td>
                    <td>
                        <%=cargo.getVolume()%>
                    </td>
                    <td>
                        <%=cargo.getCargoStatus()%>
                    </td>
                    <td>
                        <%=cargo.getCargoOrder()%>
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
                                        <h4 class="modal-title">Edit cargo</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">Cargo ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=cargo.getCargoId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="nameModal">Cargo name</label>
                                                <div class="col-md-4">
                                                    <input id="nameModal" value="<%=cargo.getName()%>" name="name"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="weightModal">Cargo
                                                    weight</label>
                                                <div class="col-md-4">
                                                    <input id="weightModal" value="<%=cargo.getWeight()%>" name="weight"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="volumeModal">Cargo
                                                    volume</label>
                                                <div class="col-md-4">
                                                    <input id="volumeModal" value="<%=cargo.getVolume()%>" name="volume"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="order">Cargo
                                                    order</label>
                                                <div class="col-md-4">
                                                    <input id="order" value="<%=cargo.getCargoOrder()%>" name="order"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Select Basic -->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="cargoStatusModal">Cargo
                                                    status</label>
                                                <div class="col-md-4">
                                                    <select id="cargoStatusModal" name="cargoStatusId"
                                                            class="form-control">
                                                        <option disabled>Choose status</option>
                                                        <option selected value="1">Ready</option>
                                                        <option value="2">Shipped</option>
                                                        <option value="3">Delivered</option>
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
                        <form action="/Cargo" method="post">
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

