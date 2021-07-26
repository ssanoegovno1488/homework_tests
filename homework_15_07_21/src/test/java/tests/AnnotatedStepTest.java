package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 58;

    private WebSteps steps = new WebSteps();


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
    @DisplayName("Проверка поиска работы по Issues с применением @Step и аннотаций")
    void shouldSeeIssueInRepository() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
