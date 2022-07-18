package 토마토_7569;
/*
	Baekjoon Online Judge
	Problem : 토마토_7569
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022/07/18
*/

import java.util.*;
import java.io.*;

public class Main {
    static int N, M, H;

    static class POS{
        int r;
        int c;
        int h;

        int day;
        POS(int r, int c, int h, int day){
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }

    static int[] dr = {-1,0,1,0,0,0};
    static int[] dc = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        H = Integer.parseInt(stk.nextToken());

        int [][][] tomatos = new int[N][M][H]; //r c h
        boolean [][][] isVisited = new boolean[N][M][H];

        Queue<POS> queue = new LinkedList<>();

        for(int h = 0 ; h < H; ++h){
            for(int n = 0 ; n < N ; ++n){
                stk = new StringTokenizer(br.readLine());
                for(int m = 0 ; m < M ; ++m){
                    tomatos[n][m][h] = Integer.parseInt(stk.nextToken());
                    if(tomatos[n][m][h] == 1){
                        queue.add(new POS(n,m,h , 1));
                        isVisited[n][m][h] = true;
                    }
                }
            }
        }

        int maxDays = -1;
        while(!queue.isEmpty()){
            POS pos = queue.poll();
            maxDays = Math.max(maxDays, pos.day);
            for(int i = 0 ; i < 6 ; ++i){
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];
                int nh = pos.h + dh[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H || isVisited[nr][nc][nh])
                    continue;

                if(tomatos[nr][nc][nh] == 0) {
                    queue.add(new POS(nr, nc, nh, pos.day + 1));
                    tomatos[nr][nc][nh] = pos.day + 1;
                    isVisited[nr][nc][nh] = true;
                }
            }
        }

        boolean isComplete = true;
        for(int h = 0 ; h < H; ++h){
            for(int n = 0 ; n < N ; ++n){
                for(int m = 0 ; m < M ; ++m){
                    if(tomatos[n][m][h] == 0){
                        isComplete = false;
                        break;
                    }
                }
            }
        }

        if(!isComplete)
            System.out.println(-1);
        else
            System.out.println(maxDays - 1);
    }
}