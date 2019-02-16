String.prototype.repeatify=function(n) {
    
    str="";
    for(let i=0;i<n;i++) {
        str+=this;
    }
    return str;

};
function repeat() {
   try{
    let n = document.getElementById("add1").value;
    let string= document.getElementById("add").value;
    if(n=="")
    {
        alert("Number can't be null");
    }
    else{
        if(string==""){
            alert("String can't be null");
        }
        else{
            document.getElementById("show").innerHTML=string.repeatify(n);
        }
    }
   }
   catch(err){
       console.log(err.message);
   }
    
    
  
    
}