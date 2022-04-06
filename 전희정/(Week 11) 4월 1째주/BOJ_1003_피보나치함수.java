package BOJ.Study.Week11_Apr1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수2 {

	static int[][] arr = new int[41][2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr[0][0] = arr[1][1] =1;
			arr[0][1] = arr[1][0] =0;
			
			fibonacci(n);
			sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
		}
		System.out.println(sb);
	}// main

	private static int[] fibonacci(int n) {
		// arr가 둘 다 빈 값일 때 배열에 추가해준다
		if(arr[n][0]==0 && arr[n][1]==0) {
			arr[n][0] = fibonacci(n-1)[0] +fibonacci(n-2)[0];
			arr[n][1] = fibonacci(n-1)[1] +fibonacci(n-2)[1];
		}
		
		return arr[n];
		
	}// fibo
}
