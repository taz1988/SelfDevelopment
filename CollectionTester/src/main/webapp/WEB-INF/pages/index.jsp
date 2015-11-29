<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
    <script src="resources/js/jquery-1.11.3.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/index.js"></script>
    <title>Collection test runner</title>
</head>
<body>
<div class="dropdown">
  <button class="btn btn-default dropdown-toggle core-interfaces-button" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    Choose a main interface
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu core-interfaces-dropdown" aria-labelledby="dropdownMenu1">
    <c:forEach var="coreInterface" items="${coreInterfaces}">
        <li><a href="#">${coreInterface}</a></li>
    </c:forEach>
  </ul>
</div>
</body>
</html>
