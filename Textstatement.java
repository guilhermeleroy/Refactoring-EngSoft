import java.util.Enumeration;

public class TextStatement extends Statement {
   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = this.header(aCustomer);

      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += this.body(each);
      }
      
      //add footer lines
      result += this.footer(aCustomer);

      return result;
   }

   public String header(Customer aCustomer) {
     return "Rental Record for " + aCustomer.getName() + "\n";
   }

   public String body(Rental each) {
     return "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(each.getCharge()) + "\n";
   }

   public String footer(Customer aCustomer) {
     String result = "Amount owed is " +
                      String.valueOf(aCustomer.getTotalCharge()) + "\n";
    result += "You earned " +
              String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
              " frequent renter points";
    return result;
   }
}