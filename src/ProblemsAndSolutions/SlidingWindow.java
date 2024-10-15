package ProblemsAndSolutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {

    public static void main(String[] args) {
    }

    public static int[] longestSubarrayWithKWindow(int[] nums, int k) {

        nums = new int[]{8, 2, 4, 7, 2, 0, 5};
        int windowSize = 3;

        /*
            [8,2,4,7,2,0,5]

            Last    8                 First
            Last    8,2               First
            Last    8,4               First
            Last    7                 First
            Last    7,2               First
            Last    7,2,0             First
            Last    5                 First

        */
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, num;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            num = nums[i];
            while (!deque.isEmpty() && deque.peekLast() <= i - k)
                deque.pollLast();
            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i])
                deque.pollFirst();
            deque.addFirst(i);
            if (i + 1 >= k)
                ans[i - k + 1] = nums[deque.peekLast()];
        }
        return ans;
    }

    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> increase =  new LinkedList<>();
        Deque<Integer> decrease = new LinkedList<>();

        int ans = 0,n = nums.length, left=0;
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            while (!decrease.isEmpty() && decrease.peekLast() < num)
                decrease.pollLast();
            decrease.addLast(num);
            while (!increase.isEmpty() && increase.peekLast() > num)
                increase.pollLast();
            increase.addLast(num);

            while(decrease.peekFirst()-increase.peekFirst()>limit){
                if(decrease.peekFirst()==nums[left])
                    decrease.pollFirst();
                if(increase.peekFirst()==nums[left])
                    increase.pollFirst();
                left++;
            }

            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

}



