package properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
  public static final Logger LOGGER = LogManager.getLogger(ConfProperties.class);
  private static FileInputStream fileInputStream;
  private static Properties properties;

  public ConfProperties(String confProperties) {
    try {
      fileInputStream = new FileInputStream(confProperties);
      properties = new Properties();
      properties.load(fileInputStream);
      fileInputStream.close();
    } catch (IOException e) {
      LOGGER.error("Что-то пошло не так с конфигами драйвера", e);
      throw new RuntimeException(e);
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}