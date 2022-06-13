package 최대힙_11279;
//https://www.acmicpc.net/problem/11279
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

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
