## 1차 풀이
count(동전을 몇번 넣었는지)를 올리면서 각 count 마다 최대의 값을 set에 매번 갱신해줬어요.

원래 dp에 각 set을 다 넣어주려 했는데 몇 번째까지 들어갈지 판단하는 과정도 불필요 할거 같아서 생각해다가 set을 temp array에 넣고 매번 Set을 다시 할당해서 넣는 방식으로 작성했어요.

공간복잡도 면에서도 더 효율적일듯 합니다! (애용해야겠네요)

Set에 만약 amount와 같은 값이 있다면 해당 count를 리턴하고, 만약 count에서 가장 적은값이 amount를 넘어가면 이후로는 코인을 넣어도 항상 실패하니까 -1을 리턴해줬어요.

<code>coinChange([2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24], 9999)</code> 하지만 케이스에 시간초과가 뜨네요 

최적화를 더 해봅시다 :)
```typescript
function coinChange(coins: number[], amount: number): number {
    let coinsDp = new Set([0]);

    let count = 0;
    while (true) {
        if (coinsDp.has(amount)) {
            break;
        }

        const temp: number[] = [];

        let min = Infinity;

        coinsDp.forEach(elem => {
            if (elem < min) {
                min = elem;
            }

            temp.push(elem);
        });

        // 제일 작은 dp가 최종 amount 넘어서면 break
        if (min > amount) {
            return -1;
        }

        coinsDp = new Set();

        temp.forEach(elem => {
            coins.forEach(coin => {
                coinsDp.add(elem + coin);
            });
        });

        count++;
    }

    return count;
}
```

## 2차 풀이
실패한 케이스를 다시봅시다!

<code>coinChange([2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24], 9999)</code>

음... 보시면 2의 배수로 상당히 많은 인자들이 들어가 있는 게 보이실 거예요.

이렇게 들어간다면 1번째에 2원을 넣고 2번째에 4원을 넣는다면 6원이 되겠죠?

하지만 3번째에 1번에 2원 2번에 2원 3번에 2원을 넣는 케이스를 한 번 더 돌려야 해요.

당연히 이전 단계에서 6원을 계산했으니까 3번째에 6원이라는 요소를 넣어 줄 필요는 없겠죠?

이런 케이스를 없애려고 하다보니 trashSet이라는  Set을 하나 더 선언해서 이전에 계산했던 요소가 있으면 추가적으로 계산을 하지않게 작성했어요.(성공)
```typescript
function coinChange(coins: number[], amount: number): number {
    let coinsDp = new Set([0]);
    const trashSet = new Set([0]);

    let count = 0;
    while (true) {
        if (coinsDp.has(amount)) {
            break;
        }

        const temp: number[] = [];

        let min = Infinity;

        coinsDp.forEach(elem => {
            if (elem < min) {
                min = elem;
            }

            temp.push(elem);
        });

        // 제일 작은 dp가 최종 amount 넘어서면 break
        if (min > amount) {
            return -1;
        }

        coinsDp = new Set();

        temp.forEach(elem => {
            coins.forEach(coin => {
                const sum = elem + coin;
                if (!trashSet.has(sum)) {
                    coinsDp.add(sum);
                    trashSet.add(sum);
                }
            });
        });

        count++;
    }

    return count;
}
```