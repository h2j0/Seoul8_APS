package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11399_ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//어차피 그냥 순서대로 줄을 서면 최솟값 같음
		
		int N = sc.nextInt();
		
		int[] row = new int[N];
		
		for(int i = 0; i < N; i++) {
			row[i] = sc.nextInt();
		}
		
		Arrays.sort(row);
		
		int sum = 0;
		int tmp = 0;
		
		for(int i = 0; i < N; i++) {
			sum += row[i];
			tmp += sum;
		}
		
		System.out.println(tmp);

	}
}
