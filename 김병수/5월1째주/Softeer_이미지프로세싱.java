package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_이미지프로세싱
{
    public static class coor{
        public int r;
        public int c;
        public coor(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static int [] dr = {0,-1,0,1};
    public static int [] dc = {1,0,-1,0};
    public static int H;
    public static int W;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String [] HW = br.readLine().split(" ");
        H = Integer.parseInt(HW[0]);
        W = Integer.parseInt(HW[1]);
        // 크기 1패딩
        int [][] board = new int[H+2][W+2];

        // 비트맵 정보 받기
        for(int r=1; r<=H; r++){
            String [] aline = br.readLine().split(" ");
            for(int c=1; c<=W;c++){
                board[r][c] = Integer.parseInt(aline[c-1]);
            }
        }

        // 명령 수행
        int Q = Integer.parseInt(br.readLine());
        for(int q=0; q<Q; q++){
            String [] order = br.readLine().split(" ");
            int row = Integer.parseInt(order[0]);
            int col = Integer.parseInt(order[1]);
            int value = Integer.parseInt(order[2]);
            // BFS
            BFS(board, row, col, value);
        }

        // 출력
        for(int r=1; r<= H;r++){
            for(int c=1; c<= W; c++){
                sb.append(board[r][c]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void BFS(int [][] board, int r, int c, int value){
        Queue<coor> Q = new LinkedList<>();
        boolean [][] check = new boolean[H+2][W+2];
        Q.add(new coor(r,c));
        check[r][c] = true;
        while(!Q.isEmpty()){
            coor curr = Q.poll();
            int tmp = board[curr.r][curr.c];
            board[curr.r][curr.c] = value;

            for(int i=0; i<4; i++){
                int rowD = curr.r+dr[i];
                int colD = curr.c+dc[i];
                if(BC(rowD,colD) && !check[rowD][colD] && board[rowD][colD] == tmp){
                    Q.add(new coor(rowD,colD));
                    check[rowD][colD] = true;
                }
            }
        }
    }

    public static boolean BC(int r, int c){
        if(r>=1 && r<=H && c>=1 && c<=W){
            return true;
        }else{
            return false;
        }
    }
}