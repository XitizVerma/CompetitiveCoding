package BitManipulation;

public class BitManipulation {

    public static void main(String[] args){
        countBits(2);
    }

    public static int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<=n;i++)
            arr[i]=arr[i/2]+i%2;
        return arr;
    }
}