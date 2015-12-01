$(document).ready(function () {
    searchAccount();
    searchUser();
});

function searchAccount(){
    $("#selectAccID").select2({
        language: "ru",
        maximumSelectionLength: 1,
        minimumInputLength: 1,
        ajax: {
            type: "POST",
            url: "/InternetBanking/admin/account/searchAcc",
            contentType: 'application/json',
            dataType: 'json',
            delay: 250,
            data: function (params) {
                var query = {
                    accountNumber: params.term
                };
                return JSON.stringify(query);
            },
            processResults: function (data) {
                var accounts = [];

                for (var responseIndex = 0; responseIndex < data.length; responseIndex++) {
                    var account = {};
                    account["text"] = data[responseIndex].accountNumber;
                    account["id"] = data[responseIndex].bankAccountID;
                    accounts[responseIndex] = account;
                }

                return {
                    results: accounts
                };
            },
            cache: true
        }
    });
}

function searchUser(){
    $("#selectUserID").select2({
        language: "ru",
        maximumSelectionLength: 1,
        minimumInputLength: 1,
        ajax: {
            type: "POST",
            url: "/InternetBanking/admin/users/searchUsers",
            contentType: 'application/json',
            dataType: 'json',
            delay: 250,
            data: function (params) {
                var query = {
                    login: params.term
                };
                return JSON.stringify(query);
            },
            processResults: function (data) {
                var users = [];

                for (var responseIndex = 0; responseIndex < data.length; responseIndex++) {
                    var user = {};
                    user["text"] = data[responseIndex].login;
                    user["id"] = data[responseIndex].userID;
                    users[responseIndex] = user;
                }

                return {
                    results: users
                };
            },
            cache: true
        }
    });
}

