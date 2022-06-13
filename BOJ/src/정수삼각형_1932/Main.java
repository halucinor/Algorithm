package 정수삼각형_1932;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[][] dp = new Integer[N][N];

        for(int i = 0 ; i < N ; ++i)
            for(int j = 0 ; j <= i; ++j)
                dp[N-1-i][j] = sc.nextInt();

        for(int i = 0 ; i < N-1 ; ++i)
            for(int j = 0 ; j < N-1-i ; ++j)
                dp[i+1][j] = dp[i+1][j] + Math.max(dp[i][j], dp[i][j+1]);

        System.out.println(dp[N-1][0]);
    }
}
