<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<h1> Please fill in the registration form </h1>
<form action="controller" method="post">
    <input type="hidden" name="command" value="add">
    name:<input type="text" name="name" value=""/>
    <br/>
    surname: <input type="text" name="surname" value=""/>
    <br/>
    date_of_expirity(driving_licence): <input type="date" name="date_of_expirity" value=""/>
    <br/>
    identification_number(driving_licence): <input type="text" name="identification_number" value=""/>
    <br/>
    e_mail: <input type="text" name="e_mail" value=""/>
    <br/>
    password: <input type="text" name="password" value=""/>
    <br/>
    <br/>
    <br/>
    <input type="submit" name="push" value="add" />
    <br/>
</form>
</body>
</html>
