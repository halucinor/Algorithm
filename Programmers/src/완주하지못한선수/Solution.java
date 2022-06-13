package 완주하지못한선수;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participantMap = new HashMap<>();

        for(String person : participant)
            participantMap.put(person, participantMap.getOrDefault(person,0) + 1);


        for(String person : completion)
            participantMap.replace(person, participantMap.get(person) - 1);

        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }
}
