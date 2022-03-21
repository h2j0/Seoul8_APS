package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1018_체스판다시칠하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//N이랑 M 받기 위한 배열
		String[] nm = br.readLine().split(" ");
		// 하얀거가 먼저오는 체스판
		String[] chessBoard = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", 
                "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"};
		// 까만거가 먼저오는 체스판
		String[] chessBoard2 = { "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", 
                "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"};
		
		// N이랑 M
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		//입력 받는 board 배열 설정해주기
		char[][] board = new char[N][M];
		
		//입력 받기
		for(int i = 0; i < N; i++) {
				board[i] = br.readLine().toCharArray();
		}
		
		// count 해줄 거로 최솟값 찾기 위해 설정
		int cnt = Integer.MAX_VALUE;
		// 행은 N-8+1까지만 보면 되고
		for(int i = 0; i < N-8+1; i++) {
			// 열도 M-8+1까지만 보면 됨
			for(int j = 0; j < M-8+1; j++) {
				// 두 종류 체스 판 중 어떤 게 더 작은 지 모르니까 min 하나 잡아주고
				int min = Integer.MAX_VALUE;
				int ans = 0; //하얀거랑 다른거 찾는 용
				int ans2 = 0; //까만거랑 다른거 찾는 용
				for(int d = 0; d < 8; d++) {
					for(int k = 0; k < 8; k++) {
						// 하얀 체스판이랑 다르면 ans++
						if(board[i+d][j+k] != chessBoard[d].charAt(k)) {
							ans++;
						} 
						//까만 체스판이랑 다르면 ans2++
						if(board[i+d][j+k] != chessBoard2[d].charAt(k)) {
							ans2++;
						}
						
					}
					
				}
				// 둘중에 뭐가 더 작을까
				min = Math.min(ans, ans2);
				
				// 그래서 그중에 젤 작은거
				if(cnt > min) {
					cnt = min;
				}
				
			}
		}
		// 답 출력
		System.out.println(cnt);
		
		
	}
}
