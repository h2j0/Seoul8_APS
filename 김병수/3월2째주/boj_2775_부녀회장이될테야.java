package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2775_부녀회장이될테야 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tIdx = 1; tIdx <= T; tIdx++) {

			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());

			int[][] AP = new int[K + 1][N + 1];

			// 테두리는 인원이 확정됨
			// 층은 0층부터, 호는 1호부터
			for (int ho = 1; ho <= N; ho++) {
				// 0층은 호가 곧 인원수
				AP[0][ho] = ho;
			}
			for (int flo = 0; flo <= K; flo++) {
				// 1호는 무조건 1명
				AP[flo][1] = 1;
			}

			// 내 집 바로 아랫집과 옆집(작은 호수)의 인원수 합이
			// 내 집 인원수
			for (int flo = 1; flo <= K; flo++) {
				for (int ho = 2; ho <= N; ho++) {
					AP[flo][ho] = AP[flo-1][ho] + AP[flo][ho-1];
				}
			}

			// 출력
			bw.write(AP[K][N]+"\n");
			bw.flush();
		}
		bw.close();
	}
}
// End
