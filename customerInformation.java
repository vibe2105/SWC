import java.util.LinkedList;

public class customerInformation {
   private String iD;
   private String iC;
   private String counterPaid;
   private int numOfItem; 
   private double totalPayment;
   private LinkedList<itemInformation> itemList;
   
   public customerInformation (String iD, String iC, String counterPaid,int numOfItem,double totalPayment)
   {
       this.iD = iD;
       this.iC = iC;
       this.counterPaid = counterPaid;
       this.numOfItem = numOfItem;
       this.totalPayment = totalPayment;
       this.itemList = new LinkedList<>();
   }
   
   customerInformation(){
       String iD = "";
       String iC = "";
       String counterPaid = "";
       int numOfItem = 0;
       double totalPayment = 0.0;
   }
    
   public String getID()
   {
       return iD;
   }
   
   public void setID(String iD)
   {
       this.iD = iD;
   }
   
   public String getIC()
   {
       return iC;
   }
   
   public void setIC(String iC)
   {
       this.iC = iC;
   }
   
   public String getCounterPaid()
   {
       return counterPaid;
   }
   
   public void setCounterPaid(String counterPaid)
   {
       this.counterPaid = counterPaid;
   }
   
   
   public int getNumOfItem()
   {
       return numOfItem;
   }
   
   public void setNumOfItem(int numOfItem)
   {
       this.numOfItem = numOfItem;
   }
   
   public double getTotalPayment() 
   {
       return totalPayment;
   }
   
   public void setTotalPayment(double totalPayment) 
   {
    this.totalPayment = totalPayment;
   }
   
   public String toString() 
   {
       return
       "Indentification Number: " + iD +
       ",IC Number : " + iC +
       ",Counter Paid : " + counterPaid +
       ", Number Of Item :" + numOfItem +  ", Total Payment :" + totalPayment;

   }
}