package week06;

import java.util.Scanner;

public class boj2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int GCDab = gcd(a, b);
		int LCMab = a * b / GCDab;

		System.out.println(GCDab);
		System.out.println(LCMab);

	}

	public static int gcd(int x, int y) {

		while (y > 0) {
			int tmpx = x;
			int tmpy = y;
			x = tmpy;
			y = tmpx % tmpy;
		}
		return x;
	}
}
