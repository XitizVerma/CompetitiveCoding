package ProblemsAndSolutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
public class NextHighestNumber {

    public static void main(String[] args) {

        /*
        * For every number in the list, find the first number on its right whose frequency
        *  is greater than that of the number.
        * Maintain order
        Input -   [5, 5, 3, 2, 2, 2, 6,  7,   7,   7,   7]
        Result - [2, 2, 2, 7, 7, 7, 7, -1,  -1, -1,  -1 ]
         */
        int[] arr = {5, 5, 3, 2, 2, 2, 6, 7, 7, 7, 7};
        Map<Integer,Integer> hashMap = new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0)+1);
        }
        Stack<Pairs> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stack.empty() || (stack.peek().key!=arr[i]))
                stack.push(new Pairs(arr[i],hashMap.get(arr[i])));
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            if(!stack.empty() && stack.peek().key==arr[i])
                stack.pop();
            Stack<Pairs> temp = stack;
            while(!temp.empty() && temp.peek().value<hashMap.get(arr[i]))
                temp.pop();
            if(temp.empty())
                ans[i]=-1;
            else
                ans[i]=temp.peek().key;
        }
        System.out.println(arr);
    }


}
class Pairs{
    int key;
    int value;
    Pairs(int a ,int b){
        key=a;
        value=b;

    }
}

