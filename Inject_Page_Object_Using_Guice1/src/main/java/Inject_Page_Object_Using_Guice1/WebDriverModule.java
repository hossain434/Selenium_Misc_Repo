package Inject_Page_Object_Using_Guice1;
import com.google.inject.Binder;
import com.google.inject.Module;
 
public class WebDriverModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(WebDriverProducer.class).to(DefaultWebDriverProducerImpl.class);
    }
}
