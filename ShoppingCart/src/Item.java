import java.util.ArrayList;


public class Item {
	 String productName=new String();
	 float productPrice;
	 int productID;
	 int productQty;
	 
	 public void setProductName(String productName)
	 {
		 this.productName=productName;
	 }
	 public void setProductPrice(float productPrice)
	 {
		 this.productPrice=productPrice;
	 }
	 public void setProductId(int productID)
	 {
		 this.productID=productID;
	 }
	 public void setProductQty(int productQty)
	 {
		 this.productQty=productQty;
	 }
	 public String getProductName()
	 {
		 return productName;
	 }
	 public float getProductPrice()
	 {
		 return productPrice;
	 }
	 public int getProductId()
	 {
		 return productID;
	 }
	 public int getProductQty()
	 {
		 return productQty;
	 }

}
