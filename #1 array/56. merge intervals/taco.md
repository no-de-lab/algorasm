###### 배열 56. Merge Intervals

```
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
   const merging = (acc, cur) =>
   (!acc.length || acc[acc.length - 1][1] < cur[0] ? acc.push(cur) :
                                  acc[acc.length - 1][1] = Math.max(acc[acc.length-1][1], cur[1]),acc)

   return intervals.sort((a,b) => a[0] - b[0]).reduce(merging,[]);

}
```
