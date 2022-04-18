package Apr_2nd_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2606_바이러스 {
	static boolean[][] adjArr; // 인접 배열
	static int[] dist;
	static boolean[] check; // 방문처리
	static Queue<Integer> queue = new LinkedList<>();
	static int ansDist, contaminated, v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine()); // 노드 개수
		int n = Integer.parseInt(br.readLine()); // 간선 개수
		
		adjArr = new boolean[v+1][v+1];
		check = new boolean[v+1];
		dist = new int[v+1];
		ansDist = -1;
		
		
		// 간선 입력 받자
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int head = Integer.parseInt(st.nextToken());
			int tail = Integer.parseInt(st.nextToken());
			
			// 무향 그래프
			adjArr[head][tail] = true;
			adjArr[tail][head] = true;
			
		}
		
		// bfs로 탐색
		bfs(1);
		
		System.out.println(contaminated);
	}// main 종료

	private static void bfs(int k) {
		queue.add(k);
		check[k] = true;
		contaminated = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int i = 1; i<= v ; i++) {
				if(adjArr[curr][i] && !check[i]) {
					queue.add(i);
					contaminated++;
					check[i] = true;
				}
				
			}
			
			
		}
	}

}
