$(document).ready(function () {
    $('[id*=refill]').filter(':button').click(function(){
        $("#form").attr('action', this.id);
    });

    $('[id*=delete]').filter(':button').click(function(){
        $('[id*=delAccButton]').filter(':button').attr('accID', $(this).attr("accID"));
    });
});