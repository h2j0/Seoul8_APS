package com.ssafy.boj.y22.m03.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class boj_11650_좌표정렬 {
	public static class coor {
		private int x;
		private int y;
		
		public coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "coor [x=" + x + ", y=" + y + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N 관련 입력
		int N = Integer.parseInt(br.readLine());
		coor [] coorArr = new coor[N];
		for (int nIdx = 0; nIdx < N; nIdx++) {
			String[] nArr = br.readLine().split(" ");
			coorArr[nIdx] = new coor(Integer.parseInt(nArr[0]),Integer.parseInt(nArr[1]));
		}
		// 버블정렬
		boolean endSignal = true;
		while(endSignal) {
			endSignal = false;
			for(int nIdx=0; nIdx<N-1; nIdx++) {
				// x에 대해 정렬
				if(coorArr[nIdx].x > coorArr[nIdx+1].x) {
					coor tmp = coorArr[nIdx];
					coorArr[nIdx] = coorArr[nIdx+1];
					coorArr[nIdx+1] = tmp;
					endSignal = true;
				// x가 같을 경우 y에 대해 정렬
				}else if(coorArr[nIdx].x == coorArr[nIdx+1].x) {
					if(coorArr[nIdx].y > coorArr[nIdx+1].y) {
						coor tmp = coorArr[nIdx];
						coorArr[nIdx] = coorArr[nIdx+1];
						coorArr[nIdx+1] = tmp;
						endSignal = true;
					}
				}
			}
		}
		
//		// 디버깅
//		for (int nIdx = 0; nIdx < N; nIdx++) {
//			System.out.print(coorArr[nIdx].toString() + " ");
//		}
//		System.out.println();

		// 출력
		for (int nIdx = 0; nIdx < N; nIdx++) {
			bw.write(coorArr[nIdx].x+" "+coorArr[nIdx].y+"\n");
		}
		bw.flush();
		bw.close();
	}
}
// End
