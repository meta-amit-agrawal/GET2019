package Question2;

//POJO class to create the node with the following properties
public class Node 
{
	
	String data;
    Node next;
    
    //parameterized constructor to initialize the properties
    public Node(String data) {
        this.data=data;
        this.next=null;
    }

    //This method will return the data of the node 
    public String getData() {
        return this.data;
    }

    //This method will return the next node location 
    public Node getNext() {
        return this.next;
    }

    //This method will set the next node location
    public void setNext(Node node) {
        this.next=node;
    }
	
}
