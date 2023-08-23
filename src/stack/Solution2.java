package stack;

import java.util.Stack;

/**
 * 接雨水
 */
public class Solution2 {
    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack();//创建一个单调栈,是小顶单调栈
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                Integer top = stack.pop();
                if(stack.isEmpty()){
                    //栈空 表示没有墙了
                    break;
                }
                //算出当前墙面与前面的墙面相隔数
                int destination = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[i]);
                result += destination*(min - height[top]);
            }
            stack.push(i);
        }
        return result;
    }
}
