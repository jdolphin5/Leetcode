var TimeLimitedCache = function() {
    this.data = {};
    this.active = 0;
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    //if this.data[key].isActive is null then set to false
    const prevActive = !!this.data[key]?.isActive;
    //if timeout for key is active, clear timeout else inc count
    prevActive ? clearTimeout(this.data[key].timeoutId) : this.active++;
    //set timeout for key (timer of duration) - dec count and set false if runs out
    const timeoutId = setTimeout(() => {
        this.active--;
        this.data[key].isActive = false;
    }, duration);
    //set key to active
    this.data[key] = {
        isActive: true,
        value,
        timeoutId
    }
    return prevActive;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    return this.data[key]?.isActive ? this.data[key].value : -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.active;
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */