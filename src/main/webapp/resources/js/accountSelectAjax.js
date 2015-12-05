$(document).ready(function () {
    searchAccount();
});

function searchAccount() {
    $("#accSelect").select2({
        width: '256px',
        language: "ru",
        maximumSelectionLength: 2,
        minimumInputLength: 1,
        ajax: {
            type: "POST",
            url: $("#accSelect").attr("url"),
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
                    account["id"] = data[responseIndex].accountNumber;
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