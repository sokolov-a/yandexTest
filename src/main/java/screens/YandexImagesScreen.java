package screens;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class YandexImagesScreen {
  public static final Logger logger = LogManager.getLogger(YandexImagesScreen.class);

  private static final By LOAD_PICTURE_SEARCH = By.xpath(".//button[@aria-label='Поиск по изображению']");
  private static final By SELECT_A_FILE = By.xpath("//input[@type='file']");
  private static final String RESULT_BUTTON_WITH_TEXT = "//div[contains(@class,'CbirItem CbirTags')]//span[contains(@class, 'Button2-Text') " +
      "and text() = '%s']";

  private WebDriver driver;

  public YandexImagesScreen(WebDriver driver) {
    this.driver = driver;
  }

  public YandexImagesScreen clickToLoadPictureSearch() {
    logger.info("Кликаем на иконку поиска по изображению");
    driver.findElement(LOAD_PICTURE_SEARCH).click();
    return this;
  }

  public YandexImagesScreen loadImageToYandex(String filePath, String searchResult) {
    logger.info("Загружаем картинку в поле для загрузки и ждем, когда страница прогрузится");
    var resultButtonWithText = By.xpath(String.format(RESULT_BUTTON_WITH_TEXT, searchResult));
    driver.findElement(SELECT_A_FILE).sendKeys(filePath);
    WebDriverWait wait = new WebDriverWait(this.driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(resultButtonWithText));
    return this;
  }

  public boolean isSearchResultVisible(String searchResult) {
    logger.info("Проверяем, что результаты поиска правильные");
    var resultButtonWithText = By.xpath(String.format(RESULT_BUTTON_WITH_TEXT, searchResult));
    boolean result = driver.findElement(resultButtonWithText).isDisplayed();
    logger.log(Level.INFO, "Результат => {}", result);
    return result;
  }
}