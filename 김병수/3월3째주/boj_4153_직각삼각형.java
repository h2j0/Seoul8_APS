package com.ssafy.boj.y22.m03.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class boj_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String[] inArr = br.readLine().split(" ");
			int [] len = new int[3];
			len[0] = Integer.parseInt(inArr[0]);
			len[1] = Integer.parseInt(inArr[1]);
			len[2] = Integer.parseInt(inArr[2]);
			// 탈출조건
			if(len[0]==0) {
				break;
			}
			// 최대변
			int maxVal = Math.max(Math.max(len[0], len[1]),len[2]);
			// 최대변인덱스찾기
			int maxIdx=-1;
			for(int i=0; i<=2; i++) {
				if(maxVal==len[i]) {
					maxIdx = i;
					break;
				}
			}
			// 최대변제곱
			int a2 = len[maxIdx]*len[maxIdx];
			// 최대변 제외 두변의 제곱합
			int b2c2=0;
			for(int i=0; i<=2; i++) {
				if(i != maxIdx) {
					b2c2+=len[i]*len[i];
				}
			}
			// 일치여부
			if(a2==b2c2) {
				bw.write("right\n");
			}else {
				bw.write("wrong\n");
			}
		}
		
		// 출력
		bw.flush();
		bw.close();
	}
}
// End
