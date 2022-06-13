package 최소힙_1927;

//https://www.acmicpc.net/problem/1927
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < N ; ++i){
            int val = sc.nextInt();
            if(val == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll() + "\n");
                }else
                    sb.append(0 + "\n");
            }else
                pq.add(val);
        }
        System.out.println(sb);
    }
}
