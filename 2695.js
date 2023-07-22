/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.arr = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    let sum = 0;
    for (let i = 0; i < this.arr.length; i++) {
        sum += this.arr[i];
    }
    return sum;
}

ArrayWrapper.prototype.toString = function() {
    let ret = "[";
    for (let i = 0; i < this.arr.length; i++) {
        ret = ret.concat(this.arr[i]);
        if (i < this.arr.length-1)
            ret = ret.concat(',');
    }
    ret = ret.concat(']');
    return ret;
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */