
package K번째수;

import java.util.*;
import java.io.*;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer =  new ArrayList<>();

        for (int[] commend: commands) {
            int start = commend[0] - 1; // from idx - 1
            int end = commend[1];   // to idx
            int idx = commend[2] - 1;

            int[] subArray = Arrays.copyOfRange(array,start,end); //[from, end)
            Arrays.sort(subArray);
            answer.add(subArray[idx]);
        }
        return answer;
    }
}