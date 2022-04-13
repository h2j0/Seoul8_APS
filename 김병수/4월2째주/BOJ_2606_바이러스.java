package com.ssafy.boj.y22.m04.w2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2606_바이러스 {

	public static List<Integer> [] adjArr;
	public static boolean[] check;
	
	// 1번 컴퓨터는 cnt에 미포함.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		// 인접리스트 만들기
		adjArr = new ArrayList[N+1];
		check = new boolean[N+1];
		for(int i=1; i<= N; i++) {
			adjArr[i]= new ArrayList<>();
		}
		
		// 입력받기
		for(int i=0; i<E; i++) {
			String [] input = br.readLine().split(" ");
			int st = Integer.parseInt(input[0]);
			int ed = Integer.parseInt(input[1]);
			// 쌍방연결관계 입력
			adjArr[st].add(ed);
			adjArr[ed].add(st);
		}

		// BFS 실행, 출력
		bw.write(BFS(1)+"\n");
		bw.flush();
	}

	public static int BFS(int start) {
		int elementCnt = 0;
		Queue<Integer> Q = new LinkedList<>();
		Q.add(start);
		check[start] = true;
		while (!Q.isEmpty()) {
			int curr = Q.poll();
			elementCnt++;
			// delta 탐색
			for (int i = 0; i < adjArr[curr].size(); i++) {
				int candi = adjArr[curr].get(i);
				if(!check[candi]) {
					Q.add(candi);
					check[candi] = true;
				}
			}
		}
		// 첫 시작인 1번 컴퓨터 미포함
		return elementCnt-1;
	}
}
//End