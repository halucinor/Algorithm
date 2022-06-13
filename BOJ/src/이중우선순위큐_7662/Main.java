//https://www.acmicpc.net/problem/7662

package 이중우선순위큐_7662;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < TC ; ++t){
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            for(int k = 0 ; k < K ; ++k){
                String[] line = br.readLine().split(" ");
                char cmd = line[0].charAt(0);
                int value = Integer.parseInt(line[1]);

                if(cmd == 'I'){
                    maxHeap.offer(value);
                    minHeap.offer(value);
                    map.put(value, map.getOrDefault(value,0) + 1);
                }else{
                    if(value == 1){
                        while(true){
                            if(maxHeap.isEmpty()) break;
                            int max = maxHeap.poll();
                            int cnt = map.getOrDefault(max,0);

                            if(cnt == 0)
                                continue;
                            else if(cnt == 1)
                                map.remove(max);
                            else
                                map.put(max, cnt - 1);
                            break;
                        }
                    }else{
                        while(true){
                            if(minHeap.isEmpty()) break;
                            int min = minHeap.poll();
                            int cnt = map.getOrDefault(min,0);

                            if(cnt == 0)
                                continue;
                            else if(cnt == 1)
                                map.remove(min);
                            else
                                map.put(min, cnt - 1);
                            break;
                        }
                    }
                }
            }
            if (map.isEmpty())
                System.out.println("EMPTY");
            else{
                int max, min;
                while(true){
                    max = maxHeap.poll();
                    int cnt = map.getOrDefault(max, 0);
                    if(cnt == 0)
                        continue;
                    else break;
                }
                while (true){
                    min = minHeap.poll();
                    int cnt = map.getOrDefault(min,0);
                    if(cnt == 0)
                        continue;
                    else break;
                }
                System.out.println(max + " " + min);
            }
        }

    }
}
