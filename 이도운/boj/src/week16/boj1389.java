package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1389 {
	static int n;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		int[] dist = new int[n];
		for (int i=0; i<n; i++) {
			dist[i] = bfs(i+1);
		}
		int[] minIdx = {Integer.MAX_VALUE, 0};
		for (int i=0; i<n; i++) {
			if (minIdx[0]>dist[i]) {
				minIdx[0] = dist[i];
				minIdx[1] = i+1;
			}
		}
		System.out.println(minIdx[1]);
		
	}

	static int bfs(int root) {
		int[] distance = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			distance[i] = -1;
		}
		distance[root] = 0;

		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(root);

		while (!dq.isEmpty()) {
			int node = dq.pollFirst();
			for (int nextNode = 1; nextNode < n + 1; nextNode++) {
				if (graph[node][nextNode] > 0 && distance[nextNode] < 0) {
					dq.add(nextNode);
					distance[nextNode] = distance[node] + 1;
				}
			}
		}
		int sum = 0;
		for (int i = 1; i < distance.length; i++) {
			sum += distance[i];
		}

		return sum;
	}

}
