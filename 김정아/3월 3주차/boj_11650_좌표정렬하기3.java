package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj_11650_좌표정렬하기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//x가 증가 하는 순
		//x가 같다면 y순으로 정렬
		int N = sc.nextInt();
		
		int[][] dimension = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			dimension[i][0] = sc.nextInt();
			dimension[i][1] = sc.nextInt();
		}
		
		Arrays.sort(dimension, new Comparator<int[]>() {
			//2차원 평면에서 x좌표 증가하는 순으로, x가 같으면 y가 증가하는 순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) { //파라미터는 비교를 해야 해서 항상 두 개씩 들어온다.
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0] - o2[0];
				}
			}
			
		});
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(dimension[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
