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

public class boj_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> JAMIN = new Stack<>();
		
		// N 관련 입력
		int N = Integer.parseInt(br.readLine());
		int newNum = 0;
		for (int nIdx = 0; nIdx < N; nIdx++) {
			newNum = Integer.parseInt(br.readLine());
			if( newNum==0 ) {
				JAMIN.pop();
			}else {
				JAMIN.add(newNum);
			}
		}
		int result=0;
		if(!JAMIN.isEmpty()) {
			// for문안에서 JAMIN의 사이즈가 줄어들기 때문에
			// for문 조건 안에 JAMIN.size()를 쓰면 안된다!!
			int jSize = JAMIN.size();
			for(int i=0; i< jSize; i++) {
				result+=JAMIN.pop();
			}
		}
		
		// 출력
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
}
// End
