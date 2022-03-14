package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class boj_1181_단어정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
//		Queue<String> word = new LinkedList<>();
		String[] words = new String[N];
		for(int i = 0; i < N; i++) {
			words[i] = sc.next(); //일단 입력 받고
		}
		Arrays.sort(words);// 순서대로 정렬해주기
//		System.out.println(Arrays.toString(words));
		for(int i = 1; i < N; i++) { // 길이대로 정렬해주기
			for(int j = 0; j < N-i; j++) {
				if(words[j].length() > words[j+1].length()) {
					String tmp = words[j];
					words[j] = words[j+1];
					words[j+1] = tmp;
				}
			}
		}
//		System.out.println(Arrays.toString(words));

		
		System.out.println(words[0]); //0번째는 걍 출력하고
		for(int i = 1; i < N; i++) {//1번째부터 그 전꺼랑 다르면출력스.
			if(!words[i].equals(words[i-1])) {
				System.out.println(words[i]);
			}
		}
		
	}
}
