$(document).ready(
    function(){
        $('input:file').change(
            function(){
                if ($(this).val()) {
                    $('button:submit').attr('disabled',false);
                }
            }
        );
    });


function fileValidation() {
    var fileInput = document.getElementById("exampleFormControlFile1");
    var filePath = fileInput.value;
    var allowedExtensions = /(\.txt)$/i;
    if(!allowedExtensions.exec(filePath)) {
        alert('Please upload txt file only!');
        fileInput. value = '';
        return false;
    }
}


// $(function() {
//     $("#btnSolve").bind("click", function() {
//         console.log("dupa");
//         var userGridJSON = $("#userGrid").find('input').serializeArray();
//         console.log(userGridJSON);
//         alert(JSON.stringify(userGridJSON));
//     });
// });


