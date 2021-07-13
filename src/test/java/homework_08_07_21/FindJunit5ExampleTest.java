package homework_08_07_21;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FindJunit5ExampleTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.startMaximized=true;
    }

    @Test
    void shouldFindWikiPageInSelenideRepository(){
        open("/selenide/selenide");
        $(".UnderlineNav-body").$(byText("Wiki")).click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".wiki-more-pages").shouldHave(Condition.text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:"))
                .shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})"));
        //Решил идти не через клик по элементу, а через поиск.
    }
}
