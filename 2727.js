/**
 * @param {Object | Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    if (Object.values(obj).length === 0) return true;
    return false;
};