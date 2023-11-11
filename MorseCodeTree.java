import java.util.ArrayList;
/*
 * Second-level class that constructs a binary tree with corresponding morse code
 * @author Alex Tseng
 * */
public class MorseCodeTree implements LinkedConverterTreeInterface {
	
	private TreeNode<String> root;
	
	public MorseCodeTree() {
		buildTree();
	}
	/*
	 * Retrieves the root
	 * @return the root
	 * */
	@Override
	public TreeNode getRoot() {
		return this.root;
	}
	/*
	 * Sets the current root with a new root
	 * @param newNode is the new root
	 * */
	@Override
	public void setRoot(TreeNode newNode) {
		this.root = newNode;
	}
	/*
	 * Inserts a TreeNode in the correct position
	 * @param code is the morse code, result is the letter of the morse code
	 * */
	@Override
	public void insert(Object code, Object result) {
		addNode(root, code, result);
	}
	/*
	 * Recursive method that traverses the tree to add a new TreeNode
	 * @param root is the current TreeNode that will be looked at, 
	 * code is the morse code, and letter is a letter corresponding to the code
	 * */
	@Override
	public void addNode(TreeNode root, Object code, Object letter) {
		// base case
		if (((String) code).length() == 1) {
			if (((String)code).equals(".")) {
				root.left = new TreeNode<String>((String) letter);
			}
			else {
				root.right = new TreeNode<String>((String) letter);
			}
		}
		// recursive case
		else {
			String modified = ((String) code).substring(1); // for every character
			if (((String)code).charAt(0) == '.') {
				addNode(root.left, modified, letter);
			}
			else {
				addNode(root.right, modified, letter);
			}
		}
	}
	/*
	 * Returns the letter associated with the specified code
	 * @param a morse code
	 * @return the letter corresponding to the morse code
	 * */
	@Override
	public Object fetch(String code) {
		return fetchNode(root, code);
	}
	/*
	 * Recursively traverses the tree to find a specific letter
	 * @param root is the current TreeNode to look at, code is a morse code to find
	 * @return the letter corresponding to the morse code
	 * */
	@Override
	public Object fetchNode(TreeNode root, Object code) {
		String letter = "";
		
		// base case
		if (((String) code).length() == 1) {
			if (((String)code).equals(".")) {
				return letter + root.left.data;
			}
			else {
				return letter + root.right.data;
			}
		}
		// recursive case
		else {
			String modified = ((String) code).substring(1); // for every character
			if (((String)code).charAt(0) == '.') {
				letter += fetchNode(root.left, modified);
			}
			else {
				letter += fetchNode(root.right, modified);
			}
		}
		
		return letter;
	}

	@Override
	public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/*
	 * Builds a binary tree of morse code
	 * */
	@Override
	public void buildTree() {
		this.root = new TreeNode<String>("");
		
		// level 1
		insert(".", "e");
		insert("-", "t");
		
		// level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		// level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	/*
	 * Converts the tree to an ArrayList
	 * @return an ArrayList of the tree
	 * */
	@Override
	public ArrayList toArrayList() {
		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(root, list);
		
		return list;
	}
	/*
	 * Recursively traverses the tree and appends their data to the list
	 * @param root is the current TreeNode to look at, list is the ArrayList to be modified
	 * */
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list); // first left subtree
			list.add(root.getData());
			LNRoutputTraversal(root.right, list); // then right subtree
		}
		
	}
	
}