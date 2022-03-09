package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_7568_덩치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] human = new int[N][3];
		int weightIdx = 0;
		int heightIdx = 1;
		int rankIdx = 2;
		for (int n = 0; n < N; n++) {
			String inNum = br.readLine();
			String[] Arr = inNum.split(" ");

			human[n][weightIdx] = Integer.parseInt(Arr[0]);
			human[n][heightIdx] = Integer.parseInt(Arr[1]);
			// 덩치 큰 사람이 k명이라면 그 사람의 덩치 등수는 k+1
			human[n][rankIdx] = 1;
		}

		// 본인 보다 덩치 큰 사람수 조사
		for (int main = 0; main < N; main++) {
			for (int sub = 0; sub < N; sub++) {
				if (human[main][weightIdx] < human[sub][weightIdx]
						&& human[main][heightIdx] < human[sub][heightIdx]) {
					human[main][rankIdx]++;
				}
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			bw.write(human[i][rankIdx] + " ");
		}
		bw.flush();
		bw.close();
	}
}
// End
