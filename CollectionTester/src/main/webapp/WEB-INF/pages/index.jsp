<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1" name="viewport">
            <link href="resources/css/bootstrap.min.css" rel="stylesheet">
                <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
                    <script src="resources/js/jquery-1.11.3.min.js"></script>
                    <script src="resources/js/bootstrap.min.js"></script>
                    <script src="resources/js/index.js"></script>
                    <title>Collection test runner</title>
                </head>
                <body>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-3 dropdown">
                                <button aria-expanded="true" aria-haspopup="true" class="btn btn-default dropdown-toggle core-interfaces-button" data-toggle="dropdown" id="coreInterface" type="button">
                                    Choose a main interface
                                    <span class="caret"></span>
                                </button>
                                <ul aria-labelledby="coreInterface" class="dropdown-menu core-interfaces-dropdown">
                                    <c:forEach items="${coreInterfaces}" var="coreInterface">
                                        <li>
                                            <a href="#">${coreInterface}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="col-md-3 dropdown">
                                <button aria-expanded="true" aria-haspopup="true" class="btn btn-default dropdown-toggle implementations-button" data-toggle="dropdown" disabled id="implemantation" type="button">
                                    Implementation
                                    <span class="caret"></span>
                                </button>
                                <ul aria-labelledby="implemantation" class="dropdown-menu implementations-dropdown">
                                    <c:forEach items="${collectionImplementations}" var="implementation">
                                        <li class="hidden implementations" data-core-interface="${implementation.type}">
                                            <a href="#">${implementation}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="col-md-3 dropdown">
                                <button aria-expanded="true" aria-haspopup="true" class="btn btn-default dropdown-toggle test-cases-button" data-toggle="dropdown" disabled id="test-cases" type="button">
                                    Implementation
                                    <span class="caret"></span>
                                </button>
                                <ul aria-labelledby="test-cases" class="dropdown-menu test-cases-dropdown">
                                    ${testCases}
                                    <c:forEach items="${testCases}" var="testCaseEntry">
                                        <li class="hidden test-cases" data-implementation="${testCaseEntry.key}" data-test-case-id="${testCaseEntry.value}">
                                            <a href="#">${testCaseEntry.value.getName()}</a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="col-md-3 dropdown">
                                <button aria-expanded="true" aria-haspopup="true" class="btn btn-primary" disabled id="run-test" type="button">
                                    Run test
                                </button>
                            </div>
                        </div>
                    </div>
                </body>
            </html>
