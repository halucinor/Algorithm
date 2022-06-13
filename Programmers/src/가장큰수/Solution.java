package 가장큰수;
//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java

import java.util.*;
import java.io.*;

class Solution {
    public static String solution(int[] numbers) {
        String answer = "";
        Integer[] list = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(list, (Integer o1, Integer o2) -> {
            String s1 = o1.toString() + o2.toString();
            String s2 = o2.toString() + o1.toString();

            Integer v1 = Integer.parseInt(s1);
            Integer v2 = Integer.parseInt(s2);

            return v2.compareTo(v1);
        });

        for(Integer i : list){
            answer += i.toString();
        }
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}

//class Solution {
//    public static String solution(int[] numbers) {
//        String answer = "";
//        Integer[] list = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
//
//        Arrays.sort(list, (Integer o1, Integer o2) -> {
//            int exp1 = (int) Math.log10(o1);
//            int exp2 = (int) Math.log10(o2);
//            if(exp1 > exp2)
//                o2 = o2 * (int) Math.pow(10,exp1 - exp2);
//            else if(exp1 < exp2)
//                o1 = o1 * (int) Math.pow(10,exp2 - exp1);
//            int res = o2.compareTo(o1);
//            return res;
//        });
//
//        for(Integer i : list){
//            answer += i.toString();
//        }
//
//        return answer;
//    }
//}
