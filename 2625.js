/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    let ret = []
    for (let i = 0; i < arr.length; i++) {
        if (n > 0 && Array.isArray(arr[i])) {
            ret.push(...flat(arr[i], n-1)) //spread because recursive ret could be multiple elements
        }
        else {
            ret.push(arr[i])
        }
    }
    return ret
};