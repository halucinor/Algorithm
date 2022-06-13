package 피보나치_1003;

//https://www.acmicpc.net/problem/1003
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        ArrayList<Integer> order = new ArrayList<>();
        ArrayList<Integer> print = new ArrayList<>();
        for(int i = 0 ; i < T ; ++i){
            int N = sc.nextInt();
            order.add(N);
            print.add(N);

        }
//        Collections.copy(order, print);
        Collections.sort(order, Collections.reverseOrder());

        int[] zeros = new int[41];
        int[] ones = new int[41];

        zeros[0] = 1;
        ones[0] = 0;

        zeros[1] = 0;
        ones[1] = 1;

        int _max = order.get(0);

        for(int i = 2; i <= _max ; ++i){
            ones[i] = ones[i - 1] + ones[i - 2];
            zeros[i] = zeros[i - 1] + zeros[i - 2];
        }

        print.stream().forEach(i ->{
            System.out.println(zeros[i] + " " + ones[i]);
        });
    }
}
