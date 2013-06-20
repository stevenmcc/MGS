/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 20/06/13
 * Time: 00:45
 * To change this template use File | Settings | File Templates.
 */

    var currentuser = $("usertext").text();


    var request = $.ajax({
        url: "/lc",
        type: "post",
        data: ""
    });
    request.success(function (response, textStatus, jqXHR){
        $("#user").html(response);
    });


