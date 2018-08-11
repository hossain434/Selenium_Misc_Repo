package Handle_Annoying_Random_Popup_Alerts;
public class MyPageFactory {
    
    public static <T> void initElements(WebDriver driver, T pageobject){
        
        //first init elements
        PageFactory.initElements(driver, pageobject);
        
        //then access all the WebElements and create a wrapper
        for(Field f:pageobject.getClass().getDeclaredFields()){
            if(f.getType().equals(WebElement.class)){
                boolean accessible = f.isAccessible();
                f.setAccessible(true);
                //reset the webelement with proxy object
                f.set(pageobject, ElementGuard.guard((WebElement) f.get(pageobject)));
                f.setAccessible(accessible);
            }  
        }

    }
    
}