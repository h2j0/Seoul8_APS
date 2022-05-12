package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1679_숨바꼭질 {
	public static int[] T;
	public static boolean[] check;
	public static int subin;
	public static int sister;

	public static class number {
		public int num;
		public int t;

		public number(int num, int t) {
			this.num = num;
			this.t = t;
		}

		@Override
		public String toString() {
			return "number [num=" + num + ", t=" + t + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String[] NK = br.readLine().split(" ");
		subin = Integer.parseInt(NK[0]);
		sister = Integer.parseInt(NK[1]);

		T = new int[100_001];
		check = new boolean[100_001];

		// 각 위치에서 동생에게 오는 최소시간을 탐색;
		// 출력
		bw.write(BFS(sister,0) + "\n");
		bw.flush();
	}

	public static int BFS(int stN, int stT) {
		Queue<number> Q = new LinkedList<>();
		Q.add(new number(stN,stT));
		check[stN]=true;

		while (!Q.isEmpty()) {
			number target = Q.poll();
			// 수빈이냐
			if (target.num == subin) {
				return target.t;
			}
			// Q채우기
			doTree(target, Q);
		}
		// 정상적인 경우 여긴 오지 못함.
		return -1;

	}
	public static void doTree(number target, Queue<number> Q) {
		// 이미 해당 위치에 대해 설정된 시간이 있으면
		// 무조건 이미 있는 값이 최소이므로 갱신하지 않는다.
		
		// N+1에서 가기
		// N+1에서 동생에게 가는 최소 시간은
		// N에서 동생에게 가는 최소 시간의 +1이다
		if (target.num + 1 <= 100_000 && !check[target.num + 1] ) {
			Q.add(new number(target.num + 1, target.t + 1));
			T[target.num + 1] = target.t + 1;
			check[target.num+1]=true;
		}
		// N-1에서 가기
		// N-1에서 동생에게 가는 최소 시간은
		// N에서 동생에게 가는 최소 시간의 +1이다
		if (target.num - 1 >= 0 && !check[target.num - 1] ) {
			Q.add(new number(target.num - 1, target.t + 1));
			T[target.num - 1] = target.t + 1;
			check[target.num-1]=true;
		}
		// 짝수이면
		if (target.num % 2 == 0) {
			// N/2에서 가기
			// N/2에서 동생에게 가는 최소 시간은
			// N에서 동생에게 가는 최소 시간의 +1이다
			if(!check[target.num /2]) {
			Q.add(new number(target.num / 2, target.t + 1));
			T[target.num / 2] = target.t + 1;
			check[target.num/2]=true;
			}
		}
	}
}
//End