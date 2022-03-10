package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String inNum = br.readLine();
		String[] Arr = inNum.split(" ");

		int A = Integer.parseInt(Arr[0]);
		int B = Integer.parseInt(Arr[1]);
	
		int GCF=1;
		int LCM=1;
		
		int Big;
		int Small;
		
		// 둘 중 작은 값 찾기
		if (A > B) {
			Big =A;
			Small = B;
		}else {
			Big =B;
			Small = A;
		}
		
		// 최대공약수 찾기
		for(int scan = 1; scan <= Small; scan++) {
		    // 큰수와 작은수에 모두 나누어 떨어지는 수
			if(Big%scan ==0 && Small%scan ==0) {
				GCF=scan;
				// 최대값을 원하니 no break;
			}
		}
		
		// 최소공배수 찾기
		int mul = 1;
		while(true) {
			// 작은수의 배수 중 큰 수에 나누어 떨어지는 수
			if(Small*mul % Big ==0) {
				LCM = Small*mul;
				// 최소값을 원하니 break;
				break;
			}
			mul++;
		}

		// 출력
		bw.write(GCF+"\n");
		bw.write(LCM+"\n");
		bw.flush();
		bw.close();
	}
}
// End
