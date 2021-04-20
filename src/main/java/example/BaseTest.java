package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import properties.ConfProperties;

import java.util.concurrent.TimeUnit;

public class BaseTest {
  private static final String CONF_PROPERTIES = "src/main/resources/conf.properties";
  protected ConfProperties confProperties;
  protected WebDriver driver;

  @BeforeSuite
  public void configEnvironment() {
    driver = new ChromeDriver();
    confProperties = new ConfProperties(CONF_PROPERTIES);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get(confProperties.getProperty("mainpage"));
  }
}