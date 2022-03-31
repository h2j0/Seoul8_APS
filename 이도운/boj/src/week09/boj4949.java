package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		last:while (true) {
			String word = br.readLine();
			if (word.length()==1 && word.charAt(0)=='.') {
				break last;}
			String ans = "yes";
			Stack oc = new Stack<>();
			outer: for (int i = 0; i < word.length(); i++) {
				switch (word.charAt(i)) {
				case '(':
					oc.add(true);
					break;
				case '[':
					oc.add(false);
					break;
				case ')':
					if (oc.isEmpty()) {
						ans = "no";
						break outer;
					} else {
						if ((boolean) oc.peek()) {
							oc.pop();
						} else {
							ans = "no";
							break outer;
						}
					}
					break;
				case ']':
					if (oc.isEmpty()) {
						ans="no";
					}else {
						if(!(boolean) oc.peek()) {
							oc.pop();
						}else {
							ans="no";
							break outer;
						}
					}
					break;
				}

			}
			if (!oc.isEmpty()) {
				ans="no";
			}
			System.out.println(ans);
		}

	}

}
