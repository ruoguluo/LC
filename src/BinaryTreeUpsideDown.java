
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null) return null;
        TreeNode leftChild = root.left;
        TreeNode rightChild =root.right;
        while (leftChild!=null){
 
            TreeNode leftLeft = leftChild.left;
            TreeNode leftRight = leftChild.right;
            
            leftChild.left=rightChild;
            leftChild.right=root;
            
            root = leftChild;
            leftChild=leftLeft;
            rightChild=leftRight;
        }
        return root;
    }
 
    
    public static void main(String[] args) {
    	TreeNode tr0 = new TreeNode(1);
    	TreeNode tr1 = new TreeNode(2);
    	TreeNode tr2= new TreeNode(3);
    	tr0.left=tr1;
    	tr0.right=tr2;
    	BinaryTreeUpsideDown btud = new BinaryTreeUpsideDown();
    	TreeNode newRoot = btud.upsideDownBinaryTree(tr0);
    	System.out.println(newRoot.val);
    	System.out.println(newRoot.left.val);

    	System.out.println(newRoot.right.val);
    	//System.out.println(newRoot.right.right.val);
    }
}
