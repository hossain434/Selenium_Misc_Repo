package Inject_Page_Object_Using_Guice1;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
 
import java.util.List;
 
public class GuiceParentModuleInjector implements IAlterSuiteListener {
	@Override
    public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        suite.setName(getClass().getSimpleName());
    }

}