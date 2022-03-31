var timersCount = 0;
var pause = false; //is timer paused
var isRunning = false;


function countTimers() {
    timersCount++;
    
    if (isRunning) {
        return;
    }

    isRunning = true;
    var count = 0;
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
            document.getElementById("timer").innerHTML = hours + "h "
                + minutes + "m " + seconds + "s ";

            //document.getElementById("timer").innerHTML = count;
        }
    }

    document.getElementById("countTimers").innerHTML = timersCount;


    document.getElementById('pause').addEventListener('click', function () {
        pause = true;
    });

    document.getElementById('resume').addEventListener('click', function () {
        pause = false;
    });
}

