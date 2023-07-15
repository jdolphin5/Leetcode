/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    this.active = false
    this.data = {}
    return function(...args) {
        
        if (this.active === true)
            clearTimeout(this.data.timeoutId)

        const timeoutId = setTimeout(() => {
            fn(...args)
            this.active = false
        }, t);

        this.active = true
        this.data = {
            timeoutId
        }
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */