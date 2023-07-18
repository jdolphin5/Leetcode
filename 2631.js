/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function(fn) {
    let ret = { };
    for (let i = 0; i < this.length; i++) {
        let key = fn(this[i]);
        if (ret[key] === undefined) ret[key] = [];
        ret[key].push(this[i]);
    }

    return ret;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */