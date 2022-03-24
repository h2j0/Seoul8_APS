package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class boj10989 {
	public static void main(String[] args) throws IOException {
		
		// 입출력 횟수가 압도적으로 많은 문제이므로 무조건 사용해야함

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[10001];

		for (int i = 0; i < n; i++) {
			count[Integer.parseInt(br.readLine())] += 1;
		}
		for (int i = 0; i <= 10000; i++) {
			for (int j=0; j<count[i]; j++) {
				bw.write(i+"\n");
			}
		}
		bw.flush();

	}

}
