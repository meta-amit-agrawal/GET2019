package Question4;

//POJO class to store the node
public class Node 
{
	String data;
    Node next;
    
    //create the node with the given data
    public Node(String data) {
        this.data=data;
        this.next=null;
    }

    //returns the data of the node
    public String getData() {
        return this.data;
    }

    //returns the next location of the node
    public Node getNext() {
        return this.next;
    }

    //sets the next ocation into the node
    public void setNext(Node node) {
        this.next=node;
    }
}


