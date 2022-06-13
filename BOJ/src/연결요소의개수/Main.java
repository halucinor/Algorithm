//https://www.acmicpc.net/problem/11724
package 연결요소의개수;

import java.io.*;
import java.util.*;

public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        root = new int[N+1];

        for(int i = 1; i < N+1; ++i)
            root[i] = i;

        for(int i = 0 ; i < M ; ++i){
            int u = sc.nextInt();
            int v = sc.nextInt();

            if(find(u) != find(v))
                union(u,v);
        }
        int ans = 0;
        for(int i = 1; i < N+1; ++i){
            if(root[i] == i) ans++;
        }
        System.out.println(ans);
    }

    public static void union(int u, int v){
        int _u = find(u);
        int _v = find(v);

        if(_u > _v) root[_u] = _v;
        else root[_v] = _u;

    }

    public static int find(int node){
        if(root[node] == node) return node;
        return root[node] = find(root[node]);
    }

}
