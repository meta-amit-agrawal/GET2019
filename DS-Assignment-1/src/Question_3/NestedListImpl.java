package Question_3;
import org.json.simple.JSONArray;


public class NestedListImpl implements NestedList 
{
	LinkedList nestedList = new LinkedList();

	public NestedListImpl(JSONArray jsonArray) throws Exception 
	{
		if(jsonArray == null)
		{
			throw new Exception("Json object should not be null");
		}
		else
		{
			createNestList(jsonArray);
			nestedList = createNestList(jsonArray);
		}
	}
	
	private LinkedList createNestList(JSONArray jsonArray) throws Exception 
	{
		LinkedList sublist = new LinkedList();
		for(Object object : jsonArray)
		{
			if(object!=null)
			{
				if(object instanceof Long)
				{
					long value = (Long) object;
					sublist.add(value);
				}
				else
				{
					JSONArray newJsonArray = (JSONArray) object;
					LinkedList list = createNestList(newJsonArray);
					sublist.add(list);
				}
			}
		}
		return sublist;
	}

	@Override
	public Long getSum() 
	{
		Node head = nestedList.getHead();
		return sumOfAllValues(head);
	}
	
	private Long sumOfAllValues(Node node)
	{
		Long sum = (long) 0;
		if(node != null)
		{
			while(node != null)
			{
				if(node.getData() instanceof Long)
				{
					sum += (Long) node.getData();
					node = node.getNext();
				}
				else
				{
					Node head = ((LinkedList)node.getData()).getHead();
					node = node.getNext();
					sum += sumOfAllValues(head);
				}
			}
		}
		return sum;
	}

	@Override
	public Long getMaxValue() 
	{
		Node head = nestedList.getHead();
		return getMaxValueFromList(head);
	}

	private Long getMaxValueFromList(Node node) 
	{
		Long max = (long) 0;
		
		if(node != null)
		{
			while(node != null)
			{
				if(node.getData() instanceof Long)
				{
					if(max < (Long) node.getData())
					{
						max= (Long) node.getData();
					}
					node = node.getNext();
				}
				else
				{
					Node head = ((LinkedList)node.getData()).getHead();
					node = node.getNext();
					max = (long) getMaxValueFromList(head);
				}
			}
		}
		
		return max;
	}

	@Override
	public boolean isValueAvailable(int value)
	{
		Node head = nestedList.getHead();
		return searchValue(head, value);
	}
	
	private boolean searchValue(Node node, int value) 
	{
		if(node != null)
		{
			while(node != null)
			{
				if(node.getData() instanceof Long)
				{
					if(value == (Long) node.getData())
					{
						return true;
					}
					node = node.getNext();
				}
				else
				{
					Node head = ((LinkedList)node.getData()).getHead();
					node = node.getNext();
					return searchValue(head, value);
				}
			}
		}
		return false;
	}
	
}
