package AC_5430;
/*
	Baekjoon Online Judge
	Problem : AC_5430
	Link : https://www.acmicpc.net/problem/5430
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-06-28
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < T ; ++t){
            char[] CMD = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            input = input.substring(1, input.length()-1);

            ArrayDeque<Integer> intArray = new ArrayDeque<>();

            if(n != 0) {
                stk = new StringTokenizer(input, ",");
                while (stk.hasMoreTokens())
                    intArray.add(Integer.parseInt(stk.nextToken()));
            }

            boolean reverseFlag = false;
            boolean isError = false;
            for(int i = 0 ; i < CMD.length ; ++i){
                char cmd = CMD[i];
                if(cmd == 'R'){
                    reverseFlag = !reverseFlag;
                    continue;
                }else if(cmd == 'D'){
                    if(intArray.size() == 0){
                        isError = true;
                        break;
                    }
                    if(!reverseFlag)
                        intArray.removeFirst();
                    else
                        intArray.removeLast();
                }
            }
            if(!isError){
                sb.append("[");
                if(intArray.size() != 0) {

                    if(!reverseFlag){
                        sb.append(intArray.pollFirst());

                        while(!intArray.isEmpty())
                            sb.append(',').append(intArray.pollFirst());

                    }else{
                        sb.append(intArray.pollLast());

                        while(!intArray.isEmpty())
                            sb.append(',').append(intArray.pollLast());
                    }
                }
                sb.append("]\n");
            }else
                sb.append("error\n");
        }
        System.out.println(sb);
    }
}
