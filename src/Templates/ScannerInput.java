package Templates;

import java.util.Scanner;

public class ScannerInput {

    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        int a = scr.nextInt();
        int b = scr.nextInt();
        System.out.println(a*6+b);
    }
//TODO: take input from a file
}
