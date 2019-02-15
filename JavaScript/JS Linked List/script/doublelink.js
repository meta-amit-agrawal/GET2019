class Node1{
    constructor(element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList1{
    constructor(){
        this.size = 0;
        this.head = null;
            
    }

    addDouble(){
        var value = document.getElementById("getValueDouble").value;
        var position = document.getElementById("getPositionDouble").value;
        if(value == "") {
            alert("Element Can't be null");
        }
        else{
            if(position == ""){

                var node = new Node1(value); 

                if(this.head == null){
                    this.head = node; 
                    this.size++;

                }
                else{
                    var currentNode = this.head;
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = node;
                    node.prev = currentNode;
                    this.size++;
                }
            }
            else{
                if(position <0 || position >this.size){
                    alert("Position is out of range!!");
                }
                else{
                    var node = new Node1(value); 
                    var curr , prev;
                    curr = this.head;

                    if(position == 0){
                        node.next=this.head;
                        this.head = node;
                        node.prev = null;
                        this.size++;
                    }
                    else{
                        curr = this.head;
                        var it=0;
                        while(it<position){
                            it++;
                            prev=curr;
                            curr = curr.next;
                        }
                        node.next = curr;
                        prev.next = node;
                        node.prev = prev;
                        curr.prev = node;
                        this.size++;
                    }
                }
            }
            document.getElementById("getValueDouble").value="";
            document.getElementById("getPositionDouble").value="";
            this.printListDouble();
        }
    }

    deleteDouble(){
        var value = document.getElementById("getValueDouble").value;
        var current = this.head; 
	    var prev = null; 
        if(this.size == 0){
            alert("List is Empty");
        }
        else if(value == ""){
            alert("Input Can't be null");
        }
        else{
            while(current != null){

                if(current.element == value){
                    
                    if(current.next){
                        current.next.prev = current.prev;
                    }
                    else{

                    }
                    if(current.prev){
                        current.prev.next = current.next;
                    }
                    else{
                        this.head = current.next;
                        if(this.head){
                            this.head.prev = null;
                        }
                    }
                }
                current = current.next;
            }
        }

        document.getElementById("getValueDouble").value="";
        document.getElementById("getPositionDouble").value="";
        this.printListDouble();
    }

    printListDouble() 
    { 
	var curr = this.head; 
	var str = ""; 
	while (curr) { 
		str += curr.element + " "; 
		curr = curr.next; 
    } 
    if(str=="") alert("no element");
    
	document.getElementById("resultDouble").innerHTML=str; 
    } 

}

let doubleObject = new LinkedList1();