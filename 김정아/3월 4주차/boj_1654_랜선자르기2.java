package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1654_랜선자르기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int K = sc.nextInt(); //
		int N = sc.nextInt();
		
		long[] line = new long[K];
		
		for(int i = 0 ; i < K; i++) {
			line[i] = sc.nextLong();
		}
		
		Arrays.sort(line);
		long max = line[K-1];	
		long min = 0;
		
		while(min<=max) {
			long sum = 0;
			long mid = (min+max)/2; //중간을 구해주고
			for(int i = 0; i < K; i++) {
				if(line[i]>=mid) {//선이 mid보다 크면
					sum+=line[i]/mid;//선을 mid로 나눈거의 몫을 sum에 더해준다.
				} else {
					continue;
				}
			}
			if(sum>=N) {
				min = mid+1;
			} else {
				max = mid-1;
			}
		}
		System.out.println(max);
		
		
	}
}
