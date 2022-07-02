package 엄청난_부자2_1271;
/*
	Baekjoon Online Judge
	Problem : 엄청난_부자2_1271
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-18
*/

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();

        System.out.println(a.divide(b));
        System.out.println(a.remainder(b));
    }
}
