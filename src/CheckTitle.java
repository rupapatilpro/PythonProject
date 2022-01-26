
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;




public class CheckTitle {

	static WebDriver driver; // Selenium control driver
    private static String baseUrl; // baseUrl of Website Guru99
   
    // This method SetUp will read initialization parameters from the class Util.java & launch Firefox 

    public static void setUp() throws Exception {
	/* 
	 * In some PC's, Selenium can not find the binary file of Firefox because
	 * user doesn't install Firefox at its default location. We need to tell
	 * Selenium where the firefox.exe is
	
		File pathToBinary = new File(Util.FIREFOX_PATH);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary); */
		System.setProperty("webdriver.gecko.driver", "/Users/ruheenaansari/Downloads/geckodriver");	
	
	 // Create new firefoxProfile for Testing
	 
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver();

	// Setting Base URL of website Guru99
	baseUrl = Util.BASE_URL;
	driver.manage().timeouts()
		.implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
	// Go to http://www.demo.guru99.com/V4/
	driver.get(baseUrl + "/V4/");
    }

    /**
     * 
     * @author Ruheena Ansari
     *        Test Script 02
     *        ************** 
     *        This method will perform following Test Steps
     *        
     *        1)  Go to http://www.demo.guru99.com/V4/
              2) Enter valid UserId
              3) Enter valid Password
              4) Click Login
              5) Verify the Page Title after login
     */
   
   public static void main(String[] args) throws Exception {

     	
	
    String username, password;
	String actualTitle;
	String actualBoxtitle;

	    
	    //Setup Firefox driver
	    setUp();
	
	   
	    driver.findElement(By.name("uid")).clear(); 
	    driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);  // Enter username

	   
	    driver.findElement(By.name("password")).clear(); 
	    driver.findElement(By.name("password")).sendKeys(Util.PASSWD);  // Enter Password

	    // Click Login
	    driver.findElement(By.name("btnLogin")).click();

	  	actualTitle = driver.getTitle();
		if (actualTitle.contains(Util.EXPECT_TITLE)) {
				    System.out.println("Test case: Passed");
		} 
		else {
				    System.out.println("Test case : Failed");
		}
				
	    driver.close();
	    
	

    }

}

        

