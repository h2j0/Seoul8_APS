package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_지우는소수를좋아해
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

    public static int [] p;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // PQ만들기
        PriorityQueue<edge> pq = new PriorityQueue<>();

        // PQ 구성
        for(int i=0; i< M; i++){
            String [] ABC = br.readLine().split(" ");
            int st = Integer.parseInt(ABC[0]);
            int ed = Integer.parseInt(ABC[1]);
            int wgt = Integer.parseInt(ABC[2]);
            pq.add(new edge(st,ed,wgt));
        }
        // 부모 배열, 초기값은 본인
        p = new int[N+1];
        for(int i=1; i<=N; i++){
            p[i] = i;
        }

        int needed = -1;
        // union 시작
        while(true){
            edge curr = pq.poll();
            union(curr.st, curr.ed);
            if(findset(N)==1){
                needed = curr.wgt;
                break;
            }
        }
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

    public static boolean isPrime(int needed){
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

    // 더 작은 조상을 가진 친구에 다른 친구를 연결한다.(작은 조상 친구가 부모가 된다.)
    public static void union(int a, int b){
        int kingA = findset(a);
        int kingB = findset(b);
        if(kingA<kingB){
            p[b] =a;
        }else if(kingA>kingB){
            p[a] = b;
        }
        // 같은 경우 어케 하지ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
    }

    public static int findset(int x){
        if(x!=p[x]){
            return findset(p[x]);
        }else{
            return p[x];
        }
        
    }
}