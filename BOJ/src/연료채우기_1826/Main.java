package 연료채우기_1826;
/*
	Baekjoon Online Judge
	Problem : 연료채우기_1826
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-26
*/

import java.util.*;
import java.io.*;

public class Main {
    static class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {

        PriorityQueue<Pair> station_q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.a,o2.a);
            }
        });

        Scanner sc = new Scanner(System.in);

        int N, L, P;
        N = sc.nextInt();

        for(int i = 0 ; i < N ; ++i) {
            Pair station = new Pair(sc.nextInt(), sc.nextInt());
            station_q.offer(station);
        }

        L = sc.nextInt();
        P = sc.nextInt();

        PriorityQueue<Integer> fuels = new PriorityQueue<>(Comparator.reverseOrder());
        int cnt = 0;

        while(P < L){
            while(!station_q.isEmpty() && P >= station_q.peek().a)
                fuels.add(station_q.poll().b);

            if(fuels.isEmpty()){
                System.out.println(-1);
                return;
            }

            P += fuels.poll();
            cnt++;
        }
        System.out.println(cnt);


    }
}
