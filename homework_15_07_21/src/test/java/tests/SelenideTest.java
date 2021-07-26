package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 58;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    @Feature("Issues")
    @Story("Поиск по Issues")
    @Owner("Roman")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "GitHub", url = "https://github.com")
    @Description("Тест на чистом Selenide без использования лямбда-методов и @Step с аннтоацией")
    @DisplayName("Проверка поиска работы по Issues без дополнительных фишек аллюра")
    public void testRepositoryIssue() {
        open("https://github.com");

        $(".header-search-input").setValue(REPOSITORY).submit();

        $(By.linkText(REPOSITORY)).click();
        $(By.partialLinkText("Issues")).click();
        $("#issue_58").shouldHave(Condition.text("#" + ISSUE_NUMBER));


    }
}
