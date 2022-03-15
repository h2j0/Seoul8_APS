package BOJ;

import java.util.Scanner;

public class boj_2775_부녀회장이될테야 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int k = sc.nextInt(); //k층 받아주고
			int n = sc.nextInt(); //n호 받아준다
			
			int[] apart = new int[n]; //아파트 배열을 그냥 하나 일단 0층 배열 맹글어줌
			for(int i = 0; i < n; i++) { //
				apart[i] = i+1;
			}
			
			if(n == 1) { //n이 1일때는 그냥 1이다
				System.out.println(1);
			}else if(n == 2) {// 2일때는 2부터 차례로 올라가서 k에 2를 더해줌.
				System.out.println(k+2);
			}else {
				while(k > 0) { //층수 만큼 반복해서 더해줘
//				for(int t = 0; t < k; t++) {//for문도 가능
					for(int i = 0; i < n-1; i++) {
						apart[i+1] += apart[i]; // 그냥 배열 돌면서 n까지 더해주는 거임
					}
//				}
					k--;
				}
				System.out.println(apart[n-1]); // n-1번째 인덱스 값 출력
			}			
		}
	}
}
