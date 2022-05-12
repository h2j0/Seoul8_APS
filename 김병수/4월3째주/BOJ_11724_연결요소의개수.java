package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_11724_연결요소의개수 {
	public static int [] p;
	public static int N;
	public static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		String [] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		
		// 부모 배열 초기화
		p = new int[N+1];
	    for(int i=1; i<=N; i++) {
	    	p[i]=i;
	    }

	    // 입력받기
	    for(int i=0; i<M; i++) {
	    	String [] edge = br.readLine().split(" ");
	    	int st = Integer.parseInt(edge[0]);
	    	int ed = Integer.parseInt(edge[1]);
	    	// ed집단 우두머리가 st집단 우두머리에 바로 연결된다.
	    	// 연결구조는 다르지만 연결요소 개수는 같다.
	    	union(st,ed);
	    }
	    
	    // 여전히 본인의 부모가 본인인 원소의 노드의 개수 찾기
	    int rtCnt = 0;
	    for(int i=1; i<=N; i++) {
	    	if(p[i]==i) {
	    		rtCnt++;
	    	}
	    }

		// 출력
		bw.write(rtCnt + "\n");
		bw.flush();
	}
	// b집단 두목의 부모는 a집단 두목의 부모가 된다.
	// 여기서 findSet(b)이 아닌 단순 b를 하면 b가 원래 집단과의 연결이 끊어지고
	// a집단에 붙기 때문에 문제가 된다.
	public static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
	
	public static int findSet(int x) {
		int curX = x;
		while(p[curX]!=curX) {
			curX = p[curX];
		}
		return curX;
	}
}
//End