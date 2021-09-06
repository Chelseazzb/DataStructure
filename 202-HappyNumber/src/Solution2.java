import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    //求和函数
    private int next (int n){
        int sum = 0;
        while ( n > 0 ){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();

        while (!sum.contains(n)){
            sum.add(n);
            n = next(n);
        }

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}
