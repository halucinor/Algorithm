package 보물_1026;
//https://www.acmicpc.net/problem/1026

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer A[] = new Integer[N];
        Integer B[] = new Integer[N];

        for(int i = 0 ; i < N ; ++i)
            A[i] = sc.nextInt();

        for(int i = 0 ; i < N ; ++i)
            B[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int ans = 0;
        for(int i = 0; i < N ; ++i)
            ans += A[i] * B[i];

        System.out.println(ans);
    }
}
