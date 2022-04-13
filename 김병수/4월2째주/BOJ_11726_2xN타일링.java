package com.ssafy.boj.y22.m04.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11726_2xN타일링 {
	public static int N;
	public static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		N = Integer.parseInt(br.readLine());

		// 왼쪽에서 오른쪽으로 채운다 생각하고
		// 2*1로 가로 한칸을 채우거나 1*2 두개로 가로 두칸을 채우거나
		make(0);

		// 출력
		bw.write(sum%10007+"\n");
		bw.flush();
	}
	public static void make(int width) {
		if(width==N) {
			sum++;
			return;
		}else if( width>N) {
			return;
		}
		// 2*1 하나로 가로 한칸을 채우기
		make(width+1);
		// 1*2 두개로 가로 두칸을 채우기
		make(width+2);
	}
}
//End