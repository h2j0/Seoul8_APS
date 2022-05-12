package com.ssafy.boj.y22.m05.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BOJ_5430_AC {
	public static boolean dir;
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			char [] orders = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> DQ = new LinkedList<>();
			String [] arr = br.readLine().split(",");
			if(!game(orders, DQ, arr, n)) {
				sb.append("error\n");
			}else {
				trimPrint(DQ);
			}
		}
		System.out.println(sb);

	}
	// 출력할때 [1, 2, 3]처럼 사이에 빈칸 있으면 안되서 Arrays.toString() 못 씀.
	public static void trimPrint(Deque<Integer> DQ) {
		Integer [] arr = DQ.toArray(new Integer[DQ.size()]);
		if(!dir) {
			sb.append("[");
			for(int i=0; i<arr.length;i++) {
				sb.append(arr[i]);
				if(i != arr.length-1) {
					sb.append(",");
				}
			}
			sb.append("]\n");
		}else {
			sb.append("[");
			for(int i=arr.length-1; i>=0;i--) {
				sb.append(arr[i]);
				if(i != 0) {
					sb.append(",");
				}
			}
			sb.append("]\n");
		}
	}
	
	public static boolean game(char [] orders, Deque<Integer> DQ, String [] arr, int n) {
		boolean nothing = false;
		
		// 맨 앞과 맨뒤의 "[", "]" 제거
		if(n>=2) {
		arr[0]= arr[0].substring(1);
		// 종료 인덱스 "전"까지 반영
		arr[n-1] = arr[n-1].substring(0,arr[n-1].length()-1);
		}else if(n==1) {
			arr[0]= arr[0].substring(1,arr[0].length()-1);
		}else {
			nothing=true;
		}
		
		
		// DQ에 담기
		if(!nothing) {
			for(int i=0; i<n; i++) {
				DQ.add(Integer.parseInt(arr[i]));
			}
		}
		
		// 명령 시작
		// false면 앞에서 부터, true면 뒤에서 부터
		dir = false;
		for(char order : orders) {
			switch(order) {
			case 'R' :
				dir = !dir;
				break;
			case 'D' :
				// 앞에서 부터 제거
				if(!dir) {
					if(DQ.isEmpty()) {
						return false;
					}
					DQ.removeFirst();
				// 뒤에서 부터 제거
				}else {
					if(DQ.isEmpty()) {
						return false;
					}
					DQ.removeLast();
				}
			}
		}
		return true;
	}

}
//End