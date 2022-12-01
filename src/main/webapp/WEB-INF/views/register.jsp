<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<body class="bg-dark">
<link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>

<link  rel="stylesheet" href="<c:url value="resources/css/all.min.css"/>"/>

<link  rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>

<%@ include file="/WEB-INF/fragments/meta.jsp" %>

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Zarejestruj się</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="registerDTO">
                <div class="form-group">
                    <fieldset class="form-label-group">
                        <form:label for="firstName" path="firstName">firstName</form:label>
                        <form:input path="firstName" type="text" id="firstName" placeholder="First Name" class="form-control" required="required"
                                    autofocus="autofocus"/>
                        <form:errors path="firstName" cssStyle="color: red" element="div"/>
                    </fieldset>

                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label for="lastName" path="lastName">lastName</form:label>
                        <form:input path="lastName" type="text" id="lastName" class="form-control"
                                    placeholder="Last name" required="required" autofocus="autofocus"/>
                        <form:errors path="lastName" cssStyle="color: red" element="div"/>
                    </div>

                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label path="email" for="inputEmail">email</form:label>
                        <form:input path="email" type="text" id="inputEmail" class="form-control"
                                    placeholder="Email address" required="required"/>
                        <form:errors path="email" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label path="password" for="password">password</form:label>
                        <form:input path="password" type="text" id="password" class="form-control"
                                    placeholder="password" required="required" autofocus="autofocus"/>
                        <form:errors path="password" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label path="confirm_password" for="confirm_password">confirm password</form:label>
                        <form:input path="confirm_password" type="text" id="confirm_password" class="form-control"
                                    placeholder="confirm password" required="required" autofocus="autofocus"/>
                        <form:errors path="confirm_password" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Register"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
        </div>
    </div>
</div>

<script src="<c:url value="resources/js/app.js"/>"></script>
</body>

</html>