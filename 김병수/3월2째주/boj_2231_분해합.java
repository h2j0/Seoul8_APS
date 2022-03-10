package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2231_분해합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		// 생성자는 abc이고 abc+a+b+c = N일때
		// N-27 <= abc <= N
		// 즉,  N-(N의 자리수)*9 <= abc <= N이다.
		int tmpN =N;
		int digit = 0;
	    while(tmpN>0) {
	    	tmpN /= 10;
	    	digit++;
	    }

	    int result = 0;
	    // 범위 내 모든 경우에 대해 생성자인가 확인
	    for(int scan = N-digit*9; scan <= N; scan++) {
	    	int tmpScan= scan;
	    	int decom = tmpScan;
	    	while(tmpScan>0) {
	    		decom+=tmpScan%10;
	    		tmpScan/=10;
		    }
	    	if(decom == N) {
	    		result = scan;
	    		break;
	    	}
	    }
	    
		// 출력
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}

}
// End
