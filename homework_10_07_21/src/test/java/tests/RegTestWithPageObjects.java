package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static Utils.RandomUtils.*;

public class RegTestWithPageObjects {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String address = faker.pokemon().name();

    RegistrationPage registrationPage = new RegistrationPage();
    String email = getRandomEmail();
    String gender = "Other";
    String number = getRandomPhoneNumber();
    String day = "26";
    String month = "April";
    String year = "1990";
    String subjects = "Maths";
    String hobbie1 = "Reading";
    String state = "Haryana";
    String city = "Karnal";
    String whereismyfile = "src/test/recources/picture.png";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized=true;
    }
    @Test
    void positiveFormFillTest(){
        //Ввод тестовых данных
        registrationPage.openPage();
        registrationPage.checkPageTitle();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email)
                .selectGender(gender)
                .typeNumber(number)
                .setBirthDate(day, month, year)
                .chooseSubject(subjects)
                .choose2Hobbies(hobbie1)
                .uploadAFile(whereismyfile)
                .typeAdress(address)
                .setStateAndCity(state, city)
                .submitForm();

        //Проверка результатов
        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue(firstName + " " + lastName)
                .checkResultsValue(email)
                .checkResultsValue(gender)
                .checkResultsValue(number)
                .checkResultsValue(day + " " + month + "," + year)
                .checkResultsValue(subjects)
                .checkResultsValue(hobbie1)
                .checkResultsValue(address)
                .checkResultsValue(state + " " + city);
    }
}
