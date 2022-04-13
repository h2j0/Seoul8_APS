package com.ssafy.boj.y22.m04.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class BOJ_2961_도영이음식 {
	public static class ingre {

		private int sour;
		private int bitter;

		public ingre(int sour, int bitter) {
			super();
			this.sour = sour;
			this.bitter = bitter;
		}

		public int getSour() {
			return sour;
		}

		public void setSour(int sour) {
			this.sour = sour;
		}

		public int getBitter() {
			return bitter;
		}

		public void setBitter(int bitter) {
			this.bitter = bitter;
		}

		@Override
		public String toString() {
			return "ingre [sour=" + sour + ", bitter=" + bitter + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<ingre> ingredients = new ArrayList<>();

		// 재료 저장
		for (int nc = 1; nc <= N; nc++) {
			String[] input = br.readLine().split(" ");
			ingredients.add(new ingre(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
		}

		// 비트마스킹을 이용하여 부분집합 구하기
		long minDiff = 1000000000;
		// 재료를 적어도 하나는 사용해야 하므로 subset=1로 시작해야 한다.
		for(int subset=1; subset < (1 << N); subset++) {
			long totalS = 1;
			long totalB = 0;
			for(int bitScan=0; bitScan<N;bitScan++) {
				if( (subset & (1<<bitScan)) >0 ){
					totalS*=ingredients.get(bitScan).getSour();
					totalB+=ingredients.get(bitScan).getBitter();
				}
			}
			long diff = Math.abs(totalS-totalB);
			minDiff = Math.min(minDiff, diff);
		}
		// 출력
		bw.write(minDiff+"\n");
		bw.flush();
	}
}
// End
