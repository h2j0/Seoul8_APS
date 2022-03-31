package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		ArrayList<String> yesOrno = new ArrayList<>();
//		원래는 리스트에 담고 출력할까 햇으나 그냥 했다. 

		boolean flag = true; //while문 실행 하기 위해 boolean 하나 만들어줌
		
		while(flag != false) {
			char[] palin = br.readLine().toCharArray(); //chararray로 받고
			int cnt = 0; //같은 글자인지 count용
			if(palin.length == 1 && palin[0] == '0') { // 만약 0이면 빠져나오기
				flag = false;
				break;
			} else {
				for(int i = 0; i < palin.length/2; i++) { // 아닌경우 회문 검사
					if(palin[i] == palin[(palin.length-1)-i]) {
						cnt++; //같으면 하나씩 카운트
					}
				}
				if(cnt == palin.length/2) { //카운트 한게 (전체 길이/2)와 같다면 회문
					System.out.println("yes");
				}else {//아니라면 회문 아님
					System.out.println("no");
				}
			}
		
		}
		
		
	}
}
