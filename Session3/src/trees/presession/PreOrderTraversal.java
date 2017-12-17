package trees.presession;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by saip92 on 12/11/2017.
 */
public class PreOrderTraversal {


    public ArrayList<Integer> preorderTraversal(TreeNode a) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(a != null || !stack.isEmpty()){
            if(a != null){
                stack.push(a);
                result.add(a.val);
                a = a.left;
            }else{
                a = stack.pop();
                a = a.right;
            }
        }

        return result;
    }

}
