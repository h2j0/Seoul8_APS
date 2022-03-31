package BOJ;

import java.util.Scanner;

public class boj_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = sc.nextInt();
		int cnt = 0;
		int title = 666;
		
		while(cnt <= ans) {
			//그냥 일일이 다 세본다.
			if(Integer.toString(title).contains("666")) {
				cnt++;
				if(cnt == ans) {
					System.out.println(title);
				}
			}
			title++;
		}
		
		
	}
}
