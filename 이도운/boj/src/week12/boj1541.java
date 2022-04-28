package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String eq = br.readLine();

		LinkedList<Integer> n = new LinkedList<Integer>();
		LinkedList<Character> op = new LinkedList<Character>();
		int st = 0;
		int ed = 0;

		for (int i = 0; i < eq.length(); i++) {
			char eqChar = eq.charAt(i);
			if (eqChar == '+' || eqChar == '-') {
				n.add(Integer.parseInt(eq.substring(st, ed)));
				op.add(eqChar);
				ed++;
				st = ed;
			} else {
				ed++;
			}
		}
		n.add(Integer.parseInt(eq.substring(st, ed)));

		int idx = 1;
		LinkedList<Integer> nFin = new LinkedList<Integer>();
		nFin.add(n.get(0));

		while (idx < n.size()) {
			if (op.get(idx - 1) == '+') {
				int tmp = nFin.get(nFin.size() - 1);
				nFin.removeLast();
				nFin.add(tmp + n.get(idx++));
			} else {
				nFin.add(n.get(idx++));
			}
		}


		int ans = nFin.get(0);
		for (int i = 1; i < nFin.size(); i++) {
			ans -= nFin.get(i);
		}
		System.out.println(ans);

	}

}
