package 웜홀_1865;

import java.io.*;
import java.util.*;

public class Main {

    public static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static public int N, M ,W;

    static public ArrayList<Node>[] graph;

    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < TC ; ++t){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            W = Integer.parseInt(stk.nextToken());


            graph = new ArrayList[N+1];
            for(int i = 1 ; i <= N ; ++i)
                graph[i] = new ArrayList<>();


            for(int i = 0 ; i < M + W ; ++i){
                stk = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(stk.nextToken());
                int e = Integer.parseInt(stk.nextToken());
                int weight = Integer.parseInt(stk.nextToken());


                if(i < M){
                    graph[s].add(new Node(e, weight));
                    graph[e].add(new Node(s,weight));
                }else
                    graph[s].add(new Node(e, -weight));
            }

            boolean negativeCycle = bellman_ford();

            if(negativeCycle) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }

    public static boolean bellman_ford(){

        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        boolean update = false;
        for(int i = 1; i <= N; ++i){
            update = false;
            for(int n = 1 ; n <= N ; ++n){
                for(Node node : graph[n]){
                    int cur = n;
                    int next = node.end;

                    if(dist[cur] == INF) continue;

                    if(dist[next] > dist[cur] + node.weight){
                        dist[next] = dist[cur] + node.weight;
                        update= true;
                        if(i == N) return true;
                    }
                }
            }
            if(!update)
                break;
        }
        return update;
    }
}
