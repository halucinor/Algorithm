//https://programmers.co.kr/learn/courses/30/lessons/42586?language=java

package 기능개발;
import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        //days to finish
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int temp = (100 - progresses[i])/speeds[i];

            if((100 - progresses[i]) % speeds[i] != 0)
                temp++; // spend time
            queue.add(temp);

        }
        int day = queue.peek();
        int cnt = 0;
        while (true) {
            if (day >= queue.peek()) {
                cnt++;
                queue.poll();
                if (queue.isEmpty()) {
                    ans.add(cnt);
                    break;
                }
            }
            else {
                ans.add(cnt);
                day = queue.peek();
                cnt = 0;
            }
        }

        answer = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
