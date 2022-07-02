package 모음의개수_1264;
/*
	Baekjoon Online Judge
	Problem : 모음의개수_1264
	Link : https://www.acmicpc.net/problem/1264
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-20
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String line = sc.nextLine().toLowerCase();
            if(line.equals("#")) break;
            int cnt = 0;
            for(int i = 0 ; i < line.length(); ++i){
                char ch = line.charAt(i);

                if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u')
                    cnt++;
            }
            System.out.println(cnt);
        }
    }
}
