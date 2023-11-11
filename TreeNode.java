/*
 * This is a first-level class that creates a basic Node for a tree
 * @author Alex Tseng
 * */
public class TreeNode<T> {
	
	TreeNode left, right;
	T data;
	
	public TreeNode(T dataNode) {
		this.left = null;
		this.right = null;
		this.data = dataNode;
	}
	
	public TreeNode(TreeNode<T> node) {
		this.left = node.left;
		this.right = node.right;
		this.data = node.data;
	}
	/*
	 * Retrieves the current instance's data
	 * @return the instance's data
	 * */
	public T getData() {
		return this.data;
	}
	
}