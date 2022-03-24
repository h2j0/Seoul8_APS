package com.ssafy.boj.y22.m03.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		int M = Integer.parseInt(inArr[1]);
		inArr = br.readLine().split(" ");

		// 한칸은 인덱스에러 방지를 위한 깡통
		Integer[] wood = new Integer[N + 1];
		wood[N] = 0;
		for (int wc = 0; wc < N; wc++) {
			wood[wc] = Integer.parseInt(inArr[wc]);
		}

		// Arrays.sort(기본 자료형) :
		// 기본 자료형은 비교 기준이 결정되어있기때문에
		// 객체처럼 따로 compareTo메소드로 결정기준을 정해주지 않아도 된다.

		// Arrays.sort(Object[])에 대한 추가 설명 :
		// 기본적으로 객체는 Comparable 인터페이스가 구현되어있습니다.
		// sort(Object[])는 Comparable(compareTo메소드)에 의해 리턴되는 값을 비교하여
		// 오름차순 또는 내림차순으로
		// 배열을 정렬합니다.
		// Object[]는 모두 같은 타입의 객체로 구성되어 있으니 본 객체의 기본 정렬 기준인
		// Comparable(compareTo메소드)에 대해 비교 기준이 동일하다.

		// Arrays.sort(a, c)에 대한 설명 :
		// Comparator c가 제시한 기준에 따라 a를 정렬한다.
		// a는 무조건 '객체로 구성된 Array'이어야 한다.
		// a의 모든 원소는 c에 대해 상호 비교가능해야한다.
		// stable하다 -> 같은 원소는 순서가 reorder되지 않는다.
		// Collections.reverseOrder()는 Comparator 객체입니다.
		// Comparator 객체는 compare(T o1, T o2) 메서드를 가지고 있고
		// 두 입력을 받아 정해진 정렬 규칙에 만들어줄 수 있는 값을 return

		// Comparable은 "자기 자신과 매개변수 객체를 비교"하는 것이고,
		// Comparator는 "두 매개변수 객체를 비교"한다는 것이다.
		
		// Arrays.sort(Object[])는 Comparable, Arrays.sort(a, c)는 Comparator를 쓰는 이유 : 
		// Comparable(compareTo메소드)은 '객체(Object[]의 원소)에 탑재된 기본 정렬방식'이기 때문에
		// Arrays.sort(Object[])와 같이 해당 객체가 정해놓은 자신에 대한 기본 정렬방식을
		// 그대로 따라서 정렬할때 쓰고
		// Comparator(compare(T o1, T o2))는 객체에 탑재된 기본 정렬방식이 아닌 새로운 
		// 정렬 방식을 만들고 싶을때 추가해서 사용한다.
		// 결론적으로 Arrays.sort(Object[])는 원소 객체의 compareTo메소드를 실행시켜
		// 리턴값으로 비교하고 Arrays.sort(a, c)는 a의 원소 객체의 compareTo메소드는 무시하고
		// c의 compare(T o1, T o2)의 리턴값으로 비교한다.
		
		// 블로그 작성ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
		// 1.  Arrays.sort
		// 2. 오답노트
		
		// 내림차순 정렬
		Arrays.sort(wood, Collections.reverseOrder());

		// 1m를 하나의 나무 조각으로 생각한다.
		// 확보한 나무 조각
		int howManyIGet = 0;
		// 현재 자르고 있는 높이
		// 첫 컷팅 높이는 '최대 나무 높이 - 1'
		int runningHeight = wood[0] - 1;
		// 현재 잘리고 있는 나무들 중 마지막 나무
		int lastWoodIdx = 0;
		// 컷팅 당 잘리는 나무 조각
		int getValue = 1;

		// 현재 다루는(지금은 가장 높은 나무) 나무와 같은 높이의 나무가 있으면
		// lastWoodIdx, getValue에 반영하고 건너띄기
		int passN = passSameHeight(wood, lastWoodIdx);
		lastWoodIdx += passN;
		getValue += passN;

		// 오답노트 ==
		// 오답 : 컷 -> runningHeight--; -> 진행중인 높이가 다음 나무의 높이와 같나
		// 수정 : 컷 -> 진행중인 높이가 다음 나무의 높이와 같나 -> runningHeight--; 
		// 4 10
		// 10 1 1 1 이 있을때 (각각을 a,b,c,d 나무라 하자)
		// 오답 알고리즘 :
		// h=2에서 컷하고 h--;하면 h=1이고 다음과 같음을 확인해서 다른 나무들 추가(x)
		// 정답 알고리즘 : 
		// h=1에서 컷하고 다음과 같음을 확인해서 다른 나무들 추가 후 h--;(o)
		// -> 오답은 h=1컷에서 a,b,c,d 나무 모두를 컷하지만
		// -> 정답은 h=1컷에서 a 나무만을 컷한다.
		while (true) {
			// 컷
			howManyIGet += getValue;
			// 목표 달성 확인
			if (howManyIGet >= M) {		
				break;
			}
			// 진행중인 높이가 다음 나무의 높이와 같아지면
			if (wood[lastWoodIdx + 1] == runningHeight) {
				// 이제 잘리는 나무가 하나 추가되고
				// 일회 컷팅 당 잘리는 나무 조각 하나 추가
				lastWoodIdx++;
				getValue++;
				// 새로운 lastWoodIdx와 같은 높이의 나무가 더 있으면
				// 그 같은 높이의 나무들의 맨마지막이
				// 진정한 lastWoodIdx이다.
				passN = passSameHeight(wood, lastWoodIdx);
				lastWoodIdx += passN;
				getValue += passN;

			}
			// 진행중인 높이 한칸 다운
			runningHeight--;
		}

		// 출력
		bw.write(runningHeight + "\n");
		bw.flush();
		bw.close();
	}

	// 출력은 pass한 나무 개수
	public static int passSameHeight(Integer[] wood, int lastWoodIdx) {
		int toPass = 0;
		// 깡통빼고 스캔
		for (int scan = lastWoodIdx + 1; scan <= wood.length - 2; scan++) {
			// 나와 다른 높이의 wood를 만날때까지 진행
			if (!wood[lastWoodIdx].equals(wood[scan])) {
				break;
			} else {
				toPass++;
			}
		}
		return toPass;
	}
}
// End
