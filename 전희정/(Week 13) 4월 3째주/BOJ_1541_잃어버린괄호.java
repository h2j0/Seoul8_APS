package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1541_잃어버린괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		List<Integer> numArr = new ArrayList<>();
		List<Character> operArr = new ArrayList<>();

		String strNum = "";
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			// 연산자 만나면 연산자리스트에 추가
			if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				operArr.add(str.charAt(i));
				flag = true;
			} else { // 숫자면 string으로 숫자 만들어준다
				strNum += str.charAt(i);
				flag = false;
			}
			// numArr에 strNum을 추가하는 조건: 1. 연산자를 만나거나 2. i가 맨 마지막까지 갔거나
			if (flag || i == str.length() - 1) {
				numArr.add(Integer.parseInt(strNum));
				strNum = "";
			} // 숫자, 연산자 구분해서 따로 저장
		}
		// 첫 마이너스 찾기
		int idx = operArr.size();
		for (int i = 0; i < operArr.size(); i++) {
			if(operArr.get(i)=='-') {
				idx=i;
				break;
			}
		}

		// 첫 마이너스 찾으면 그 앞까진 다 더하고 그 뒤는 다 뺀다		
		int ans =0;
		for(int i=0;i<=idx;i++) {
			ans+=numArr.get(i);
		}
		for(int i=idx+1;i<numArr.size();i++) {
			ans-=numArr.get(i);
		}
		System.out.println(ans);
	}
}
