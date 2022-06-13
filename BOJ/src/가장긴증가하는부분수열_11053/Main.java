package 가장긴증가하는부분수열_11053;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] array = new int[N];
        Arrays.fill(dp,1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; ++i)
            array[i] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i < N ; ++i)
            for(int j = 0 ; j < i ; ++j){
                if(array[i] > array[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

            }
        int _max = -1;
        for(int i = 0 ; i < N ; ++i)
            _max = Math.max(dp[i], _max);
        System.out.println(_max);
    }
}
