jQuery(document).ready(function () {
    $('[id*=delUserButton]').click(function () {
        deleteViaAjax(this);
    });

});

function deleteViaAjax(button) {
    var userIDBody = {};
    var userID = $(button).attr("userID");
    userIDBody["userID"] = userID;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/users/deleteuser",
        data: userID,
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("Transfer SUCCESS: ", data);
            removeUserFromJSP(userID)
        }
    });
}

function lockOrUnlockViaAjax(button) {
    var userIDBody = {};
    var userID = $(button).attr("userID");
    userIDBody["userID"] = userID;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/users/lockorunlock",
        data: userID,
        dataType: 'text',
        timeout: 100000,
        success: function () {
            lockOrUnlockUserOnJSP(button);
        }
    });
}

function removeUserFromJSP(userID) {
    $("#user" + userID).remove();
}

function lockOrUnlockUserOnJSP(button) {

    if ($(button).attr("unlock") == 'true') {
        $(button).attr("unlock", 'false');
        $(button).removeClass('btn-warning');
        $(button).addClass('btn-success');
    } else {
        $(button).attr("unlock", 'true');
        $(button).removeClass('btn-success');
        $(button).addClass('btn-warning');
    }
}
