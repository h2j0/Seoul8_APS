package com.ssafy.boj.y22.m04.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9095_123더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tnum = Integer.parseInt(br.readLine());
		// testCase 횟수
		for (int tc = 1; tc <= tnum; tc++) {

			int N = Integer.parseInt(br.readLine());
			// 여기서 공간을 N+1으로 하면 N<3일때
			// 없는 공간에 할당함으로 인해 ArrayIndexException이 발생한다.
			int [] Nlist = new int [12];
			// 아래와 같이 몇칸을 의무할당해야할때
			// 무조건 의무할당 이상으로 배열공간을 초기화하게 끔 신경써줘야한다.
			// 블로그 메모ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
			Nlist[1] = 1;
			Nlist[2] = 2;
			Nlist[3] = 4;
			for(int nIdx=4;nIdx<=N;nIdx++) {
				Nlist[nIdx] = Nlist[nIdx-1]+Nlist[nIdx-2]+Nlist[nIdx-3];
			}
			// 출력
			bw.write(Nlist[N]+"\n");
			bw.flush();
		}
	}
}
//End