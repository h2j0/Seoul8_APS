package com.ssafy.boj.y22.m05.w1;
import java.util.*;
import java.io.*;


public class Softeer_거리합구하기_DFS
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

    public static int [] subTree;
    public static int [] D;
    public static boolean [] check;
    public static List<edge> [] adjList;
    public static int N;
    public static int [] sigma;

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        // 인접 리스트
        // idx1부터 쓰는 것 주의하자.
        adjList = new LinkedList[N+1];
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

        // 서브트리크기(본인+총 자손)
        subTree = new int[N+1];
        // D(1,j)
        D = new int[N+1];
        // 체크 배열
        check = new boolean[N+1];
        sigma =new int[N+1];


        // DFS하기-노드 1 출발일때 정보 얻기
        DFS_A(1,0);
        // 노드 1 출발일때의 Sigma 구하기
        for(int i=2; i<=N; i++){
            sigma[1] += D[i];
        }

        //  노드를 옮겨 다니면서 Sigma 계산 - 노드 1 출발일때의 Sigma를 활용
        DFS_B(1);

        for(int i=1; i<=N;i++){
        System.out.println(sigma[i]);
        }

    }
    // 부모값으로 자식값을 계산
    public static void DFS_B(int node){
        check[node] = true;

        // 인접 탐색
        List<edge> adj = adjList[node];
        int size = adjList[node].size();
        for(int i =0; i<size;i++){
            if(!check[adj.get(i).ed]){
                int target = adj.get(i).ed;
                int connect = adj.get(i).wgt;
                sigma[target] = sigma[node]+(N-subTree[target]) * connect - subTree[target] * connect;
                DFS_B(target);
            }
        }

        check[node] = false;
    }

    //해당 노드를 출발로 한 경로 배열 D를 구한다.
     public static int DFS_A(int node, int sum){
        check[node] = true;
        subTree[node]++;
        D[node] = sum;

        // 인접 탐색
        List<edge> adj = adjList[node];
        int size = adjList[node].size();
        for(int i =0; i<size;i++){
            if(!check[adj.get(i).ed]){
                subTree[node]+=DFS_A(adj.get(i).ed,sum+adj.get(i).wgt);
            }
        }

        check[node] = false;
        return subTree[node];
     }
}