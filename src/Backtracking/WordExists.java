package Backtracking;
public class WordExists {

    public static void main(String[] args) {
        char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        exist(board, word);
    }

    public static boolean exist(char[][] board, String word) {
        int n = word.length();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtracking(board, word, i,j, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean backtracking(char[][] board, String word, int i, int j, int index){
        if(index == word.length())
            return true;
        if(i == board.length || i==-1 || j == board[0].length || j==-1)
            return false;
        if(board[i][j] == word.charAt(index)){
            return backtracking(board,word,i+1,j,index+1) ||
                    backtracking(board,word,i-1,j,index+1) ||
                    backtracking(board,word,i,j+1,index+1) ||
                    backtracking(board,word,i,j-1,index+1);
        }
        return false;
    }
}

