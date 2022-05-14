package BOJ;

import java.util.*;

public class boj_18870_좌표압축 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] coordinate = new int[N];
		ArrayList<Integer> compress = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			coordinate[i] = sc.nextInt();
			int tmp = coordinate[i];
			if(!compress.contains(tmp)) {
				compress.add(tmp);
			}
		}
//		System.out.println(compress);
//		ArrayList<Integer> ans = new ArrayList<>();
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sum = 0;
			for(int j = 0; j < compress.size(); j++) {
				if(coordinate[i] > compress.get(j)) {
					sum++;
				}
			}
//			ans.add(sum);
			sb.append(sum+" ");
		}
		System.out.println(sb);
		
		
	}
}
