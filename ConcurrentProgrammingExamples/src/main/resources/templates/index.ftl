<html>
<head>
    <title>
        Concurrent programming examples tester
    </title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
    <script src="/js/jquery-1.11.3.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/index.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4 dropdown">
            <div class="fix-height">
            <#list testCases as testCase>
                <div class="panel panel-default">
                    <div class="panel-body">
                    ${testCase.name}
                        <button data-test-case-name="${testCase.name}" class="btn btn-default start">Start</button>
                        <button data-test-case-name="${testCase.name}" class="btn btn-default kill">Kill</button>
                    </div>
                </div>
            </#list>
            </div>
        </div>
        <div class="col-md-4 dropdown">
            <div class="panel panel-default fix-height">
                <div class="panel-heading">
                    <h3 class="panel-title">Output</h3>
                    <button id="clear" class="btn btn-default">Clear</button>
                </div>
                <div id="log" class="panel-body">
                    Log output
                </div>
            </div>
        </div>
    </div>
</body>
</html>