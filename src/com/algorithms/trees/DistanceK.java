/*https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/ */
class Solution {
    HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashSet<TreeNode> seen = new HashSet<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        this.buildParentMap(root, null);

        q.add(target);
        seen.add(target);

        int dist = 0;
        while (!q.isEmpty()){

            int size = q.size();

            if (dist == k){
                for (int i=0; i<size; i++){
                    list.add(q.poll().val);
                }

                return list;
            }

            for (int i=0; i<size; i++){
                TreeNode node = q.poll();

                if (node.left!=null && !seen.contains(node.left)){
                    seen.add(node.left);
                    q.add(node.left);
                }

                if (node.right!=null && !seen.contains(node.right)){
                    seen.add(node.right);
                    q.add(node.right);
                }

                TreeNode par = this.parentMap.get(node);
                if (par!=null && !seen.contains(par)){
                    seen.add(par);
                    q.add(par);
                }
            }

            dist++;
        }

        return list;
    }

    private void buildParentMap(TreeNode node, TreeNode parent){

        if (node!=null){
            this.parentMap.put(node, parent);
            this.buildParentMap(node.left, node);
            this.buildParentMap(node.right, node);
        }
    }
}