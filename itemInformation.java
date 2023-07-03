import java.text.*;
import java.util.Date;

class itemInformation {
    private String itemId;
    private String itemName;
    private Date datePurchase;
    private double itemPrice;

    public itemInformation(String itemId, String itemName, Date datePurchase, double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.datePurchase = datePurchase;
        this.itemPrice = itemPrice;
    }
    
       itemInformation(){
       String itemId = "";
       String itemName = "";
       double itemPrice = 0.0;
   }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDatePurchase() {
        // Format the date as a string before returning
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(datePurchase);
    }

    public double getItemPrice() {
        return itemPrice;
    }
   
   public void setItemPrice(double itemPrice)
   {
       this.itemPrice = itemPrice;
   }
   
   public String toString() 
   {
       return
       ",Item Identification Number: " + itemId +
       ",Item Name: " + itemName +
       ",datePurchase: " + datePurchase +
       ",Item Price: " + itemPrice;
   }
}
