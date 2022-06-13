package 입국심사;
//https://programmers.co.kr/learn/courses/30/lessons/43238?language=java
import java.util.*;
import java.io.*;
class Solution {

    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) (10E8 * 10E8);

        while(left < right){
            long mid = (right + left) / 2;
            long cnt = 0;
            for(int time : times)
                cnt+= mid/time;

            if(cnt >= n){
                right = mid -1;
            }else{
                left = mid + 1;
            }

        }
        return answer = left;
    }
}
