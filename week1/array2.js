/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    if (intervals.length === 1) return intervals;

    intervals.sort((a, b) => a[0] - b[0]);
    
    for (let i = 0; i < intervals.length - 1; i++) {
        if (intervals[i][1] >= intervals[i + 1][0]) {
            intervals[i + 1] = mergeTuples(intervals[i], intervals[i + 1]);
            intervals[i] = null;
        }
    }

    return intervals.filter(c => c !== null);
};

const mergeTuples = (tupleA, tupleB) => {
    return [Math.min(tupleA[0], tupleB[0]) , Math.max(tupleA[1], tupleB[1])];
}

