package BinarySearchVariations;

import java.util.List;

public class LowerBound {

    public static void main(String[] args) {

    }

    private static int binarySearchLowerBound(int k, List<Integer> arr) {
        int ans=0,mid;
        int left = 0, right = arr.size()-1;
        while(left <= right){
            mid = left + ((right-left)/2);
            int num = arr.get(mid);
            if(num<=k){
                ans=num;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return ans;
    }
}
