package DynamicProgramming;

public class Recursion {

    public static void main(String[] args){
//        char[] s = {'h','e','l','l','o'};
//        int n = s.length;
//        reverseString(0,n,s);


    }

    public static void reverseString(int i,int n,char[] s) {
        if(i>=n/2)
            return;
        swap(i,n-i-1,s);
        reverseString(++i,n,s);
    }

    private static void swap(int i, int j, char[] s) {
        char temp=s[j];
        s[j]=s[i];
        s[i]=temp;
    }

}


