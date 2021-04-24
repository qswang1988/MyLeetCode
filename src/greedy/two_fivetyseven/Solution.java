package greedy.two_fivetyseven;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.right = five;
        List<String> list = new Solution().binaryTreePaths(one);
        System.out.println(list);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        search_branch(root,new StringBuilder(),list);
        return list;
    }
    public void search_branch(TreeNode root, StringBuilder sb, List<String> list){
        sb.append(root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(right==left) {
            list.add(sb.toString());
            return;
        }
        String sb_n = sb.append("->").toString();
        if (left != null)
            search_branch(left, sb, list);
        if (right != null)
            search_branch(right, (left == null)?sb:new StringBuilder(sb_n), list);
    }
/*    public void search_branch(TreeNode root, StringBuilder sb, List<String> list){

        sb.append(root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left!=null&&right==null) {
            search_branch(left, sb.append("->"), list);
        }else if(right!=null&&left==null){
            search_branch(right,sb.append("->"),list);
        }else if(right!=null&&left!=null){
            String sb_n = sb.append("->").toString();
            search_branch(left, new StringBuilder(sb_n), list);
            search_branch(right,new StringBuilder(sb_n),list);
        }else if(right==null&&left==null){
            list.add(sb.toString());
        }
    }*/
}
