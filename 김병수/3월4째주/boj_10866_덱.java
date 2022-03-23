package com.ssafy.boj.y22.m03.w3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class boj_10866_덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Integer> LL = new LinkedList<Integer>();
		// N 관련 입력
		int N = Integer.parseInt(br.readLine());
		for (int in = 0; in < N; in++) {
			String[] input = br.readLine().split(" ");
			int toPush = 0;
			String order = input[0];
			if (order.equals("push_front") || order.equals("push_back")) {
				toPush = Integer.parseInt(input[1]);
			}
			switch (order) {
			case "push_front":
				LL.add(0, toPush);
				break;

			case "push_back":
				LL.add(toPush);
				break;
			case "pop_front":
				if (!LL.isEmpty()) {
					bw.write(LL.get(0) + "\n");
					LL.remove(0);
				} else {
					bw.write(-1 + "\n");
				}
				break;
			case "pop_back":
				if (!LL.isEmpty()) {
					bw.write(LL.get(LL.size()-1) + "\n");
					LL.remove(LL.size()-1);
				} else {
					bw.write(-1 + "\n");
				}
				break;
			case "size":
				bw.write(LL.size()+ "\n");
				break;
			case "empty":
				if (!LL.isEmpty()) {
					bw.write(0 + "\n");
				}else {
					bw.write(1 + "\n");
				}
				break;
			case "front":
				if (!LL.isEmpty()) {
					bw.write(LL.get(0) + "\n");
				} else {
					bw.write(-1 + "\n");
				}
				break;
			case "back":
				if (!LL.isEmpty()) {
					bw.write(LL.get(LL.size()-1) + "\n");
				}else {
					bw.write(-1 + "\n");
				}
				break;
			}

		}

		// 출력
		bw.flush();
		bw.close();
	}
}
// End
