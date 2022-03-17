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

public class boj_1874_스택수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        //입력 배열저장
        int [] inputArr = new int[N];
        for (int nIdx = 0; nIdx < N; nIdx++) {
			int newNum = Integer.parseInt(br.readLine());
			inputArr[nIdx]=newNum;
		}
        //현재 다루는 입력이 몇번째 입력인가
        int inIdx=0;
		// 1~n 중 현재 다루는 수
		int toPush=1;
		// pop을 몇번했나
		int popCnt = 0;
		// EmptyStackException 방지
		stk.push(0);
		// 최종 출력 결정
		boolean pos = true;
		// 입력된 수열 판단 시작
		while(popCnt<N) {
			// 스택의 피크보다 입력값이 크면 그값까지 push해주고
			// 마지막에 pop 1회
			// 그 후 다음 입력으로 넘어감
			if(inputArr[inIdx] > stk.peek()){
				while(toPush<=inputArr[inIdx]){
					stk.push(toPush++);
					sb.append("+\n");
				}
			    stk.pop();
			    popCnt++;
			    sb.append("-\n");
			}
			// 스택의 피크와 입력값이 같으면 pop하고 다음 입력으로 넘어감
			else if(inputArr[inIdx] == stk.peek()){
				stk.pop();
				popCnt++;
				sb.append("-\n");
			}else {
				pos=false;
				break;
			}
			inIdx++;
		}
		
		
//		//디버깅
//		for (int nIdx = 0; nIdx < 8; nIdx++) {
//		System.out.println(inputArr[nIdx]);
//		}
		
		
		// 출력
		if(!pos) {
			bw.write("NO\n");
		}else {
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
// End
