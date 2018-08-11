package Inject_Page_Object_Using_Guice1;
import com.google.inject.AbstractModule;

public class DefaultParentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EnvInfo.class).to(DefaultEnvInfo.class);
    }
}