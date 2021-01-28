```cpp
#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
#include <climits>
using namespace std;

const int MAX = 5 * 1e5;

typedef struct
{
	int prev, next;
}Node;

Node doublyLinkedList[MAX + 2];

int N, M;
int cache[MAX + 1];
int st[MAX + 1];

int main(void)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;

	for (int i = 0; i <= N + 1; i++)
	{
		doublyLinkedList[i].next = i + 1;
		if (i == 0)
		{
			continue;
		}
		doublyLinkedList[i].prev = i - 1;
	}

	for (int i = 0; i < M; i++)
	{
		char op;
		int a, b;
		cin >> op >> a >> b;

		doublyLinkedList[doublyLinkedList[a].next].prev = doublyLinkedList[a].prev;
		doublyLinkedList[doublyLinkedList[a].prev].next = doublyLinkedList[a].next;

		switch (op)
		{
		case 'A':
			doublyLinkedList[a].prev = doublyLinkedList[b].prev;
			doublyLinkedList[a].next = b;

			break;
		case 'B':
			doublyLinkedList[a].prev = b;
			doublyLinkedList[a].next = doublyLinkedList[b].next;

			break;
		}

		doublyLinkedList[doublyLinkedList[a].next].prev = a;
		doublyLinkedList[doublyLinkedList[a].prev].next = a;
	}

	cache[0] = 0;

	for (int i = 1; i <= N; i++)
	{
		cache[i] = INT_MAX;
	}

	int longestIncreasingLength = 0;

	for (int i = doublyLinkedList[0].next; i != N + 1;i = doublyLinkedList[i].next)
	{
		int idx = lower_bound(cache, cache + N, i) - cache;

		cache[idx] = i;
		st[i] = cache[idx - 1];

		longestIncreasingLength = max(longestIncreasingLength, idx);
	}

	int result = N - longestIncreasingLength;
	cout << result << "\n";
	vector<int> v;

	for (int i = cache[longestIncreasingLength]; i; i = st[i])
	{
		v.push_back(i);
	}

	reverse(v.begin(), v.end());

	int idx = 1;

	for (int i = 0; i < longestIncreasingLength; idx++)
	{
		if (v[i] == idx)
		{
			i++;
			continue;
		}
		cout << "A " << idx << " " << v[i] << "\n";
	}

	for (int i = idx, j = v[v.size() - 1]; i <= N; i++)
	{
		cout << "B " << i << " " << j << "\n";
		j = i;
	}

	return 0;
}
```
