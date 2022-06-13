package LCS_9251;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        int [][] dp = new int[b.length()+1] [a.length()+1];

        for(int r = 1; r < b.length()+1 ; ++r){
            for(int c = 1; c < a.length()+1 ; ++c){

                if(b.charAt(r-1) != a.charAt(c-1)){
                    dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]);
                }else{
                    dp[r][c] = dp[r-1][c-1] + 1;
                }
            }
        }

        System.out.println(dp[b.length()][a.length()]);
    }
}
