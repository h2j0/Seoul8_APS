package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_1931_회의실배정 {

	public static class meet implements Comparable<meet> {
		public int st;
		public int ed;
		
		public meet(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}

		@Override
		// end가 일찍인거 우선
		// end가 같을때 start 일찍인거 우선
		public int compareTo(meet o) {
			int out;
			if(this.ed == o.ed) {
				out = this.st - o.st;
			}else {
				out = this.ed - o.ed;
			}
			return out;
		}

		@Override
		public String toString() {
			return "meet [st=" + st + ", ed=" + ed + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기, 입력 순서대로 시간 배정하는 것은 아니다!
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<meet> Q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String[] aLine = br.readLine().split(" ");
			int st = Integer.parseInt(aLine[0]);
			int ed = Integer.parseInt(aLine[1]);
			Q.add(new meet(st, ed));
		}
		
		// 먼저 끝나는 회의를 우선적으로 한다.
		// 동시에 끝나는 회의라면 먼저 시작한 회의를 우선으로 한다.
		meet curr = new meet(-1,-1);
		int lastEd = -1;
		int cnt=0;
		while(!Q.isEmpty()) {
			curr = Q.poll();
			// 새로 뽑은 회의가 시간 조건을 만족하지 못하면.
			if(lastEd > curr.st) {
				continue;
			}
			
			// 시간 조건을 만족하지 하면.
			cnt++;
			lastEd = curr.ed;
		}
		
		// 출력
		bw.write(cnt + "\n");
		bw.flush();
	}

}
//End