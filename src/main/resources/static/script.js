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

function getAllCells() {

    var sudokuCellList = [];

    for (let i = 1; i <= 81; i++) {
        let cell = document.getElementById("cell" + i);
        sudokuCellList.push(cell.value);
    }

    let httpRequest = new XMLHttpRequest();

    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            $("html").html(httpRequest.responseText);
        }
    };
    let json = "{\"sudokuCells\": " + JSON.stringify(sudokuCellList) + "}";
    console.log(json);
    httpRequest.open('POST', '/userGrid');
    httpRequest.send(json);
}
