$(document).ready(function () {
    clickRefill();
    clickDelete();
});

function clickDelete() {
    $('[id*=delete]').filter(':button').click(function () {
        $('[id*=delAccButton]').attr('accID', $(this).attr("accID"));
    });
}

function clickRefill() {
    $('[id*=refill]').filter(':button').click(function () {
        $("#formID").attr('action', '/admin/users/' + $(this).attr("userID") + '/accounts/'+$(this).attr("accID")+'/refill');
        //$('#refAccButton').attr('accID', $(this).attr("accID"));
    });
}