package Mar_5th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1259_팰린드롬수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String word = br.readLine();
			if(word.equals("0")) break;
			char[] words = word.toCharArray();
			int n = words.length;
			String result = "yes";
			for(int i = 0; i<n/2; i++) {
				if(words[i] != words[n-1-i]) {
					result="no";
					break;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

}
