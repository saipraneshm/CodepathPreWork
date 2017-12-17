package trees.presession;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


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


    public static void main(String[] args) {
        counts(new int[]{2,10,5,4,8},new int[]{3,1,7,8});
    }

    static int[] counts(int[] nums, int[] maxes) {
        HashMap<Integer,Integer> map = new HashMap<> ();

        Arrays.sort(maxes);

        for(int i = 0; i < nums.length; i++){
            int maxesIndex = 0;
            while( maxesIndex < maxes.length){
                if(nums[i] <= maxes[maxesIndex])
                    map.put(maxes[maxesIndex], map.getOrDefault(maxes[maxesIndex],0) + 1);
                maxesIndex++;
            }
        }

        Iterator<Integer> it = map.keySet().iterator();
        int[] result = new int[maxes.length];
        int counter = 0;
        while(it.hasNext()){
            int key = it.next();
            result[counter] = map.get(key);
            counter++;
        }

        return result;
    }
}
