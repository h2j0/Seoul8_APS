package BOJ;

import java.util.HashSet;
import java.util.Scanner;

public class boj_1107_리모컨 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashSet<Integer> broken = new HashSet<>();
		for(int i = 0; i < M; i++) {
			broken.add(sc.nextInt());
		}
//		System.out.println(broken);
		//
		int min = Integer.MAX_VALUE;
		int control = 0;
		
		for(int i = 0; i <=1000000; i++) { //겁나 많이 돈다는 단점이,,, 499900이라 생각했는데, 500000을 가기 위해 저 위에서 내려와햐 하는 경우가 생긴다.
			String[] tmp = Integer.toString(i).split("");
			boolean flag = true;
			for(int j = 0; j < tmp.length; j++) {
				if(broken.contains(Integer.parseInt(tmp[j]))) {
					flag = false;
					break;
				}
			}
			if(flag == false) continue; //만약에 리모컨에 그 수가 포함되어잇는애라면 걍 패스
			
			control = tmp.length + Math.abs(i-N); // 아니라면 일단 tmp개수만큼은 누르게 될테고, i번째에서 N을 뺀담에 그거 음수값 없애줘
			
			if(control < min) { // 그리고 그 control중에 최소값인거를 구해
				min = control;
			}
		}
//		System.out.println(min);
		int res = Math.abs(100-N);
		int result = Math.min(min, res);
		
		System.out.println(result);
		
//		5457
//		3
//		6 7 8
//		for(int i = 0; i < aim.length; i++) {
//			if(!broken.contains(Integer.parseInt(aim[i]))) {
//				
//			}else {
//				
//			}
//		}
		

		
	}
}
