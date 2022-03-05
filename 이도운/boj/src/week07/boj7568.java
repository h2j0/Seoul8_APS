package week07;

import java.util.Scanner;

public class boj7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		
		for (int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		int[] rank = new int[n];
		
		for (int i=0; i<n; i++) {
			rank[i]+=1;
			for (int j=0; j<n; j++) {
				if (i!=j && x[j]-x[i]>0 && y[j]-y[i]>0) {
					rank[i]+=1;
				}
			}
		}
		
		for (int i=0; i<n-1; i++) {
			sb.append(rank[i]+" ");
		}
		sb.append(rank[n-1]);
		System.out.println(sb);
	}

}
