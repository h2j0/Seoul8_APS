package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_차세대지능형교통시스템
{

    public static int [] dr = {0,-1,0,1};
    public static int [] dc = {1,0,-1,0};
    public static int N;
    public static int T;
    


    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] NT = br.readLine().split(" ");
        N = Integer.parseInt(NT[0]);
        T = Integer.parseInt(NT[1]);

        List<Integer> [][] board = new LinkedList[N][N];
        // board 채우기
        for(int r=0; r< N; r++){
            for(int c=0; c<N;c++){
                String [] aline = br.readLine().split(" ");
                // 신호 집합 큐 생성
                List<Integer> light = new LinkedList<>();
                light.add(Integer.parseInt(aline[0]));
                light.add(Integer.parseInt(aline[1]));
                light.add(Integer.parseInt(aline[2]));
                light.add(Integer.parseInt(aline[3]));
                // board에 만든 큐 넣어주기
                board[r][c] = light;
            }
        }
        //r,c<=99이므로 100*r+c로 구분할 수 있음.
        Set<Integer> result = new HashSet<>();
        // 주행시작
        drive(0, 0, 0, 1, copy(board), result);

        // 출력
        System.out.println(result.size());




        // 디버깅
        //for(int r=0; r< N; r++){
        //    System.out.println(Arrays.toString(board[r]));
        //}
        
    }
    public static List<Integer> [][] copy(List<Integer> [][] board){
        List<Integer> [][] tmp = new LinkedList[N][N];
        for(int r=0; r<N;r++){
            for(int c=0; c<N;c++){
                tmp[r][c] = new LinkedList<>();
                int size = board[r][c].size();
                for(int i=0; i<size;i++){
                    tmp[r][c].add(board[r][c].get(i));
                }
            }
        }
        return tmp;
    }

    public static void drive(int time, int r, int c, int dir, List<Integer> [][] board, Set<Integer> result){
        if(time == T+1){
            return;
        }
        
        // 현재 위치에서 작업
        result.add(100*r+c);

        // 방향 결정
        int [] posDir = posDirList(r, c, board);
        // 전환 전 방향이 일치하면
        if(posDir[0] == dir){
            int size = posDir.length;
            for(int i=1; i<size; i++){
                int rowD = r+dr[posDir[i]];
                int colD = c+dc[posDir[i]];
                if(BC(rowD,colD)){
                    // 신호등 전환
                    List<Integer> [][] newBoard =  copy(board);
                    for(int row=0; row<N;row++){
                        for(int col=0; col<N;col++){
                            newBoard[row][col].add(newBoard[row][col].remove(0));
                        }
                    }
                    // 다음 시간 진입
                    drive(time+1, rowD, colD, posDir[i], newBoard, result);
                }
            }
        }





    }
    // [전환 전 방향, 전환 후 방향, 전환 후 방향,.......]
    public static int [] posDirList(int r, int c, List<Integer> [][] board){
        switch(board[r][c].get(0)){
            case 1 :
                int [] arr1 = {0,0,1,3};
                return arr1;
            case 2 :
                int [] arr2 = {1,0,1,2};
                return arr2;
            case 3 :
                int [] arr3 = {2,1,2,3};
                return arr3;
            case 4 :
                int [] arr4 = {3,0,2,3};
                return arr4;
            case 5 :
                int [] arr5 = {0,0,1};
                return arr5;
            case 6 :
                int [] arr6 = {1,1,2};
                return arr6;
            case 7 :
                int [] arr7 = {2,2,3};
                return arr7;
            case 8 :
                int [] arr8 = {3,0,3};
                return arr8;
            case 9 :
                int [] arr9 = {0,0,3};
                return arr9;
            case 10 :
                int [] arr10 = {1,0,1};
                return arr10;
            case 11 :
                int [] arr11 = {2,1,2};
                return arr11;
            case 12 :
                int [] arr12 = {3,2,3};
                return arr12;
        }
        int [] trash = new int [4];
        return trash;
    }

    public static boolean BC(int r, int c){
        if(r>=0 && r<N && c>=0 && c<N){
            return true;
        }else{
            return false;
        }

    }
}