<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <%@ include file="/WEB-INF/fragments/meta.jsp" %>
    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>

    <title>Document</title>

</head>
<body>


<section class="help">
    <h2>Lista organizacji</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>

        <ul class="help--slides-items">
            <li>
                <div>
                    <a class="dropdown-item" href="/admin/createOrg">
                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                        Dodaj organizację </a>
                </div>
                <c:forEach var="inst" items="${institutions}" varStatus="i">
                    <c:if test="${i.index%2 != 0}">
                        <div class="col">
                            <div class="title">Fundacja ${inst.name}</div>
                            <br>
                            <div class="subtitle">Cel i misja: ${inst.description}</div>
                        </div>
                        <br>
                        <div>
                            <a class="dropdown-item" href="/admin/editOrg?id=${inst.id}">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Zmiana profilu </a>
                        </div>
                        <br>
                        <div>
                            <a class="dropdown-item" href="/admin/deleteOrg?id=${inst.id}">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Usunięcie profilu </a>
                        </div>
                    </c:if>
                </c:forEach>
            </li>

            <li>
                <c:forEach var="inst" items="${institutions}" varStatus="i">
                    <c:if test="${i.index%2 == 0}">
                        <div class="col">
                            <div class="title">Fundacja ${inst.name}</div>
                            <br>
                            <div class="subtitle">Cel i misja: ${inst.description}</div>
                            <br>
                            <div>
                                <a class="dropdown-item" href="/admin/editOrg?id=${inst.id}">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Zmiana profilu </a>
                            </div>
                            <br>
                            <div>
                                <a class="dropdown-item" href="/admin/deleteOrg?id=${inst.id}">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Usunięcie profilu </a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </li>
        </ul>
    </div>
    <table class="table">
        <thead>
        <th>email</th>
        <th>funkcja</th>
        <th>imię</th>
        <th>nazwisko</th>
        <th>ustaw jako admin</th>
        <th>usunięcie użytkownika</th>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="users">
            <tr>
                <td><c:out value="${users.email}"/></td>
                <td><c:out value="${users.enabled}"/></td>
                <td><c:out value="${users.firstName}"/></td>
                <td><c:out value="${users.lastName}"/></td>
                <td>
                    <a class="dropdown-item" href="/admin/deleteUser?id=${users.id}">
                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                        usunięcie profilu </a>
                </td>
                <td>
                    <a class="dropdown-item" href="/admin/editUser?id=${users.id}">
                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                        Zmiana profilu </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


</section>


<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>