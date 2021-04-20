package example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import screens.YandexImagesScreen;
import screens.YandexMainScreen;

import static org.testng.Assert.assertTrue;

public class YandexTest extends BaseTest {
  private String filePath = "/home/andrey/image/billi.jpg";
  private String resultText = "билли херрингтон";

  @Test(description = "Загружаем картинку на странице поиска яндекса и убеждаемся, что поиск работает корректно")
  public void test() {
    new YandexMainScreen(driver).goToImagesScreen()
        .clickToLoadPictureSearch()
        .loadImageToYandex(filePath, resultText);
    assertTrue(new YandexImagesScreen(driver).isSearchResultVisible(resultText), "Искомый результат поиска отсутствует!");
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}