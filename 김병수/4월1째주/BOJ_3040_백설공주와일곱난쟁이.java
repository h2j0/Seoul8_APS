package com.ssafy.boj.y22.m04.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class BOJ_3040_백설공주와일곱난쟁이 {
	public static int [] sel;
	public static int N = 9;
	public static int R = 2;
	public static int diff;
	public static  List<Integer> nanJang;
	public static  List<Integer> Alien;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		nanJang = new ArrayList<>();
		Alien = new ArrayList<>();
		// 재료 저장
		int sumVal = 0;
		for (int nc = 1; nc <= N; nc++) {
			int aNanJang = Integer.parseInt(br.readLine());
			nanJang.add(aNanJang);
			sumVal += aNanJang;
		}
		diff = sumVal-100;

		// 조합
		sel = new int [R];
		comb(0,0);
		
		// 외부 난쟁이 제거
		for(int r = 0; r< R; r++) {
			nanJang.remove(Alien.get(r));
		}
		// nanJang 출력
		for(int i = 0; i< N-R; i++) {
		bw.write(nanJang.get(i)+"\n");
		}
		bw.flush();
	}
	
	public static void comb(int idx, int sidx) {
		if (sidx == R) {
			int sumAlien = 0;
			for(int r = 0; r< R; r++) {
				sumAlien+=sel[r];
			}
			if(sumAlien==diff) {
				for(int r = 0; r< R; r++) {
					Alien.add(sel[r]);
				}
			}
		}else {
			for(int i = idx; i<= N-R+sidx; i++) {
				sel[sidx] = nanJang.get(i);
				comb(i+1,sidx+1);
			}
		}
	}
}
// End
