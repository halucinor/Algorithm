package 디스크컨트롤러;

import java.util.*;

class Solution {
    static class Pair{
        int start;
        int interval;

        Pair(int s, int i){
            this.start = s;
            this.interval = i;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            int interval1 = o1.interval;
            int interval2 = o2.interval;
            return interval1 - interval2;
        });

        Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0]));

        boolean[] isDone = new boolean[jobs.length];
        int cnt = 0; //complete counter
        int currTime = jobs[0][0];
        int total = 0;
        while(cnt < jobs.length){
            for(int i = 0 ; i < jobs.length; ++i){
                if(isDone[i]) continue;
                if(jobs[i][0] <= currTime) {
                    pq.add(new Pair(jobs[i][0],jobs[i][1]));
                    isDone[i] = true;
                    cnt++;
                }
            }
            if(pq.isEmpty()){
                for(int i = 0 ; i < jobs.length; ++i){
                    if(isDone[i]) continue;
                    currTime = jobs[i][0];
                    pq.add(new Pair(jobs[i][0],jobs[i][1]));
                    isDone[i] = true;
                    cnt++;
                    break;

                }
            }

            while (!pq.isEmpty()){
                Pair work = pq.poll();
                int end = currTime + work.interval;
                int duration = end - work.start;
                total += duration;
                currTime = end;
            }
        }

        answer = total / jobs.length;
        return answer;
    }
}