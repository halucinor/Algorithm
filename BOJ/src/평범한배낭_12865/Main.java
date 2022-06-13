package 평범한배낭_12865;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int N, K;
        int[] W, V;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        W = new int[N+1];
        V = new int[N+1];

        for(int i = 1 ; i <= N ; ++i){
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][K+1];//dp[가방 크기][물건의 개수]

        for(int i = 1; i <=N ;++i){
            for(int j = 1; j <= K; ++j) {
                if(j >= W[i])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);

    }
}
