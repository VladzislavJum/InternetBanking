$(document).ready(function () {
    searchUserInCreate();
});

function searchUserInCreate() {
    $("#userSelect").select2({
        width: '256px',
        language: "ru",
        maximumSelectionLength: 1,
        minimumInputLength: 1,
        ajax: {
            type: "POST",
            url: $("#userSelect").attr("url"),
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
                    user["id"] = data[responseIndex].login;
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