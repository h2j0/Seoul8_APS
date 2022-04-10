package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2606 {
	static int[][] tree;
	static int N;
	static int M;
	static int[] contg;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		tree = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			tree[x][y] = 1;
			tree[y][x] = 1;			
		}
		contg = new int[N+1];
		dfs(1);
		int sum = 0;
		for (int i=0; i<N+1; i++) {
			sum+= contg[i];
		}
		System.out.println(sum-1);
		
	}
	static void dfs(int v) {
		contg[v] = 1;
		for (int i=1; i<N+1; i++) {
			if (tree[v][i]==1 && contg[i]==0) {
				dfs(i);
			}
		}
	}

}
