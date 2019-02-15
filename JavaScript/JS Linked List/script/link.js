class Node { 
	constructor(element) 
	{ 
		this.element = element; 
		this.next = null
	} 
} 
 
class LinkedList { 
	constructor() 
	{ 
		this.head = null; 
		this.size = 0; 
	} 

	 
add() 
{ 
	let element=document.getElementById("getValue").value;
	let position = document.getElementById("getPosition").value;
    if(element==""){
		alert("Input can't be null");
	}
	else if(position != ""){
	
    	if (position < 0 || position > this.size) {
			alert("Position entered out of range");
		}
    	else { 
       
    		var node = new Node(element); 
        	var curr, prev; 
  
        	curr = this.head; 
   
        	if (position == 0) { 
            	node.next = this.head; 
				this.head = node; 
				console.log("hello");
			} 
			else { 
            	curr = this.head; 
            	var it = 0; 
  
            	while (it < position) { 
                	it++; 
                	prev = curr; 
                	curr = curr.next; 
            	} 
  
            node.next = curr; 
            prev.next = node; 
        	} 
			this.size++; 
			document.getElementById("getValue").value="";
			document.getElementById("getPosition").value="";
			this.printList();
		} 

	}
	else{
		var node = new Node(element); 

		var current; 

		if (this.head == null) 
			this.head = node; 
		else { 
			current = this.head; 

		
			while (current.next) { 
				current = current.next; 
			}  
			current.next = node; 
		} 
		document.getElementById("getValue").value="";
    	this.size++; 
		this.printList();
	}
} 
     
removeElement() 
{ 
    let element=document.getElementById("getValue").value;
	var current = this.head; 
	var prev = null; 
	var flag=0;

	if(this.size == 0){
		alert("List is Empty");
	}
	else{
		while (current != null) { 
		
			if (current.element === element) { 
				if (prev == null) { 
					this.head = current.next; 
				} else { 
					prev.next = current.next; 
				} 
				this.size--;
				flag=1;
			} 
			prev = current; 
			current = current.next; 
		} 
		if(flag==0){
			alert("ELement Not found");
		}
		else{
			this.printList();
		}
	}
	document.getElementById("getValue").value="";
	
	
} 

printList() 
{ 
	var curr = this.head; 
	var str = ""; 
	while (curr) { 
		str += curr.element + " "; 
		curr = curr.next; 
    } 
    if(str=="") alert("no element");
    
	document.getElementById("resultSingle").innerHTML=str; 
} 

} 
let object=new LinkedList();