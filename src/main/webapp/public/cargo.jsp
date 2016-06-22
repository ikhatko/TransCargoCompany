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
        <%@include file="publicmenu.html"%>
        <br>
        <div class="col-sm-10">
            <form data-toggle="validator" action="/AddCargoWaypoints" method="post" class="form-horizontal">
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
                            <select id="loadFrom" name="loadFrom" class="form-control">
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
                            <select id="unloadTo" name="unloadTo" class="form-control">
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
                        <label class="col-md-4 control-label" for="cargoWeight">Cargo weight (kg)</label>
                        <div class="col-md-4">
                            <input id="cargoWeight" name="weight" placeholder="Cargo weight"
                                   class="form-control input-md"
                                   required type="text" maxlength="10"
                                   data-error="Cargo weight is invalid"
                                   pattern="[0-9]+([\.,][0-9]+)?">
                            <div class="help-block with-errors"></div>
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cargoVolume">Cargo volume (m3)</label>
                        <div class="col-md-4">
                            <input id="cargoVolume" name="volume" placeholder="Cargo volume"
                                   class="form-control input-md"
                                   required type="text" maxlength="10"
                                   data-error="Cargo volume is invalid"
                                   pattern="[0-9]+([\.,][0-9]+)?">
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
                        Name
                    </th>
                    <th>
                        Cargo Weight
                    </th>
                    <th>
                        Cargo Volume
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

