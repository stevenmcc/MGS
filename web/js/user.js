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
        var isFormValid=true;
        var isEmailValid;
        var passMatch = false;

        // Make sure all inputs are entered
        $("#registration input:text").each(function(){ // Note the :text
            if ($.trim($(this).val()).length == 0){
                isFormValid = false;
            }
        });
        //validate the users email
        var email = $("#email").val();
        var regex = /^([a-zA-Z0-9_\.\-\+])+@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        isEmailValid=regex.test(email);

        //validate the passwords match
        var p1 = $("#password").val();
        var p2 = $("#c_password").val();
        if(p1==p2){
            passMatch=true;
        }

        if (!isFormValid){
            var errorThrown = "Please fill in all the required fields.";
            throwError(errorThrown);
        }
        else if (!passMatch){
            var errorThrown = "Passwords do not match.";
             throwError(errorThrown);
        }
        else if (!isEmailValid){
            var errorThrown = "Email is invalid.";
            throwError(errorThrown);
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
                throwError(errorThrown);
            });
        }
    });





