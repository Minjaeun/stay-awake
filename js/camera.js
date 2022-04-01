navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia;
var isRunning = false;

var constraints = { audio: false, video: true };
var video = document.getElementById("videoInput");

function toggleCam() {
    if (video.paused) {
        startCam(video);
    }
    else {
        pauseCam();
    }
}

function startCam(video) {
    function successCallback(stream) {
        video.srcObject = stream;
        video.play();
    }

    function errorCallback(error) {
        console.log(error);
    }
    navigator.getUserMedia(constraints, successCallback, errorCallback);
}

function pauseCam() {
    video.pause();
}