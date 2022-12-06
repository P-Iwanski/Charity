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

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <%@ include file="/WEB-INF/fragments/header.jsp" %>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>
<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Edytuj użytkownika</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="user">
            <div class="form-group">
                <fieldset class="form-label-group">
                    <form:label for="email" path="email">Email</form:label>
                    <form:input path="email" type="text" id="email" class="form-control" required="required" autofocus="autofocus"/>
                    <form:errors path="email" cssStyle="color: red" element="div"/>
                </fieldset>

            </div>
                <div class="form-group">
                    <fieldset class="form-label-group">
                        <form:label for="firstName" path="firstName">Nazwa</form:label>
                        <form:input path="firstName" type="text" id="firstName" class="form-control" required="required" autofocus="autofocus"/>
                        <form:errors path="firstName" cssStyle="color: red" element="div"/>
                    </fieldset>

                </div>
            <div class="form-group">
                <div class="form-label-group">
                    <form:label for="lastName" path="lastName">Opis</form:label>
                    <form:input path="lastName" type="text" id="lastName" name="lastName" class="form-control" placeholder="Opis" required="required" autofocus="autofocus"/>
                    <form:errors path="lastName" cssStyle="color: red" element="div"/>
                </div>
            </div>
                <div class="form-group">
                    <div class="form-label-group" style="display: none">
                        <form:label for="password" path="password">Opis</form:label>
                        <form:input path="password" type="text" id="password" name="password" class="form-control" placeholder="Opis" required="required" autofocus="autofocus"/>
                        <form:errors path="password" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label for="enabled" path="enabled">Opis</form:label>
                        <form:input path="enabled" type="text" id="enabled" name="enabled" class="form-control" placeholder="Opis" required="required" autofocus="autofocus"/>
                        <form:errors path="enabled" cssStyle="color: red" element="div"/>
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
