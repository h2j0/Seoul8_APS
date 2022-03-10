package BOJ;

import java.util.Scanner;

public class boj_7568_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] dungchi = new int[N][2];
		
		for(int i = 0; i < N; i++) {			
				dungchi[i][0] = sc.nextInt(); //무게
				dungchi[i][1] = sc.nextInt(); //키
		}
//		System.out.println(Arrays.toString(dungchi[1])); 확인용
		
		
			for(int i = 0; i < N; i++) {
				int bigboss = 1; // 순위매기기 위해 bigboss 선언
				for(int j = 0; j < N; j++) {
					if(i==j) { //같으면 패스
					 continue;
					}
					if(dungchi[i][0] < dungchi[j][0] && dungchi[i][1] < dungchi[j][1]) { //더 작다면
							bigboss++; // 랭크+ 해주기.
					}
				}
				System.out.println(bigboss);
			}
			
	}
}
