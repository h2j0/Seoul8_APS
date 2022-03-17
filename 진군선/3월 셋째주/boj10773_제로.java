package Mar_3rd_Week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj10773_제로 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			switch (n) {
			case 0:
				stack.pop();
				break;

			default:
				stack.push(n);
				break;
			}
		}
		
		int result = 0;
		while(stack.size()>0) {
			result += stack.pop();
		}
		
		bw.write(result+"\n");
		bw.close();
		
	}

}
