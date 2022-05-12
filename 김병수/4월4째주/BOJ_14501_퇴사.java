package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_14501_퇴사 {
	public static class day {
		public int T;
		public int P;
		// 현재 날짜의 최대 수익
		public int decide;
		// 뒤에 애들이 던진 것 담아두는 역할
		// 받은 것 중 최대값만 쓸것이라 PQ에 저장.
		public PriorityQueue<Integer> pq;

		public day(int t, int p) {
			T = t;
			P = p;
			// MaxHeap
			pq = new PriorityQueue<>(Collections.reverseOrder());
		}

		@Override
		public String toString() {
			return "day [T=" + T + ", P=" + P + ", decide=" + decide + ", pq=" + pq + "]";
		}
	}

	public static int N;
	// 인덱스가 각 날짜를 의미함.
	public static day[] days;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		days = new day[31];
		// day1을 처리하기 위한 day0
		days[0] = new day(0,0);
		days[0].decide = 0;
		// 입력받기
		for (int i = 1; i <= N; i++) {
			String[] TP = br.readLine().split(" ");
			int T = Integer.parseInt(TP[0]);
			int P = Integer.parseInt(TP[1]);
			days[i] = new day(T, P);
		}
		// 여유공간에도 객체 채워주기
		for (int i = N+1; i <= 30; i++) {
			days[i] = new day(0,0);
		}

		// 본 게임
		// - X일 최대 수익 결정 기준은 다음과 같다.
		// 1. 이전의 누군가가 시작해서 X일 끝난 값(시작했을때 최대값+시작했을때 P) 중 최대값
		// 2. 전날 최대값 + (만약 Tx==1이면) Px -> Tx==1이면 Px가 오늘 바로 실현되기 때문이다.
		// 1,2 중 최대값이 X일 최대 수익.
		// - 이전 Y일에 시작해서 X일 끝난 값은 Y일 계산할때 X일에 반영시켜준다.(이하 "던진다"고 표현)
		// 만약 Ty != 1이면 Y일부터 시작해서 (Y+Ty-1)일에 실현되므로 
		// (Y+Ty-1)일로 (Y-1일 최대수익+Py)를 던진다.
		
		// -주의사항
		// 여기서 (Y-1일 최대수익+Py)이 아닌 (Y일 최대수익+Py)를 던지면 Y일이 중복반영되므로
		// 주의해줘야한다.
		for (int i = 1; i <= N; i++) {
			findMax(i);
			doThrow(i);
		}

		bw.write(days[N].decide+" ");
		bw.flush();

	}
	public static void findMax(int idx) {
		// 직전결정 + a
		int prePlusAlpha = days[idx - 1].decide;
		if (days[idx].T == 1) {
			prePlusAlpha += days[idx].P;
		}

		// 받은 애들 중 최대
		int receiveMax = -1;
		if (!days[idx].pq.isEmpty()) {
			receiveMax = days[idx].pq.poll();
		}
		
		// 최대결정
		int maxVal = Math.max(prePlusAlpha, receiveMax);
		
		// 본인 객체에게 반영
		days[idx].decide = maxVal;
		
	}
	
	public static void doThrow(int idx) {
		if(days[idx].T != 1) {
			days[idx+days[idx].T-1].pq.add(days[idx-1].decide+days[idx].P);
		}
	}
}
//End