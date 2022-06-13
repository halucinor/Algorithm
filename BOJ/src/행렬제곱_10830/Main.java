package 행렬제곱_10830;
//https://www.acmicpc.net/problem/10830

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];

        for(int i = 0 ; i < N ; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ; ++j)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        int [][] res = multi(matrix, B);

        for(int i = 0 ; i < N ; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.print(res[i][j] % 1000 + " ");
            System.out.println();
        }
    }

    public static int[][] multi(int[][] matrix, long b){

        if(b == 1) return matrix;

        long half = b/2;

        int[][] h_multi = multi(matrix, half);

        if(b % 2 == 0){
            return dot(h_multi, h_multi);
        }else{
            return dot(dot(h_multi, h_multi),matrix);
        }

    }

    public static int[][] dot(int[][] a, int[][] b){
        int[][] temp = new int[N][N];

        for(int i = 0 ; i < N ; ++i){
            for(int j = 0; j < N ; ++j){
                int sum = 0;
                for (int k = 0 ; k < N ; ++k)
                    sum+= (a[i][k] * b[k][j]);
                temp[i][j] = sum % 1000;
            }
        }
        return temp;
    }
}
