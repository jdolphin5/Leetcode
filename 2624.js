/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if (rowsCount * colsCount !== this.length) return [];
    const arr = this;
    let ret = [];
    for (let i = 0; i < rowsCount; i++) {
        ret.push([]);
        for (let j = 0; j < colsCount; j++) {
            let cellNumber = j * rowsCount + i;
            if (cellNumber < rowsCount * colsCount) {
                if (j % 2 == 1) {
                    cellNumber = cellNumber - i + rowsCount - i - 1;
                }
                ret[i].push(arr[cellNumber]);
            }
        }
    }
    return ret;
    

}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */