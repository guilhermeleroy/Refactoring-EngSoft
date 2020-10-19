public abstract class Statement {
    public abstract String header(Customer aCustomer);
    public abstract String body(Rental each);
    public abstract String footer(Customer aCustomer);
}