package 거짓말_1043;
//https://www.acmicpc.net/problem/1043

import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        boolean[] truthPeoples = new boolean[N+1];

        parent = new int[N+1];
        for(int i = 0 ; i < N+1 ; ++i)
            parent[i] = i;

        for(int i = 0 ; i < truthCnt; ++i)
            truthPeoples[Integer.parseInt(st.nextToken())] = true;

        ArrayList<Integer>[] parties = new ArrayList[M];
        for(int i = 0 ; i < M ; ++i){
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());

            for(int p = 0 ; p < P ; ++p){
                parties[i].add(Integer.parseInt(st.nextToken()));

                if(parties[i].size() > 1)
                    union(parties[i].get(p-1),parties[i].get(p));
            }
        }

        for(int i = 1 ; i < truthPeoples.length ; ++i){
            if(truthPeoples[i])
                truthPeoples[find(i)] = true;
        }

        int total = 0;
        for(int i = 0 ; i < M ; ++i){
            int p = find(parties[i].get(0));
            if(!truthPeoples[p]) total++;
        }

        System.out.println(total);

    }

    public static int find(int x){
        if(parent[x] == x) return parent[x] = x;
        else return find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            if(a > b){
                parent[a] = b;
            }else{
                parent[b] = a;
            }
        }
    }
}
