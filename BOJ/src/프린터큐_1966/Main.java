package 프린터큐_1966;
/*
	Baekjoon Online Judge
	Problem : 프린터큐_1966
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-04
*/

import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int idx;
        int priority;
        Pair(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int t = 0 ; t < T ; ++t){
            int N = sc.nextInt();
            int M = sc.nextInt();

            Deque<Pair> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for(int i = 0 ; i < N ; ++i){
                int p = sc.nextInt();
                queue.add(new Pair(i, p));
                pq.add(p);
            }
            int order = 0;
            while (!queue.isEmpty()){
                Pair pair = queue.pollFirst();
                if(pair.priority >= pq.peek()){
                    order++;
                    pq.poll();
                    if(pair.idx == M){
                        sb.append(order + "\n");
                        break;
                    }
                }else
                    queue.addLast(pair);
            }
        }
        System.out.println(sb);
    }
}
