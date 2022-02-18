package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    //components
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private final SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            fileInput = $("#uploadPicture"),
            currentAddressInput= $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            sendButton = $("#submit"),
            resultModalTile = $("#example-modal-sizes-title-lg"),
            resultModalTable = $(".table-responsive");

    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage checkHeaderTitle(String title) {
        headerTitle.shouldHave(text(title));
        return this;
    }

    public RegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationFormPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage uploadFile(String filePath) {
        fileInput.uploadFromClasspath(filePath);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage setState(String state){
        stateInput.setValue(state).pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationFormPage sendForm() {
        sendButton.scrollTo().click();
        return this;
    }

    public RegistrationFormPage checkResultModalTitle(String title) {
        resultModalTile.shouldHave(text(title));
        return this;
    }

    public RegistrationFormPage checkResultModalTable(String rowName, String rowValue) {
        resultModalTable.$(byText(rowName)).parent().shouldHave(text(rowValue));
        return this;
    }

}
