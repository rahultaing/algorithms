import java.util.List;

// https://www.geeksforgeeks.org/merge-two-balanced-binary-search-trees/

public class MergeBST{

    private List<Integer> listFromTree;

    public TreeNode merge(TreeNode node1, TreeNode node2){

        List<Integer> list1 = this.treeToList(node1);
        List<Integer> list2 = this.treeToList(node2);
        List<Integer> mergedList = this.mergeList(list1, list2);
        return this.treeFromList(mergedList);
    }

    public TreeNode treeFromList(List<Integer> list){

        return this.recursiveTreeFromList(list, 0, list.size() - 1);
    }

    private TreeNode recursiveTreeFromList(List<Integer> list, int start, int end){

        if (start>end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode node = new TreeNode(list.get(mid));
        node.left = this.recursiveTreeFromList(list, start, mid-1);
        node.right = this.recursiveTreeFromList(list, mid+1, end);
        return node;
    }

    public List<Integer> treeToList(TreeNode node){
        this.listFromTree = new ArrayList<>();
        this.recursiveTreeToList(node);
        return this.listFromTree;
    }

    private void recursiveTreeToList(TreeNode node){
        if (node == null){
            return;
        }

        this.recursiveTreeToList(node.left);
        this.listFromTree.add(node.val);
        this.recursiveTreeToList(node.right);
    }

    public List<Integer> mergeList(List<Integer> list1, List<Integer> list2){

        int n = list1.size();
        int m = list2.size();

        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();

        while (i < n && j < m){

            if (list1.get(i) < list2.get(j)){
                list.add(list1.get(i));
                i++;
            }
            else{
                list.add(list2.get(j));
                j++;
            }
        }

        while (i<n){
            list.add(list1.get(i));
            i++;
        }

        while (j<m){
            list.add(list2.get(j));
            j++;
        }

        return list;
    }

    
}