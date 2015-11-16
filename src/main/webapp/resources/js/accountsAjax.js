jQuery(document).ready(function () {
    $('[id*=delAccButton]').click(function () {
        //$("#rowDivForEach").empty();
        deleteViaAjax(this);
    });

});

function deleteViaAjax(button) {
    var userAccID = {}
    userAccID["userID"] = $(button).attr("userID");
    userAccID["accountID"] = $(button).attr("accID");

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/admin/deleteuseracc",
        data: JSON.stringify(userAccID),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("Transfer SUCCESS: ", data);
            display(data);
        }
    });

}

function display(data) {

    var body = "";
    for (var i = 0; i < data.accountDTOList.length; i++) {
        var account = data.accountDTOList[i];
        body += "<div class='row' id='rowAcc" + account.bankAccountID + "'>  <div class='account-inf col-sm-4'>" + account.accountNumber +
            "</div> <div class='account-inf col-sm-4'>" + account.amountOfMoney + "</div>" +
            "<div class='account-inf col-sm-4'> <button class='btn btn-success col-sm-3 col-sm-offset-2'" +
            "id='refill" + account.bankAccountID + "' data-toggle='modal' data-target='#refPoppup'>refillButton</button>" +
            "<a class='col-sm-3'>|</a><button class='btn btn-danger col-sm-3' id = 'delete" + account.bankAccountID +
            "' accID='" + account.bankAccountID + "' data-toggle='modal' data-target='#target'>deleteButton</button></div></div>"
    }

    $('#rowDivForEach').html(body);
}