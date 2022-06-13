package 곱셈_1629;

//https://www.acmicpc.net/problem/1629

import java.util.*;

public class Main {
    public static long A;
    public static long B;
    public static long C;
    public static Map<Long, Long> mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        System.out.println(getMul(B));


    }

    public static long getMul(long b){

        if(b == 1) return  A % C;

        long temp = getMul(b /2);

        if(b % 2 == 1){
            return (temp * temp % C) * A % C;
        }else{
            return (temp * temp % C);
        }

    }
}
