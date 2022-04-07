package BOJ.Study.Week11_Apr1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int[][] graph;
	static int n;
	static boolean[] visited;
	static List<Integer> dfsRes;
	static List<Integer> bfsRes;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		} // 그래프 입력

//		for (int i = 0; i < n+1; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
//		System.out.println();

		// dfs
		visited = new boolean[n + 1];
		dfsRes = new ArrayList<>();
		dfs(v);

		// bfs
		bfsRes = new ArrayList<>();
		bfs(v);

		// 출력
		for (int i = 0; i < dfsRes.size(); i++) {
			sb.append(dfsRes.get(i)).append(" ");
		}
		sb.append("\n");
		for (int i = 0; i < bfsRes.size(); i++) {
			sb.append(bfsRes.get(i)).append(" ");
		}
		System.out.println(sb);

	}// main

	public static void bfs(int v) {
		// 큐 생성
		Queue<Integer> q = new LinkedList<>();
		// 박문철이 생성
		boolean[] visited2 = new boolean[n + 1];

		q.add(v); // 입력되는 정점 큐에 넣어주고
		visited2[v] = true; // 박문철하고
		while (!q.isEmpty()) { // 큐가 빌 때까지
			int curr = q.poll(); // 큐에서 하나 꺼낸 값을
			bfsRes.add(curr); // bfs결과 리스트에 넣어준다
			for (int i = 1; i <= n; i++) { // 그 현재 값의 인접한 애들 검사
				// 인접하지 않거나 (0) 박문철했으면 제껴
				if (graph[curr][i] == 0 || visited2[i]) {
					continue;
				}
				// 제껴지지 않은 애들은
				q.add(i); // 큐에 넣고
				visited2[i] = true; // 박문철2
			}
		}
	}// bfs

	public static void dfs(int v) {
		// 종료 조건
		if (dfsRes.size() == n) {
			return;
		}
		// 방문처리
		visited[v] = true;
		// 정점 담기
		dfsRes.add(v);

		// 순회
		for (int i = 1; i <= n; i++) {
			// 연결이 안되어있거나 이미 방문했으면 제껴
			if (graph[v][i] == 0 || visited[i]) {
				continue;
			}
			dfs(i);
		}
	}// dfs

}
