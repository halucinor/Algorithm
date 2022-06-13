//https://www.acmicpc.net/problem/4485
package 녹색옷젤다_4485;

import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static class Tuple{
        int r;
        int c;
        int v;
        Tuple(int r, int c, int v){
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 0;
        while(true){
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;
            tc++;
            int[][] cave = new int[N][N];
            int[][] dist = new int[N][N];
            for(int i = 0 ; i < N ; ++i) {
                cave[i] = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

                Arrays.fill(dist[i],Integer.MAX_VALUE);
            }

            PriorityQueue<Tuple> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.v,o2.v));
            pq.offer(new Tuple(0,0,cave[0][0]));
            dist[0][0] = cave[0][0];

            while(!pq.isEmpty()){
                Tuple current = pq.poll();
                if(dist[current.r][current.c] < current.v) continue;

                for(int i = 0 ; i < 4; ++i){
                    int nr = current.r + dr[i];
                    int nc = current.c + dc[i];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    int nextDist = dist[current.r][current.c] + cave[nr][nc];
                    if(dist[nr][nc] > nextDist){
                        dist[nr][nc] = nextDist;
                        pq.offer(new Tuple(nr,nc,nextDist));
                    }
                }
            }

            System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);
        }
    }
}
