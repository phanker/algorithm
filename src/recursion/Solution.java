package recursion;

class Solution {
    public static void main(String[] args) {
        double v = new Solution().myPow(2, -2);
        System.out.println(v);
    }
    public double myPow(double x, int n) {
        boolean flag = false;
        double result = 0;
        if( n == 0){
            return 1;
        }
        if( n < 0){
            flag = true;
            n = 0-n;
        }
        if (n == 1){
            result = x;
        }else if(n == 2){
            result  = x * x;
        }else if(n % 2 == 0){
            double a = myPow(x,n/2);
            result = a*a;
        }
        else if(n % 2 == 1)   {
            double a = myPow(x,n/2);
            result = a*a*x;
        }
        if(flag){
            result = 1/ result;
        }
        return result;

    }
}