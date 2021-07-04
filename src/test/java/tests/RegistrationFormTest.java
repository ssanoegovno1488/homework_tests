package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormTest {


    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized=true;
    }
    @Test
    void positiveFormFillTest(){
        //Ввод тестовых данных
        open("/automation-practice-form");
        $("#firstName").setValue("Allo");
        $("#lastName").setValue("Yoba");
        $("#userEmail").setValue("bolsho@yoba.com");
        $("#genterWrapper").$(byText("Other")).click(); //Не получилось использовать selectRadio по какой-то причине. Костыль.
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/recources/picture.png"));
        $("#currentAddress").setValue("Some_Street_1");
        $("#react-select-3-input").setValue("Haryana").pressEnter(); // штат
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").scrollIntoView(true).click();

        //Проверка результатов

        //Для чекбоксов Hobbies важен порядок: в какой последовательности заполнялись чекбоксы, в такой и будет результат
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("tbody").$(byText("Student Name")).parent().shouldHave(text("Allo"));
        $("tbody").$(byText("Student Email")).parent().shouldHave(text("bolsho@yoba.com"));
        $("tbody").$(byText("Gender")).parent().shouldHave(text("Other"));
        $("tbody").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $("tbody").$(byText("Date of Birth")).parent().shouldHave(text("15 March,1900"));
        $("tbody").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $("tbody").$(byText("Hobbies")).parent().shouldHave(text("Reading, Sports"));
        $("tbody").$(byText("Picture")).parent().shouldHave(text("picture.png"));
        $("tbody").$(byText("Address")).parent().shouldHave(text("Some_Street_1"));
        $("tbody").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
    }
}
