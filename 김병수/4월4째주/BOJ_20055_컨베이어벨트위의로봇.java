package com.ssafy.boj.y22.m04.w4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class BOJ_20055_컨베이어벨트위의로봇 {
	public static List<Integer> upBelt;
	public static List<Integer> dnBelt;
	public static boolean[] robot;
	public static int N;
	public static int K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NK = br.readLine().split(" ");
		N = Integer.parseInt(NK[0]);
		K = Integer.parseInt(NK[1]);
		upBelt = new ArrayList<>();
		dnBelt = new ArrayList<>();
		robot = new boolean[N];
		String[] hardInfo = br.readLine().split(" ");
		for (int i = N - 1; i >= 0; i--) {
			upBelt.add(Integer.parseInt(hardInfo[i]));
		}
		for (int i = 2 * N - 1; i >= N; i--) {
			dnBelt.add(Integer.parseInt(hardInfo[i]));
		}

		int stage = 0;
		boolean doEnd = false;
		while (!doEnd) {
			stage++;
			rotBelt();
			robotMove();
			newRobot();
			doEnd = cntHardZero();
		}

		bw.write(stage + "\n");
		bw.flush();
	}

	public static boolean cntHardZero() {
		int cnt = 0;
		// upBelt
		for (int i = 0; i < N; i++) {
			if (upBelt.get(i) == 0) {
				cnt++;
			}
		}

		// dnBelt
		for (int i = 0; i < N; i++) {
			if (dnBelt.get(i) == 0) {
				cnt++;
			}
		}
		// 판단
		if (cnt >= K) {
			return true;
		} else {
			return false;
		}
	}

	public static void newRobot() {
		if (upBelt.get(N - 1) != 0) {
			robot[N - 1] = true;
			upBelt.set(N - 1, upBelt.get(N - 1) - 1);
		}
	}

	public static void robotMove() {
		// 뒤에서부터
		for (int i = 1; i <= N - 1; i++) {
			// 그곳에 로봇이 있으면
			if (robot[i]) {
				// 이동할 수 있다면
				if (!robot[i - 1] && upBelt.get(i - 1) >= 1) {
					// 이동
					robot[i - 1] = true;
					// 마지막칸으로 이동한거면 즉시 하차
					if (i - 1 == 0) {
						robot[i - 1] = false;
					}
					robot[i] = false;
					// 이동완료하여 해당 칸 내구도 1 감소
					upBelt.set(i - 1, upBelt.get(i - 1) - 1);
				}
			}
		}
	}

	public static void rotBelt() {
		upBelt.add(dnBelt.get(0));
		dnBelt.remove(0);
		dnBelt.add(upBelt.get(0));
		upBelt.remove(0);
		rotRobot();
	}

	public static void rotRobot() {
		// 뒤에서부터 한칸씩 옮기기
		for (int i = 1; i <= N - 1; i++) {
			robot[i - 1] = robot[i];
			// 다른칸은 덮어씌어지는데 마지막 칸은
			// 안 덮어씌어지므로 꼭 지워줘야한다.
			robot[i] = false;
		}
		// 마지막칸은 즉시 하차이므로 비워준다.
		robot[0] = false;
	}

}
//End