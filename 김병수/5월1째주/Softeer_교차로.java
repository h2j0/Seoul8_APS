package com.ssafy.boj.y22.m05.w1;

import java.util.*;
import java.io.*;

public class Softeer_교차로 {
	public static Deque<Integer> lineA;
	public static Deque<Integer> lineB;
	public static Deque<Integer> lineC;
	public static Deque<Integer> lineD;
	public static Map<Integer, List<car>> TT;
	public static int cnt;
	public static int time;
	public static boolean allFalse;

	public static class car {
		public char dir;
		public int idx;

		public car(char dir, int idx) {
			this.dir = dir;
			this.idx = idx;
		}

		public String toString() {
			return "[dir = " + dir + ", idx = " + idx + " ]";
		}

	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 자료구조 생성
		// line에는 담기는 차량이 몇번째 입력인가가 담긴다.
		lineA = new LinkedList<>();
		lineB = new LinkedList<>();
		lineC = new LinkedList<>();
		lineD = new LinkedList<>();

		// < 시각, 해당 시각에 진입하는 차량 리스트>
		TT = new HashMap<>();

		// 입력받기
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] tw = br.readLine().split(" ");
			int T = Integer.parseInt(tw[0]);
			char W = tw[1].charAt(0);
			// 이미 저장한 시각이면
			if (!TT.containsKey(T)) {
				List<car> carList = new LinkedList<>();
				carList.add(new car(W, i));
				TT.put(T, carList);
				// 새로운 시각이면
			} else {
				TT.get(T).add(new car(W, i));
			}
		}

		// i번 차량의 교차로를 통과하는 시각
		// 인덱스는 진입 순서이고 값은 출차 시간이다.
		int[] outTime = new int[N];
		// 출차한 차량 체크
		boolean[] check = new boolean[N];

		// 남은 차량 개수
		cnt = N;
		// 시각
		time = 0;
		// 시뮬레이션 시작(시간 흐름)
		while (cnt > 0) {
			// 라인 배정
			distribute(time);

			// 출차
			boolean[] pass = new boolean[4];
			lookRight(pass);
			outCar(pass, outTime, check);

			// 막히면 아직 출차안한 모든 차량이 출차불가
			// 막힌다는 것은 차량이 있는데 못나가는 것임.
			if ((!lineA.isEmpty() || !lineB.isEmpty() || !lineC.isEmpty() || !lineD.isEmpty()) && allFalse) {
				for (int i = 0; i < N; i++) {
					if (!check[i]) {
						outTime[i] = -1;
					}
				}
				break;
			}

			// 시간 증가
			time++;

		}

		// 출력
		for (int i = 0; i < N; i++) {
			System.out.println(outTime[i]);
		}

	}

	// 출차
	public static void outCar(boolean[] pass, int[] outTime, boolean[] check) {
		// 아무도 출차를 안할 경우
		allFalse = true;
		// 각 라인을 출차 처리 하기
		for (int i = 0; i < 4; i++) {
			if (pass[i]) {
				allFalse = false;
				int idx = -1;
				switch (i) {
				case 0:
					idx = lineA.removeFirst();
					outTime[idx] = time;
					check[idx] = true;
					cnt--;
					break;
				case 1:
					idx = lineD.removeFirst();
					outTime[idx] = time;
					check[idx] = true;
					cnt--;
					break;
				case 2:
					idx = lineC.removeFirst();
					outTime[idx] = time;
					check[idx] = true;
					cnt--;
					break;
				case 3:
					idx = lineB.removeFirst();
					outTime[idx] = time;
					check[idx] = true;
					cnt--;
					break;
				}
			}
		}
	}

	// 오른쪽 차선 조건만 아니면 모두 출차할 수 있다.
	// 조건 체크를 동시에!! 하게 끔 구성.
	public static void lookRight(boolean[] pass) {
		// A출차 조건
		if (lineD.isEmpty() && !lineA.isEmpty()) {
			pass[0] = true;
		}
		// D출차 조건
		if (lineC.isEmpty() && !lineD.isEmpty()) {
			pass[1] = true;
		}
		// C출차 조건
		if (lineB.isEmpty() && !lineC.isEmpty()) {
			pass[2] = true;
		}
		// B출차 조건
		if (lineA.isEmpty() && !lineB.isEmpty()) {
			pass[3] = true;
		}
	}

	// 차량을 각 라인에 분배
	public static void distribute(int time) {
		if (TT.containsKey(time)) {
			// 현재 시각에 진입하는 차량 리스트
			List<car> curr = TT.get(time);
			int size = curr.size();
			// 차량을 각 도로에 배정
			for (int i = 0; i < size; i++) {
				switch (curr.get(i).dir) {
				case 'A':
					lineA.addLast(curr.get(i).idx);
					break;
				case 'B':
					lineB.addLast(curr.get(i).idx);
					break;
				case 'C':
					lineC.addLast(curr.get(i).idx);
					break;
				case 'D':
					lineD.addLast(curr.get(i).idx);
					break;
				}
			} // 배정 완료
		}
	}

}