package stack;

import java.util.HashMap;
import java.util.Stack;

class Solution1 {
    HashMap<Character, Character> hmLambda = new HashMap<Character, Character>() { {
        put('(',')');
        put('[', ']');
        put('{', '}');
    }};
   


    public boolean isValid(String s) {
         if(s.length() % 2 != 0){
             return false;
         }
         Stack<Character> stack = new Stack<Character>();
         char[] charArray = s.toCharArray();
         for(Character k : charArray){
             if(hmLambda.containsKey(k)){
                stack.push(k);
             }else{
                if(stack.isEmpty() || k != hmLambda.get(stack.pop())){
                    return false;
                }
             }
         }
         return true;
    }

    public static void main(String[] args) {
        boolean valid = new Solution1().isValid("()");
        System.out.println(valid);
    }
}