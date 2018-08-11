package PageObjectsDesignUsingFluentStyle2;
public class OrderConfirmationPage extends Page{
    
    public void verify(){
        System.out.println("verifying the order confirmation page");
    }

    public void print(){
        System.out.println("printing the order confirmation page");
    }
    
    @Override
    public boolean isAt() {
        return true;
    }

}