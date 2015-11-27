$(document).ready(function () {
    clickRefill();
    clickDelete();
    if ($('[id*=amountOfMoney]').html() != null) {
        //$("#formID").attr('formID', $('[id*=amountOfMoney]').attr('idForm'));
        $('[id*=refill]').click();
    }
});

function clickDelete() {
    $('[id*=delete]').filter(':button').click(function () {
        $('[id*=delAccButton]').attr('accID', $(this).attr("accID"));
    });
}

function clickRefill() {
    $('[id*=refill]').filter(':button').click(function () {
        $("#formID").attr('action', $(this).attr("url") + $(this).attr("userID") + '/accounts/' + $(this).attr("accID") + '/refill');
        //$('[id*=amountOfMoney]').attr('idForm', $(this).attr("url") + $(this).attr("userID") + '/accounts/' + $(this).attr("accID") + '/refill');
    });
}