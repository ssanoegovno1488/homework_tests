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
        Configuration.baseUrl = "https://github.com/selenide/selenide";
        Configuration.startMaximized=true;
    }

    @Test
    void shouldFindWikiPageInSelenideRepository(){
        open("/wiki");
        $("#wiki-body").shouldHave(Condition.text("Soft assertions"));
        $("#wiki-body").$(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:"))
                .shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})"));
        //здесь стоит отметить, что без четкого ТЗ - результат ХЗ, поэтому для проверки использовался
        //лишь заголовок  и первая строчка кода, чего вполне хватает для того, чтобы убедиться
        //в наличии описания JUnit5 на странице
    }
}
