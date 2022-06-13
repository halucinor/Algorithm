package Poketmon_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        HashMap<String, String> dict = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            String num = Integer.toString(i+1);
            dict.put(name, num);
            dict.put(num,name);
        }

        for (int i = 0; i < M ; ++i){
            String code = br.readLine();
            System.out.println(dict.get(code));
        }
    }
}
