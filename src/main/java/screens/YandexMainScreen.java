package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class YandexMainScreen {
  public static final Logger logger = LogManager.getLogger(YandexMainScreen.class);

  private static final By YANDEX_PICTURE_SEARCH = By.xpath("//a[@data-id='images']");

  private WebDriver driver;

  public YandexMainScreen(WebDriver driver) {
    this.driver = driver;
  }

  public YandexImagesScreen goToImagesScreen() {
    logger.info("Переходим на страницу поиска по картинке и закрываем вкладку главного поиска");
    driver.findElement(YANDEX_PICTURE_SEARCH).click();
    List<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(0));
    driver.close();
    driver.switchTo().window(tabs.get(1));
    return new YandexImagesScreen(driver);
  }
}