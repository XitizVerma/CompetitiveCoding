package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxProfitDifficultyWorker {

    public static void main(String[] args) {
        int[] diff = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        int ans = maxProfitAssignment(diff,profit,worker);
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length;
        List<Pair> pairList = new ArrayList<>();
        for(int i=0;i<n;i++)
            pairList.add(new Pair(difficulty[i],profit[i]));
        pairList.sort(Comparator.comparing(p -> p.x));
        int y=0;
        for(Pair pair : pairList){
            y=Math.max(pair.y,y);
            pair.y=y;
        }
        int ans=0;
        for(int i:worker)
            ans+=getProfit(i,pairList,n);
        return ans;
    }

    private static int getProfit(int capacity, List<Pair> pairList,int n) {
        int left = 0, right = n-1, mid, ans=0;
        while(left <= right){
            mid = left + ((right-left)/2);
            Pair pair = pairList.get(mid);
            int x = pair.x;
            if(x<=capacity){
                ans=pair.y;
                left = mid+1;
            }else
                right = mid-1;
        }
        return ans;
    }


    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

}
