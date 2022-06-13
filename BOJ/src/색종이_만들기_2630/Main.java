package 색종이_만들기_2630;
//https://www.acmicpc.net/problem/2630

import java.util.*;

public class Main {
    static int blue = 0;
    static int white = 0;

    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        map = new int[N][N];

        for(int r = 0 ; r < N ; ++r)
            for(int c = 0 ; c < N ; ++c)
                map[r][c] = sc.nextInt();
        int r_s,c_s, r_e,c_e;
        r_s = c_s = 0;
        r_e = c_e = N;

        findPaper(r_s,r_e,c_s,c_e);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void findPaper(int r_s,int r_e,int c_s, int c_e){
        if(colorCheck(r_s, r_e, c_s, c_e))
            return;

        int r_m = (r_s + r_e)/2;
        int c_m = (c_s + c_e)/2;

        if(r_m == r_e || c_m == c_e) return;

        findPaper(r_s, r_m, c_s, c_m);//1사분변
        findPaper(r_s, r_m, c_m, c_e);//2사분변
        findPaper(r_m, r_e, c_s, c_m);//3사분변
        findPaper(r_m, r_e, c_m, c_e);//4사분변
    }

    public static boolean colorCheck(int r_s,int r_e,int c_s, int c_e){
        int initColor = map[r_s][c_s];
        for(int r = r_s; r < r_e;++r){
            for(int c = c_s; c < c_e; ++c){
                if (map[r][c] != initColor) return false;
            }
        }

        if(initColor == 0)
            white++;
        else
            blue++;

        return true;
    }
}
