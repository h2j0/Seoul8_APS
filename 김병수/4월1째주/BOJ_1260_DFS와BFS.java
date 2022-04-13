package com.ssafy.boj.y22.m04.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BOJ_1260_DFS와BFS {
	public static Map<Integer, node> nodeMap;
	public static int N;
	public static List<Integer> path;
	public static boolean[] check;

	public static class node {
		// 인덱스로 1~N노드가 내 이웃인지 아닌지 알려줌
		private boolean[] neighbor;

		public node(boolean[] neighbor) {
			this.neighbor = neighbor;
		}

		public boolean[] getNeighbor() {
			return neighbor;
		}

		public void setNeighbor(boolean[] neighbor) {
			this.neighbor = neighbor;
		}

		@Override
		public String toString() {
			return "node [neighbor=" + Arrays.toString(neighbor) + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NMB = br.readLine().split(" ");
		N = Integer.parseInt(NMB[0]);
		int M = Integer.parseInt(NMB[1]);
		int V = Integer.parseInt(NMB[2]);

		// 노드를 담아 놓을 Map 만들기
		nodeMap = new HashMap<>();
		// 1~N 노드를 먼저 다 넣어놓기
		for (int nc = 1; nc <= N; nc++) {
			nodeMap.put(nc, new node(new boolean[N + 1]));
		}

		// 입력받아서 이웃관계 저장
		for (int mc = 0; mc < M; mc++) {
			String[] aLine = br.readLine().split(" ");
			int N1 = Integer.parseInt(aLine[0]);
			int N2 = Integer.parseInt(aLine[1]);
			// N2를 N1의 이웃리스트에 추가
			nodeMap.get(N1).getNeighbor()[N2] = true;
			// N1를 N2의 이웃리스트에 추가
			nodeMap.get(N2).getNeighbor()[N1] = true;
		}

		// DFS 결과
		path = new LinkedList<>();
		check = new boolean[N + 1];

		DFS_recur(V);
		// 출력
		for (int i = 0; i < path.size(); i++) {
			bw.write(path.get(i) + " ");
		}
		bw.write("\n");
		
		// BFS 결과
		path = new LinkedList<>();
		check = new boolean[N + 1];
		BFS(V);
		// 출력
		for (int i = 0; i < path.size(); i++) {
			bw.write(path.get(i) + " ");
		}

		bw.flush();
	}

	public static void DFS_recur(int nodeNum) {
		path.add(nodeNum);
		check[nodeNum] = true;
		boolean[] neighbor = nodeMap.get(nodeNum).getNeighbor();
		for (int i = 1; i <= N; i++) {
			// 내 이웃이면서 방문한 적이 없는 노드에 재귀를 실행한다.
			if (neighbor[i] == true && check[i] == false) {
				DFS_recur(i);
			}
		}
	}

	public static List<Integer> DFS_stack(int nodeNum) {
		int nodeN = nodeNum;
		List<Integer> path = new LinkedList<>();
		Stack<Integer> stk = new Stack<>();
		boolean[] check = new boolean[N + 1];
		whileLoop: while (true) {
			// 나 자신을 방문했음을 표시
			// 스택을 따라 되돌아올때는 path에 기록해주지 않는다.
			if (check[nodeN] == false) {
				path.add(nodeN);
			}
			stk.add(nodeN);
			check[nodeN] = true;
			for (int nIdx = 1; nIdx <= N; nIdx++) {
				// 방문 안한 이웃이 있으면
				if (nodeMap.get(nodeN).getNeighbor()[nIdx] == true && check[nIdx] == false) {
					nodeN = nIdx;
					continue whileLoop;
				}
			}
			// 방문 안한 이웃이 없지만 스택은 있을때
			if (stk.size() >= 2) {
				// 나 자신
				stk.pop();
				nodeN = stk.pop();
				// 방문 안한 이웃도 없고 되돌아갈 곳도 없다 -> 종료
			} else {
				break whileLoop;
			}

		}
		return path;
	}

	public static void BFS(int nodeNum) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(nodeNum);
		check[nodeNum] = true;
		while (!Q.isEmpty()) {
			int curr = Q.poll();
			path.add(curr);
			boolean[] neighbor = nodeMap.get(curr).getNeighbor();
			for (int i = 0; i < neighbor.length; i++) {
				if (neighbor[i] == true && check[i] == false) {
					Q.add(i);
					check[i] = true;
				}
			}
		}
	}

	// 의미 없는 DFS
	// 스택을 사용한 DFS를 깔끔하게 구성해보려했는데
	// 그냥 한가지 길만 쭉 따라가고 되돌아가는 기능없는 탐색이 되었다.
	public static void DFS_trash(int nodeNum) {
		Stack<Integer> nodeStk = new Stack<>();
		// 첫 노드 스택에 담기
		nodeStk.add(nodeNum);
		// 스택에 담긴 노드가 다시 담기는 것을 방지하기 위해
		// 스택에 넣을 때 완료표시한다.
		check[nodeNum] = true;
		while (!nodeStk.isEmpty()) {
			// 스택에서 꺼내기
			int nodeNow = nodeStk.pop();
			path.add(nodeNow);
			// 꺼낸 노드의 이웃 정보 얻기
			boolean[] neighbor = nodeMap.get(nodeNow).getNeighbor();
			// 이웃 탐색
			for (int i = 1; i <= N; i++) {
				// 내 이웃이면서 방문한 적이 없는 노드에 재귀를 실행한다.
				if (neighbor[i] == true && check[i] == false) {
					nodeStk.add(i);
					check[i] = true;
					// 첫 하나만 쌓는다!!!!!!!!!!!!!!!!!!!!!!
					break;
				}
			}
		}
	}

}

// End
