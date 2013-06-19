/**
 * Created with IntelliJ IDEA.
 * User: bruno
 * Date: 07/06/13
 * Time: 18:11
 * To change this template use File | Settings | File Templates.
 */
$(window).load(function(){
    $("#failure").hide();
    $('ul#navi li').click(function() {
        $('li.active').removeClass('active');
        $(this).addClass('active');
    });
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
    $('a[href="#home"]').trigger("click");

});