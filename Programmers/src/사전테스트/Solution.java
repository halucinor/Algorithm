package 사전테스트;

import java.util.*;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = {0,0};
        Map<Integer,Integer> xMap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> yMap = new HashMap<Integer,Integer>();

        for(int r = 0 ; r < 3 ; ++r){

            if(xMap.containsKey(v[r][0]))
                xMap.replace(v[r][0],2);
            else
                xMap.put(v[r][0],1);
            if(yMap.containsKey(v[r][1]))
                yMap.replace(v[r][1],2);
            else
                yMap.put(v[r][1],1);
        }

        xMap.forEach((key,value) ->{
            if(value == 1) answer[0] = key;
        });

        yMap.forEach((key,value) ->{
            if(value == 1) answer[1] = key;
        });
        return answer;
    }
}
