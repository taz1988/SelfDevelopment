function handleResponse(response) {
    if (Array.isArray(response.logMessages)) {
        $(response.logMessages).each(function () {
                var message = '<div class="alert ';
                if (this.type === "INFO") {
                    message += 'alert-success"';
                } else {
                    message += 'alert-danger"';
                }
                message += '>[' + (new Date(this.date)).toISOString() + '] - ' + this.message + '</div>';
                $("#log").append(message);
            }
        );
    }
    if (response.status === "IN_PROGRESS") {
        setTimeout(function () {
            $.ajax({
                url: "progress",
                success: function (response) {
                    handleResponse(response);
                }
            });
        }, 1000);
    }
}

$(document).ready(function () {
    $("#clear").click(function () {
        $("#log").html("");
    });
    $(".start").click(function () {
        $.ajax({
            url: "start",
            data: {
                testCaseName: $(this).data("testCaseName")
            },
            success: function (response) {
                handleResponse(response);
            }
        });
    });
    $(".kill").click(function () {
        $.ajax({
            url: "kill",
            success: function (response) {
                handleResponse(response);
            }
        });
    });
});
