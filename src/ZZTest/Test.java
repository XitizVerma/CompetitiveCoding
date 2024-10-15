package ZZTest;

import LinkedList.ListNode;

import java.time.ZonedDateTime;

public class Test {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now() + "\n");

        Test test = new Test();
        test.spiralMatrix(3,5,0);

    }

    int counter=1;
    public int[][] spiralMatrix(int m, int n, int head) {
        int[][] arr = new int[m][n];
        int i=0,j=0,m0=0,n0=0;
        while(m0<=m && n0<=n){
            for(j=n0;j<n;j++)
                helper(arr,head,i,j);
            j--;
            m0++;
            for(i=m0;i<m;i++)
                helper(arr,head,i,j);
            i--;
            n--;
            for(;j>=n0;j--)
                helper(arr,head,i,j);
            j++;
            m--;
            for(;i>=m0;i--)
                helper(arr,head,i,j);
            i++;
            n0++;
            // 00 01 02 03 04 14 24 23 22 21 20 10 11 12 13
        }
        return arr;
    }

    int helper(int[][] arr, int head, int i, int j){
        arr[i][j]=counter;
        return counter++;
    }
}
