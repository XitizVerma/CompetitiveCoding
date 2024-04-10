package ProblemsAndSolutions;

import java.util.*;


public class StringManipulation {

    public static void main(String[] args){
//        String []word1 = {"ab", "c"}, word2 = {"a", "bc"};
//        System.out.println(arrayStringsAreEqual(word1,word2));

//        String num = "6777133339";
//        System.out.println(largestGoodInteger(num));

//        String a = "11", b = "1";
//        System.out.println(addBinary(a,b));

//        List<List<String>> arr = new ArrayList<>();
//        arr.add(Arrays.asList("London", "New York"));
//        arr.add(Arrays.asList("New York", "Lima"));
//        arr.add(Arrays.asList("Lima", "Sao Paulo"));
//        System.out.println(destCity(arr));

//        isAnagram("ab","a");
//        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
//        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
//        int[] rating = {9, 12, 8, 15, 14, 7};
//        foodRatings(foods, cuisines, rating);

//        String s = "011101",s2="00111",s3="1111",s4="00";
//        maxScore(s4);

//        isPathCrossing("ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS");

//        minOperations("0100");

//        String[] words = {"abc","aabc","bc"};
//        makeEqual(words);

//        String word="abca";
//        maxLengthBetweenEqualCharacters(word);

//        String s = "leetcode", t = "practice";
//        minSteps(s,t);

//        String[] arr = {"2","1","+","3","*"};
//        evalRPN(arr);

//        firstUniqChar("leetcode");

//        String[] anagrams = {"eat","tea","tan","ate","nat","bat"};
//        groupAnagrams(anagrams);

//        frequencySort("cccaaabbd");
        String [] words = {"a","aba","ababa","aa"};
        countPrefixSuffixPairs(words);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder wordA = new StringBuilder();
        for(String s:word1){
            wordA.append(s);
        }
        StringBuilder wordB = new StringBuilder();
        for(String s:word2){
            wordB.append(s);
        }
        return wordA.toString().equals(wordB.toString());
    }

