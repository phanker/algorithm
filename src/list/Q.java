package list;

import java.util.*;


public class Q {
    Stack<Integer> a; //进
    Stack<Integer> b; //出
    public Q() {
        a = new Stack<Integer>();
        b = new Stack<Integer>();
    }

    public void appendTail(int value) {
        a.push(value);
    }
    HashMap<Integer, Integer> hmLambda = new HashMap<Integer, Integer>() { { put(0, 1); put(1, 1); } };
    public int deleteHead() {
        HashMap<Character, Character> hmLambda = new HashMap<Character, Character>() { {
            put('(',')');
            put('[', ']');
            put('{', '}');
        }};

        if(b.size() == 0){
            while(a.size() != 0){
                b.push(a.pop());
            }
        }
        return b.size() < 1 ? -1 : b.pop();
    }

    public static void main(String[] args) {
        new Q().deleteHead();
    }
}
