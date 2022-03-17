package week08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] NM = br.readLine().split(" ");
		int n = Integer.parseInt(NM[0]);
		int m = Integer.parseInt(NM[1]);

		int[][] Board = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String ipt = br.readLine();
			for (int j = 0; j < m; j++) {
				char BW = ipt.charAt(j);
				if (BW == 'B') {
					Board[i][j] = 0;
				} else {
					Board[i][j] = 1;
				}
			}
		}
				
		int minV = n*m+1; 
	
		for (int i=0; i<n-8+1; i++) {
			for (int j=0; j<m-8+1; j++) {
				int disB = 0;
				int disW = 0;
				for (int r=0; r<8; r++) {
					for (int c=0; c<8; c++) {
						disB += (((r+c)%2)==Board[i+r][j+c])?0:1;
						disW += (((r+c+1)%2)==Board[i+r][j+c])?0:1;
					}
				}
				minV = (disB<minV)?disB:minV;
				minV = (disW<minV)?disW:minV;
			}
		}
		System.out.println(minV);
		
		
		
		

	}

}
