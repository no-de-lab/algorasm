Language : Typescript

성공하는데 시행착오가 많았지만 코드가 너무 길어서 최종 코드만 첨부합니다~

우선 `valueMap`에는 `set` 메서드에서 입력받은 `key`를 기준으로 `{ value, timestamp }`의 배열을 갖고있어요.

그리고 `timeMap`또한 `set` 메서드에서 입력받은 `key`를 기준으로 입력받은 `timestamp`를 배열형태로 저장해 두려고 했어요!

우선 `set`을 하면서 신경쓴 점은 `timeMap` `key`를 기준으로 가지고 있는 `number[]` 배열의 순서를 정렬된 상태로 유지하는 것 이었어요.

정렬된 상태를 유지해야 `binarySearch`를 진행 할 수 있기 때문에 새로운 `timestamp`가 들어오면 `insertAndSort` 메서드를 사용해서 값을 배열에 추가하는 동시에 정렬된 배열 상태를 유지했어요.

`get` 메서드가 들어오면 `get`의 인자로 들어온 `key`를 기준으로 `valueMap`과 `timeMap`을 가져와요!

`timeMap`에서 가져온 객체를 `valueObject` 그리고 `timeMap`을 기준으로 가져온 객체를 `timeArray`라고 서술할게요.

만약 `valueObject`나 `timeArray`가 비어있다면 빈 문자열을 리턴해주고, 만약 비어있지 않다면 인자로받은 `timeArray`와 `timestamp`를 인자로 받는 `binaryIndexSearch`를 호출해요.

이미 `timeArray`는 정렬되었기 때문에 이진 정렬을 한다면 `timestamp`와 같거나 작은 최대 타임스탬프인 `nowTimestamp`를 반환해줘요.

이 `nowTimestamp`를 기준으로 `valueObject`를 `filter`로  `obj.timestamp === nowTimestamp`인 배열을 리턴해준 `sorted`배열의 첫번째 인덱스에 정답이 들어가요!

이 값을 그대로 리턴해주면 성공합니다~
```typescript
interface ValueObjectProps {
    value: string;
    timestamp: number;
}

class TimeMap {
    _valueMap;
    _timeMap;
    constructor() {
        this._valueMap = new Map<string, ValueObjectProps[]>();
        this._timeMap = new Map<string, number[]>();
    }

    set(key: string, value: string, timestamp: number): void {
        let valueObject = this._valueMap.get(key);
        let timeObject = this._timeMap.get(key);
        if (!valueObject) {
            this._valueMap.set(key, []);
            this._timeMap.set(key, []);
            valueObject = this._valueMap.get(key);
            timeObject = this._timeMap.get(key);
        }

        if (valueObject && timeObject) {
            valueObject.push({ value, timestamp });
            insertAndSort(timeObject, timestamp);
        }
    }

    get(key: string, timestamp: number): string {
        const valueObject = this._valueMap.get(key);
        const timeArray = this._timeMap.get(key);

        if (!valueObject || !timeArray) {
            return "";
        }

        const nowTimestamp = binaryIndexSearch(timeArray, timestamp);

        const sorted = valueObject.filter(obj => obj.timestamp === nowTimestamp);

        if (!sorted.length) {
            return "";
        }

        return sorted[0].value;
    }
}

function insertAndSort(array: number[], value: number) {
    array.splice(0, 0, value);

    let index = 1;
    while (array[index] !== undefined && array[index] < array[index - 1]) {
        const temp = array[index - 1];
        array[index - 1] = array[index];
        array[index] = temp;
        index++;
    }
}

function binaryIndexSearch(array: number[], target: number): number {
    let result = 0;
    let start = 0;
    let end = array.length - 1;

    while (start <= end) {
        const mid = Math.floor((start + end) / 2);
        const index = array[mid];

        if (index < target) {
            result = Math.max(result, index);
            start = mid + 1;
            continue;
        }

        if (index > target) {
            end = mid - 1;
            continue;
        }

        if (index === target) {
            result = index;
            break;
        }
    }

    return result;
}
```