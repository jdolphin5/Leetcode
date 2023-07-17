Array.prototype.last = function() {
    const len = this.length;
    if (len === 0) return -1;
    return this.pop();
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */