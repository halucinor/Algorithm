package 쇠막대기_10799;
/*
	Baekjoon Online Judge
	Problem : 쇠막대기_10799
	Link : 
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022/07/02
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int pipe = 0;
        for(int i = 0 ; i < line.length() ; ++i){
            char c = line.charAt(i);

            if(c == '(')
                stack.push('(');
            else{
                char _prev = line.charAt(i-1);
                stack.pop();
                if(_prev == '(')
                    pipe += stack.size();
                else if(_prev == ')')
                    pipe += 1;
            }
        }
        System.out.println(pipe);

    }
}