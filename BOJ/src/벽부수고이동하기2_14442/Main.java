package 벽부수고이동하기2_14442;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;

    static class Pair{
        int r, c, cnt, breakCnt;
        Pair(int r, int c, int cnt, int breakCnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.breakCnt = breakCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int r = 0; r < N ; ++r) {
            String row = br.readLine();
            for(int c = 0 ; c < M ; ++c)
                map[r][c] = (int) row.charAt(c) - '0';
        }

        System.out.println(bfs(map));
    }
    public static int bfs(int[][] map){

        Queue<Pair> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[N][M][K+1];

        int dr[] = {1,0,-1,0};
        int dc[] = {0,1,0,-1};

        queue.add(new Pair(0,0,1,0));
        isVisited[0][0][0] = true;

        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            if(cur.r == N-1 && cur.c == M-1)
                return cur.cnt;

            for(int i = 0; i < 4 ; ++i){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int nCnt = cur.cnt + 1;

                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if(map[nr][nc] == 0){
                    if(!isVisited[nr][nc][cur.breakCnt]) {
                        queue.add(new Pair(nr,nc,nCnt, cur.breakCnt));
                        isVisited[nr][nc][cur.breakCnt] = true;
                    }
                }else{
                    if(cur.breakCnt < K) {
                        if (!isVisited[nr][nc][cur.breakCnt+1]){
                            queue.add(new Pair(nr,nc,nCnt,cur.breakCnt + 1));
                            isVisited[nr][nc][cur.breakCnt+1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
