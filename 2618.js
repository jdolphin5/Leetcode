/**
 * @param {any} obj
 * @param {any} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || typeof obj === 'undefined' || classFunction === null || typeof classFunction !== 'function') return false;
    const objProto = Object.getPrototypeOf(obj);
    const classProto = classFunction.prototype;

    if (objProto === classProto) return true;

    return checkIfInstanceOf(objProto, classFunction);

};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */