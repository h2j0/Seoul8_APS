package week08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i=0; i<n; i++) {
			String[] ipt = br.readLine().split(" ");
			
			switch (ipt[0]) {
			case "push_front":
				stack.addFirst(Integer.parseInt(ipt[1]));
				break;
			case "push_back":
				stack.addLast(Integer.parseInt(ipt[1]));
				break;
			case "pop_front":
				if (stack.isEmpty()) {
					bw.write("-1\n");
				}else {
					bw.write(stack.pollFirst()+" \n");
				}
				break;
			case "pop_back":
				if (stack.isEmpty()) {
					bw.write("-1"+"\n");
				}else {
					bw.write(stack.pollLast()+"\n");
				}
				break;
			case "size":
				bw.write(stack.size()+"\n");
				break;
			case "empty":
				bw.write((stack.isEmpty()?1:0)+"\n");
				break;
			case "front":
				bw.write((stack.isEmpty()?-1:stack.peekFirst())+"\n");
				break;
			case "back":
				bw.write((stack.isEmpty()?-1:stack.peekLast())+"\n");
				break;
			}
			
		}
		bw.flush();
		bw.close();
		
		
		
		
	}

}
