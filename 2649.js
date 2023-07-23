/**
 * @param {Array} arr
 * @return {Generator}
 */


var flat = function (arr) {
    let ret = []
    for (let i = 0; i < arr.length; i++) {
        if (Array.isArray(arr[i])) {
            ret.push(...flat(arr[i])); //spread because recursive ret could be multiple elements
        }
        else {
            ret.push(arr[i]);
        }
    }
    return ret
};


var inorderTraversal = function*(arr) {
    const ret = flat(arr);
    let i = 0;
    while (i < ret.length) {
        yield ret[i];
        i++;
    }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */