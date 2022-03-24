package week07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		
		int idx = 0;
		int q = 1;
		boolean check = true;
		
		
		outer:while (idx < n) {
			if (stack.isEmpty()) {
				stack.add(q++);
				sb.append("+\n");
			}else {
				if (stack.peek() != arr[idx]) {
					if (q<=arr[idx]) {
						stack.add(q++);
						sb.append("+\n");
					}else {
						System.out.println("NO");
						check=false;
						break outer;
					}					
				}else {
					stack.pop();
					sb.append("-\n");
					idx+=1;
				}
			}
		}
		
		
		if (check) {
			System.out.println(sb);
		}
	
		
		
	}

}
