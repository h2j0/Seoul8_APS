package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_4153_직각삼각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean flag = true;
		while (flag) {
			
			String[] triangle = br.readLine().split(" ");
			
			int[] rightAngle = new int[triangle.length];
			for (int i = 0; i < rightAngle.length; i++) {
				rightAngle[i] = Integer.parseInt(triangle[i]);
			}
			//가장 긴 변을 알기 위해 일단 정렬
			Arrays.sort(rightAngle);
			//0이면 break;
			if(rightAngle[0] == 0) {
				flag = false;
				break;
				//피타고라스
			}else if (Math.pow(rightAngle[0], 2) + Math.pow(rightAngle[1], 2) == Math.pow(rightAngle[2], 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
			
		}

	}
}
