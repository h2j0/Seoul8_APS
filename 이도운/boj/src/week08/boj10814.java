package week08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class boj10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, String> dict = new HashMap<Integer, String>();
		
		
		
		int n = Integer.parseInt(br.readLine());
		int[][] age = new int[n][2];
		for (int i=0; i<n; i++) {
			String[] ipt = br.readLine().split(" ");
			age[i][0] = i;
			age[i][1] = Integer.parseInt(ipt[0]);
			dict.put(i, ipt[1]);
		}
		
		Arrays.sort(age, (o1, o2) -> {
		    if (o1[1] == o2[1]) {
		        return o1[0] - o2[0];
		    } else {
		        return o1[1] - o2[1];
		    }
		});
		
		for (int i=0; i<n; i++) {
			bw.write(age[i][1]+" "+dict.get(age[i][0])+"\n");
		}
		bw.flush();
		
	}

}
