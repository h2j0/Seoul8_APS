package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class boj_5430_AC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			
			String[] P = sc.next().split("");
			int n = sc.nextInt();
			ArrayList<String> AC = new ArrayList<>();
			
			String[] intStr = sc.next().replaceAll("[^0-9]", "").split(""); //0-9가아니면 공백처리
			for(int i = 0; i < intStr.length; i++) {
				AC.add(intStr[i]);
			}
//			System.out.println(Arrays.toString(intStr)); 출력 확인용
//			System.out.println(AC);
			boolean reverse = false;
			for(int i = 0; i < P.length; i++) {
				switch(P[i]) {
				case "R":
					reverse = !reverse;
					break;
				case "D":
					if(!AC.isEmpty())
						if(reverse) {
							AC.remove(AC.size()-1);
						}else {
							AC.remove(0);
						}
					
					break;
				}
			}
			if(!AC.isEmpty()) {
				if(reverse) {
					Collections.reverse(AC);
					sb.append('[');
					for(int i = 0; i < AC.size()-1; i++) {
						sb.append(AC.get(i)).append(',');
					}
					sb.append(AC.get(AC.size()-1)).append(']');
					System.out.println(sb);
				}else {
					sb = new StringBuilder();
					sb.append('[');
					for(int i = 0; i < AC.size()-1; i++) {
						sb.append(AC.get(i)).append(',');
					}
					sb.append(AC.get(AC.size()-1)).append(']');
					System.out.println(sb);
				}
			}else {
				System.out.println("error");
			}
		}
		
	}
}
