/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 19/06/13
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function(){

    var request = $.ajax({
        url: "/lc",
        type: "post",
        data: ""
    });
    request.success(function (response, textStatus, jqXHR){
       $("#usertext").html(response);
    });
    // callback handler that will be called on failure
    request.fail(function (jqXHR, textStatus, errorThrown){
        url = "../index.jsp"
        window.location = url;
    });
});
