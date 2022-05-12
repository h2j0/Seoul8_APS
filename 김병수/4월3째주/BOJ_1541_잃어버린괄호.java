package com.ssafy.boj.y22.m04.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

public class BOJ_1541_잃어버린괄호 {
	public static int[] p;
	public static int N;
	public static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 방식 설명 :
		// "-" 를 기준으로 나눠서 각 항을 한 세트로 본다.
		// 그러면 각항은 '단독 항'이거나 '+와 수로 이뤄진 항'일 것이다.
		// '+와 수로 이뤄진 항'을 하나의 수로 합친다.
		// 이제 각 항들을 "-"에 대해 연산한다.
		// ex) 55-50+40-30+70이면
		// "-"를 기준으로 세트화 시키면 (55)-(50+40)-(30+70)이 되고
		// 각 세트를 합쳐서 (55)-(90)-(100)을 만들고 이 식의 계산결과가 정답이다.
		
		
		// 입력받기
		String[] fomula = br.readLine().split("-");

		int sumVal = 0;
		// 첫항만 sum에 +, 나머지는 sum에 - 한다.
		for (int i = 0; i < fomula.length; i++) {
			// 해당 항의 수를 모두 더한다.
			int partSum = 0;
			String[] plusSet = fomula[i].split("\\+");
			for (int sc = 0; sc < plusSet.length; sc++) {
				partSum += Integer.parseInt(plusSet[sc]);
			}
			// 첫항
			if (i == 0) {
				sumVal += partSum;
			// 그외 항
			} else {
				sumVal -= partSum;
			}
		}

		// 출력
		bw.write(sumVal + "\n");
		bw.flush();
	}

}
//End