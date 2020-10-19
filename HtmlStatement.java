import java.util.Enumeration;

public class HtmlStatement extends Statement {
  public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = this.header(aCustomer);

      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for each rental
         result += this.body(each);
      }

      //add footer lines
      result += this.footer(aCustomer);
      return result;
  }

  public String header(Customer aCustomer) {
    return "<H1>Rentals for <EM>" + aCustomer.getName() +
          "</EM></H1><P>\n";
  }

  public String body(Rental each) {
    return each.getMovie().getTitle() + ": " +
          String.valueOf(each.getCharge()) + "<BR>\n";
  }

  public String footer(Customer aCustomer) {
    String result = "<P>You owe <EM>" +
                    String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
    return result;
  }
}