package 보석도둑_1202;

/*
	Baekjoon Online Judge
	Problem : 보석도둑_1202
	Link :
	Author : LibertBaek
	Mail : halucinor0@gmail.com
	Date : 2022-07-05
*/

import java.util.*;

public class Main {
    static class Pair{
        int w;
        int v;
        Pair(int M, int V){
           this.w = M;
           this.v = V;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K, M, V;

        PriorityQueue<Pair> jewl = new PriorityQueue<>((A, B) -> {
            if(A.w != B.w)
                return Integer.compare(A.w, B.w);
            else
                return Integer.compare(B.v,A.w);
        });


        ArrayList<Integer> bag = new ArrayList<>();

        N = sc.nextInt();
        K = sc.nextInt();

        for(int i = 0 ; i < N ; ++i)
            jewl.add(new Pair(sc.nextInt(), sc.nextInt()));

        for(int i = 0 ; i < K ; ++i)
            bag.add(sc.nextInt());

        Collections.sort(bag);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;

        for(int i = 0 ; i < bag.size() ; ++i){
            int weight = bag.get(i);

            while(!jewl.isEmpty() && jewl.peek().w <= weight)
                queue.add(jewl.poll().v);

            if(!queue.isEmpty())
                ans += queue.poll();

        }
        System.out.println(ans);
    }
}
