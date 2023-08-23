package stack;

import java.util.Stack;

/**
 * 单调栈
 */
class StockSpanner {

    static class Stock{
        int price;
        int span;

        public Stock(int price,int span){
            this.price = price;
            this.span = span;
        }
    }

    Stack<Stock> stock;

    public StockSpanner() {
        stock = new Stack<Stock>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stock.isEmpty() && stock.peek().price < price){
            Stock s = stock.pop();
            span += s.span;
        }
        stock.push(new Stock(price,span));
        return span;
    }


}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */