/**
 * Created by dearshor on 23/07/2017.
 */

function getTimeRemaining(endtime) {
    var t = Date.parse(endtime) - Date.parse(new Date());
    var seconds = Math.floor((t / 1000) % 60);
    var minutes = Math.floor((t / 1000 / 60) % 60);
    var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
    var days = Math.floor(t / (1000 * 60 * 60 * 24));
    return {
        'total': t,
        'days': days,
        'hours': hours,
        'minutes': minutes,
        'seconds': seconds
    };
}

function initializeClock(clock, endtime) {

    function updateClock() {
        var t = getTimeRemaining(endtime);

        clock.days = t.days;
        clock.hours = ('0' + t.hours).slice(-2);
        clock.minutes = ('0' + t.minutes).slice(-2);
        clock.seconds = ('0' + t.seconds).slice(-2);

        if (t.total <= 0) {
            clearInterval(timeinterval);
        }
    }

    updateClock();
    var timeinterval = setInterval(updateClock, 1000);
}

function initDialogPosition() {
    var initNum = 0;

    var timeinterval = setInterval(function () {
        if(initNum > 0){
            clearInterval(timeinterval);
            initNum = 0;
        }
        if($(".shopweb_left_over")){
            $(".shopweb_left_over").scrollTop($(".maxhigth").height());
        }
        initNum ++;
    },1000)

}

