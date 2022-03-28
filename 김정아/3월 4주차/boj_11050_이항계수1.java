package BOJ;

import java.util.Scanner;

public class boj_11050_이항계수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int n = 1;
		for(int i = 1; i <= N; i++) {
			n*=i;
		}
		
		int k = 1;
		for(int i = 1; i <= K; i++) {
			k*=i;
		}
		
		int e = 1;
		for(int i = 1; i <= N-K; i++) {
			e*=i;
		}
		
		System.out.println(n/(e*k));
		
		
	}
	
	//재귀로도 풀이 가능
	public static int factorial(int n) {
		if( n <= 1)
			return n ;
		else
			return factorial(n-1)*n;	
	}
}
