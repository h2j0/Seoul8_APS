package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ_11050_이항계수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int K = Integer.parseInt(inArr[1]);
		
		// Combination
		int denom =1;
		for(int kc=0; kc < K ; kc++) {
		denom*=N-kc;
		}
		int numer =1;
		for(int kc=2; kc <= K ; kc++) {
			numer*=kc;
		}
		int result = denom/numer;
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
// End
