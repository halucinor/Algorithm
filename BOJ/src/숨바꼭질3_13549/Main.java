package 숨바꼭질3_13549;
/*
	Baekjoon Online Judge
	Problem : 숨바꼭질3_13549
	Link : https://www.acmicpc.net/problem/13549
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-12
*/

import java.util.*;
import java.io.*;

public class Main {

    public static class Node {
    int x;
    int time;

    public Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2) -> Integer.compare(n1.time,n2.time));

        pq.offer(new Node(N,0));

        boolean[] visited = new boolean[100001];
        int min_ = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node pos = pq.poll();
            visited[pos.x] = true;
            if(pos.x == K)
                min_ = Math.min(pos.time,min_);

            if(pos.x * 2 <= 100000 && !visited[pos.x * 2]) pq.offer(new Node(pos.x * 2, pos.time));
            if(pos.x + 1 <= 100000 && !visited[pos.x + 1]) pq.offer(new Node(pos.x + 1, pos.time + 1));
            if(pos.x - 1  >= 0 && !visited[pos.x - 1]) pq.offer(new Node(pos.x - 1, pos.time + 1));
        }

        System.out.println(min_);
    }
}
