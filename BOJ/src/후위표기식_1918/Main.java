package 후위표기식_1918;
/*
	Baekjoon Online Judge
	Problem : 후위표기식_1918
	Link : https://www.acmicpc.net/problem/1918
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-14
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Map<Character,Integer> priority = new HashMap<>();
        Stack<Character> operator = new Stack<>();

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String eq = sc.nextLine();

        priority.put('(', 1);
        priority.put(')', 1);
        priority.put('*', 3);
        priority.put('/', 3);
        priority.put('+', 2);
        priority.put('-', 2);

        for(int i = 0 ; i < eq.length();++i){
            char el = eq.charAt(i);
            if(el >= 'A' && el <= 'Z') {
                sb.append(el);
                continue;
            }
            if(el == '(')
                operator.push(el);
            else if(el == ')'){
                while(!operator.isEmpty() && operator.peek() != '(')
                    sb.append(operator.pop());
                operator.pop();
            }else{
                while(!operator.isEmpty() && priority.get(operator.peek()) >= priority.get(el))
                    sb.append(operator.pop());
                operator.push(el);
            }
        }
        while(!operator.isEmpty())
            sb.append(operator.pop());

        System.out.println(sb);
    }
}
