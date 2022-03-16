package Mar_3rd_Week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1436_영화감독숌 {

	public static void main(String[] args) throws Exception {
		// 666*10^n 전에 6세트, 뒤에 3세트 666*10^n은 10^n개 
		// 0~9999까지 19개 (= 9 + 10) 
		// 0~99999까지 19*6 + (6+100+3) + 19*3개 -> 19*9 + 109 = 280개 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 0;
		
		while (cnt<n) {
			num++;
			
			if((num+"").contains("666")) {
				cnt++;
			}
			
		}
		
		bw.write(num+"\n");
		bw.close();
		
	}

}
