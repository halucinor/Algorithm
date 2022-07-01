package 치즈_2638;
/*
	Baekjoon Online Judge
	Problem : 치즈_2638
	Link : https://www.acmicpc.net/problem/2638
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-01
*/

import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static Queue<Pair> queue;
    static int[][] map;
    static boolean[][] isOut;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        isOut = new boolean[N][M];

        queue = new LinkedList<>();

        for(int r = 0 ; r < N ; ++r){
            stk = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; ++c)
                map[r][c] = Integer.parseInt(stk.nextToken());
        }

        int time = 0;

        queue.add(new Pair(0,0));
        isOut[0][0] = true;
        while(true){
            setInOut();

            time++;
            meltcheese();

            if(mapcheck())
                break;
        }
        System.out.println(time);
    }
    public static void setInOut(){

        while(!queue.isEmpty()){
            Pair cur = queue.poll();

            for(int i = 0 ; i < 4; ++i){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if(map[nr][nc] == 0 && !isOut[nr][nc]){
                    isOut[nr][nc] = true;
                    queue.add(new Pair(nr,nc));
                }
            }
        }
    }

    public static void meltcheese(){
        Queue<Pair> meltQueue = new LinkedList<>();
        for(int r = 0 ; r < N ; ++r){
            for(int c = 0 ; c < M ; ++c) {
                if(map[r][c] == 1){
                    int outCnt = 0;
                    for(int i = 0 ; i < 4; ++i){
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                            continue;

                        if(isOut[nr][nc]) outCnt++;
                    }
                    if(outCnt >= 2)
                        meltQueue.add(new Pair(r,c));
                }
            }
        }

        while(!meltQueue.isEmpty()){
            Pair pos = meltQueue.poll();

            map[pos.r][pos.c] = 0;
            isOut[pos.r][pos.c] = true;
            queue.add(pos);
        }

    }

    public static boolean mapcheck(){
        for(int r = 0 ; r < N ; ++r)
            for(int c = 0 ; c < M ; ++c)
                if(map[r][c] == 1)
                    return false;
        return true;
    }
}
