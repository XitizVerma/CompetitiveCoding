package DynamicProgramming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args){

        int[] arr = {10,9,2,5,3,7,101,18};
        int index=0;
        int prev=-1;
        System.out.println(LIS(arr,index,prev));
    }

    private static int LIS(int[] arr, int index, int prev) {
        if(index==arr.length)
            return 0;
        int curr = arr[index];
        int include = 0;
        if(prev<curr)
            include = LIS(arr,index+1,curr)+1;
        int exclude = LIS(arr,index+1,prev);
        return Math.max(include,exclude);
    }
}
