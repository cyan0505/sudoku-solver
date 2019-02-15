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
    let fileInput = document.getElementById("exampleFormControlFile1");
    let filePath = fileInput.value;
    let allowedExtensions = /(\.txt)$/i;
    if(!allowedExtensions.exec(filePath)) {
        alert('Please upload txt file only!');
        fileInput. value = '';
        return false;
    }
}

function getAllCells() {
    let tds = $('[data-cell="cell"]');
    let sudokuCellList = [];
    let arrayLength = tds.length;
    for (let i = 0; i < arrayLength; i++) {
        let value = tds[i].getAttribute("value");
        if (value === ' ' || value === null) {
            value = 0;
        }
        sudokuCellList.push(new CellDTO(value));
    }

    let httpRequest = new XMLHttpRequest();

    httpRequest.onreadystatechange = function () {
        if(httpRequest.readyState === 4 && httpRequest.status === 200) {
            $("html").html(httpRequest.responseText);
        }
    };
    let json = "{\"sudokuCells\": " + JSON.stringify(sudokuCellList) + "}";
    httpRequest.open('POST', '/solve');
    httpRequest.send(json);
}

$(":input").keyup(function(){
    var input = $(this).val();
    var regex = new RegExp("^[1-9]$");
    if(regex.test(input) || input === "") {
    } else {
        alert("Please enter only number in range 1 - 9.");
        $(this).val(input.substring(0,input.length-1));
    }
});

$('input').on('change keydown keyup',function () {
    let parent = $(this).parent();
    parent.get(0).setAttribute("value", $(this).val());
});

class CellDTO {
    constructor(value) {
        this.value = value;
    }
}