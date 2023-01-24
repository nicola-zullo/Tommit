
$(document).ready(function() {
	
	// declare vars
	var tweenOriginOffset = 773,
			tweenMinuteOffset = 30,
			sessionTimeMin = 25,
			breakTimeMin = 5,
			timer = null,
			isSession = true,
			playState = 'stopped', // playing, paused, stopped
			largeViewBox = '1095 0 3200 100',
			desktopViewBox = '1695 0 2000 100',
			mediumViewBox = '1944 0 1500 100',
			smallViewBox = '2195 0 1000 100';
	
	// jQuery Elements
	var $body = $('body'),
			$window = $(window),
			$document = $(document),
			$sessionTypeCheckbox = $('#session-type-checkbox'),
			$countdownTimerText = $('#timer-countdown'),
			$timerIncrease = $('#timer-increase'),
			$timerDecrease = $('#timer-decrease');
	
	
	var tickSVGElement = document.getElementById('timer-ticks');
	
	// create timer and tick controller
	var sessionTimer = new Timer(sessionTimeMin * 60); // time in seconds
	var breakTimer = new Timer(breakTimeMin * 60);
	var ticks = new TimerTickController(
				$('#mark-container'),
				tweenOriginOffset, 
				tweenMinuteOffset, 
				sessionTimeMin);
	
	var timer = sessionTimer;
	
	resizeBody();
	
	// resize svg viewBox dependion viewport size
	$(window).resize(function() {
		resizeBody();
		var width = $(this).width();
		if (width <= 480) {
			tickSVGElement.setAttribute('viewBox', smallViewBox);
		} 
		else if (width > 480 && width <= 768) {
			tickSVGElement.setAttribute('viewBox', mediumViewBox);
		} else if (width > 768 && width <= 1350) {
			tickSVGElement.setAttribute('viewBox', desktopViewBox);
		} else {
			tickSVGElement.setAttribute('viewBox', largeViewBox);
		}
	});
	
	
	/**********************
	 *
	 * Events
	 *
	 *********************/
	
	// click events
	$timerIncrease.click(function() {
		if (isSession && sessionTimeMin < 60) {
			sessionTimeMin += 1;
			sessionTimer.setTime(sessionTimeMin*60).reset().update();
		} else if (!isSession && breakTimeMin < 60) {
			breakTimeMin += 1;
			breakTimer.setTime(breakTimeMin*60).reset().update();
		}
	});
	
	$timerDecrease.click(function() {
		if (isSession && sessionTimeMin > 1) {
			sessionTimeMin -= 1;
			sessionTimer.setTime(sessionTimeMin*60).reset().update();
		} else if (!isSession && breakTimeMin > 1) {
			breakTimeMin -= 1;
			breakTimer.setTime(breakTimeMin*60).reset().update();
		}
	});
	
	$('#btn-restart').click(function() {
		sessionTimer.reset();
		breakTimer.reset();
		timer.update();
		playState = 'stopped';
	});
	
	$('#btn-play-control').click(function() {
		
		$(this).removeClass('initial-play-state');
		$body.toggleClass('playing');
		$sessionTypeCheckbox.attr('disabled', $sessionTypeCheckbox.is(':disabled') === true ? false : true);
		$('#btn-restart').attr('disabled', $('#btn-restart').is(':disabled') === true ? false : true);
		
		switch (playState) {
			case 'stopped':
				ticks.countDown();
				timer.run();
				playState = 'playing';
				break;
			case 'paused':
				ticks.resume();
				timer.run();
				playState = 'playing';
				break;
			case 'playing':
				ticks.pause();
				timer.stop();
				playState = 'paused';
				break;
		}
		
	});
	
	// change events
	$sessionTypeCheckbox.on('change', function() {
		toggleSessionType();
	});
	
	
	// window events fired by timer
	$window.on('timerUpdate', function(event, time) {
		updateTimer(time);
		ticks.moveTo(time/60);
	});
	
	$window.on('timerFinished', function() {
		var timerToReset = timer;
		var bell = "http://www.oringz.com/oringz-uploads/sounds-924-long-chime-sound.mp3";
		var audio = new Audio(bell);
		audio.play();
		var toggle = setInterval(function() {
			
			toggleSessionType();
			clearInterval(toggle);
			
			var start = setInterval(function() {
				timerToReset.reset();
				timer.run();
				ticks.countDown();
				clearInterval(start);
			}, 1500);
		}, 1500);
		
	});
	
	$('#title-element').click(function() {
		$window.trigger('timerFinished');
	})
	
	/**********************
	 *
	 * Functions
	 *
	 *********************/
	
	function resizeBody() {
		$body.css('height', 'auto');
		$body.css('height', $document.height());
	}
	
	function updateTimer(seconds) {
		var min = Math.floor(seconds/ 60);
		var sec = seconds % 60;
		
		if (sec < 10) {
			sec = '0'+sec;
		}
		
		
		var minHtml = '';
		var secHtml = '';
		min = min.toString().split('');
		sec = sec.toString().split('');
		for(var i = 0; i < min.length; i++) {
			minHtml += '<span class="timer__countdown-char">'+min[i]+'</span>';
		}
		for(var i = 0; i < sec.length; i++) {
			secHtml += '<span class="timer__countdown-char">'+sec[i]+'</span>';
		}
		
		$countdownTimerText.html(minHtml + ':' + secHtml);
	}
	
	var toggleSessionType = function() {
		if (isSession) {
			$sessionTypeCheckbox.prop('checked', true);
			timer = breakTimer;
			timer.update();
			$body.addClass('green');
			isSession = false;
		} else {
			$sessionTypeCheckbox.prop('checked', false);
			timer = sessionTimer;
			timer.update();
			$body.removeClass('green');
			isSession = true;
		}
	}
});


