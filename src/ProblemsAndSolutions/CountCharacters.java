package ProblemsAndSolutions;

import java.util.HashMap;
import java.util.Objects;

public class CountCharacters {
    public static void main(String[] args){
        String []words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words,chars));
    }

    public static int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> charCount = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            char ch = chars.charAt(i);
            if(charCount.containsKey(ch))
                charCount.put(ch,charCount.get(ch)+1);
            else
                charCount.put(ch,1);
        }
        int ans=0;
        for(String word : words){
            HashMap<Character,Integer> wordCount = new HashMap<>();
            boolean flag = true;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                wordCount.put(ch, Objects.isNull(wordCount.get(ch))?1: wordCount.get(ch)+1);
            }
            for(char ch : wordCount.keySet()){
                if(Objects.isNull(charCount.get(ch)) || wordCount.get(ch)>charCount.get(ch))
                    flag=false;
                if(!flag)
                    break;
            }
            if(flag){
                ans+=word.length();
            }
        }
        return ans;
    }
}




