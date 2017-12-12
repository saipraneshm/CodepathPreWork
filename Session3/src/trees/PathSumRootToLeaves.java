package trees;

import java.util.ArrayList;


public class PathSumRootToLeaves {

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        return pathSumHelper(root, sum, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>());
    }


    public ArrayList<ArrayList<Integer>>
    pathSumHelper(TreeNode root, int target, int currentSum, ArrayList<Integer> nodes, ArrayList<ArrayList<Integer>> result){
        if(root != null){
            currentSum += root.val;
            nodes.add(root.val);
            if(currentSum == target && root.left == null && root.right == null){
                result.add(new ArrayList<>(nodes));
                nodes.remove(nodes.size()-1);
                return result;
            }else{
                pathSumHelper(root.left,target,currentSum,nodes,result);
                pathSumHelper(root.right,target,currentSum,nodes,result);
            }
            if(!nodes.isEmpty()){
                nodes.remove(nodes.size()-1);
            }
        }

        return result;
    }

}
