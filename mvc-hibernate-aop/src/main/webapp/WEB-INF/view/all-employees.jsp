<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

</head>

<body>
<h2>All Employees</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="employee" items="${allEmployees}">

        <c:url var="updateButton" value="updateInfo">
            <c:param name="empId" value="${employee.id}" />
        </c:url>

        <tr>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'" />
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewEmployee'" />

</body>
</html>
