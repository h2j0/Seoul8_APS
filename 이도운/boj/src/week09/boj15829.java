package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15829 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long l = Integer.parseInt(br.readLine());
		long r = 31;
		long m = 1234567891;
		
		String word = br.readLine();
		long hashres = 0;
		for (int i=0; i<l; i++) {
			hashres += (Character.getNumericValue(word.charAt(i))-9)*ABmodC(r, i, m);
			hashres %= m;
		}
		System.out.println(hashres);
		
		
	}

	public static long ABmodC(long a, long b, long c) {
		String binb = Integer.toBinaryString((int) b);
		long[] modc = new long[binb.length()];
		modc[0] = a % c;
		for (int i = 1; i < binb.length(); i++) {
			modc[i] = (modc[i - 1] * modc[i - 1]) % c;
		}
		long res = 1;
		for (int i = 0; i < binb.length(); i++) {
			if (binb.charAt(binb.length() - 1 - i) == '1') {
				res *= modc[i];
				res %= c;
			}
		}
		return res;
	}

}
