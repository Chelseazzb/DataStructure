public class Solution1 {

    /*
     * 思路：
     *定义四个方向上下左右，从左至右开始遍历，走到不能走为止(碰到左右边界)。
     *跳出循环的条件：index=数组元素个数
     */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        /**定义四个边界：上下左右（即已经走过或不能走的位置）**/
        int up=0; int down=matrix.length-1;
        int left=0; int right=matrix[0].length-1;
        //数组元素个数
        int[] res=new int[matrix.length*matrix[0].length];
        //index指向当前遍历的元素
        int index=0;
        while(index<res.length){
            for(int i=left;i<=right;i++){ //从左至右遍历
                res[index++]=matrix[up][i];
            }
            if(++up>down) break; //++up代表已走过，判断条件代表不能超出边界
            //up++;//代表已走过,下次从up+1开始走
            for(int i=up;i<=down;i++){//从上至下遍历
                res[index++]=matrix[i][right];
            }
            if(--right<left) break;
            //right--;
            for(int i=right;i>=left;i--){//从右至左遍历
                res[index++]=matrix[down][i];
            }
            if(--down<up) break;
            //down--;
            for(int i=down;i>=up;i--){//从下至上遍历
                res[index++]=matrix[i][left];
            }
            if(++left>right) break;
            //left++;
        }
        return res;
    }
}
