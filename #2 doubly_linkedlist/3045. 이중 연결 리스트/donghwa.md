언어: Java
시간초과나네요.. 
```.java
package doublyLinkedList3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DoublyLinkedList {
	public static int N;
	public static int M;
	public static Node[] nodeSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().trim().split(" ");
		N = Integer.parseInt(input1[0]);
		M = Integer.parseInt(input1[1]);
		// nodeSet 초기화
		nodeSet = new Node[N+2];
		for(int i=0; i<=N+1; i++)
			nodeSet[i] = new Node(i);
		for(int i=1; i<=M; i++) {
			String[] input2 = br.readLine().trim().split(" ");
			char type = input2[0].charAt(0);
			int x = Integer.parseInt(input2[1]);
			int y = Integer.parseInt(input2[2]);
			changeNode(type, x, y);
		}
		// 가장 긴 정렬된 노드 셋 찾기
		int maxScoreFirstNode = 0;
		int maxScore = 0;
		int[] score = new int[N+2];
		int[] nextNode = new int[N+2];
		for(int i=nodeSet[N+1].prev; i>0; i=nodeSet[i].prev) {
			for(int j=i; j<N+1; j=nodeSet[j].next) { 
				if(i < nodeSet[j].next && score[nodeSet[j].next]+1 > score[i]) {
					nextNode[i] = nodeSet[j].next;
					score[i] = score[nodeSet[j].next]+1;
					if(score[nodeSet[j].next] == maxScore)
						break;
				}
			}
			if(score[i]>=maxScore) {
				maxScore = score[i];
				maxScoreFirstNode = i;
			}
		}
		System.out.println(N-maxScore);
		for(int i=maxScoreFirstNode; i>1; i--) {
			System.out.println("A " + Integer.toString(i-1) + " " + Integer.toString(i));
		}
		for(int i=nextNode[maxScoreFirstNode]; i<N+1; i=nextNode[i]) {
			for(int j=i; j<nextNode[i]-1; j++) {
				System.out.println("B " + Integer.toString(j+1) + " " + Integer.toString(j));
			}
		}
		
	}
	public static void changeNode(char type, int x, int y) {
		// a <-> x <-> b => a <-> b
		nodeSet[nodeSet[x].prev].next = nodeSet[x].next;
		nodeSet[nodeSet[x].next].prev = nodeSet[x].prev;
		if(type == 'A') {
			// c <-> y => c <-> x <-> y
			nodeSet[x].prev = nodeSet[y].prev;
			nodeSet[x].next = y;
			nodeSet[nodeSet[y].prev].next = x;
			nodeSet[y].prev = x;
		}
		if(type == 'B') {
			// y <-> c => y <-> x <-> c
			nodeSet[x].prev = y;
			nodeSet[x].next = nodeSet[y].next;
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
