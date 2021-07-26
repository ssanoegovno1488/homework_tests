package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
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

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).click();
        //$(".opened-by").shouldHave(Condition.text(" #58 opened"));
        $("#issue_58").shouldHave(Condition.text("#58"));


    }
}
