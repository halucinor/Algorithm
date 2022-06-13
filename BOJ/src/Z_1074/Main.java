package Z_1074;

import java.io.*;

public class Main {

    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        int size = (int)Math.pow(2,N);
        count(size, r , c);
        System.out.println(cnt);
    }

    public static void count(int size, int r, int c){
        if(size == 1) return;

        int l = size / 2;
        if(r < l && c >= l) {// 2사분면
            c = c - l;
            cnt += l * l;
        }else if(r >= l && c < l){ // 3사분면
            r = r - l;
            cnt += 2 * (l * l);
        }else if(r >= l && c >= l){
            c = c - l;
            r = r - l;
            cnt += 3 * (l * l);
        }
        count(l, r, c);
    }
}
//
//    public static void drow(int rs, int re, int cs, int ce){
//        //열시작, 열끝, 행시작, 행 끝
//
//        int rm = (rs + re) / 2;
//        int cm = (cs + ce) / 2;
//
//        if(rs == rm && cs == cm){
//            if(rs == r && cs == c){
//                ans = cnt;
//            }
//            cnt++;
//            return;
//        }
//
//        drow(rs, rm, cs, cm); //좌상
//        if(ans != -1) return;
//        drow(rs, rm, cm, ce); //우상
//        if(ans != -1) return;
//        drow(rm, re, cs, cm); //좌하
//        if(ans != -1) return;
//        drow(rm, re, cm, ce);//우하
//        if(ans != -1) return;
//    }
//}
