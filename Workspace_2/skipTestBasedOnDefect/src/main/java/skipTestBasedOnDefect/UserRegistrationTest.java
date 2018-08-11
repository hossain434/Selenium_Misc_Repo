package skipTestBasedOnDefect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listener(MethodIssueStatusListener.class)
public class UserRegistrationTest {
    
      @Test
      public void launchRegistrationPage() {
          RegistrationPage.launch();
          Assert.assertTrue(RegistrationPage.isAt());
      }

      @Test(dependsOnMethods= "launchRegistrationPage")
      public void enterDemographicInformation() {
          RegistrationPage.enterDemographicInformation();
          RegistrationPage.submit();
          Assert.assertTrue(ProductsListPage.isAt());
      }
      
      @Test(dependsOnMethods= "enterDemographicInformation")
      public void chooseProduct() {
          ProductsListPage.chooseProduct(Products.DUMMY);
          ProductsListPage.submit();
          Assert.assertTrue(PaymentInformationPage.isAt());
      }
      @Issue("APP-1234")
      @Test(dependsOnMethods= "chooseProduct")
      public void enterPayment() {
          PaymentInformationPage.enterPayment(PaymentMethods.CC);
          PaymentInformationPage.submit();
          Assert.assertTrue(OrderConfirmationPage.isAt());
      }
      
       
      @Test(dependsOnMethods= "enterPayment")
      public void orderConfirmation() {
          Assert.assertTrue(OrderConfirmationPage.isOrderSuccessful());
          OrderConfirmationPage.close();
      } 
      @Retention(RetentionPolicy.RUNTIME)
      @Target(ElementType.METHOD)
      public @interface Issue {
          String value() default "";
      }
}