$(document).ready(function () {
    clickRefill()
    clickDelete();
});

function clickDelete() {
    $('[id*=delete]').filter(':button').click(function () {
        alert(this.id);
        $('[id*=delAccButton]').attr('accID', $(this).attr("accID"));
    });
}

function clickRefill(){
    $('[id*=refill]').filter(':button').click(function(){
        $("#form").attr('action', this.id);
    });
}