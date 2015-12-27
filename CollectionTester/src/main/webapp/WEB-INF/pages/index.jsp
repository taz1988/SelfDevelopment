<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/bootstrap-theme.min.css" rel="stylesheet">
        <link href="resources/css/chartist.min.css" rel="stylesheet">
        <link href="resources/css/index.css" rel="stylesheet">
        <script src="resources/js/jquery-1.11.3.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/chartist.min.js"></script>
        <script src="resources/js/index.js"></script>
        <script type="text/javascript">
            var avarageBar;
            var deviationBar;
            {
                var dataForAvarageBar = { labels : [], series: []};
                var dataForDeviationBar = { labels : [], series: []};
             <c:forEach items="${testResults}" var="testResult">
                dataForAvarageBar.labels.push("${testResult.name}");
                dataForAvarageBar.series.push(["${testResult.average}"]);
                dataForDeviationBar.labels.push("${testResult.name}");
                dataForDeviationBar.series.push(["${testResult.deviation}"]);
            </c:forEach>
                $(document).ready(function() {
                    avarageBar = new Chartist.Bar(".avarage-time", dataForAvarageBar);
                    deviationBar = new Chartist.Bar(".deviation-time", dataForAvarageBar);
                });
            }
        </script>
        <title>Collection test runner</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 dropdown">
                    <button aria-expanded="true" aria-haspopup="true" class="btn btn-default dropdown-toggle core-interfaces-button" data-toggle="dropdown" id="coreInterface" type="button">
                        Choose a main interface
                        <span class="caret"></span>
                    </button>
                    <ul aria-labelledby="coreInterface" class="dropdown-menu core-interfaces-dropdown">
                        <c:forEach items="${coreInterfaces}" var="coreInterface">
                            <li class="dropdown-item">
                                ${coreInterface}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-2 dropdown">
                    <button aria-expanded="true" aria-haspopup="true" class="btn btn-default dropdown-toggle implementations-button" data-toggle="dropdown" disabled id="implemantation" type="button">
                        Implementation
                        <span class="caret"></span>
                    </button>
                    <ul aria-labelledby="implemantation" class="dropdown-menu implementations-dropdown">
                        <c:forEach items="${collectionImplementations}" var="implementation">
                            <li class="hidden implementations dropdown-item" data-core-interface="${implementation.type}">
                                ${implementation}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-4 dropdown">
                    <button aria-expanded="true" aria-haspopup="true" class="btn btn-default dropdown-toggle test-cases-button" data-toggle="dropdown" disabled id="test-cases" type="button">
                        Implementation
                        <span class="caret"></span>
                    </button>
                    <ul aria-labelledby="test-cases" class="dropdown-menu test-cases-dropdown">
                        <c:forEach items="${testCases}" var="testCase">
                            <li class="hidden test-cases dropdown-item" data-implementation="${testCase.implementation}" data-test-case-id="${testCase.id}">  
                                ${testCase.name}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-2 dropdown">
                    <div class="form-group">
                        <label for="numberOfRuns">Number of Runs</label>
                        <input type="email" class="form-control" id="numberOfRuns" placeholder="Number of runs" value="5" />
                    </div>
                </div>
                <div class="col-md-1 dropdown">
                    <button aria-expanded="true" aria-haspopup="true" class="btn btn-primary" disabled id="run-test" type="button">
                        Run test
                    </button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 dropdown">
                </div>
                <div class="col-md-4 dropdown">
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                            Test Running in progress, please wait...
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 dropdown">
                </div>
                <div class="col-md-8 dropdown">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                              <td>Name</td>
                              <td>Number of Runs</td>
                              <td>Avarage (ms)</td>
                              <td>Deviation (ms)</td>
                              <td>Min (ms)</td>
                              <td>Max (ms)</td>
                            </tr>
                        </thead>
                        <tbody id="testCasesInTable">
                             <c:forEach items="${testResults}" var="testResult">
                                <tr>
                                    <td>${testResult.name}</td>
                                    <td>${testResult.numberOfRuns}</td>
                                    <td>${testResult.average}</td>
                                    <td>${testResult.deviation}</td>
                                    <td>${testResult.min}</td>
                                    <td>${testResult.max}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 dropdown">
                </div>
                <div class="col-md-8 dropdown">
                <h3>Avarage time</h3>
                <div class="avarage-time"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 dropdown">
                </div>
                <div class="col-md-8 dropdown">
                <h3>Deviation time</h3>
                <div class="deviation-time"></div>
                </div>
            </div>
        </div>
    </body>
</html>
