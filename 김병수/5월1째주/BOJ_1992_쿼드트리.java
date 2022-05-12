package com.ssafy.boj.y22.m05.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1992_쿼드트리 {
	public static int[][] board;
	public static List<Character> colorList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받기
		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		for (int r = 0; r < N; r++) {
			String aline = br.readLine();
			for (int c = 0; c < N; c++) {
				board[r][c] = aline.charAt(c) - '0';
			}
		}
		
		colorList = new LinkedList<>();
		quard(0,0,N);
		
		// 출력
		StringBuilder sb =new StringBuilder();
		int size = colorList.size();
		for(int i=0;i<size;i++) {
			sb.append(colorList.get(i));
		}
		System.out.println(sb);

	}
	
	// 기준점은 해당면의 가장 좌상단 원소
	public static void quard(int row, int col, int len) {
		int black = 0;
		int white = 0;
		for(int r = row; r< row+len;r++) {
			for(int c=col; c<col+len;c++) {
				if(board[r][c]==0) {
					white++;
				}else {
					black++;
				}
			}
		}
		// 전부 흰색
		if(black ==0) {
			colorList.add('0');
			return;
		// 전부 검은색
		}else if(white==0) {
			colorList.add('1');
			return;
		}
		else {
			
			colorList.add('(');
			
			// 좌상면
			quard(row, col, len/2);
			// 우상면
			quard(row,col+len/2,len/2);
			// 좌하면
			quard(row+len/2,col,len/2);
			// 우하면
			quard(row+len/2,col+len/2,len/2);
			
			colorList.add(')');
			
		}
	}
}
//End