package PageObjectsDesignUsingFluentStyle2;

import java.util.function.Consumer;

public class RegistrationWorkflow {
    
	  //This is static to give an entry point
	    public static RegistrationWorkflow userDetailsPage(Consumer<UserDetailsPage> c){
	        UserDetailsPage p = new UserDetailsPage( );
	        c.accept(p);
	        return new RegistrationWorkflow();
	    }

	    public RegistrationWorkflow productSearchPage(Consumer<ProductSearchPage> c){
	        ProductSearchPage p = new ProductSearchPage();
	        this.waitForPageLoad(p);
	        c.accept(p);
	        return this;
	    }

	    public RegistrationWorkflow orderSummaryPage(Consumer<OrderSummaryPage> c){
	        OrderSummaryPage p = new OrderSummaryPage();
	        this.waitForPageLoad(p);
	        c.accept(p);
	        return this;
	    }

	    public void orderConfirmationPage(Consumer<OrderConfirmationPage> c){
	        OrderConfirmationPage p = new OrderConfirmationPage();
	        this.waitForPageLoad(p);
	        c.accept(p);
	    }

	    //handle page sync techniques here
	    private void waitForPageLoad(Page p){
	        System.out.println("------------------------------");
	        System.out.println("Waiting for " + p.toString() + " to load" );
	        // wait till p.isAt() returns true with a timeout
	    }
	}
