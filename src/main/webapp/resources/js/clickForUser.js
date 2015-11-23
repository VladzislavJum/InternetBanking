$(document).ready(function () {
    $('[id*=delete]').filter(':button').click(function () {
        $('[id*=delUserButton]').attr('userID', $(this).attr("userID"));
    });
});
