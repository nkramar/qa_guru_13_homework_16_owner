import com.codeborne.selenide.Configuration;
import config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
  @BeforeAll
  public static void setUp() {
    WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    Configuration.browser = webDriverConfig.getBrowser();
    Configuration.browserVersion = webDriverConfig.getBrowserVersion();
    Configuration.browserSize = webDriverConfig.getBrowserSize();
    if (!webDriverConfig.getRemoteWebDriver().equals("")) {
      Configuration.remote = webDriverConfig.getRemoteWebDriver();
    }
    String baseUrlOfPage = System.getProperty("base.url");
    if (Objects.isNull(baseUrlOfPage)) {
      baseUrlOfPage= "https://www.google.com/";
    }
    open(baseUrlOfPage);
  }
}

