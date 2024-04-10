package Contests;

import java.util.Scanner;

public class Codechef {

    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();
        while(t-->0){
            int n = scr.nextInt();
            int x = scr.nextInt();
            int[] arr = new int[n];
            arr[0] = x;
            int count=1;
            for(int i=1;i<=n;i++){
                if(i!=x)
                    arr[count++]=i;
            }
            //TODO: Backtracking
        }
    }


}

