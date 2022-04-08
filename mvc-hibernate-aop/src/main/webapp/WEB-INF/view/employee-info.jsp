<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>

<body>

<h2>Employee Info</h2>
<br>

<form:form action = "saveEmployee" modelAttribute="employee">
    Name: <form:input path="name"/>
    <br>
    Surname: <form:input path="surname" />
    <br>
    Department: <form:input path="department" />
    <br>
    Salary: <form:input path="salary" />
    <br>
    <input type="submit" value="Ok">
</form:form>

</body>
</html>