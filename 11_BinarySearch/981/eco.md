Link : https://leetcode.com/problems/time-based-key-value-store/

Language : JavaScript


```javascript
/**
 * Initialize your data structure here.
 */
var TimeMap = function() {
    this.map = new Map();
};

/** 
 * @param {string} key 
 * @param {string} value 
 * @param {number} timestamp
 * @return {void}
 */
TimeMap.prototype.set = function(key, value, timestamp) {
    const temp = {
        v: value,
        t: timestamp,
    };
    
    if (this.map.get(key) !== undefined) {
        this.map.get(key).push(temp);
    } else {
        this.map.set(key, [temp]);
    }
    
    /*
     
     map = {
        key1 : [
            {
                v: value,
                t: timestamp1,
            },
            {
                v: value,
                t: timestamp2,
            },
            {
                v: value,
                t: timestamp3,
            },
            ....
        ],
        key2 : [
            {
                v: value,
                t: timestamp1,
            },
            {
                v: value,
                t: timestamp2,
            },
            {
                v: value,
                t: timestamp3,
            },
            ....
        ], 
        ...
     }
     
     *** 중요한 점은 timestamp 가 계속 증가한다는 점 => 정렬된 배열 => binary search 가능
     *** 만약 정렬된 배열이 아니었으면 => 최대 t 를 찾기 위해 for loop 으로 뒤에서부터 하나씩 모두 검사해야함 
     */
    
};

/** 
 * @param {string} key 
 * @param {number} timestamp
 * @return {string}
 */
TimeMap.prototype.get = function(key, timestamp) {
    const cur = this.map.get(key);
    
    // Edge Case
    if (cur === undefined || timestamp < cur[0].t) return "";
    
    // Binary Search
    let left = 0;
    let right = cur.length - 1;
    let mid;
    while (right - left > 1) {
        mid = Math.floor((left + right) / 2);
    
        if (cur[mid].t > timestamp) {
            right = mid; 
        } else if (cur[mid].t <= timestamp) {
            left = mid;
        }
    }
    
    // right 인지 left 인지 한번 더 체크 해주는 이유 :
    // cur.length = 2 일 경우 위의 while 문이 돌지 않아 어느 것이 최대 t 인지 알 수 없기 때문
    // (cur.length > 2 일 경우 위의 while 문을 통해 cur[left] 의 t 가 최대값인 것을 알 수 있음)
    if (cur[right].t <= timestamp) return cur[right].v;
    else return cur[left].v;
};

/** 
 * Your TimeMap object will be instantiated and called as such:
 * var obj = new TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */ 
```
