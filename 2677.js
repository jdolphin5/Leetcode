/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function(arr, size) {
    const ret = [ ]
    let i = 0
    let subArr = [ ]
    while (i < arr.length) {
        subArr.push(arr[i])
        //console.log(subArr)
        if (subArr.length === size || i === arr.length-1) {
            ret.push(subArr)
            subArr = [ ]
        }
        i++
    }
    return ret
};