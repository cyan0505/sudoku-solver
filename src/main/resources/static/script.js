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

function download(d) {
    if (d == 'Select document') return;
    window.location = '/home/szwajcii/Desktop/Java Advanced/TW_5/sudoku-solver/src/main/resources/sudoku/' + d;
}