package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_지우는소수를좋아해_다익스트라
{
    public static class edge implements Comparable<edge>{
        public int st;
        public int ed;
        public int wgt;

        public edge(int st, int ed, int wgt){
            this.st = st;
            this.ed = ed;
            this.wgt = wgt;
        }

        public String toString(){
            return "(st = "+st+", ed = "+ed+", wgt = "+wgt+")";
        }

        public int compareTo(edge o){
            return this.wgt - o.wgt;
        }

    }

    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // 인접 리스트 만들기
        List<edge> [] adjArr = new LinkedList[N+1];
        for(int i=1; i<= N; i++){
            adjArr[i] = new LinkedList<>();
        }

        // 체크 배열
        boolean [] check = new boolean [N+1];

        // 레벨 배열
        int [] level = new int [N+1];
        for(int i=1; i<=N;i++){
            level[i] = Integer.MAX_VALUE;
        }
        

        // PQ 구성
        for(int i=0; i< M; i++){
            String [] ABC = br.readLine().split(" ");
            int st = Integer.parseInt(ABC[0]);
            int ed = Integer.parseInt(ABC[1]);
            int wgt = Integer.parseInt(ABC[2]);
            adjArr[st].add(new edge(st,ed,wgt));
            adjArr[ed].add(new edge(ed,st,wgt));
        }

        // 다익스트라 시작
        // 노드1 처리
        level[1] = 0;
        int curr = 1;
        // 반복문 시작
        for(int cnt = 0; cnt<N-1; cnt++){
        check[curr] = true;
        // 인접 탐색
        List<edge> adj = adjArr[curr];
        int size = adjArr[curr].size();
        for(int i=0; i<size;i++){
            int someNew = Math.max(level[adj.get(i).st],adj.get(i).wgt);
            int someOld = level[adj.get(i).ed];
            level[adj.get(i).ed] = Math.min(someOld,someNew);

            // 다음노드 선정
            int minIdx = Integer.MAX_VALUE;
            int minVal = Integer.MAX_VALUE;
            for(int nxt=1; nxt<=N; nxt++){
                if(!check[nxt] && level[nxt] < minVal){
                    minVal = level[nxt];
                    minIdx = nxt;
                }
            }
            curr = minIdx;
        }
        }

        int needed = level[N];
        // need보다 큰 최소 소수
        while(true){
            needed+=1;
            if(isPrime(needed)){
                break;
            }
        }

        // 출력
        System.out.println(needed);
        
    }

    public static boolean isPrime(long needed){
        boolean prime = true;
        if(needed <=1){
            prime = false;
        }else{
            for(int i=2; i*i<= needed;i++){
                if(needed % i == 0){
                    prime = false;
                    break;
                }
            }
        }
        return prime;

    }

}