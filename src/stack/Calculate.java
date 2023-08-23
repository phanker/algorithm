package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Calculate {
    List<Character> symbels = new ArrayList<Character>(){{
        add('+');
        add('-');
        add('*');
        add('/');
    }};

    Stack<Character> symbel = new Stack();
    Stack<Integer> nums = new Stack<>();
    public int calculate(String s) {

        resoution(s);
        int result = 0;
        while (!nums.isEmpty()){
            result += nums.pop();
        }
        return result;
    }


    private void resoution(String s) {
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(symbels.contains(c)){
                int base = 1;
                int integrate = 0;
                while(j>0){
                    Integer pop = nums.pop();
                    int temp = pop * base;
                    integrate += temp;
                    base = base*10;
                    j--;
                }
                if(symbel.size() > 0){
                    Character peek = symbel.peek();
                    if(peek == '*'){
                        Integer pop = nums.pop();
                        integrate = pop * integrate;
                    }else if(peek == '/'){
                        Integer pop = nums.pop();
                        integrate = pop / integrate;
                    }else if(peek == '-'){
                        integrate = -integrate;
                    }
                }
                nums.push(integrate);
                symbel.push(c);

            }else{
                if(c != ' '){
                    j ++;
                    nums.push(c - '0');
                }

                if(i + 1 == s.length()){
                    int base = 1;
                    int integrate = 0;
                    while(j>0){
                        Integer pop = nums.pop();
                        int temp = pop * base;
                        integrate += temp;
                        base = base*10;
                        j--;
                    }
                    nums.push(integrate);
                }

            }

        }
        Character peek = symbel.peek();
        Integer first = nums.pop();
        Integer second = nums.pop();
        int top = 0;
        if(peek == '*'){
            top = first * second;
        }else if(peek == '/'){
            top = second / first;
        }else if(peek == '-'){
            top = second - first;
        }else{
            top = second + first;
        }
        nums.push(top);
    }

    public static void main(String[] args) {
        int calculate = new Calculate().calculate("1 + 1");
        System.out.println(calculate);
    }
}