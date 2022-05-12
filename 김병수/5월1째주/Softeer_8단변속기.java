package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_8단변속기
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] aline  = br.readLine().split(" ");
        int [] DCT = new int[8];
        for(int i=0; i<8;i++){
            DCT[i] = Integer.parseInt(aline[i]);
        }

        String mode = "mixed";
        if(DCT[0]==1){
            mode = "ascending";
        }else if(DCT[0]==8){
            mode = "descending";
        }

        // ascending, descending이 정상인지 확인
        for(int i=1; i<8;i++){
            String curr = mode;
            if( DCT[i-1] <= DCT[i] ) {
                curr = "ascending";
            }else{
                curr = "descending";
            }
            if(!curr.equals(mode)){
                mode = "mixed";
                break;
            }
        }
        
        // 출력
        System.out.println(mode);

    }
}