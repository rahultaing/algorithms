// https://leetcode.com/problems/n-ary-tree-preorder-traversal/solution/

public class Solution {
    public List<Integer> preorder(NAryTreeNode node) {
        List<Integer> list = new ArrayList<>();

        if (node == null){
            return list;
        }

        Stack<NAryTreeNode> st = new Stack<>();

        st.push(node);

        while (!st.isEmpty()){
            node = st.pop();

            list.add(node.val);
            Collections.reverse(node.children);

            for(NAryTreeNode child: node.children){
                st.push(child);
            }
        }

        return list;
    }
}