    public static String largestGoodInteger(String num) {
        int ans=-1;
        for(int i=0;i<num.length()-2;i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2))
                ans=Math.max(ans,num.charAt(i)-'0');
        }
        return (ans==-1)?"":(String.valueOf(ans)+String.valueOf(ans)+String.valueOf(ans));
    }

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int m=a.length()-1,n=b.length()-1,carry=0,sum=0;
        while(m>=0 || n>=0){
            sum=carry;
            sum+=(m>=0)?a.charAt(m--)-'0':0;
            sum+=(n>=0)?b.charAt(n--)-'0':0;
            carry=(sum>1)?1:0;
            ans.append(sum%2);
        }
        if(carry!=0)
            ans.append(carry);
        return ans.reverse().toString();
    }

    public static String destCity(List<List<String>> paths) {
        HashSet<String> hashSet = new HashSet<>();
        for(List<String> path : paths)
            hashSet.add(path.get(0));
        for(List<String> path : paths)
            if(!hashSet.contains(path.get(1)))
                return path.get(1);
        return "";
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] schars = s.toCharArray();
        Arrays.sort(schars);
        char[] tchars = t.toCharArray();
        Arrays.sort(tchars);
        int j=0,i=0;
        while(i<t.length()){
            if(tchars[i]==schars[j]){
                i++;j++;
            }
            else
                return false;
        }
        return true;
    }

    public static HashMap<String,Integer> foodrating;
    public static HashMap<String,List<String>> cuisineFoodMapping;
    public static void foodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodrating= new HashMap<>();
        cuisineFoodMapping = new HashMap<>();
        for(int i=0;i<foods.length;i++){
            if(cuisineFoodMapping.containsKey(cuisines[i])){
                cuisineFoodMapping.get(cuisines[i]).add(foods[i]);
            }
            else{
                List<String> temp = new ArrayList<>();
                temp.add(foods[i]);
                cuisineFoodMapping.put(cuisines[i],temp);
            }
            foodrating.put(foods[i],ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        foodrating.put(food,newRating);
    }

    public String highestRated(String cuisine) {
        List<String> foods = cuisineFoodMapping.get(cuisine);
        String ans = "";int max=-1;
        for(String food : foods){
            if(foodrating.get(food)>max){
                ans = food;
                max = foodrating.get(food);
            }
            else if(foodrating.get(food)==max)
                ans = lexographyCheck(food,ans);
        }
        return ans;
    }

    private String lexographyCheck(String food, String ans) {
        int i=0,m=food.length(),j=0,n=ans.length();
        while(i<m && j<n){
            if(food.charAt(i)!=ans.charAt(j))
                return food.charAt(i)<ans.charAt(j)?food:ans;
            i++;j++;
        }
        return (i==m)?food:ans;
    }

    public static int maxScore(String s) {
        int zero=0,one=0,ans=0,totalZeros=0,n=s.length();
        for(int i=0;i<n;i++)
            if(s.charAt(i)=='0')
                totalZeros++;
        if(s.charAt(0)=='0'){
            zero++;
        }
        for(int i=1;i<n-1;i++){
            int rightOnes=(n-totalZeros)-(i-zero);
            ans = Math.max(ans,zero+rightOnes);
            if(s.charAt(i)=='0')
                zero++;
        }
        return ans;
    }

    public static boolean isPathCrossing(String path) {
        int x=0,y=0;
        HashSet<String> visited = new HashSet<>();
        visited.add("0_0");
        for(int i=0;i<path.length();i++){
            switch (path.charAt(i)){
                case 'N':y++;break;
                case 'S':y--;break;
                case 'E':x++;break;
                case 'W':x--;break;
            }
            String point = String.valueOf(x)+"_"+String.valueOf(y);
            if(visited.contains(point))
                return true;
            visited.add(point);
        }
        return false;
    }

    public static int minOperations(String s) {
        int n=s.length(),ans=0;
        for(int i=0;i<n;i++){
            if((i&1)==0 && s.charAt(i)=='0') ans++;
            if((i&1)==1 && s.charAt(i)=='1') ans++;
        }
        return Math.min(ans,n-ans);
    }

    public static boolean makeEqual(String[] words) {
        int n = words.length;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(String word:words){
            for(int i=0;i<word.length();i++)
                freq.put(word.charAt(i),freq.containsKey(word.charAt(i))?freq.get(word.charAt(i))+1:1);
        }
        for(Character ch:freq.keySet())
            if(freq.get(ch)%n!=0)
                return false;
        return true;
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> firstOccurence = new HashMap<>();
        int n=s.length(),ans=-1;
        for(int i=0;i<n;i++){
            if(firstOccurence.containsKey(s.charAt(i)))
                ans=Math.max(ans,i-firstOccurence.get(s.charAt(i))-1);
            else
                firstOccurence.put(s.charAt(i),i);
        }
        return ans;
    }

    public static boolean halvesAreAlike(String s) {
        List<Character> chars = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        HashSet<Character> hashSet = new HashSet<>(chars);
        int firstHalf=0,n=s.length()/2;
        for(int i=0;i<n;i++)
            firstHalf+=hashSet.contains(s.charAt(i))?1:0;
        for(int i=n*2-1;i>=n;i--)
            firstHalf-=hashSet.contains(s.charAt(i))?1:0;
        return firstHalf==0;
    }

    public static int minSteps(String s, String t) {
        HashMap<Character,Integer> maps = new HashMap<Character,Integer>();
        for(char ch : s.toCharArray())
            maps.put(ch,maps.getOrDefault(ch,0)+1);
        for(char ch : t.toCharArray()){
            maps.put(ch,maps.getOrDefault(ch,0)-1);
        }
        int ans=0;
        for(int val : maps.values())
            ans+= Math.abs(val);
        ans/=2;
        return ans;
    }

    public static boolean closeStrings(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;
        for (int i = 0; i < 26; i++)
            if ((arr1[i] == 0 && arr2[i] != 0) || (arr1[i] != 0 && arr2[i] == 0))
                return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < 26; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    public static int evalRPN(String[] tokens) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for(String i:tokens){
            if(hashSet.contains(i)){
                int b = stack.pop();
                int a = stack.pop();
                switch (i){
                    case "+":stack.push(a+b);break;
                    case "-":stack.push(a-b);break;
                    case "*":stack.push(a*b);break;
                    case "/":stack.push(a/b);
                }
            }else
                stack.push(Integer.valueOf(i));
        }
        return stack.peek();
    }

    public static int firstUniqChar(String s) {
        int ans =-1,n=s.length();
        HashMap<Character,Integer> hash= new HashMap<>();
        for(Character ch:s.toCharArray())
            hash.put(ch,hash.getOrDefault(ch,0)+1);
        for(int i=0;i<n;i++)
            if(hash.get(s.charAt(i))==1){
                ans=i;
                break;
            }
        return ans;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,List<String>> hashMap = new HashMap<>();
        for(String str : strs){
            HashMap<Character,Integer> charMap = new HashMap<>();
            for(Character ch : str.toCharArray()){
                charMap.put(ch,charMap.getOrDefault(ch,0)+1);
            }
            hashMap.put(charMap,hashMap.computeIfAbsent(charMap,key -> new ArrayList<>())).add(str);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static String frequencySort(String s) {
        // cccaaabbd
        // aaacccbbd
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(Character ch : s.toCharArray())
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        int[][] arr= new int[hashMap.size()][2];

        StringBuilder stringBuilder = new StringBuilder();
        int i=0;
        for(Map.Entry<Character,Integer> entry : hashMap.entrySet()){
            arr[i][0] = entry.getValue();
            arr[i][1] = entry.getKey();
            i++;
        }
        int[][] sortedArr = Arrays.stream(arr).sorted((a1,b1) -> {
            if(a1[0]!=b1[0])
                return Integer.compare(b1[0],a1[0]);//Descending
            return Integer.compare(a1[1],b1[1]);//ascending
        }).toArray(int[][]::new);
        for(i=0;i<sortedArr.length;i++){
            int a = sortedArr[i][0];
            char ch = (char)sortedArr[i][1];
            while(a-->0){
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static String firstPalindrome(String[] words) {
        for(String word: words)
            if(checkPallindrome(word))
                return word;
        return "";
    }

    private static boolean checkPallindrome(String word) {
        int i=0,j=word.length()-1;
        while(i<j){
            if(word.charAt(i++)!=word.charAt(j--))
                return false;
        }
        return true;
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int n=words.length,count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(checkPrefixAndSuffix(words[i],words[j]))
                    count++;
            }
        }
        return count;
    }

    public static boolean checkPrefixAndSuffix(String word1, String word2){
        int l1=word1.length(), l2=word2.length();
        if(l1>l2)
            return false;
        return (word2.substring(0,l1).equals(word1) && word2.substring(l2-l1,l2).equals(word1));
    }


}
