<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Dear Employee, Please enter your details</h2>

<br>
<br>


<form:form action = "showDetails" modelAttribute="employee">
    Name: <form:input path="name"/>
    <form:errors path="name"/>
    <br>
    <br>
    Surname: <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <br>
    Salary: <form:input path="salary"/>
    <br>
    <br>
    Department: <form:select path="department">
    <form:options items="${employee.departments}"/>
    </form:select>
    <br>
    <br>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
<%--    BMW <form:radiobutton path="carBrand" value="BMW"/>--%>
<%--    Audi <form:radiobutton path="carBrand" value="Audi"/>--%>
<%--    MB <form:radiobutton path="carBrand" value="Mercedes-Benz"/>--%>
    <br><br>
    Foreign Language(s)
    <form:checkboxes path="languages" items="${employee.languageList}"/>
<%--    EN <form:checkbox path="languages" value="English"/>--%>
<%--    DE <form:checkbox path="languages" value="Deutch"/>--%>
<%--    FR <form:checkbox path="languages" value="French"/>--%>

    <br><br>
    <input type="submit" value="Ok">
</form:form>


</body>
</html>
