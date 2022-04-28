package BOJ;

import java.util.Scanner;

public class boj_1676_팩토리얼0의개수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		//일단 10이 나오면 0이 생긴다
		//근데 만약 10이 나오지 않더라도 2나 5가 나오면 이게 또 10이 되니까 0이 생긴다.
		//그니까 2, 5 쌍이 생기거나 10이 나오면 그게 곧 0이 생기는.
		//유의할게 있다면 만약 25같은 5가 두개, 그니까 이런 5의 배수들을 고려해줘야한다. 5 25 125 500까지니까
		//
		
		int cnt = 0;
		for(int div = 5; (N/div)>0; div = div*5) {  //div는 5로 초기값 설정해주고 5로 나눳을 때 0보다 크면 계속 반복/ div에는 5곱한값 저장해주고
			cnt = cnt + N/div;
		}
		
		System.out.println(cnt);

		//1~9 1
		//10~14 2
		//15~19 3
		//20~24 4
		//25~
	}
}
