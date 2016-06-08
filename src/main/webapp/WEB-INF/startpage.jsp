<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>START PAGE FOR LOGGINED USER</title>
</head>
<body>
Welcome: <%=request.getParameter("email")%><br>
Password: <%=request.getParameter("password")%>
</body>
</html>
