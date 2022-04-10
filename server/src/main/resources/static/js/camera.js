navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;

var constraints = {audio: false, video: true};

startCam();

function startCam() {

    const video = document.getElementById("videoInput");

    function successCallback(stream) {
        video.srcObject = stream;
        video.play();
    }

    function errorCallback(error) {
        console.log(error);
    }

    navigator.mediaDevices.getUserMedia(constraints, successCallback, errorCallback);
}

function pauseCam() {
    const video = document.getElementById("videoInput");
    video.pause();
}