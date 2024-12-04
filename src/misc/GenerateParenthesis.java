package misc;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(int n, int open, int close, StringBuilder soFar){
        if(soFar.length() == 2*n) {
            result.add(soFar.toString());
            return;
        }

        //System.out.println("open:" + open + " close: " + close + " " + soFar.toString());

        if(open < n) {
            soFar.append('(');
            helper(n, open + 1, close,  soFar);
            soFar.deleteCharAt(soFar.length()-1);
        }
        if (close < open ){
            soFar.append(')');
            helper(n, open, close + 1,  soFar);
            soFar.deleteCharAt(soFar.length()-1);
        }
    }

}
