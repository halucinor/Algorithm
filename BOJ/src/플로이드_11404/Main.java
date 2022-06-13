package 플로이드_11404;
//https://www.acmicpc.net/problem/11404

import java.io.*;
import java.util.*;

public class Main {
    static int INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        INF = 1000000000;

        int[][] dist = new int[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for(int i = 0 ; i < M; ++i){
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int fr = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            dist[fr][to] = Math.min(dist[fr][to], cost);
        }

        for(int k = 1; k < N + 1 ; ++k){
            for(int i = 1 ; i < N + 1; ++i){
                for(int j = 1; j < N + 1 ; ++j){
//                    if(k == i || k == j) continue;
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for(int i = 1 ; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j){
                if(dist[i][j] >= INF)
                    dist[i][j] = 0;
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
