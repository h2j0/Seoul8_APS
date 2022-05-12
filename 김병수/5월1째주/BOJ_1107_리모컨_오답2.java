package com.ssafy.boj.y22.m05.w1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1107_리모컨_오답2 {
	public static int[] target;
	public static boolean[] btn;
	public static int[] click;
	public static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// result 초기화
		result = Integer.MAX_VALUE;

		// 목표 채널 배열화
		char[] N = br.readLine().toCharArray();
		target = new int[N.length];
		for (int i = 0; i < N.length; i++) {
			target[i] = N[i] - '0';
		}

		// 버튼 상태 배열 만들기
		int M = Integer.parseInt(br.readLine());
		btn = new boolean[10];
		Arrays.fill(btn, true);
		// 불량 버튼 확인
		if (M != 0) {
			String[] broken = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				btn[Integer.parseInt(broken[i])] = false;
			}
		}

		// 클릭 배열
		click = new int[6];

		// 게임시작
		//// 오직 (+,-)버튼만 누르는 경우
		onlyPM();
		//// 숫자버튼으로 목표 채널에 가까이 간 다음 (+,-)를 누르는 경우
		perm(0);

		// 출력
		System.out.println(result);
		
	}

	public static void onlyPM() {
		int stt = 100;
		int dst = toInt(target);
		result = Math.min(result, Math.abs(stt - dst));
	}
	public static int digit(int num) {
		int digit = 0;
		while(num>0) {
			num/=10;
			digit++;
		}
		return digit;
	}


	// 클릭 배열 만들기, 중복순열
	public static void perm(int sidx) {
		if (sidx == 6) {
			// 중복순열 생성 완료
			int arrive = toInt(click);
			int digit =digit(arrive);
			
			int dst = toInt(target);
			result = Math.min(result, digit+ Math.abs(arrive - dst));
			return;
		}


		// 중복순열 생성
		for (int i = 0; i < 10; i++) {
			if (btn[i]) {
				click[sidx] = i;
				perm(sidx + 1);
			}
		}

	}

	// 클릭 배열을 숫자로 만들어주기
	public static int toInt(int[] click) {
		int length = click.length;
		String word = "";
		for (int i = 0; i < length; i++) {
			word += click[i];
		}
		return Integer.parseInt(word);
	}

	// 숫자버튼 0~9의 BC
	public static boolean BC(int n) {
		if (n >= 0 && n <= 9) {
			return true;
		} else {
			return false;
		}
	}

}
//End