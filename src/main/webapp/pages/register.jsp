
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
</head>
<body>
<form action="controller" >
  <input type="hidden" name="command" value="add_user"/>
   <h1> Please fill in the registration form </h1>
  name:<input type="text" name="name" value=""/>
  <br/>
  surname: <input type="text" name="surname" value=""/>
  <br/>
  date_of_issue(driving_licence): <input type="date" name="date_of_issue" value=""/>
  <br/>
  date_of_expirity(driving_licence): <input type="text" name="date_of_expirity" value=""/>
  <br/>
  identification_number(driving_licence): <input type="text" name="identification_number" value=""/>
  <br/>
  e_mail: <input type="text" name="e_mail" value=""/>
  <br/>
  password: <input type="text" name="password" value=""/>
  <br/>
  <br/>
  <br/>
  <input type="submit" name="push" value="add_user" />
  <br/>
</form>
</body>
</html>
