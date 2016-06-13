<%@ page import="model.Entities.User" %>
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
            <form action="/AddNewUser" method="post" class="form-horizontal">
                ${errorMsg}
                <%request.getSession().removeAttribute("errorMsg");%>
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add new user</legend>
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

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="email">Email</label>
                        <div class="col-md-4">
                            <input id="email" name="email" placeholder="Email address" class="form-control input-md"
                                   required="" type="text">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="email">Password</label>
                        <div class="col-md-4">
                            <input id="password" name="password" placeholder="Password" class="form-control input-md"
                                   required="" type="text">
                        </div>
                    </div>

                    <!-- Select Basic -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="userRole">User role</label>
                        <div class="col-md-4">
                            <select id="userRole" name="userRole" class="form-control">
                                <option selected disabled>Choose user role</option>
                                <option value="1">Admin</option>
                                <option value="2">Staff</option>
                                <option value="3">Driver</option>
                                <option value="4">Public</option>
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
                        First Name
                    </th>
                    <th>
                        Last Name
                    </th>
                    <th>
                        Email
                    </th>
                    <th>
                        Password
                    </th>
                    <th>
                        Role
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
                    List<User> resultList = (List) request.getAttribute("resultList");
                    for (User user : resultList) {
                        int id = user.getUserId();
                %>
                <tr>
                    <td>
                        <%=id%>
                    </td>
                    <td>
                        <%=user.getFirstName()%>
                    </td>
                    <td>
                        <%=user.getLastName()%>
                    </td>
                    <td>
                        <%=user.getEmail()%>
                    </td>
                    <td>
                        <%=user.getPassword()%>
                    </td>
                    <td>
                        <%=user.getUserRole()%>
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
                                        <h4 class="modal-title">Edit user</h4>
                                    </div>
                                    <br>
                                    <form class="form-horizontal" method="post">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="idmodal">User ID</label>
                                                <div class="col-md-4">
                                                    <input id="idmodal" value="<%=user.getUserId()%>" name="id"
                                                           class="form-control input-md" type="text"
                                                           readonly="readonly">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="firstName">First Name</label>
                                                <div class="col-md-4">
                                                    <input id="modalFname" value="<%=user.getFirstName()%>"
                                                           name="firstName" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="lastName">Last Name</label>
                                                <div class="col-md-4">
                                                    <input id="modalLname" name="lastName"
                                                           value="<%=user.getLastName()%>" class="form-control input-md"
                                                           type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="emailModal">User
                                                    email</label>
                                                <div class="col-md-4">
                                                    <input id="emailModal" value="<%=user.getEmail()%>" name="email"
                                                           class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <!-- Text input-->
                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="passwordModal">User
                                                    password</label>
                                                <div class="col-md-4">
                                                    <input id="passwordModal" value="<%=user.getPassword()%>"
                                                           name="password" class="form-control input-md" type="text">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-md-4 control-label" for="userRoleModal">User
                                                    role</label>
                                                <div class="col-md-4">
                                                    <select id="userRoleModal" name="userRole" class="form-control">
                                                        <option selected disabled>Choose user role</option>
                                                        <option value="1">Admin</option>
                                                        <option value="2">Staff</option>
                                                        <option value="3">Driver</option>
                                                        <option value="4">Public</option>
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
                        <form action="/User" method="post">
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

