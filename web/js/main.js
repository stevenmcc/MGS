
$("#login").submit(function(event) {
    event.preventDefault();
    var serializedData = $(this).serialize();
    // fire off the request to /form.php
    var request = $.ajax({
        url: "/log",
        type: "post",
        data: serializedData
    });
    // callback handler that will be called on success
    request.done(function (response, textStatus, jqXHR){
        // log a message to the console
        var url = "../jsp/loggedindex.jsp";
        window.location = url;
    });

    // callback handler that will be called on failure
    request.fail(function (jqXHR, textStatus, errorThrown){
        // log the error to the console
        $("#failure").slideDown("slow");
        $('#content-container').slideUp("slow");
        $("#errordetials").html("");
        $("#errordetials").append(errorThrown);
    });
})
