<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@ include file="/WEB-INF/fragments/meta.jsp" %>


    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <%@ include file="/WEB-INF/fragments/header.jsp" %>
</header>
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Edytuj Organizacje</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="institution">
            <div class="form-group">
                <fieldset class="form-label-group">
                    <form:label for="name" path="name">Nazwa</form:label>
                    <form:input path="name" type="text" id="name" class="form-control" required="required" autofocus="autofocus"/>
                    <form:errors path="name" cssStyle="color: red" element="div"/>
                </fieldset>

            </div>
            <div class="form-group">
                <div class="form-label-group">
                    <form:label for="description" path="description">Opis</form:label>
                    <form:input path="description" type="text" id="description" name="description" class="form-control" placeholder="Opis" required="required" autofocus="autofocus"/>
                    <form:errors path="description" cssStyle="color: red" element="div"/>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Register"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form:form>
            </div>
        </div>
    </div>



    <%@ include file="/WEB-INF/fragments/footer.jsp" %>


    <script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
