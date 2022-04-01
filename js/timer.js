var pause = true; //is timer paused
var isRunning = false;
var count = 0;

countTimers();

function countTimers() {

    setInterval(timer, 1000);

    function timer() {
        if (!pause) { //do something if not paused
            count = count + 1;
            /* if (count < 0) {
               clearInterval(counter);
               setTimeout(countTimers, 5000); //start count from 26 again
               return;
             } */
            var hours = Math.floor((count % (60 * 60 * 24)) / (60 * 60));
            var minutes = Math.floor((count % (60 * 60)) / 60);
            var seconds = Math.floor(count % 60);

            // Output the result in an element with id="demo"
            document.getElementById("timer").innerHTML = hours + ": "
                + minutes + ": " + seconds;

            //document.getElementById("timer").innerHTML = count;
        }
    }

    //document.getElementById("countTimers").innerHTML = timersCount;

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

