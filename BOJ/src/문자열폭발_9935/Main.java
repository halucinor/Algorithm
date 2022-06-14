package 문자열폭발_9935;
/*
	Baekjoon Online Judge
	Problem : 문자열폭발_9935
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-14
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String target = sc.nextLine();
        String boom = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        int boomlen = boom.length();

        for(int i = 0 ; i < target.length(); ++i){
            sb.append(target.charAt(i));

            if(sb.length() >= boomlen){
                boolean isSame = true;
                for(int j = 0 ; j < boomlen; ++j){
                    char c1 = sb.charAt(sb.length() - boomlen + j);
                    char c2 = boom.charAt(j);
                    if(c1 != c2) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    sb.delete(sb.length() - boomlen, sb.length());
                }
            }
        }

        if(sb.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(sb.toString());

    }
}
