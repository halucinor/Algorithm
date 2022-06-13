package 벽부수고이동하기_2206;
//https://www.acmicpc.net/problem/2206

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static class Path{
        int r;
        int c;
        int cnt;
        boolean block;
        Path(int r, int c, int cnt, boolean block){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.block = block;
        }
    }
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int r = 0 ; r < N ; ++r){
            String row = br.readLine();
            for(int c = 0 ; c < M ; ++c)
                map[r][c] = (int) row.charAt(c) - '0';
        }
        System.out.println(bfs(map));

    }

    public static int bfs(int[][] map){

        boolean[][][] isVisited = new boolean[N][M][2];

        Path start = new Path(0,0 , 1, false);

        Queue<Path> queue = new LinkedList<>();

        queue.add(start);
        isVisited[0][0][0] = true;
        while(!queue.isEmpty()){
            Path cur = queue.poll();
            if(cur.r == N-1 && cur.c == M-1)
                return cur.cnt;

            for(int i = 0 ; i < 4 ; ++i){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr >= N || nr < 0 || nc >= M || nc < 0 )
                    continue;

                if(map[nr][nc] == 0){
                    if(cur.block == false && !isVisited[nr][nc][0]){
                        queue.add(new Path(nr,nc, cur.cnt + 1, false));
                        isVisited[nr][nc][0] = true;
                    }
                    if(cur.block == true && !isVisited[nr][nc][1]){
                        queue.add(new Path(nr,nc, cur.cnt + 1, true));
                        isVisited[nr][nc][1] = true;
                    }

                }else{//벽인경우
                    if(cur.block == false) {
                        queue.add(new Path(nr, nc, cur.cnt + 1, true));
                        isVisited[nr][nc][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
