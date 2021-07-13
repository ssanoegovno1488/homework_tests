package homework_08_07_21;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragNDropTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized=true;
    }

    @Test
    void dragNDropCheck() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("A"));
        //На всякий случай выполнил обратную проверку, чтобы посмотреть, что работает
        //в обе стороны

    }
}
