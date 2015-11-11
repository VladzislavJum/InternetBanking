function show(state, id) {
    document.getElementById(id).style.display = state;
    document.getElementById('wrap').style.display = state;
}
var buttonID;
function setDetails(object) {
    buttonID = object.id;
}

function getDetails() {
    document.getElementById('form').setAttribute('action', buttonID);
}