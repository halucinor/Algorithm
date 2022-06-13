// https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
package 프린터;

import java.util.*;
import java.io.*;

public class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int locIdx = location;

        ArrayList<Integer> prioritiesList = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i : priorities) {
            queue.add(i);
            prioritiesList.add(i);
        }
        //우선순위 정렬
        Collections.sort(prioritiesList,Collections.reverseOrder());
        int cnt = 0;
        while(!queue.isEmpty()){
            int maxPriority = prioritiesList.get(0);
            int target = queue.poll();
            //최고 우선순위 일 경우
            if(target == maxPriority){
                //print
                cnt+= 1;
                prioritiesList.remove(0);
                if(locIdx == 0){
                    answer = cnt;
                    break;
                }else{
                    locIdx-= 1;
                }
            }else{
                queue.add(target);

                if(locIdx == 0){
                    locIdx = queue.size() - 1;
                }else{
                    locIdx -= 1;
                }
            }
        }

        return answer;
    }
}