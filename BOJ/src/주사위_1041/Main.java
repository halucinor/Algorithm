package 주사위_1041;
/*
	Baekjoon Online Judge
	Problem : 주사위_1041
	Link : https://www.acmicpc.net/problem/1041
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-22
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();

        int[] dice = new int[6];

        for(int i = 0 ; i < 6 ; ++i)
            dice[i] = sc.nextInt();

        if(N == 1){
            int _max = -1;
            int _sum = 0;
            for(int i = 0 ; i < 6 ; ++i){
                _sum += dice[i];
                _max = Math.max(_max, dice[i]);
            }
            System.out.println(_sum - _max);
            return;
        }

        int[] min_value = new int[3];
        long[] sum = new long[3];
        min_value[0] = Math.min(dice[0],dice[5]);
        min_value[1] = Math.min(dice[1],dice[4]);
        min_value[2] = Math.min(dice[2],dice[3]);

        Arrays.sort(min_value);

        sum[0] = min_value[0];
        sum[1] = min_value[0] + min_value[1];
        sum[2] = min_value[0] + min_value[1] + min_value[2];

        long n1, n2, n3;

        n1 = (N-2) * (N-2) + 4 * (N-1) * (N-2);
        n2 = 4 * (N-2) + 4 * (N-1);
        n3 = 4;

        System.out.println(sum[0] * n1 + sum[1] *  n2 + sum[2] * n3);
    }
}
