package 수정렬하기2_2751;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = sc.nextInt();

        for(int i = 0 ; i < N ; ++i)
            pq.offer(sc.nextInt());

        for(int i = 0 ; i < N ; ++i)
            sb.append(pq.poll() + "\n");

        System.out.println(sb);
    }
}
