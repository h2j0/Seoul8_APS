package Mar_5th_Week;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	loop:	while(true) {
			String sentence = br.readLine();
			if(sentence.equals(".")) break;
			
			char[] arr = sentence.trim().toCharArray();
			Stack<Character> stack = new Stack<>();
			for(int i = 0; i<arr.length; i++) {
				switch (arr[i]) {
				case '(':
					stack.add('(');
					break;
				case '[':
					stack.add('[');
					break;
				case ')':
					if(stack.isEmpty()) {
						sb.append("no").append("\n");
						continue loop;
					} else {
						if(stack.peek()=='(')
							stack.pop();
						else {
							sb.append("no").append("\n");
							continue loop;
						}
						break;
					}
					
				case ']':
					if(stack.isEmpty()) {
						sb.append("no").append("\n");
						continue loop;
					} else {
						if(stack.peek()=='[')
							stack.pop();
						else {
							sb.append("no").append("\n");
							continue loop;
						}
						break;
					}
				}
			}
			
			if(stack.isEmpty()) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
			
		}
		
		System.out.println(sb);
	}

}
