package week08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] ipt = br.readLine().split(" ");
		int[] side = new int[3];
		for (int i=0; i<3; i++) {
			side[i] = Integer.parseInt(ipt[i]);
		}
		Arrays.sort(side);
		
		while (side[0]!=0) {
			if(side[0]*side[0]+side[1]*side[1]==side[2]*side[2]) {
				bw.write("right\n");
			}
			else {
				bw.write("wrong\n");
			}
			ipt = br.readLine().split(" ");
			for (int i=0; i<3; i++) {
				side[i] = Integer.parseInt(ipt[i]);
			}
			Arrays.sort(side);
			
		}
		bw.flush();
		bw.close();
		
	}

}
