package 정수제곱근_2417;

//https://www.acmicpc.net/problem/2417
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long left, right;
        left = 0;
        right = n; //q <= n

        long answer = n;
        while(left <= right){
            long middle = (right + left)/2;
            BigInteger exp = BigInteger.valueOf(middle).pow(2); // q^2

            if(exp.compareTo(BigInteger.valueOf(n)) >= 0){
                answer = Math.min(middle,answer);
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }

        System.out.println(answer);

    }
}
