jQuery(document).ready(function () {
    $('[id*=delUserButton]').click(function () {
        deleteUserViaAjax(this);
    });

});

function deleteUserViaAjax(button) {
    var userID = $(button).attr("userID");

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/users/deleteuser",
        data: userID,
        dataType: 'json',
        timeout: 100000,
        success: function () {
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
        $(button).removeClass('btn-success');
        $(button).addClass('btn-warning');
        $("#unlockimg").attr("src", "../../../resources/images/button/lock.png");
    } else {
        $(button).attr("unlock", 'true');
        $(button).removeClass('btn-warning');
        $(button).addClass('btn-success');
        $("#unlockimg").attr("src", "../../../resources/images/button/unlock.png");
    }
}
