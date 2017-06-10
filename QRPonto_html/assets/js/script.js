var decode = function () {
    var reader = new FileReader();
    // read the image file as a data URL.
    qrcode.callback = function(decoded) { alert(decoded) };
    reader.onload = function (e) {
        // get loaded data and render thumbnail.
	    $('#uploaded')[0].src = e.target.result;
		qrcode.decode(e.target.result);
    };

    // read the image file as a data URL.
    reader.readAsDataURL($('#cameraInput')[0].files[0]);



};