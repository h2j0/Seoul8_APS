package com.ssafy.boj.y22.m05.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BOJ_1764_듣보잡 {
	public static int[][] board;
	public static List<Character> colorList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		
		String [] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		int cnt = 0;
		Set<String> hear = new HashSet<>();
		List<String> result = new ArrayList<>();
		for(int i=0;i<N;i++) {
			hear.add(br.readLine());
		}
		for(int i=0;i<M;i++) {
			String word = br.readLine();
			if(hear.contains(word)) {
				cnt++;
				result.add(word);
			}
		}
		
		Collections.sort(result);
		
		System.out.println(cnt);
		for(int i=0;i<cnt;i++) {
			System.out.println(result.get(i));
		}
	}
}
//End