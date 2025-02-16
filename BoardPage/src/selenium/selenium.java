import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium {
	
private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "./chromedriver.exe";
    //크롤링 할 URL
    private String base_url;
    
    public selenium() {
        super();
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.kosaf.go.kr/ko/notice.do?ctgrId1=&ctgrId2=&searchStr=&searchType=&page=1&pg=";
    }
 
    public void crawl() {
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            System.out.println(driver.getPageSource());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}
