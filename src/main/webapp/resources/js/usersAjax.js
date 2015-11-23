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
        url: $(button).attr("url"),
        data: userID,
        dataType: 'json',
        timeout: 100000,
        success: function () {
            removeUserFromJSP(userID)
        }
    });
}

function lockOrUnlockViaAjax(button, url, imgUrl) {
    var userIDBody = {};
    var userID = $(button).attr("userID");
    userIDBody["userID"] = userID;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: url,
        data: userID,
        dataType: 'text',
        timeout: 100000,
        success: function () {
            lockOrUnlockUserOnJSP(button, imgUrl);
        }
    });
}

function removeUserFromJSP(userID) {
    $("#user" + userID).remove();
}

function lockOrUnlockUserOnJSP(button, imgUrl) {

    if ($(button).attr("unlock") == 'true') {
        $(button).attr("unlock", 'false');
        $(button).removeClass('btn-success');
        $(button).addClass('btn-warning');
        $("#unlockimg").attr("src", imgUrl + "lock.png");
    } else {
        $(button).attr("unlock", 'true');
        $(button).removeClass('btn-warning');
        $(button).addClass('btn-success');
        $("#unlockimg").attr("src", imgUrl + "unlock.png");
    }
}
