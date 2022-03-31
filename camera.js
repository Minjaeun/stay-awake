navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;

        //var constraints = { video: { facingMode: { exact: "environment" }, width: { exact: 395 }, height: { exact: 395 } }, audio: false };
function startCam() {
        var constraints = { audio: false, video: true };

        var video = document.getElementById("videoInput");

        function successCallback(stream) {
            video.srcObject = stream;
            video.play();
        }

        function errorCallback(error) {
            console.log(error);
        }
navigator.getUserMedia(constraints, successCallback, errorCallback);

}