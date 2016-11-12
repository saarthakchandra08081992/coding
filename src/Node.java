
public class Node {

	private int key;
	private Node left;
	private Node right;
	
	public Node(int key){
		this.key = key;
		this.left=null;
		this.right=null;
	}
	
	public Node getLeft(){
		return this.left;
	}
	
	public Node getRight(){
		return this.right;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public int getKey(){
		return this.key;
	}
	
}
