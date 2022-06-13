package 좌표압축_18870;
//https://www.acmicpc.net/problem/18870
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        int[] cord = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < N; ++i){
            cord[i] = sc.nextInt();
            sorted[i] = cord[i];
        }

        HashMap<Integer,Integer> newOrder = new HashMap<>();

        Arrays.sort(sorted);
        int order = 0;
        for (int i = 0; i < N; i++) {
            if(!newOrder.containsKey(sorted[i])){
                newOrder.put(sorted[i],order);
                order++;
            }
        }

        for(int num : cord)
            sb.append(newOrder.get(num) + " ");

        System.out.println(sb);
    }
}
