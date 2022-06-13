package 적록색약_10026;

import java.util.*;

public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        char[][] map = new char[N][N];

        for(int r = 0 ; r < N ; ++r) {
            char[] line = sc.next().toCharArray();
            map[r] = line;
        }

        int first = bfs(map, 0);
        int second = bfs(map, 1);

        System.out.println(first + " " + second);

    }
    public static int bfs(char[][] map, int mode){
        int N = map.length;
        boolean[][] isVisited = new boolean[N][N];
        int area = 0;
        for(int r = 0; r < N; ++r){
            for(int c = 0; c < N ; ++c){
                if(!isVisited[r][c]){
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(r,c));
                    isVisited[r][c] = true;

                    area++;
                    while(!q.isEmpty()) {
                        Pair pos = q.poll();
                        char color = map[pos.r][pos.c];

                        for(int i = 0; i < 4; ++i){
                            int nextR = pos.r + dy[i];
                            int nextC = pos.c + dx[i];

                            if(nextR >= N || nextC >= N || nextR < 0 || nextC < 0) continue;
                            if(isVisited[nextR][nextC]) continue;

                            if(mode == 0){
                                if(map[nextR][nextC] == color){
                                    q.add(new Pair(nextR,nextC));
                                    isVisited[nextR][nextC] = true;
                                }
                            }else{
                                if(color == 'R' || color == 'G'){
                                    if(map[nextR][nextC] == 'R' || map[nextR][nextC] == 'G'){
                                        q.add(new Pair(nextR,nextC));
                                        isVisited[nextR][nextC] = true;
                                    }
                                }else{
                                    if(map[nextR][nextC] == color){
                                        q.add(new Pair(nextR,nextC));
                                        isVisited[nextR][nextC] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return area;
    }
}
