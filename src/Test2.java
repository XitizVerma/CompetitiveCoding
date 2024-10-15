import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2 {

    public static FastScanner scr;
    public static void main(String[] args) {
        scr = new FastScanner();
        int t = scr.nextInt();
        while(t-->0){
            coder();
        }
    }

    public static void coder(){

    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next(){
            while(!st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        int[] readArray(int n){
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long nextLong(){
            return Long.parseLong(next());
        }

    }

}
