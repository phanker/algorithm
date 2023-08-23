package stack;

import java.util.Stack;

public class RainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>(); // 单调递减栈，存储柱子的索引
        int result = 0; // 雨水总量
        
        for (int current = 0; current < height.length; current++) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int topIndex = stack.pop(); // 弹出栈顶柱子的索引
                
                if (stack.isEmpty()) {
                    break;
                }
                
                int prevIndex = stack.peek(); // 前一根柱子的索引
                int distance = current - prevIndex - 1; // 计算距离
                int boundedHeight = Math.min(height[current], height[prevIndex]) - height[topIndex]; // 计算有效高度
                result += distance * boundedHeight; // 计算雨水面积并累加到结果中
            }
            
            stack.push(current); // 当前柱子索引入栈
        }
        
        return result; // 返回雨水总量
    }

    public static void main(String[] args) {
        int trap = new RainWater().trap(new int[]{2, 3, 1, 1, 4});
        System.out.println(trap);
    }
}
