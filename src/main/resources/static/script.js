$(document).ready(
    function(){
        $('input:file').change(
            function(){
                if ($(this).val()) {
                    $('button:submit').attr('disabled',false);
                    // or, as has been pointed out elsewhere:
                    // $('input:submit').removeAttr('disabled');
                }
            }
        );
    });

$(document).ready(function () {
    $("#uploadForm").submit(function () {
        $('#uploadBtn').attr("disabled", true);
        return true;
    });
});


// $(document).ready(function () {
//
//     $("#uploadForm").submit(function (e) {
//
//         //stop submitting the form to see the disabled button effect
//         e.preventDefault();
//
//         //disable the submit button
//         $("#btnSubmit").attr("disabled", true);
//
//
//         return true;
//
//     });
// });