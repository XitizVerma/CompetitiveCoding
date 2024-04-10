package ProblemsAndSolutions;

public class FileLineManipulation {
    public static void main(String[] args) {

        String[] input = {"public void testFunction(){",
                "int a = 10; // first line of comment",
                "int b = 15; /* second line of comment */",
                "",
                "/**/",
                "int c = a + b;    /* this is a multiline comment",
                "which goes to the next line*/",
                "",
                "abc/**/",
                "// helper to print line of code ",
                "system.out.println(\"we are looking at number of inline/block comments; based on // or /* characters\" + c);  ",
                "}"
        };

        int totalLines = 0, blankLines = 0, comments = 0;
        boolean isComment = false;
        for (String str : input) {
            str = str.trim();
            totalLines++;
            if (str.length() == 0) {
                if (isComment)
                    comments++;
                else
                    blankLines++;
                continue;
            }
            if(str.contains("/*") && !checkIfItIsPrintStatement(str)){
                comments++;
                isComment=true;
            }
            if(str.contains("*/") && !checkIfItIsPrintStatement(str)){
                if(!str.contains("/*"))
                    comments++;
                isComment=false;
            }
            if(!isComment && str.contains("//") && !checkIfItIsPrintStatement(str))
                comments++;
        }
        System.out.println("TotalLine " + totalLines);
        System.out.println("blankLines " + blankLines);
        System.out.println("comments " + comments);
    }

    private static boolean checkIfItIsPrintStatement(String str) {
        return str.contains("\"");//Checking in case of System.out.println()
    }
}
