/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 07/06/13
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
$(window).load(function(){
    //Setup error diaogs
    $("#failure").hide();
    $("#errorclose").on("click", function(e) {
        $(this).parent(this).hide();
    });
    //Setup Navigation highlighting
    $('ul#navi li').click(function() {
        $('li.active').removeClass('active');
        $(this).addClass('active');
    });
    //
    $('a').click(function(){
        $("#content-container").hide();

    });
    $('a[href="#contact"]').click(function(){
        $('#content-container').load('jsp/contact.jsp').slideDown("slow");
    });
    $('a[href="#failok"]').click(function(){
        $('#failure').slideUp("slow");
        $('#content-container').slideDown("slow");;
    });
    $('a[href="#sign_up"]').click(function(){
        $('#content-container').load('jsp/user.jsp').slideDown("slow");
    });
    $('a[href="#about"]').click(function(){
        $('#content-container').load('jsp/about.jsp').slideDown("slow");
    });
    $('a[href="#home"]').click(function(){
        $('#content-container').load('jsp/start.jsp').slideDown("slow");
    });
    $('a[href="#brand"]').click(function(){
        $('#content-container').load('jsp/start.jsp').slideDown("slow");
    });

    $('a[href="#home"]').trigger("click");


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
            var url = "../lg/home.jsp";
            window.location = url;
        });

        // callback handler that will be called on failure
        request.fail(function (jqXHR, textStatus, errorThrown){
            // log the error to the console
            throwError(errorThrown);
        });
    })

});
function throwError(errorThrown){
    $("#failure").show("slow");
    $("#errordetails").html("");
    $("#errordetails").append(errorThrown);
}