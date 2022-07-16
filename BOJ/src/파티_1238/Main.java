package 파티_1238;
/*
	Baekjoon Online Judge
	Problem : 파티_1238
	Link : https://www.acmicpc.net/problem/1238
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-09
*/

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int INF = 987654321;

    static int N,M,X;
    static class Node{
        int idx;
        int dist;

        Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        X = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node>> reverse = new ArrayList<>();

        for(int i = 0; i <= N ; ++i) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; ++i){
            stk = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());

            graph.get(s).add(new Node(e,t));
            reverse.get(e).add(new Node(s,t));
        }

        int [] dist = new int[N+1];
        int [] reverse_dist = new int[N+1];

        Arrays.fill(dist,INF);
        Arrays.fill(reverse_dist,INF);

        dijkstra(dist, graph, X);
        dijkstra(reverse_dist, reverse, X);
        int max_time = -1;
        for(int i = 1 ; i <= N ; ++i)
            max_time = Math.max(max_time,dist[i] + reverse_dist[i]);

        System.out.println(max_time);

    }
    public static void dijkstra(int[] dist, ArrayList<ArrayList<Node>> graph, int start){

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist,o2.dist));

        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int index = current.idx;
            int distance = current.dist;

            //업데이트 여부 확인
            if(dist[index] < distance)
                continue;

            for(Node node : graph.get(index)){
                int next = node.idx;
                int n_dist = node.dist;

                if(dist[next] > distance + n_dist){
                    dist[next] = distance + n_dist;
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }

    }
}
