package week10;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class boj1260 {
	static int matrix[][];
	static boolean[] visited;
	static int N, M, V;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		matrix = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		DFS(V);
		System.out.println();
		Arrays.fill(visited, false);
		BFS(V);

	}

	public static void DFS(int i) {
		visited[i] = true;
		System.out.print(i + " ");
		for (int j = 1; j < N + 1; j++) {
			if (matrix[i][j] == 1 && visited[j] == false) // 간선이 존재하고 && 방문하지 않았으면
			{
				DFS(j);
			}
		}
	}

	public static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>(); // int형 queue 선언, linkedlist 사용
		q.offer(i); // i를 q에 넣고
		visited[i] = true;// i번째 방문 완료
		while (!q.isEmpty())// q가 비어있지 않다면
		{
			int tmp = q.poll(); // popleft
			System.out.print(tmp + " ");
			for (int j = 1; j <= N; j++) {
				if (matrix[tmp][j] == 1 && visited[j] == false)// 간선이 존재하고 && 방문하지 않았으면
				{
					q.offer(j);
					visited[j] = true;
				}

			}

		}
	}

}
