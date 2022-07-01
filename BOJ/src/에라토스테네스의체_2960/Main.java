package 에라토스테네스의체_2960;
/*
	Baekjoon Online Judge
	Problem : 에라토스테네스의체_2960
	Link : https://www.acmicpc.net/problem/2960
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-30
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        int Prime = 0;
        int cnt = 0;
        int num = -1;
        while(true) {
            for (int i = 2; i <= N; ++i) {
                if (isPrime[i] == true) {
                    Prime = i;
                    break;
                }
            }

            for(int i = 2 ; i <= N ; ++i){
                if(!isPrime[i]) continue;
                else if(isPrime[i] && i % Prime == 0){
                    isPrime[i] = false;
                    cnt++;
                    if(cnt == K){
                        num = i;
                        break;
                    }
                }
            }
            if(cnt == K) break;
        }
        System.out.println(num);
    }
}
