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
import java.util.Queue;
import java.util.Stack;

public class BOJ_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// K,N받기
		String[] inArr = br.readLine().split(" ");
		int K = Integer.parseInt(inArr[0]);
		int N = Integer.parseInt(inArr[1]);
		int [] LAN = new int[K];
		int maxLAN = 0;
		for(int in=0; in < K; in++) {
			LAN[in]=Integer.parseInt(br.readLine());
			if(LAN[in] > maxLAN) {
				maxLAN = LAN[in];
			}
		}
		
		// [1~maxLAN]에서 이진탐색
		    // 밑에서 midLen+1하면서 초과할 수 있다.
			long longLen = maxLAN;
			// 밑에서 midLen+1하면서 초과할 수 있다.
			long shortLen = 1;
			// longLen+shortLen에서 int 범위를 넘어가 터진다.
			long midLen = (longLen + shortLen) / 2;
			
			// =은 long,short이 같아지는 마지막 연산때를 반영해주기 위함.
			while (shortLen <= longLen) {
				// 원하는 개수를 맞췄으면 가능한 최대 단위길이로.
				if (makeLAN(midLen,LAN) == N) {
					shortLen = midLen + 1;
				//원하는 개수보다 적으면 단위길이를 줄여야 함.
				} else if (makeLAN(midLen,LAN) < N) {
					longLen = midLen - 1;
				} else {
					shortLen = midLen + 1;
				}
				midLen = (longLen + shortLen) / 2;
			}
		// 마지막 iteration에서 shortLen과 longLen이 같은 곳에 있다가
		// shortLen이 한칸 뒤로 가면서 
		// longLen, shortLen 순서가 되고 while문을 탈출하므로
		// longLen위치가 정답이다.

		// 출력
		bw.write(longLen+"\n");
		bw.flush();
		bw.close();
	}
	public static int makeLAN(long size, int [] LAN) {
		int numOfLAN = 0;
		for(int i=0;i<LAN.length;i++) {
			numOfLAN+=LAN[i]/size;
		}
		return numOfLAN;
	}
}
// End
