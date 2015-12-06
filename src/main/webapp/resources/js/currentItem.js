$(document).ready(function () {
    var id = $("#container").attr("pageID");
    $('.nav li a').parent().parent().find('.active').removeClass('active');
    $("#" + id).parent().addClass('active');
});
