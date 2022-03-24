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

public class BOJ_1966_프린터큐 {
	public static class docu {
		private int num;
		private int importance;

		public docu(int num, int importance) {
			this.num = num;
			this.importance = importance;
		}

		@Override
		public String toString() {
			return "docu [num=" + num + ", importance=" + importance + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {

			// N,M받기
			String[] inArr = br.readLine().split(" ");
			int N = Integer.parseInt(inArr[0]);
			int M = Integer.parseInt(inArr[1]);

			// Queue만들기, 중요도 리스트 만들기
			Queue<docu> docuQ = new LinkedList<docu>();
			Integer[] impList = new Integer[N];
			// 현재 impList에서 지목하고 있는 Idx
			int impListIdx = 0;

			// 문서번호와 문서 중요도 리스트 엮어서 docu객체로 만들고 Queue에 넣기
			inArr = br.readLine().split(" ");
			for (int dc = 0; dc < N; dc++) {
				int newImp = Integer.parseInt(inArr[dc]);
				docu newDocu = new docu(dc, newImp);
				docuQ.add(newDocu);
				impList[dc] = newImp;
			}

			// 중요도 리스트 내림차순
			Arrays.sort(impList, Collections.reverseOrder());

			// Queue에서 판단 시작
			// 맨앞에 친구가 최대 중요도를 가진애가 아니면 다시 뒤로
			int printNth = 1;
			while (true) {
				if (docuQ.peek().importance != impList[impListIdx]) {
					docuQ.add(docuQ.poll());
					// 맨앞에 친구가 최대 중요도를 가진애라면 맨앞에 인쇄하고 impListIdx++
				} else {
					docu newDocu = docuQ.poll();
					// 우리가 원하는 인쇄물
					if (newDocu.num == M) {
						bw.write(printNth + "\n");
						break;
						// 관심없는 인쇄물
					} else {
						printNth++;
					}
					impListIdx++;
				}
			}
			// 출력
			bw.flush();
		}
		bw.close();
	}
}
// End
