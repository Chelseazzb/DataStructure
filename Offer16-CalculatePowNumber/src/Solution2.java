public class Solution2 {

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 1/x * myPow(1/x,-n-1); //注意：当n为负数时，Java中因为n的最小值可以取到Integer.MIN_VALUE，如果直接取它的相反数的话还是它自己，会导致堆栈溢出，因此提一个x出来。
        }else if(n%2 == 0){
            return myPow(x*x,n/2);
        }else if(n%2 != 0){
            return x * myPow(x*x,n/2);
        }
        return 0;
    }
}
