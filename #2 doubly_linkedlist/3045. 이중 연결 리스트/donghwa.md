언어: Java
시간초과나네요.. 다른방법으로 
```.java
package doublyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DoublyLinkedList {
	public static int N;
	public static int M;
	public static Node[] nodeSet;
	public static ArrayList<String> changeSet = new ArrayList<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] _t = br.readLine().trim().split(" ");
		N = Integer.parseInt(_t[0]);
		M = Integer.parseInt(_t[1]);
		nodeSet = new Node[N+1];
		// initialize nodeSet
		for(int i=1;i<=N;i++)
			nodeSet[i] = new Node(i);
		// change node
		for(int i=1;i<=M;i++) {
			String[] _t2 = br.readLine().trim().split(" ");
			char type = _t2[0].charAt(0);
			int x = Integer.parseInt(_t2[1]);
			int y = Integer.parseInt(_t2[2]);
			changeNode(type, x, y);
		}
		// Sorting
		int left = 1;
		int right = N;
		// left와 right가 같아질 때까지 반복(같아지면 정렬 완료)
		while(left<right) {
			while(nodeSet[left].prev == left - 1) {
				left++;
				if(left >= right)
					break;
			}
			while(nodeSet[right].next == right + 1) {
				right--;
				if(left >= right)
					break;
			}
			// weight: 가중치, direction: 방향(0:left, 1:right), pointX(이동할 노드), pointY(이동할 지점)
			int weight = 0, direction = -1, pointX = 0, pointY = 0;
			int _weight = 0, _point = 0;
			for(int i=left; i<=right; i++) {
				if(nodeSet[i].prev == i-1 && nodeSet[i].next == i+1)
					continue;
				int k=i;
				// 오른쪽으로 이동
				while(nodeSet[k].next <= right) {
					k = nodeSet[k].next;
					if(i>k) {
						_point = k;
						_weight++;
					}
				}
				if(weight<_weight) {
					weight=_weight;
					pointX = i;
					pointY = _point;
					direction = 1;
				}
				_weight = 0;
				k=i;
				// 왼쪽으로 이동
				while(nodeSet[k].prev >= left) {
					k = nodeSet[k].prev;
					if(i<k) {
						_point = k;
						_weight++;
					}
				}
				if(weight<_weight) {
					weight=_weight;
					pointX = i;
					pointY = _point;
					direction = 0;
				}
				_weight = 0;
			}
			if(direction == 0) {
				String _item = "A "+Integer.toString(pointX)+" "+Integer.toString(pointY);
				changeSet.add(_item);
				changeNode('A', pointX, pointY);
			} else if(direction == 1){
				String _item = "B "+Integer.toString(pointX)+" "+Integer.toString(pointY);
				changeSet.add(_item);
				changeNode('B', pointX, pointY);
			}
		}
		// 정답 출력
		System.out.println(changeSet.size());
		for(int l=0;l<changeSet.size();l++) {
			System.out.println(changeSet.get(l));
		}
	}
	
	public static void changeNode(char type, int x, int y) {
		if(type == 'A') {
			// no change
			if(nodeSet[x].next == y) // no change
				return;
			// a <-> x <-> b => a <-> b
			if(nodeSet[x].prev > 0)
				nodeSet[nodeSet[x].prev].next = nodeSet[x].next;
			if(nodeSet[x].next <= N)
				nodeSet[nodeSet[x].next].prev = nodeSet[x].prev;
			// c <-> y => c <-> x <-> y
			nodeSet[x].prev = nodeSet[y].prev;
			nodeSet[x].next = y;
			if(nodeSet[y].prev > 0)
				nodeSet[nodeSet[y].prev].next = x;
			nodeSet[y].prev = x;
			
		}
		if(type == 'B') {
			// no change
			if(nodeSet[x].prev == y)
				return;
			// a <-> x <-> b => a <-> b
			if(nodeSet[x].prev > 0)
				nodeSet[nodeSet[x].prev].next = nodeSet[x].next;
			if(nodeSet[x].next <= N)
				nodeSet[nodeSet[x].next].prev = nodeSet[x].prev;
			// y <-> c => y <-> x <-> c
			nodeSet[x].prev = y;
			nodeSet[x].next = nodeSet[y].next;
			if(nodeSet[y].next <= N)
				nodeSet[nodeSet[y].next].prev = x;
			nodeSet[y].next = x;
		}
	}
}

class Node {
	int prev;
	int next;
	Node(int val){
		prev = val-1;
		next = val+1;
	}
}
```
