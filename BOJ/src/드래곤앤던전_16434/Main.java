package 드래곤앤던전_16434;

//https://www.acmicpc.net/problem/16434

import jdk.jfr.Unsigned;

import java.io.*;
import java.util.*;

public class Main {
    static int N, h_atk;
    static int t[];
    static int a[];
    static int h[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        h_atk = Integer.parseInt(stk.nextToken());

        t = new int[N];
        a = new int[N];
        h = new int[N];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(stk.nextToken());
            a[i] = Integer.parseInt(stk.nextToken());
            h[i] = Integer.parseInt(stk.nextToken());
        }

        long lo = 0;
        long hi = ((long)2 << 62) - 1;

        while(lo <= hi){
            long hp_mid = (hi + lo) / 2;

            if(!challenge(hp_mid)){
                lo = hp_mid+1;
            }else{
                hi = hp_mid-1;
            }
        }
        System.out.println(lo);
    }

    public static boolean challenge(long hp){
        long atk = h_atk;
        long curHP = hp;
        for (int i = 0; i < N; i++) {
            if(t[i] == 1){

                if(h[i] % atk == 0)
                    curHP -= (long) ((h[i] / atk) -1) * a[i];
                else
                    curHP -= (long) (h[i] / atk) * a[i];

                if(curHP <= 0) return false;

            }else{
                // t == 2
                atk += a[i];
                curHP += h[i];
                curHP = Math.min(curHP, hp);
            }
        }
        return true;
    }
}
