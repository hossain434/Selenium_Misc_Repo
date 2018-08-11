package main.java.Switch_Browsers_Window;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import org.aopalliance.intercept.MethodInterceptor;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;

public class DriverModule extends AbstractModule {

    @Override
    protected void configure() {

        //DriverManager config
        bind(DriverManager.class)
            .to(ChromeDriverManager.class)
            .in(Scopes.SINGLETON);

        //Windows interceptor
        MethodInterceptor interceptor = new WindowInterceptor();
        requestInjection(interceptor);
        bindInterceptor(Matchers.annotatedWith(WebDriver.Window.class), Matchers.any(), interceptor);

    }

    @Provides
    public WebDriver getDriver(DriverManager driverManager) {
        return driverManager.getDriver();
    }

}