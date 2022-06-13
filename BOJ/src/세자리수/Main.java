package 세자리수;

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[3];



        for(int i = 0 ; i < 3 ; ++i)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);

        for(int i = 0 ; i < 3 ; ++i)
            System.out.print(nums[i] + " ");

    }
}