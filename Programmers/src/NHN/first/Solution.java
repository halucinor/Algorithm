package NHN.first;

import java.util.*;

import java.util.*;

public class Solution {
    public int solution(int[][] cards1, int[][] cards2) {
        int answer = 0;
        int row = cards1.length;
        int col = cards1[0].length;

        int result = 0;
        for(int r = 0 ; r < row ; ++r) {
            Set<Integer> dupCheck = new HashSet<>();
            Set<Integer> player1 = new HashSet<>();
            Set<Integer> player2 = new HashSet<>();
            boolean is_ok = true;

            //플레이어 간 중복체크
            for(int c = 0 ; c < col; ++c){
                player1.add(cards1[r][c]);
                player2.add(cards2[r][c]);
                if(dupCheck.contains(cards1[r][c])){
                    is_ok = false;
                    break;
                }else
                    dupCheck.add(cards1[r][c]);

                if(dupCheck.contains(cards2[r][c])){
                    is_ok = false;
                    break;
                }else
                    dupCheck.add(cards2[r][c]);
            }
            if(!is_ok){
                answer++;
                continue;
            };

            //플레이어 이전 라운드 중복체크
            if(r > 0){
                int p1_dup = 0;
                int p2_dup = 0;
                for(int c = 0 ; c < col; ++c){
                    if(player1.contains(cards1[r-1][c])){
                        p1_dup++;
                    }
                    if(player2.contains(cards2[r-1][c])){
                        p2_dup++;
                    }
                }
                if(p1_dup >= 2 || p2_dup >= 2) is_ok = false;
            }

            if(!is_ok) answer++;

        }
        return answer;
    }
}
