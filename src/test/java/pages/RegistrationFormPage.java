package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    //locators
    SelenideElement headerText = $("h5");
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userNumberInput = $("#userNumber");



    //actions
    public void checkHeaderText(String headerText){
        headerText.shouldHave(text);
    }

    public void setFirstName(String firstName){
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName){
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail(String userEmail){
        userEmailInput.setValue(userEmail);
    }

    public void setUserNumber(String userNumber){
        userNumberInput.setValue(userNumber);
    }

}
