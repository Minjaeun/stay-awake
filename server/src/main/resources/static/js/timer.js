var pause = true;
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

function startTimer() {
    pause = false;
}

function pauseTimer() {
    pause = true;
}