package manageMultipleWindow.manageMultipleWindow;
public class SwitchTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PageA pageA;
    private PageB pageB;
    private PageC pageC;

    @BeforeTest
    public void init(){
        this.driver = DriverManager.getDriver();
        this.mainPage = new MainPage(driver);
        this.pageA = new PageA(driver);
        this.pageB = new PageB(driver);
        this.pageC = new PageC(driver);
    }

    @Test
    public void test(){
        this.mainPage.goTo();
        this.mainPage.launchPageA();
        this.mainPage.launchPageB();
        this.mainPage.launchPageC();

        this.pageA.onNewWindow(a -> {
            a.setFn("Test");
            a.setLn("Test");
            a.setAddr("Test");
        });
        
        this.pageB.onNewWindow(b -> {
            b.setFn("Automation");
            b.setLn("Automation");
            b.setAddr("Automation");
        });

        this.pageC.onNewWindow(c -> {
            c.setFn("Guru");
            c.setLn("Guru");
            c.setAddr("Guru");
        });

    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
