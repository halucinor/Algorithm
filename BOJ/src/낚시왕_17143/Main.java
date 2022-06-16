package 낚시왕_17143;
/*
	Baekjoon Online Judge
	Problem : 낚시왕_17143
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-15
*/

import java.util.*;
import java.io.*;

public class Main {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    static class Shark{
        int r, c, s, d , z;

        Shark(int r, int c, int s, int d ,int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        //r c s d z
        ArrayList<Shark> SharkList = new ArrayList<>();
        for(int m = 0 ; m < M ; ++m){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r,c,s,d,z);
            SharkList.add(shark);
        }
        int size = 0;
        for(int pos = 1 ; pos <= C ; ++pos) {
            int minDeep = R + 2;//깊이 초기화
            Shark target = null;
            for (Shark shark : SharkList) {
                if (shark.c != pos) continue;
                if (shark.r < minDeep) {
                    target = shark;
                    minDeep = shark.r;
                }
            }
            if (target != null){
                size += target.z;
                SharkList.remove(target);
            }

            Shark[][] sea = new Shark[R+1][C+1];
            //move
            Iterator<Shark> iter = SharkList.iterator();

            ArrayList<Shark> RemoveList = new ArrayList<>();
            for(Shark shark : SharkList){
                int speed = shark.s;
                int dir = shark.d - 1; //0부터 시작

                int past_r = shark.r;
                int past_c = shark.c;

                while(speed > 0){
                    int nr = shark.r + dr[dir] * speed;
                    int nc = shark.c + dc[dir] * speed;

                    if(dir < 2){
                        if(nr <= R && nr > 0){
                            speed = 0;
                            shark.r = nr;
                            if(nr == 1)
                                shark.d = 2;
                            else if (nr == R)
                                shark.d = 1;
                            break;
                        }
                    }else{
                        if(nc <= C && nc > 0){
                            speed = 0;
                            shark.c = nc;
                            if(nc == 1)
                                shark.d = 3;
                            else if(nc == C)
                                shark.d = 4;
                            break;
                        }
                    }

                    //아래 이동
                    if(nr > R){
                        speed -= Math.abs(R - shark.r);
                        shark.r = R;
                        dir -= 1;
                    }else if(nr <= 0){//위로 이동
                        speed -= shark.r - 1;
                        shark.r = 1;
                        dir += 1;
                    }else if(nc > C){//우로 이동
                        speed -= Math.abs(C - shark.c);
                        shark.c = C;
                        dir += 1;
                    }else if(nc <= 0){//좌로 이동
                        speed -= shark.c - 1;
                        shark.c = 1;
                        dir -= 1;
                    }
                }
                shark.d = dir + 1;

                if(sea[shark.r][shark.c] != null){
                    //둘중 하나 잡아먹힘
                    Shark a = sea[shark.r][shark.c];
                    if(a.z > shark.r){
                        RemoveList.add(shark);
                    }else{
                        sea[shark.r][shark.c] = shark;
                        RemoveList.add(a);
                    }
                }else{
                    sea[shark.r][shark.c] = shark;
                }
            }

            for(Shark shark : RemoveList)
                SharkList.remove(shark);
        }
        System.out.println(size);
    }
}