/**
 * Creates a timer to countdown over a given time.
 * 
 * @param integer 	Time to run in seconds
 * @param jQuery 	Object Object reference to trigger events on. Defaults to window
 * @param integer 	Timer interval. Defaults to 1000
 */
var Timer = function(timeSpan, element, interval) {
	this.time = timeSpan * 1000;
	this.interval = typeof interval !== 'undefined' ? interval : 1000;
	this.runningTime = this.time;
	this.$element = typeof element !== 'undefined' ? element : $(window);
}

/**
 * Sets time span for the timer to run.
 * 
 * @param integer 	Time in seconds
 */
Timer.prototype.setTime = function(timeSpan) {
	this.time = timeSpan * 1000;
	
	return this;
}

Timer.prototype.update = function() {
	this.$element.trigger('timerUpdate', [this.timeInSeconds()]);
	
	return this;
}

/**
 * Resets running timer to total running time.
 * 
 * @return Timer
 */
Timer.prototype.reset = function() {
	this.stop();
	this.runningTime = this.time;
	
	return this;
}

/**
 * Fires 'updateTimer' event on provided element
 * 
 * @return Timer
 */
Timer.prototype.run = function () {
	var _this = this;
	this.$element.trigger('timerStarted');
	this.timer = setInterval(function() {
		_this.runningTime -= _this.interval;
		
		_this.update();

		if (_this.runningTime <= 0) {
			_this.$element.trigger('timerFinished');
			clearInterval(_this.timer);
		}
		
	}, this.interval);
	
	return this;
}

/**
 * @return Timer
 */
Timer.prototype.stop = function() {
	clearInterval(this.timer);
	this.$element.trigger('timerStopped');
	
	return this;
}

/**
 * @return integer 	Time in seconds
 */
Timer.prototype.timeInSeconds = function() {
	return this.runningTime / 1000;
}

// END TIMER DEF

var TimerTickController = function(element, origin, tickOffset, defaultTime) {
	this.$el = element;
	this.origin = origin;
	this.tickOffset = tickOffset;
	this.time = typeof defaultTime !== 'undefined' ? defaultTime : 5;
	
	this.moveTo(this.time, 2);
}

TimerTickController.prototype.moveTo = function(time, interval, easing) {
	this.time = time;
	var i = typeof interval !== 'undefined' ? interval : 1;
	var easingFunction = typeof easing !== 'undefined' ? easing : Power1.easeInOut;
	var dest = this.origin - (time * this.tickOffset);
	
	this.tween = TweenLite.to(this.$el, i, {x: dest, ease: easingFunction});
}

// interval in seconds
TimerTickController.prototype.countDown = function(interval) {
	var int = typeof interval !== 'undefined' ? interval : this.time;

	this.moveTo(0, int*60, Linear.easeNone);
}

TimerTickController.prototype.pause = function () {
	this.tween.pause();
}

TimerTickController.prototype.resume = function () {
	this.tween.resume();
}

TimerTickController.prototype.stop = function () {
	this.tween.kill();
}

$(document).ready(function() {
	// Transition effect for navbar
	$(window).scroll(function() {
		// checks if window is scrolled more than 500px, adds/removes solid class
		if($(this).scrollTop() > 500) {
			$('.navbar').addClass('solid');
		} else {
			$('.navbar').removeClass('solid');
		}
	});
});