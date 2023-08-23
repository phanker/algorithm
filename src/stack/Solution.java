package stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        if(null == s || s.length() < 1 || s.length() % 2 != 0){
            return 0;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for (Character k : charArray){
            if('(' == k){
                stack.push(k);
            }else{
                int score;
                //开始计算分数
                char c = stack.pop();
                if(c == '('){
                    score = 1;
                }else{
                    score = (c - '0')*2;
                    if(!stack.isEmpty()){
                        stack.pop();//把'('也弹出去
                    }
                }

                if(!stack.isEmpty() && stack.peek() != '('){
                    score += (stack.pop()-'0');
                }
                stack.push((char)(score+'0'));
            }
        }

        return stack.pop() - '0';
    }

    public static void main(String[] args) {
        int i = new Solution().scoreOfParentheses("(()(()))");
        System.out.println(i);
    }



    List<Character> symbel = new ArrayList() { {

    }};

}