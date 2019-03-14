
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
	public boolean delete(String key) throws Exception 
	{
		deleteNode(root, key);
		return false;
	}

	private void deleteNode(Node node, String key) throws Exception 
	{
		Node parent=null;
		while(node!=null && !node.getKey().equals(key))
		{
			parent = node;
			if(key.compareTo(node.getKey())<=-1)
			{
				node = node.getLeftChild();
			}
			else
			{
				node = node.getRightChild();
			}
		}
		if(node == null)
		{
			throw new Exception("Node not available in tree");
		}
		
		if(node.getLeftChild()==null && node.getRightChild()==null)
		{
			if(node != root)
			{
				if(parent.getLeftChild() == node)
				{
					parent.setLeftChild(null);
				}
				else 
				{
					parent.setRightChild(null);
				}
			}
			else
			{
				root = null;
			}
		}
		
		else if(node.getLeftChild()!=null && node.getRightChild()!=null)
		{
			Node successor = minValue(node.getRightChild());
			
			
		}
	}

	@Override
	public String findValue() {
		
		return null;
	}
	
	public static void main(String args[]) 
	{
		BST bst = new BSTImplementation();
		try {
			bst.add("b", "one");
			bst.add("a", "Two");
			bst.add("d", "Three");
			bst.add("e", "Four");
			bst.add("c", "Five");
			bst.delete("e");
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		bst.inOrder();
	}

	@Override
	public Node minValue(Node node) 
	{
		if(node.getLeftChild()!=null)
		{
			return minValue(node.getLeftChild());
		}
		return node;
		
	}
	
}
