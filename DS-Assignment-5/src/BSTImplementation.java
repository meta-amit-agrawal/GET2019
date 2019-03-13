
public class BSTImplementation implements BST 
{
	Node root;
	
	public BSTImplementation() {
		root=null;
	}
	
	@Override
	public boolean add(String key, String value) throws Exception {
		if(root==null)
		{
			root = new Node(key,value);
			return true;
		}
		return addData(key, value, root);
	}

	private boolean addData(String key, String value, Node node) throws Exception 
	{
		
		if(key.compareTo(node.getKey()) >= 1)
		{
			if(node.getRightChild()!=null)
			{
				addData(key, value, node.getRightChild());
			}
			else
			{
				node.setRightChild(new Node(key,value));
				
			}
			return true;
		}
		if(key.compareTo(node.getKey()) <= -1)
		{
			if(node.getLeftChild()!=null)
			{
				addData(key, value, node.getLeftChild());
			}
			else
			{
				node.setLeftChild(new Node(key, value));
			}
			return true;
			
		}
		throw new Exception("Key already Exist");
	}
	
	public void inOrder()
	{
		inorder(root);
	}

	private void inorder(Node node) 
	{
		if(node!=null)
		{
			inorder(node.getLeftChild());
			System.out.println(node.getKey()+"  "+node.getValue());
			inorder(node.getRightChild());
		}
	}

	@Override
	public boolean delete(String key) {
		
		return false;
	}

	@Override
	public String findValue() {
		
		return null;
	}
	
	public static void main(String args[]) 
	{
		BST bst = new BSTImplementation();
		try {
			System.out.println(bst.add("b", "one"));
			System.out.println(bst.add("a", "Two"));
			System.out.println(bst.add("a", "Three"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		bst.inOrder();
	}
	
}
