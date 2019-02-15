class Node{
    constructor(element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList{
    constructor(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    addDouble(){
        var value = document.getElementById("getValueDouble").value;
        var position = document.getElementById("getPositionDouble").value;
        if(value == null) {
            alert("Element Can't be null");
        }
        else{
            if(position == null){

                var node = new Node(element); 

                if(this.head == null){
                    this.head = node; 
                    console.log("added");
                }
            }
        }
    }
}

let object = new LinkedList();