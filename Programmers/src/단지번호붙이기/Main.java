package 단지번호붙이기;

//https://www.acmicpc.net/problem/2667
import java.util.*;
import java.io.*;

public class Main {

    static class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int[][] map = new int[N][N];
        boolean[][] isvisited = new boolean[N][N];

        for(int r = 0 ; r < N ; ++r){
            String line = sc.next();

            for(int c = 0; c < N ; ++c){
                map[r][c] = line.charAt(c) - '0';
            }
        }

        int cnt = 0;
        ArrayList<Integer> house = new ArrayList<Integer>();

        for(int r = 0 ; r < N ; ++r){
            for(int c = 0; c < N; ++c){
                if(!isvisited[r][c] && map[r][c]== 1){
                    cnt++; //단지 수 증가
                    house.add(bfs(r,c, map, isvisited, N));
                }
            }
        }

        Collections.sort(house);

        System.out.println(cnt);

        house.forEach(i -> System.out.println(i));
    }

    public static int bfs(int r, int c, int[][] map, boolean[][] isvisited, int N){

        Queue<Pair> queue = new LinkedList<>();

        Pair pair = new Pair(r,c);
        queue.add(pair);
        isvisited[r][c] = true;

        int cnt = 0;

        while(!queue.isEmpty()){
            Pair pos = queue.poll();
            cnt++;

            for(int i = 0 ; i < 4; ++i){
                int nr = pos.r + dy[i];
                int nc = pos.c + dx[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;

                if(map[nr][nc] == 1 && !isvisited[nr][nc]){
                    isvisited[nr][nc] = true;
                    queue.add(new Pair(nr,nc));
                }
            }

        }
        return cnt;
    }
}
