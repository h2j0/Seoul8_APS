package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class boj_10773_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> money = new Stack<>();
		
		int T = sc.nextInt(); //테스트 케이스 받고
		for (int tc = 1; tc <= T; tc ++) { // testcase만큼 반복
			
			int N = sc.nextInt();
			
			if(N > 0) { // N이 0보다 크면 넣고
				money.add(N);
			} else if( N == 0)  {//0이면 빼고
				money.pop();				
			}
		}
		
		long sum = 0;
		for(int i = 0; i < money.size(); i++) {
			sum += money.get(i);
		}
		System.out.println(sum);
	}
}
