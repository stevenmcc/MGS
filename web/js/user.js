/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 08/06/13
 * Time: 00:24
 * To change this template use File | Settings | File Templates.
 */
    $('a[href="#restart"]').click(function(){
        $('#content-container').load('jsp/user.jsp').slideDown("slow");
    });

    $("#page_2").hide();
    $("#page_3").hide();

    $("#success").hide();

    $("#next").click(function(){
        $("#page_1").slideUp();
        $("#page_2").slideDown();

    });
    $("#prev2").click(function(){
        $("#page_1").slideDown();
        $("#page_2").slideUp();

    });
    $("#next2").click(function(){
        $("#page_2").slideUp();
        $("#page_3").slideDown();

    });
    $("#prev3").click(function(){
        $("#page_3").slideUp();
        $("#page_2").slideDown();
    });
    $("#registration").submit(function(event) {
        event.preventDefault();
        var isFormValid = true;
        $("#registration input:text").each(function(){ // Note the :text
            if ($.trim($(this).val()).length == 0){
                isFormValid = false;
            }
        });
        if (!isFormValid){
            var errorThrown = "Please fill in all the required fields.";
            // log the error to the console
            $("#failure").slideDown("slow");
            $('#content-container').slideUp("slow");
            $("#errordetials").html("");
            $("#errordetials").append(errorThrown);

        }
        else{
            var serializedData = $(this).serialize();
            // fire off the request to /form.php
            var request = $.ajax({
                url: "/reg",
                type: "post",
                data: serializedData
            });

            // callback handler that will be called on success
            request.done(function (response, textStatus, jqXHR){
                // log a message to the console
                $("#page_3").slideUp();
                $("#success").slideDown();
            });

            // callback handler that will be called on failure
            request.fail(function (jqXHR, textStatus, errorThrown){
                // log the error to the console
                $("#failure").slideDown("slow");
                $('#content-container').slideUp("slow");
                $("#errordetials").html("");
                $("#errordetials").append(errorThrown);
            });
        }
    });




