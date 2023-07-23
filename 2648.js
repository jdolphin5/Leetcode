/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let i = 0;
    let arr = []
    while (i < 2) {
        arr.push(i);
        yield i
        i++;
    }
    while (true) {
        let val = arr[i-1]+arr[i-2];
        arr.push(val);
        i++;
        yield val;
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */