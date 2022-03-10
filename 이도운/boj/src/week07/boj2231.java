package week07;
import java.util.Scanner;

public class boj2231 {public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	String nStr = sc.nextLine();
	int d0 = nStr.length();
	int n = Integer.parseInt(nStr);
	int st = (0 > n - d0 * 9) ? 0 : n - d0 * 9;
	
	int[] ansList = new int[n - st];
	int cnt = 0;
	for (int i = st; i < n - 1; i++) {
		int d = Integer.toString(i).length();
		int t = i;

		for (int j = 0; j < d; j++) {
			t += Integer.toString(i).charAt(j) - '0';
		}
		if (t == n) {
			ansList[cnt++] = i;
		}
	}
	
	if (cnt == 0) {
		System.out.println(0);
	} else {
		int minv = Integer.MAX_VALUE;
		for (int i = 0; i < cnt; i++) {
			minv = (ansList[i] < minv) ? ansList[i] : minv;
		}
		System.out.println(minv);
	}
	
		
}
}


