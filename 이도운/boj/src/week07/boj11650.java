package week07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj11650 {public static void main(String[] args) throws IOException{
	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int n = Integer.parseInt(br.readLine());
	int[][] coord = new int[n][2];
	
	for (int i=0; i<n; i++) {
		String[] ipt = br.readLine().split(" ");
		coord[i][0] = Integer.parseInt(ipt[0]);
		coord[i][1] = Integer.parseInt(ipt[1]);		
	}
	
	Arrays.sort(coord,(a,b)->{
        if(a[0]!=b[0]) return a[0]-b[0];
        else return a[1]-b[1];
    });
	
	for (int i=0; i<n; i++) {
		bw.write(coord[i][0]+ " "+coord[i][1]+"\n");
	}
	bw.flush();
	bw.close();
	
}
	
	
	

}
