package Backtracking;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PermutationsOfWord {

    static String word;
    public static void main(String[] args){
        long start = System.nanoTime();
        word="acb";
        char[] charArray = word.toCharArray();//sorting is not necessary
        Arrays.sort(charArray);
        word = new String(charArray);
        boolean[] visited = new boolean[word.length()];
        backtracking(new StringBuilder(),visited);
        long durationInNanos = System.nanoTime()-start;
        long durationInMicros = TimeUnit.NANOSECONDS.toMicros(durationInNanos);
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNanos);
        System.out.println("Time : " + durationInNanos + " nano-seconds");
        System.out.println("Time : " + durationInMicros + " micro-seconds");
        System.out.println("Time : " + durationInMillis + " milli-seconds");
    }

    public static void backtracking(StringBuilder temp,boolean[] visited){
        if(temp.length()==word.length()){
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if(!visited[i]){
                visited[i]=true;
                temp.append(word.charAt(i));
                backtracking(temp,visited);
                temp.deleteCharAt(temp.length()-1);
                visited[i]=false;
            }
        }
    }

    public static void backtracking(String temp,boolean[] visited,String word){
        if(temp.length()==word.length()){
            System.out.println(temp);
            return;
        }
        for(int i=0;i<word.length();i++){
            if(!visited[i]){
                visited[i]=true;
                temp+=word.charAt(i);
                backtracking(temp,visited,word);
                temp = temp.substring(0,temp.length()-1);
                visited[i]=false;
            }
        }
    }
}
