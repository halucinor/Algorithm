package 지하철_17940;
/*
	Baekjoon Online Judge
	Problem : 지하철_17940
	Link : https://www.acmicpc.net/problem/17940
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-06
*/

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int INF = 987654321;
    static int PENALITY = (int) 10e7;

    static class Pair{
        int n;
        int c;

        Pair(int n, int c){
            this.n = n;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int[] companies = new int[N];
        int[][] map = new int[N][N];
        int[] dist = new int[N];

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        Arrays.fill(dist, INF);

        for(int i = 0 ; i < N ; ++i) {
            companies[i] = sc.nextInt();
            graph.add(new ArrayList<Pair>());
        }
        for(int i = 0 ; i < N ; ++i) {
            for(int j = 0 ; j < N ; ++j)
                map[i][j] = sc.nextInt();
        }
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0; j < N ; ++j){
                if(i == j || map[i][j] == 0) continue;

                if(companies[i] != companies[j])
                    graph.get(i).add(new Pair(j, map[i][j] + PENALITY));
                else
                    graph.get(i).add(new Pair(j, map[i][j]));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.c,p2.c));

        pq.offer(new Pair(0,0));
        dist[0] = 0;

        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int cur = node.n;
            int distance = node.c;

            if(dist[cur] < distance) continue;

            for(Pair n_node : graph.get(cur)){
                int next = n_node.n;
                int n_dist = n_node.c;

                if(dist[next] > distance + n_dist){
                    dist[next] = distance + n_dist;
                    pq.offer(new Pair(next,dist[next]));
                }
            }
        }

        int transfer = dist[M] / PENALITY;
        int distance = dist[M] % PENALITY;

        System.out.println(transfer + " " + distance);

    }
}
