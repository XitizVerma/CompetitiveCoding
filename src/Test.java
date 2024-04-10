public class Test {

    public static void main(String[] args) {
        int[] arr = {0,1,0,1};
        countAlternatingSubarrayss(arr);
    }

    public static long countAlternatingSubarrays(int[] nums) {
        int n=nums.length,ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(j>0 && nums[j-1]==nums[j]){
                    break;
                }
                ans++;
            }
        }
        ans+=nums.length;
        return ans;
    }

    public static int countAlternatingSubarrayss(int[] nums) {
        int count = 0;
        Integer prev = null; // Use Integer to handle null for the first element

        for (int num : nums) {
            if (prev == null || num != prev) {
                count++;
            }
            prev = num;
        }

        return count;
    }

}




