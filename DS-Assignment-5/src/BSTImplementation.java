import java.util.ArrayList;
import java.util.List;

public class BSTImplementation implements BST 
{
	Node root;
	
	public BSTImplementation() 
	{
		root=null;
	}
	
	/**
	 * isEmpty method checks whether tree is empty or not
	 * @return true if tree is empty else false
	 */
	@Override
	public boolean isEmpty() 
	{
		if(root==null)
			return true;
		return false;
	}
	
	/**
	 * add method to add the node with key and value in the tree
	 * @param key assumes to be not null
	 * @param value assumes to be not null
	 * @return true if node is added into the tree else false
	 */
	@Override
	public boolean add(String key, String value) throws Exception {
		if(isEmpty())
		{
			root = new Node(key,value);
			return true;
		}
		return addData(key, value, root);
	}

	/**
	 * addData is the private helper method to add the data into the tree which uses recursion
	 * @param key
	 * @param value
	 * @param node
	 * @return true if node is added into the tree
	 * @throws Exception if key already exists in the tree 
	 */
	private boolean addData(String key, String value, Node node) throws Exception 
	{
		//if key is greater than node key -> move to right
		if(key.compareTo(node.getKey()) >= 1)
		{
			//if node contains more right node
			if(node.getRightChild()!=null)
			{
				addData(key, value, node.getRightChild());
			}
			//add the node to right 
			else
			{
				node.setRightChild(new Node(key,value));
				
			}
			return true;
		}
		
		//if key is smaller than node key -> move to left
		if(key.compareTo(node.getKey()) <= -1)
		{
			//if node contains more left node
			if(node.getLeftChild()!=null)
			{
				addData(key, value, node.getLeftChild());
			}
			//add the node to left 
			else
			{
				node.setLeftChild(new Node(key, value));
			}
			return true;
			
		}
		//if key already exists
		throw new Exception("Key already Exist");
	}

	/**
	 * delete method to delete from the tree with respect to given key
	 * @return true if node is deleted from the tree
	 */
	@Override
	public boolean delete(String key) throws Exception 
	{
		deleteNode(root, key);
		return true;
	}

	/**
	 * deleteNode is the private helper method which helps to delete the node from the tree and
	 * uses recursion to delete the node from the tree
	 * @param node
	 * @param key 
	 * @throws Exception if node is not available of given key
	 */
	private void deleteNode(Node node, String key) throws Exception 
	{
		Node parent=null;
		
		//find the parent node and that particular node which contains the given key
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
		//if none of the node contains the given key
		if(node == null)
		{
			throw new Exception("Node not available in tree");
		}
		
		//if node doesn't have any children
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
		
		//if node has two children
		else if(node.getLeftChild()!=null && node.getRightChild()!=null)
		{
			Node successor = minValue(node.getRightChild());
			String val = successor.getValue();
			String key1 = successor.getKey();
			
			deleteNode(root, successor.getKey());
			
			node.setKey(key1);
			node.setValue(val);
		}
		
		//if node has only one children
		else
		{
			Node child = (node.getLeftChild()!=null) ? node.getLeftChild() : node.getRightChild();
			
			if(node != root)
			{
				if(node == parent.getLeftChild())
				{
					parent.setLeftChild(child);
				}
				else
				{
					parent.setRightChild(child);
				}
			}
			else
			{
				root=child;
			}
			
		}
	}
	
	/**
	 * minValue method is private helper method to find the minimum value below the given node
	 * @param node 
	 * @return the node which contains the minimum value
	 */
	private Node minValue(Node node) 
	{
		if(node.getLeftChild()!=null)
		{
			return minValue(node.getLeftChild());
		}
		return node;
		
	}

	/**
	 * findValue method finds the value of the given key
	 * @return the value 
	 * @throws Exception if tree is empty or if key doesn't exist
	 */
	@Override
	public String findValue(String key) throws Exception 
	{
		if(isEmpty())
		{
			throw new Exception("Tree is Empty");
		}
		else if(!checkKey(key))
		{
			throw new Exception("Key doesn't Exist");
		}
		else
		{
			Node node =  findValueOfKey(root , key);
			return node.getValue();
		}
	}
	
	//helper method to find the value of the given key
	private Node findValueOfKey(Node node, String key) throws Exception 
	{
		
		if(key.equals(node.getKey()))
		{
			return node;
		}
		else if(key.compareTo(node.getKey()) <= -1)
		{
			return findValueOfKey(node.getLeftChild(),key);
		}
		else if(key.compareTo(node.getKey()) >= 1)
		{
			return findValueOfKey(node.getRightChild(),key);
		}
		else
			return null;
	}
	
	/**
	 * getAll method returns the list of data which contains key and value 
	 * @return list which contains key and value of all node
	 * @throws Exception if tree is empty
	 */
	@Override
	public List<Data> getAll() throws Exception {
		List<Data> dataList = new ArrayList<>();
		if(isEmpty())
		{
			throw new Exception("Tree is empty");
		}
		dataList = inorder(root, dataList);
		return dataList;
	}
	
	//this method returns the list of data which contains key and value in sorted order 
	private List<Data> inorder(Node node, List<Data> dataList) 
	{
		if(node!=null)
		{
			inorder(node.getLeftChild(), dataList);
			dataList.add(new Data(node.getKey(), node.getValue()));
			inorder(node.getRightChild(), dataList);
		}
		return dataList;
	}
	
	/**
	 * getBetweenKeys method returns the list of node available in between the given tow keys
	 * @param key1 assumes not null
	 * @param key2 assumes not null
	 * @return list which contains the node between two given keys
	 * @throws Exception if any is not available in the tree
	 */
	@Override
	public List<Data> getBetweenKeys(String key1, String key2) throws Exception
	{
		if(checkKey(key1) && checkKey(key2))
		{
			List<Data> subList = new ArrayList<>();
			for(Data d : getAll())
			{
				if(key1.compareTo(d.getKey()) <= 0 && key2.compareTo(d.getKey()) >= 0)
					subList.add(d);
			}
			return subList;
		}
		
		throw new Exception("Key Doesn't Exist");
		
	}
	
	//private helper method to check whether given key is available in the tree or not
	private boolean checkKey(String key) throws Exception 
	{
		for(Data d : getAll())
			if(key.equals(d.getKey()))
				return true;
		return false;
	}

}
