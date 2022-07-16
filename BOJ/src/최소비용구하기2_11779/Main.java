package 최소비용구하기2_11779;
/*
	Baekjoon Online Judge
	Problem : 최소비용구하기2_11779
	Link : https://www.acmicpc.net/problem/11779
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-16
*/

import java.util.*;
import java.io.*;

public class Main {

    static int INF = 987654321;
    static class Node{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stk.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (n1,n2) -> Integer.compare(n2.cost, n1.cost)
        );

        int[] dist = new int[n+1];
        int[] route = new int[n+1];

        Arrays.fill(dist, INF);

        for(int i = 0 ; i <= n ; ++i)
            graph[i] = new ArrayList<>();

        for(int i = 0 ; i <= n ; ++i)
            route[i] = i;


        for(int i = 0 ; i < m ; ++i){
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            graph[s].add(new Node(e,cost));

        }

        //dijkstra
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        dist[start] = 0;
        route[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur_node = pq.poll();
            int cur = cur_node.idx;
            int cost = cur_node.cost;

            if(dist[cur] < cost)
                continue;

            for(Node next_node : graph[cur]){
                int next = next_node.idx;
                int n_cost = next_node.cost;
                if(dist[cur] + n_cost < dist[next]){
                    dist[next] = dist[cur] + n_cost;
                    pq.add(new Node(next, dist[next]));

                    route[next] = cur;
                }
            }
        }
        //최소비용 출력
        System.out.println(dist[end]);

        //도시개수 출력
        int current = end;
        ArrayList<Integer> path = new ArrayList<>();

        while(current != 0){
            path.add(current);
            current = route[current];
        }

        System.out.println(path.size());

        for(int i = path.size() - 1 ; i >= 0 ; --i)
            System.out.print(path.get(i) + " ");

    }
}
