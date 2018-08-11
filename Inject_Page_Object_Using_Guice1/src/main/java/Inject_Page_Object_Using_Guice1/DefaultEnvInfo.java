package Inject_Page_Object_Using_Guice1;
public class DefaultEnvInfo implements EnvInfo {
	@Override
	 public String getBrowserFlavor() {
        //Keeping it simple for the sake of example. You can make it fancy by having this read from JVM arguments for e.g.,
        return "firefox";
    }
}