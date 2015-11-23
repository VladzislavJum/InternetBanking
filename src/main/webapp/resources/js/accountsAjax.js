jQuery(document).ready(function () {
    $('#delAccButton').click(function () {
        deleteAccountViaAjax(this);
    });
});

function deleteAccountViaAjax(button) {
    var accountID = $(button).attr("accID");
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: $(button).attr("url"),
        data: accountID,
        dataType: 'text',
        timeout: 100000,
        success: function () {
            removeAccFromJSP(accountID);
        }
    });

}

function removeAccFromJSP(accountID) {
    $("#account" + accountID).remove();
}