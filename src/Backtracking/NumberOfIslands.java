package Backtracking;

public class NumberOfIslands {
    static int ans=0,m,n;
    public static void main(String[] args){
        String[][] arr= {{"1","1","1","1","0"},
                        {"1","1","0","1","0"},
                        {"1","1","0","0","0"},
                        {"0","0","0","0","1"}};
        m=arr.length;
        n=arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j].equals("1")) {
                    backtracking(i, j, arr);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void backtracking(int i, int j,String[][] arr) {
        if(i==-1 || j==-1 || i==m || j==n)
            return;
        if(!arr[i][j].equals("1"))
            return;
        arr[i][j]="2";
        backtracking(i+1,j,arr);
        backtracking(i-1,j,arr);
        backtracking(i,j+1,arr);
        backtracking(i,j-1,arr);
    }
}
