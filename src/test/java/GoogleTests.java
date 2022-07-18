import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class GoogleTests extends TestBase {

  @Tag("configuration_tests")
  @Test
  @DisplayName("Check page title")
  public void googleTitleTest() {
    assertThat(title()).contains("Google");
  }

  @Disabled("test works locally, but doesn't work remotely")
  @Test
  @DisplayName("Check search results")
  void googleSearchTest() {
    $("input[title='Поиск']").setValue("Java").pressEnter();
    ($("#search")).shouldHave(text("Java"));
  }

}


