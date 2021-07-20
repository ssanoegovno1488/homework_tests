package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;
import components.FileUploader;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {
    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";
    private SelenideElement modal = $("[role=dialog]");
    private Calendar calendar = new Calendar();
    private FileUploader fileuploader = new FileUploader();


    public void checkPageTitle() {
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }


    public void openPage() {
        open("/automation-practice-form");
    }

    public void typeFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void typeLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        //$("#genterWrapper").$(byText(gender)).click();
        //$("[name=gender][value=Other").parent().click();
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;

        /* Как работает format
        String a = "1234%s890";
        String b = format(a, 567);
        b -> 1234567890, т.е. формат подставляет значение вместо %s
         */
    }

    public RegistrationPage typeNumber(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage chooseSubject(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage choose2Hobbies(String hobbie1) {
        $("#hobbiesWrapper").$(byText(hobbie1)).click();
        return this;
    }

    public RegistrationPage uploadAFile(String filepath) {
        fileuploader.uploadFile(filepath);
        return this;
    }

    public RegistrationPage typeAdress(String adress) {
        $("#currentAddress").setValue(adress);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        $("#react-select-3-input").setValue(state).pressEnter(); // штат
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public void submitForm() {
        $("#submit").scrollIntoView(true).click();
    }


    public void checkResultsTitle() {
        modal.$(".modal-title").shouldHave(text(RESULTS_TITLE));
    }

    public RegistrationPage checkResultsValue(String value) {
        modal.$(".table-responsive").shouldHave(text(value));
        return this;
    }
}
