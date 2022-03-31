package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2108_통계학2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//시간초과 에러 난다.
		int[] num = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		//산술평균
		System.out.println(sum/N);
		Arrays.sort(num);
		//중앙값
		System.out.println(num[num.length/2]);
		//최빈값
		int max = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 0; 
			for(int j = 0; j < N; j++) {
				if(num[i] == num[j]) {
					cnt++;
				}
			}
			if(cnt > max) {
				max = cnt;
			}
		}
		System.out.println(max);
		//범위
		System.out.println(num[N-1]-num[0]);
	}
}
