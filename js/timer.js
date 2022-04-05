var pause = true;
var isRunning = false;
var count = 0;

countTimers();

function countTimers() {

    setInterval(timer, 1000);

    function timer() {
        if (!pause) { 
            count = count + 1;
           
            var hours = Math.floor((count % (60 * 60 * 24)) / (60 * 60));
            var minutes = Math.floor((count % (60 * 60)) / 60);
            var seconds = Math.floor(count % 60);

            document.getElementById("timer").innerHTML = hours + ": "
                + minutes + ": " + seconds;

        }
    }

}

function togglePause() {
    var button = document.getElementById('start');

    if (pause) {
        pause = false;
        button.innerHTML = "pause";
    }
    else {
        pause = true;
        button.innerHTML = "resume";
    }
}

