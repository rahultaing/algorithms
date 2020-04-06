public class Solution{

    private int modeCount = 0;
    private int curCount = 0;
    private int curValue;
    private int[] modes;
    private int maxCount = 0;
    public int[] findMode(TreeNode node){

        this.inorder(node);
        this.modes = new int[modeCount];
        this.modeCount = 0;
        this.curCount = 0;
        this.inorder(node);
        return modes;
    }

    private void handleValue(int val){

        if (curValue != val){
            curCount = 0;
            curValue = val;
        }

        curCount++;

        if (this.curCount > this.maxCount){
            this.modeCount = 1;
            this.maxCount = this.curCount;

        }else if (this.curCount == this.maxCount){

            if (this.modes != null){
                this.modes[this.modeCount] = curValue;
            }

            this.modeCount++;
        }

    }

    private void inorder(TreeNode node){

        if (node == null){
            return;
        }

        this.inorder(node.left);
        this.handleValue(node.val);
        this.inorder(node.right);
    }
}