package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_플레이페어암호
{
    public static Stack<Character> keyStk;
    public static List<Character> msgList;
    public static Set<Character> doneAlpha;
    public static char [][] board;

    public static void main(String args[]) throws IOException
    {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char [] msg = br.readLine().toCharArray();
        char [] key = br.readLine().toCharArray();
        keyStk = new Stack<>();
        msgList = new LinkedList<>();

        // key를 스택에 담기
        int sizeS = key.length;
        for(int i=sizeS-1; i>=0; i--){
            keyStk.add(key[i]);
        }
        // msg를 리스트에 담기
        int sizeL = msg.length;
        for(int i=0; i<sizeL; i++){
            msgList.add(msg[i]);
        }

        doneAlpha = new HashSet<>();
        board = new char [5][5];
        
        // board 만들기
        makeBoard();

        // 메세지를 두 글자씩 나누기
        makeNewMsg();
        
        // 두글자씩 암호화
        encode();

        // 출력
        int sizeResult= msgList.size();
        for(int i=0; i<sizeResult; i++){
            System.out.print(msgList.get(i));
        }
   
    }

    public static void encode(){
        int sizeMSG = msgList.size();
        for(int i=0; i< sizeMSG; i=i+2){
            char fst = msgList.get(i);
            char end = msgList.get(i+1);
            int r1=-1, c1=-1, r2=-1, c2=-1;
            // 두 글자의 위치 찾기
            for(int r=0; r<5;r++){
                for(int c=0; c<5;c++){
                    if(board[r][c] == fst){
                        r1 = r;
                        c1 = c;
                    }else if(board[r][c] == end){
                        r2 = r;
                        c2 = c;
                    }
                }
            } // 위치 찾기 완료

            if(r1==r2){
                // 오른쪽 한칸 이동
                c1 = (c1+1)%5;
                c2 = (c2+1)%5;
                // 업데이트
                msgList.set(i, board[r1][c1]);
                msgList.set(i+1, board[r2][c2]);
            }
            else if(c1 == c2){
                // 아래쪽으로 한칸 이동
                r1 = (r1+1)%5;
                r2 = (r2+1)%5;
                // 업데이트
                msgList.set(i,board[r1][c1]);
                msgList.set(i+1,board[r2][c2]);
            }
            else if( (r1 !=r2) && (c1 != c2) ){
                // 서로 열 교환
                int tmp = c1;
                c1 = c2;
                c2 = tmp;
                // 업데이트
                msgList.set(i,board[r1][c1]);
                msgList.set(i+1,board[r2][c2]);
            }
        }
    }


    public static void makeNewMsg(){
        for(int i=0; i<msgList.size(); i=i+2){
            char fst = msgList.get(i);
            // 아무값으로 초기화
            char end = 'A';
            // 마지막 한글자 남지 않는 경우
            if(i+1 != msgList.size()){
                end = msgList.get(i+1);
            // 마지막 한글자 남았을때는 X를 추가해야하는데 이를 위해
            // end가 fst와 같은 척하고 X를 추가해주면 됨.
            // 단 fst==end=='X'일때도 'X'를 추가해줘야 하는 점이 다르다.
            }else{
                end = fst;
            }
            // 쌍이 동일한 경우 X or Q 추가 해주기
            if(fst==end ){
                // 마지막 한글자 처리인 경우는 무조건 X가 추가되게끔.
                if(i+1 == msgList.size()){
                    msgList.add('X');
                }
                // 모두 X로 구성된 쌍일 경우
                else if(fst=='X' ){
                    msgList.add(i+1,'Q');
                } 
                // X 이외로 구성된 쌍일 경우
                else{
                    msgList.add(i+1,'X');
                }
            }
        }
    }

     public static void makeBoard(){
         int r=0;
        int c=0;
        char toPut = 'A';
        // board를 한칸씩 이동하며 채워 넣는다.
        while(! (r==5 && c==0)){
            // Key의 구성성분으로 board를 채우기
            if(!keyStk.isEmpty()){
                char curr = keyStk.pop();
                if(!doneAlpha.contains(curr)){
                    board[r][c] = curr;
                    doneAlpha.add(curr);
                    // 한칸이동
                    c++;
                    if(c==5){
                        r++;
                        c=0;
                    }
                }
            // key로 다 채운 후 그 외 알파벳으로 채우기
            }else{
                if(!doneAlpha.contains(toPut) && toPut!='J'){
                    board[r][c] = toPut;
                    doneAlpha.add(toPut);
                    // 한칸이동
                    c++;
                    if(c==5){
                        r++;
                        c=0;
                    }
                }
                toPut+=1;
            }
        } // board 채워넣기 완료
     }
}