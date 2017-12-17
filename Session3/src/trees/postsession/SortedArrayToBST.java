package trees.postsession;

import trees.TreeNode;

import java.util.List;

/**
 * Created by saip92 on 12/16/2017.
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return sortedArrayToBSTHelper(a , 0 , a.size()-1);
    }

    public TreeNode sortedArrayToBSTHelper(List<Integer> a, int start , int end){
        if(end < start) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = sortedArrayToBSTHelper(a, start, mid - 1);
        node.right = sortedArrayToBSTHelper(a, mid + 1, end);

        return node;
    }

}
