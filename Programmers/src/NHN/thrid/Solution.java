package NHN.thrid;

import java.util.*;

public class Solution {

    static class Pair{
        int r;
        int c;
        int cnt = 0;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int row;
    static int col;

    public int[] solution(String[] maze, String[] queries) {

        row = maze.length;
        col = maze[0].length();

        char[][] map = new char[row][col];

        for(int r = 0 ; r < row; ++r){
            map[r] = maze[r].toCharArray();
        }
        int[] answer = {};
        ArrayList<Integer> res = new ArrayList<Integer>();

        for(String query : queries){
            StringTokenizer stk = new StringTokenizer(query);

            int start_r = Integer.parseInt(stk.nextToken());
            int start_c = Integer.parseInt(stk.nextToken());
            int end_r = Integer.parseInt(stk.nextToken());
            int end_c = Integer.parseInt(stk.nextToken());

            Pair start = new Pair(start_r, start_c);
            Pair end = new Pair(end_r, end_c);

            char[] road = stk.nextToken().toCharArray();
            Set<Character> road_set = new HashSet<>();

            for(char c : road)
                road_set.add(c);

            res.add(bfs(start, end, map,road_set));

        }
        answer = res.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static int bfs(Pair start, Pair end, char[][] map, Set<Character> road_set){

        Queue<Pair> queue = new LinkedList<>();

        boolean[][] isvisited = new boolean[row][col];

        start.cnt = 0;
        queue.add(start);
        isvisited[start.r][start.c] = true;

        while(!queue.isEmpty()){
            Pair pos = queue.poll();
            int step = pos.cnt + 1;
            if(pos.r == end.r && pos.c == end.c)
                return step;

            for(int i = 0 ; i < 4; ++i){
                int nr = pos.r + dy[i];
                int nc = pos.c + dx[i];

                if(nr < 0 || nc < 0 || nr >= row || nc >= col)
                    continue;

                if(isvisited[nr][nc]) continue;

                if(road_set.contains(map[nr][nc])){
                    isvisited[nr][nc] = true;
                    Pair nPair = new Pair(nr,nc);
                    nPair.cnt = step;
                    queue.add(new Pair(nr,nc));
                }
            }

        }
        return -1;
    }

}
