package com.ssafy.boj.y22.m03.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class boj_10814_나이순정렬 {
	public static class member {
		private int age;
		private String name;
		
		public member(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return "member [age=" + age + ", name=" + name + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력의 숫자들로 배열 구성
		// 최대값 저장.
		int N = Integer.parseInt(br.readLine());
		List<member> memArr = new ArrayList<>();
		// 내가 만든 member 클래스로 배열 만들기
		member[] newMemArr = new member[N];
		int maxAge = 0;
		// 각 정보를 멤버객체로 ArrayList에 넣고 최대 나이 찾기
		for (int nIdx = 0; nIdx < N; nIdx++) {
			String[] newIn = br.readLine().split(" ");
			int age = Integer.parseInt(newIn[0]);
			String name = newIn[1];
			memArr.add(new member(age, name));
			if (age > maxAge) {
				maxAge = age;
			}
		}

		// count배열 생성
		// idx = 0,1,2....,maxNum
		int[] countArr = new int[maxAge + 1];
		for (int cIdx = 0; cIdx < N; cIdx++) {
			countArr[memArr.get(cIdx).age]++;
		}
		// count배열 누적
		for (int coIdx = 1; coIdx <= maxAge; coIdx++) {
			countArr[coIdx] = countArr[coIdx] + countArr[coIdx - 1];
		}

		// 새로운 어레이로 이동
		for (int cIdx = N - 1; cIdx >= 0; cIdx--) {
			member memberToMove = memArr.get(cIdx);
			int destinationIdx = --countArr[memberToMove.age];
			newMemArr[destinationIdx] = memberToMove;
		}

//		// 디버깅
//		for (int nIdx = 0; nIdx < N; nIdx++) {
//			System.out.print(memArr.get(nIdx) + " ");
//		}
//		System.out.println();

		// 출력
		for (int i = 0; i < N; i++) {
			bw.write(newMemArr[i].age + " " + newMemArr[i].name + "\n");
		}
		bw.flush();
		bw.close();
	}
}
// End
