package 특정한최단경로_1504;
/*
	Baekjoon Online Judge
	Problem : 특정한최단경로_1504
	Link : https://www.acmicpc.net/problem/1504
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-17
*/

import java.util.*;
import java.io.*;

public class Main {
    static int INF = 200000000;

    static class Pair{
        int v;
        int w;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    static ArrayList<Pair>[] graph;
    static int N,E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Pair>();
        }

        for(int i = 0 ; i < E ; ++i){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new Pair(v,c));
            graph[v].add(new Pair(u,c));
        }
        int v1, v2;
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        // 1 -> v2 -> v1 -> N
        int p1 = getpath(1,v1);
        int p2 = getpath(1,v2);

        int p3 = getpath(v1,v2);
        int p4 = getpath(v2,v1);

        int p5 = getpath(v1,N);
        int p6 = getpath(v2,N);

        int p7 = p1 + p3 + p6;
        int p8 = p2 + p4 + p5;

        int res = Math.min(p7,p8);
        if(res >= INF)
            System.out.println(-1);
        else
            System.out.println(res);
    }

    public static int getpath(int u, int v) {
        int[] dist = new int[N + 1];

        for (int i = 1; i <= N; ++i)
            dist[i] = INF;

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> Integer.compare(p1.w,p2.w));

        pq.offer(new Pair(u,0));
        dist[u] = 0;

        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int current = node.v;
            int distance = node.w;

            if(dist[current] < distance) continue;

            for (Pair n_node: graph[current]) {
                int next = n_node.v;
                int n_dist = n_node.w;

                if(dist[next] > distance + n_dist){
                    dist[next] = distance + n_dist;
                    pq.offer(new Pair(next,dist[next]));
                }
            }
        }

        return dist[v];
    }

}
