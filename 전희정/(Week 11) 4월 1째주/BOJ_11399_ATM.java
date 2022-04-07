package BOJ.Study.Week11_Apr1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] line = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(line);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (line[i] * (N - i));
		}
		System.out.println(sum);
	}
}
