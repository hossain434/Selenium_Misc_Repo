package PageObjectsDesignUsingFluentStyle2;
public class OrderSummaryPage extends Page{
    
    public void enterCC(){
        System.out.println("entering credit card details");
    }
    
    public void enterBillingAddress(){
        System.out.println("entering billing address");
    }

    @Override
    public boolean isAt() {
        return true;
    }

}