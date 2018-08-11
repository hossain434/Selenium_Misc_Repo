package Switch_Browsers_Window;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.openqa.selenium.WebDriver;

import com.google.inject.Inject;

public class WindowInterceptor implements MethodInterceptor {

    @Inject
    private WebDriver driver;

   // @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        int index = invocation.getMethod().getDeclaringClass().getAnnotation(Window.class).value();
        this.switchToWindow(index);
        Object obj = invocation.proceed();
        this.switchToWindow(0);
        return obj;
    }

    private void switchToWindow(int index) {
        String handle = this.driver.getWindowHandles().toArray(new String[0])[index];
        this.driver.switchTo().window(handle);
    }

}