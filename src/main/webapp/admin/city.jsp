<%@ page import="java.util.List" %>
<%@ page import="model.Entities.Driver" %>
<%@ page import="model.Entities.City" %>
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
            <form action="/AddNewCity" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new city</legend>
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="cityName">City Name</label>
                        <div class="col-md-4">
                            <input id="cityName" name="cityName" placeholder="City Name"
                                   class="form-control input-md" required="" type="text">

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
                        City Name
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
                    List<City> resultList = (List) request.getAttribute("resultList");
                    for (City city : resultList) {
                        int id = city.getCityId();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=city.getCityName()%>
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
                                        <h4 class="modal-title">Edit city</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">City ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=id%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="cityNameModal">City Name</label>
                                                <div class="col-md-4">
                                                    <input id="cityNameModal" value="<%=city.getCityName()%>"
                                                           name="cityName" class="form-control input-md" type="text">
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
                        <form action="/City" method="post">
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

