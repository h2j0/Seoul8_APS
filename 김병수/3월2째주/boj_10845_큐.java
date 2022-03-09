package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class boj_10845_큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> Q = new LinkedList<>();
		for (int n = 0; n < N; n++) {
			String inNum = br.readLine();
			String[] Arr = inNum.split(" ");
			String order = Arr[0];
			int num = 0;
			if (order.equals("push")) {
				num = Integer.parseInt(Arr[1]);
			}
			switch (order) {
			case "push":
				Q.add(num);
				break;
			case "pop":
				if (Q.isEmpty()) {
					bw.write(-1 + "\n");
				} else {
					bw.write(Q.get(0)+ "\n");
					Q.remove(0);
				}
				break;
			case "size":
				bw.write(Q.size() + "\n");
				break;
			case "empty":
				if (Q.isEmpty()) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
				break;
			case "front":
				if (Q.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(Q.get(0)+ "\n");
				}
				break;
			case "back":
				if (Q.isEmpty()) {
					bw.write(-1 + "\n");
				}else {
					bw.write(Q.get(Q.size()-1)+ "\n");
				}
			}
		}

		// 출력
		bw.flush();
		bw.close();
	}
}
// End
