package trees.postsession;

import trees.TreeNode;

/**
 * Created by saip92 on 12/16/2017.
 */
public class BalancedTree {


    public int isBalanced(TreeNode a) {
        return isBalancedHelper(a) != Integer.MIN_VALUE ? 1 : 0;
    }

    public int isBalancedHelper(TreeNode a){
        if( a == null) return -1;

        int left = isBalancedHelper(a.left);
        if(left == Integer.MIN_VALUE) return Integer.MIN_VALUE;


        int right = isBalancedHelper(a.right);
        if(right == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diff = Math.abs(right - left);

        if(diff > 1) return Integer.MIN_VALUE;
        else return Math.max(left,right) + 1;
    }

}
