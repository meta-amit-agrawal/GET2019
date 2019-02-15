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
    let element=document.getElementById("add").value;
    if(element=="") return -1;
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
    this.size++; 
  
} 


     
removeElement() 
{ 
    let element=document.getElementById("add").value;
	var current = this.head; 
	var prev = null; 

	while (current != null) { 
		
		if (current.element === element) { 
			if (prev == null) { 
				this.head = current.next; 
			} else { 
				prev.next = current.next; 
			} 
			return current.element; 
		} 
		prev = current; 
		current = current.next; 
    } 
    
	return -1; 
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
    
	document.getElementById("linked").innerHTML=str; 
} 

} 
let object=new LinkedList();