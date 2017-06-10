var decode = function () {
    var reader = new FileReader();
    // read the image file as a data URL.
    var dataUrl = reader.readAsDataURL($('#file')[0].files[0]);

    $('#uploaded')[0].src = dataUrl;



};