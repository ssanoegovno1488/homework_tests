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
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {

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
    @Description("Тест на с применением лямбда-функций")
    @DisplayName("Проверка поиска работы по Issues с применением лямбда-методов")
    public void testRepositoryIssue() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел Issues", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем, что существует issue с номером " + ISSUE_NUMBER, () -> {
            $("#issue_58").shouldHave(Condition.text("#" + ISSUE_NUMBER));
        });


    }
}
