package ProblemsAndSolutions;

import java.util.Stack;
class Pair{
    int value=0;
    int index=0;

//    Pair(int value, int index){
//        this.value=value;
//        this.index=index;
//    }
}
public class StackManipulation {

    public static void main(String[] args){

        int arr[] = {73,74,75,71,69,72,76,7};
        int ans[] = dailyTemperatures(arr);
        for(int i : ans)
            System.out.print(i + " ");
        //[1,1,4,2,1,1,0,0]
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            if(stack.empty()){
                ans[i]=0;
                Pair pair = new Pair();
                pair.value=temperatures[i];
                pair.index=i;
                stack.push(pair);
            }else{
                while(!stack.empty()){
                    if(stack.peek().value>temperatures[i]){
                        ans[i]=stack.peek().index-i;
                        Pair pair = new Pair();
                        pair.value=temperatures[i];
                        pair.index=i;
                        stack.push(pair);
                        break;
                    }else {
                        stack.pop();
                        if(stack.empty()){
                            ans[i]=0;
                            Pair pair = new Pair();
                            pair.value=temperatures[i];
                            pair.index=i;
                            stack.push(pair);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
