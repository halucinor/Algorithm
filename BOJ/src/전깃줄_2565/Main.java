package 전깃줄_2565;


/*
	Baekjoon Online Judge
	Problem : 전깃줄_2565
	Link : https://www.acmicpc.net/problem/2565
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-11
*/

import java.util.*;

public class Main {

    static int n;

    static int dp[], cost[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[n+1];
        cost = new int[n+1][2];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j)
                cost[i][j] = sc.nextInt();
        }

        Arrays.sort(cost,new Comparator<int[]>(){
                @Override
                public int compare ( int[] a, int[] b){
                if (a[0] < b[0]) return -1;
                else if (a[0] > b[0]) return 1;
                return 0;
            }
        });

        dp[1] = 1;

        for(int i = 2 ; i <= n ; ++i){
            dp[i] = 1;
            for(int j = 1 ; j < i ; ++j){
                if(cost[i][1] > cost[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int j = 1 ; j <= n ; ++j){
            if(dp[j] > max)
                max = dp[j];
        }

        System.out.println(n - max);
    }
}

