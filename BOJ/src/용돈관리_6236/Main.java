package 용돈관리_6236;
//https://www.acmicpc.net/problem/6236

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cost = new int[N];
        int total = 0;
        for(int i = 0 ; i < N ; ++i) {
            cost[i] = sc.nextInt();
            total += cost[i];
        }
        int min_money = 0;
        int max_money = total;

        int ans = 0;

        while(min_money <= max_money){
            int mid = (max_money + min_money) / 2;
            boolean res = withdrawal(cost, mid, M);

            if(res){ //인출 횟수가 적거나 같은경우
                ans = mid;
                max_money = mid - 1;
            }else{ //인출 횟수가 많은경우
                min_money = mid + 1;
            }
        }

        System.out.println(ans);

    }

    public static boolean withdrawal(int[] cost, int mid, int M){
        int cnt = 1;
        int sum = mid;

        for(int i = 0 ; i < cost.length; ++i){
            if(mid < cost[i]) return false;

            if(sum < cost[i]){
                sum =  mid;
                cnt++; //인출
            }
            sum -= cost[i];
        }
        return M >= cnt;
    }
}
