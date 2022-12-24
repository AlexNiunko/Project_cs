<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>"Welcome!"
</h1>
<br/>
<form action="controller" >
    <input type="hidden" name="command" value="login"/>
    E-mail:<input type="text" name="login" value=""/>
    <br/>
    Password: <input type="password" name="pass" value=""/>
    <br/>
    <input type="submit" name="push" value="login" />
    <br/>
    ${login_msg}
</form>
<form action="pages/register.jsp" >
    <input type="submit"  value="register">
</form>
</body>
</html>