//https://www.acmicpc.net/problem/1753

package 최단경로_1753;

import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int v;
        int w;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
        //Scanner sc = new Scanner(System.in);

        String[] str =  br.readLine().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);
        int K = Integer.parseInt(br.readLine());

        boolean[] isVisited = new boolean[V+1];

        ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);

            graph.get(u).add(new Pair(v,w));// 방향 그래프
        }

        int[] dist = new int[V+1];

        for(int i = 0 ; i < V + 1 ; ++i)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.w,p2.w));

        pq.offer(new Pair(K,0));
        dist[K] = 0;

        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int current = node.v;
            int distance = node.w;

            if(dist[current] < distance) continue;

            for (Pair n_node: graph.get(current)) {
                int next = n_node.v;
                int n_dist = n_node.w;

                if(dist[next] > distance + n_dist){
                    dist[next] = distance + n_dist;
                    pq.offer(new Pair(next,dist[next]));
                }
            }
        }

        for(int i = 1 ; i < V+1; ++i){
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

}

