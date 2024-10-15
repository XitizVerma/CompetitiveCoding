package ZZTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Template {

    public static Scanner scr;
    public static void main(String[] args) throws FileNotFoundException {
//        scr = new Scanner(new File("/Users/xitizverma/Documents/CompetitiveCoding/src/ZZTest/input.txt"));
////        scr = new Scanner(System.in);
//        int t = scr.nextInt();
//        while(t-->0){
//            coder();
//        }
        coder();
    }

    public static void coder(){

    }

    // Helper Methods

    public static int[] getArray(int n){
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i]=scr.nextInt();
        }
        return ans;
    }


}