
public class Node 
{
	
	Data data;
	Node leftChild;
	Node rightChild;
	Node parent;
	
	public Node(String key, String value)
	{
		this.data = new Data(key, value);
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String getKey() {
		return data.getKey();
	}

	public String getValue() {
		return data.getValue();
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	
	
	
}
