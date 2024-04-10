import java.util.Scanner;

public class TempCode {

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int t = scr.nextInt();
        while (t-- > 0) {
            int n = scr.nextInt();
            int ans=0;
            for(int i=0;i<n;i++)
                ans+= scr.nextInt();
            int m = (int) Math.sqrt(ans);
            System.out.println((m*m==ans)?"YES":"NO");
        }
    }
}




