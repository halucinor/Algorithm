package 낚시왕_17143;


import java.io.*;
import java.util.*;

public class Main2 {

    static int[] dr = {1,0,-1,0}; //아래 왼쪽 위 오른쪽
    static int[] dc = {0,-1,0,1};
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

    static Shark[][] sea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        //r c s d z
        ArrayList<Shark> sharkList = new ArrayList<>();

        sea = new Shark[R+1][C+1];

        for(int m = 0 ; m < M ; ++m){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            // 1 -> 2, 2 -> 0, 3 -> 3, 4 -> 1
            if(d == 1) d = 2;
            else if(d == 2) d = 0;
            else if(d == 4) d = 1;

            Shark shark = new Shark(r,c,s,d,z);

            sharkList.add(shark);
            sea[shark.r][shark.c] = shark;
        }
        int catchSize = 0;

        for(int pos = 1 ; pos <= C ; ++pos){
            for(int r = 1; r <= R ; ++r){
                if(sea[r][pos] != null){
                    Shark shark = sea[r][pos];
                    sea[r][pos] = null;

                    catchSize += shark.z;
                    sharkList.remove(shark);
                    break;
                }
            }

            for(Shark shark : sharkList){
                int speed = shark.s;
                int dir = shark.d;

                if(dir == 0 || dir == 2){//상하이동
                    speed = speed % ((R - 1) * 2);

                    while(speed > 0){
                       if(shark.r == 1)
                           dir = 0;

                       if(shark.r == R)
                           dir = 2;

                       shark.r += dr[dir];
                       speed--;
                    }

                }else{
                    speed = speed % ((C - 1) * 2);

                    while(speed > 0){
                        if(shark.c == 1)
                            dir = 3;

                        if(shark.c == C)
                            dir = 1;

                        shark.c += dc[dir];
                        speed--;
                    }
                }
                shark.d = dir;
            }

            sea = new Shark[R+1][C+1];
            for(int i = sharkList.size() - 1 ; i >= 0 ; --i){
                Shark shark = sharkList.get(i);

                if(sea[shark.r][shark.c] != null){
                    if(shark.z < sea[shark.r][shark.c].z){
                        sharkList.remove(shark);
                    }else{
                        sharkList.remove(sea[shark.r][shark.c]);
                        sea[shark.r][shark.c] = shark;
                    }
                }else
                    sea[shark.r][shark.c] = shark;
            }

        }

        System.out.println(catchSize);

    }
}
