/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    const arr = new Array(nums.length)
    for (let i = 0; i < arr.length; i++) {
        if (i === 0) {
            arr[i] = fn(init, nums[0])
        }
        else {
            arr[i] = fn(arr[i-1], nums[i])
        }
    }
    if (nums.length === 0) return init
    return arr[arr.length-1]
};