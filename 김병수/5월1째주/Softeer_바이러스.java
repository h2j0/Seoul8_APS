package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_바이러스
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] KPN = br.readLine().split(" ");

        // 곱셈간 overflow방지를 위해 long으로 설정하자.
        long K = Integer.parseInt(KPN[0]);
        long P = Integer.parseInt(KPN[1]);
        int N = Integer.parseInt(KPN[2]);

        for(int i =1; i<=N; i++){
            K = (K * P) % 1_000_000_007;
        }

        System.out.println(K);
    }
}