package 집합의_표현_1717;
/*
	Baekjoon Online Judge
	Problem : 집합의_표현_1717
	Link : https://www.acmicpc.net/problem/1717
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-17
*/

import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        for(int i = 0 ; i <= n; ++i)
            parents[i] = i;

        for(int i = 0 ; i < m ; ++i){
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 1){
                int p_a = find(a);
                int p_b = find(b);
                if(p_a == p_b)
                    sb.append("yes\n");
                else
                    sb.append("no\n");
            } else if (cmd == 0)
                union(a,b);

        }

        System.out.println(sb);
    }

    public static int find(int a){
        if(parents[a] != a){
            return parents[a] = find(parents[a]);
        }else return a;
    }

    public static void union(int a, int b){
        int p_a = find(a);
        int p_b = find(b);

        if(p_a < p_b)
            parents[p_b] = p_a;
        else
            parents[p_a] = p_b;
    }

}
