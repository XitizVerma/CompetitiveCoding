package DataStructures;

import java.util.Arrays;

public class Comparators{

    public static void main(String[] args){
        int[][] arr = new int[10][2];
        int[][] sortedArr = Arrays.stream(arr).sorted((a1, b1) -> {
            if(a1[0]!=b1[0])
                return Integer.compare(b1[0],a1[0]);//Descending
            return Integer.compare(a1[1],b1[1]);//ascending
        }).toArray(int[][]::new);
    }

}
