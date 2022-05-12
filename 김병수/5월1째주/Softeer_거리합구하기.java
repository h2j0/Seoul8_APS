package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_거리합구하기
{

    public static class edge{
        public int st;
        public int ed;
        public int wgt;

        public edge(int st,int ed,int wgt){
            this.st = st;
            this.ed = ed;
            this.wgt = wgt;
        }

        public String toString(){
            return "(st = "+st+", ed = "+ed+", wgt = "+wgt+")";
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 인접 리스트
        // idx1부터 쓰는 것 주의하자.
        List<edge> [] adjList = new LinkedList[N+1];
        for(int i=1; i<=N; i++){
            adjList[i] = new LinkedList<>();
        }
        // 간선 정보 받아서 인접 리스트 구성
        for(int i=0; i<N-1;i++){
            String [] edgeInfo = br.readLine().split(" ");
            int st = Integer.parseInt(edgeInfo[0]);
            int ed = Integer.parseInt(edgeInfo[1]);
            int wgt = Integer.parseInt(edgeInfo[2]);
            adjList[st].add(new edge(st,ed,wgt));
            adjList[ed].add(new edge(ed,st,wgt));
        }

        // 기준 노드
        for(int core = 1; core<=N; core++){

        // 기준노드에서 각 노드로 가는 최소 거리
        int [] arr = new int [N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.MAX_VALUE;
        }
        boolean [] check = new boolean [N+1];
        arr[core] = 0;
        int curr = core;

        // 다익스트라
        for(int cnt = 0; cnt < N-1; cnt++){
            check[curr] = true;
            // 인접 노드 정보로 arr 업데이트
            int size = adjList[curr].size();
            for(int i=0; i<size; i++){
                if(arr[curr]+adjList[curr].get(i).wgt < arr[adjList[curr].get(i).ed]){
                    arr[adjList[curr].get(i).ed] = arr[curr]+adjList[curr].get(i).wgt;
                }
            }
            // 다음 노드 정하기
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++){
                if(!check[i] && arr[i] < minVal){
                    minIdx = i;
                    minVal = arr[i];
                }
            }
            curr = minIdx;
        }

        // 거리합 구하기, 본인은 어차피 0이니 그냥 본인도 더해도 됨.
        int sumVal = 0;
        for(int i=1; i<= N; i++){
            sumVal+= arr[i];
        }
        bw.write(sumVal+"\n");
        }

        bw.flush();

    }
}