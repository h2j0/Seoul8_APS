package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class boj2667 {
	static int N;
	static int[][] apart;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		apart = new int[N][N];

		for (int i = 0; i < N; i++) {
			String ipt = br.readLine();
			for (int j = 0; j < N; j++) {
				apart[i][j] = Character.getNumericValue(ipt.charAt(j));
			}
		}
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		int na = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (apart[i][j]==1) {
					int ngr = search(N*i+j);
					pQ.add(ngr);
					na+=1;
				}
			}
		}
		System.out.println(na);
		for (int i=0; i<na; i++) {
			int tmp = pQ.poll();
			System.out.println(tmp);
		}

	}

	static int search(int root) {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		Stack<Integer> q = new Stack<>();
		q.add(root);

		int ngroup = 1;

		while (!q.isEmpty()) {
			int adr = q.pop();
			int x = adr / N;
			int y = adr % N;

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && apart[nx][ny] == 1) {
					apart[nx][ny] = -1;
					q.add(nx * N + ny);
					ngroup += 1;
				}
			}
		}
		if (ngroup != 1) {
			ngroup -= 1;
		}

		return ngroup;

	}

}
