package week08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		int ipt;
		Stack<Integer> stack = new Stack<>();
		
		for (int i=0; i<k; i++) {
			ipt = Integer.parseInt(br.readLine());
			if (ipt==0) {
				stack.pop();
			}
			else {
				stack.add(ipt);
			}
		}
		
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
		
		
		
		
	}

}
