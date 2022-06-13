package 최소비용구하기_1916;

import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int n;
        int cost;

        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dist = new int[N+1];
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

        for(int i = 0 ; i < N+1 ; ++i) {
            graph.add(new ArrayList<Node>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i < M; ++i){
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int fr = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());

            graph.get(fr).add(new Node(to,cost));
        }

        String[] line = br.readLine().split(" ");

        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        //min heap
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));

        //set first
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()){
            Node c = pq.poll();
            int current = c.n;
            int c_dist = c.cost;

            if(dist[current] < c_dist) continue;

            for(Node n : graph.get(current)){
                int next = n.n;
                int n_dist = n.cost;

                if(dist[current] + n_dist < dist[next]) {
                    dist[next] = dist[current] + n_dist;
                    pq.offer(new Node(next, dist[next]));
                }
            }

        }
        System.out.println(dist[end]);
    }
}
