package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] t = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i][0] = Integer.parseInt(st.nextToken());
			t[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(t, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		int i = 0;
		int tNow = 0;
		int nClass = 0;
		while (i < N) {
			int[] cNow = t[i];
			if (cNow[0] >= tNow) {
				tNow = cNow[1];
				nClass += 1;
			}
			i++;
		}
		System.out.println(nClass);

	}

}
