package 부분합_1806;
//https://www.acmicpc.net/problem/1806
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] array = new int[N+1];

        for(int i = 0 ; i < N ; ++i)
            array[i] = sc.nextInt();

        //첫번째가 가장 짧은 경우 계산
        if(array[0] >= S){
            System.out.println(1);
            return;
        }

        //init
        int left, right;
        left = 0;
        right = 1;
        int length = Integer.MAX_VALUE;
        int sum = array[0] + array[1];

        while(left <= right && right < N){
            if(sum >= S){
                length = Math.min(length,right - left + 1);
                sum-= array[left];
                left++;
            }else{
                right++;
                sum+= array[right];
            }
        }

        while(left < N){
            if(sum >= S)
                length = Math.min(length, right - left + 1);
            sum-= array[left];
            left++;
        }

        if(length != Integer.MAX_VALUE)
            System.out.println(length);
        else
            System.out.println(0);
    }
}
